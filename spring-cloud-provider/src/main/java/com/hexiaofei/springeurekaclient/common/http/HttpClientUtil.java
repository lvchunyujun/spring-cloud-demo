package com.hexiaofei.springeurekaclient.common.http;

import org.apache.http.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.*;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.*;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.LineParser;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hexiaofei on 2018/3/17.
 */
public class HttpClientUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    private final static int POOL_CONN_MAX_TOTAL = 200;

    private final static int SOCKET_TIMEOUT = 1000 * 10;
    private final static int CONN_TIMEOUT = 1000 * 10;            // 连接超时
    private final static int CONN_REQUEST_TIMEOUT = 1000 * 3;    // 请求超时

    private final static int VAL_AFTER_INACTIVITY = 1000;    // 检测时长

    // Create a connection manager with custom configuration.
    private static PoolingHttpClientConnectionManager connManager;
    private static CloseableHttpClient httpclient;

    private static ScheduledExecutorService monitorExecutor;
    static {
        info();
    }

    /**
     * 连接管理配置
     */
    public static void info() {
        // step1: 响应解析工厂
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory();

        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory,
                responseParserFactory);

        SSLContext sslcontext = SSLContexts.createSystemDefault();

        // Create a registry of custom connection socket factories for supported
        // protocol schemes.
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();

        // Use custom DNS resolver to override the system DNS resolution.
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            @Override
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("myhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }

        };

        // Create a connection manager with custom configuration.
        connManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry,
                connFactory,
                dnsResolver);

        // Create socket configuration
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true)
                .build();
        // Configure the connection manager to use socket configuration either
        // by default or for a specific host.
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setSocketConfig(new HttpHost("somehost", 80), socketConfig);
        // Validate connections after 1 sec of inactivity
        connManager.setValidateAfterInactivity(VAL_AFTER_INACTIVITY);

        // Create message constraints
        MessageConstraints messageConstraints = MessageConstraints.custom()
                .setMaxHeaderCount(200)
                .setMaxLineLength(2000)
                .build();
        // Create connection configuration
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();
        // Configure the connection manager to use connection configuration either
        // by default or for a specific host.
        connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setConnectionConfig(new HttpHost("somehost", 80), ConnectionConfig.DEFAULT);

        // 最大连接数
        connManager.setMaxTotal(POOL_CONN_MAX_TOTAL);
        getHttpClient();
    }

    /**
     * 获取请求配置
     *
     * @return
     */
    public static RequestConfig getRequestConfig() {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .setExpectContinueEnabled(true)
                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
                .build();
        RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(CONN_TIMEOUT)
                .setConnectionRequestTimeout(CONN_REQUEST_TIMEOUT)
//              .setProxy(new HttpHost("myotherproxy", 8080))
                .build();
        return requestConfig;
    }

    /**
     * 获取HttpClient连接
     *
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
         if(httpclient == null){
             httpclient = HttpClients.custom()
                     .setConnectionManager(connManager)                     //  配置连接管理
//                .setDefaultCookieStore(cookieStore)
//                .setDefaultCredentialsProvider(credentialsProvider)
//                .setProxy(new HttpHost("myproxy", 8080))             //  设置代理
                     .setDefaultRequestConfig(getRequestConfig())           //  设置request默认配置
                     .build();
         }
        return httpclient;
    }

    /**
     * get请求处理
     *
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        String respMsg = null;
        try {
            // 获取连接配置
            HttpGet httpget = new HttpGet(url);
            // Execution context can be customized locally.
            HttpClientContext context = HttpClientContext.create();

            LOGGER.info("executing request " + httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget, context);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println("----------------------------------------");

                // Once the request has been executed the local context can
                // be used to examine updated state and various objects affected
                // by the request execution.

                // Last executed request
                context.getRequest();
                // Execution route
                context.getHttpRoute();
                // Target auth state
                context.getTargetAuthState();
                // Proxy auth state
                context.getTargetAuthState();
                // Cookie origin
                context.getCookieOrigin();
                // Cookie spec used
                context.getCookieSpec();
                // User security token
                context.getUserToken();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return respMsg;
    }

    public static String sendPost(String url, Map<String, String> paraMap) {
        String respMsg = null;
        CloseableHttpClient httpclient = null;
        try {
            // 获取连接
            httpclient = getHttpClient();
            HttpPost httppost = new HttpPost(url);
            // 设置参数
            setPostParams(httppost, paraMap);
            // Execution context can be customized locally.
            HttpClientContext context = HttpClientContext.create();

            LOGGER.info("http executing request " + httppost.getURI());
            long st = System.currentTimeMillis();
            CloseableHttpResponse response = httpclient.execute(httppost, context);
            System.out.println("http respons 耗时：" + (System.currentTimeMillis() - st) + " " + httppost.getURI());
            try {
                HttpEntity httpEntity = response.getEntity();
                respMsg = EntityUtils.toString(httpEntity);
                LOGGER.info("----------------------------------------");
                LOGGER.info("http respons ：" + response.getStatusLine().toString());
//                LOGGER.info("http respons ：" + respMsg);
                LOGGER.info("----------------------------------------");
//                if (response.getStatusLine().getStatusCode() == org.springframework.http.HttpStatus.OK.value()) {
//                }

                // Last executed request
                context.getRequest();
                // Execution route
                context.getHttpRoute();
                // Target auth state
                context.getTargetAuthState();
                // Proxy auth state
                context.getTargetAuthState();
                // Cookie origin
                context.getCookieOrigin();
                // Cookie spec used
                context.getCookieSpec();
                // User security token
                context.getUserToken();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                if (httpclient != null) {
//                    httpclient.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return respMsg;
    }

    public static void setPostParams(HttpPost httpPost, Map<String, String> params) {
        if (params == null) {
            return;
        }
        List<NameValuePair> nvps = new ArrayList<>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static class DefaultHttpResponseParserFactory implements HttpMessageParserFactory {
        @Override
        public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
            LineParser lineParser = new BasicLineParser() {
                @Override
                public Header parseHeader(final CharArrayBuffer buffer) {
                    try {
                        return super.parseHeader(buffer);
                    } catch (ParseException ex) {
                        return new BasicHeader(buffer.toString(), null);
                    }
                }

            };
            return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                @Override
                protected boolean reject(final CharArrayBuffer line, int count) {
                    // try to ignore all garbage preceding a status line infinitely
                    return false;
                }

            };
        }

    }

    /**
     * 关闭连接池
     */
    public static void closeConnectionPool() {
        try {
            httpclient.close();
            connManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long s = System.currentTimeMillis();
        for(int i = 0 ; i < 500 ;i++){
            HttpClientUtil.sendPost("https://www.jd.com", null);
            System.out.println(i);
        }
        System.out.println("耗时："+(System.currentTimeMillis()-s));
        TimeUnit.SECONDS.sleep(100);
//        closeConnectionPool();
    }


}
