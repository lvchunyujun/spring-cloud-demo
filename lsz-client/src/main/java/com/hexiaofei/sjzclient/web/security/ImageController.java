package com.hexiaofei.sjzclient.web.security;

import com.hexiaofei.sjzclient.utils.VerifyCodeUtil;
import com.lcyj.common.web.WebCommonConstant;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;

@Controller
public class ImageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    /**
     * 获取gif动态验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value="verifyImg",method = RequestMethod.GET)
    public void getRandomCodes(HttpServletRequest request,HttpServletResponse response) {

        // 定义字节输入流
        InputStream is = null;
        // 定义文件对象
        File file = null;
        String vCheck = null;
        try {
            // 创建一个临时文件
            file = File.createTempFile(String.valueOf(System.currentTimeMillis()), ".gif");
            // 实例化jpg合成gif组件
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            // 设置GIF重复次数
            e.setRepeat(0);
            // 设置合成位置
            e.start(file.getCanonicalPath());
            vCheck = generateVerifyCode(request);
            BufferedImage[] src = VerifyCodeUtil.createImageCodes(vCheck);
            for (int i = 0; i < src.length; i++) {
                // 设置播放的延迟时间
                e.setDelay(200);
                // 添加到帧中
                e.addFrame(src[i]);
            }
            e.finish();
            is = new FileInputStream(file);

        } catch (Exception e) {
            LOGGER.error("JPG to GIF failed:" + e.getMessage(),e);
        }

        try {
            response.setContentType("image/gif");
            OutputStream out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            b = is.read(buffer);
            while (b != -1) {
                // 写到输出流(out)中
                out.write(buffer, 0, b);
                b = is.read(buffer);
            }
            is.close();
            out.close();
            // 删除临时文件
            file.delete();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }
    }

    /**
     * 获取普通验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value="verify",method = RequestMethod.GET)
    public void getRandomCode(HttpServletRequest request,HttpServletResponse response) {
        try {
            BufferedImage img = VerifyCodeUtil.createImageCode();
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(img, "jpg", imOut);
            InputStream is = new ByteArrayInputStream(bs.toByteArray());

            response.setContentType("image/jpg");
            OutputStream out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            b = is.read(buffer);
            while (b != -1) {
                // 写到输出流(out)中
                out.write(buffer, 0, b);
                b = is.read(buffer);
            }
            is.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * HttpSession缓存一个注册校验码
     * @param request
     * @return
     */
    private String generateVerifyCode(HttpServletRequest request){
        HttpSession session = request.getSession();
        String vCode = VerifyCodeUtil.textCode();
        session.setAttribute(WebCommonConstant.LOGIN_VERIFY_CODE,vCode);

        return vCode;
    }
}
