package com.hexiaofei.springeurekaclient.common.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by hexiaofei on 2018/3/18.
 */
public class HttpClientUtil2 {

    public static String getResposeBody(String url, Map<String, String> paramMap) {
        StringBuilder buf = new StringBuilder();
        HttpClient client = new HttpClient();
        BufferedReader br = null;
        PostMethod method = null;
        try {
            method = new PostMethod(url);
            for(String key : paramMap.keySet()) {
                method.addParameter(key, paramMap.get(key));
            }
            HttpMethodParams param = method.getParams();
            param.setContentCharset("UTF-8");
            param.setSoTimeout(10*1000);
            long st = System.currentTimeMillis();
            client.executeMethod(method);
            System.out.println("耗时："+(System.currentTimeMillis()-st));
            if(method.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
                String line;
                while (null != (line = br.readLine())) {
                    buf.append(line).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                method.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                ((SimpleHttpConnectionManager)client.getHttpConnectionManager()).shutdown();
            }
        }
        return buf.toString();
    }

}
