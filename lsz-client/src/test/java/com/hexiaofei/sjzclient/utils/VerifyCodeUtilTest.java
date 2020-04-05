package com.hexiaofei.sjzclient.utils;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class VerifyCodeUtilTest {

    public static void verifyCodeUtil(String path) {
        BufferedImage bufferedImage = VerifyCodeUtil.createImageCode();
        try {
            ImageIO.write(bufferedImage, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verifyCodeSUtil(String path) {
        // 一般来讲，1 I L l 0 o这几个字符比较相似，所以需要排除
        BufferedImage bufferedImage = VerifyCodeSUtil.createImageCode(2, 4, "1ILl0o", 100, 36, 5, true, false, null, new Color(238,242,237), new Color(0,0,0), null);
        try {
            ImageIO.write(bufferedImage, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把多张jpg图片合成一张
     *
     * @param path String 生成的gif文件名 包含路径
     */
    public static void verifyCodeJpgToGif(String path) {
        try {
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            // 设置GIF重复次数
            e.setRepeat(0);
            //设置合成位置
            e.start(path);
            BufferedImage[] src = VerifyCodeUtil.createImageCodes();
            for (int i = 0; i < src.length; i++) {
                // 设置播放的延迟时间
                e.setDelay(200);
                // 添加到帧中
                e.addFrame(src[i]);
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "JPG to GIF failed:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 把多张jpg图片合成一张
     *
     * @param path String 生成的gif文件名 包含路径
     */
    public static void verifyCodeJpgToGifs(String path) {
        try {
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            // 设置GIF重复次数
            e.setRepeat(0);
            // 设置合成位置
            e.start(path);
            BufferedImage[] src = VerifyCodeSUtil.createImageCodes(2, 4, "1ILl0o", 100, 36, 5, true, false, null, new Color(238,242,237), new Color(0,0,0), null);
            for (int i = 0; i < src.length; i++) {
                // 设置播放的延迟时间
                e.setDelay(200);
                // 添加到帧中
                e.addFrame(src[i]);
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "JPG to GIF failed:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 拆分gif图片
     *
     * @param imagePath 需要拆分的图片路径
     * @param jpgPath 拆分出来的jpg图片路径
     * @throws IOException
     */
    public static void verifyCodeGifToJpgs(String imagePath, String jpgPath) {
        GifDecoder decoder = new GifDecoder();
        // imagePath源文件路径
        int status = decoder.read(imagePath);
        try {
            if (status != GifDecoder.STATUS_OK) {
                throw new IOException("read image " + imagePath + " error!");
            }
            // 获取GIF有多少个frame
            int frameCount = decoder.getFrameCount();
            for (int i = 0; i < frameCount; i++) {
                BufferedImage bufferedImage = decoder.getFrame(i);
                ImageIO.write(bufferedImage, "jpg", new File(jpgPath+"\\" + i + ".jpg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建gif文件测试
     */
    public static void createTempGifFile() {
        try {
            InputStream is = VerifyCodeUtil.createTempGifFile();
            OutputStream out = new FileOutputStream(new File("/Users/hexiaofei/Desktop/dynamicTest.gif"), true);
            int b = 0;
            byte[] buffer = new byte[1024];
            b = is.read(buffer);
            while (b != -1){
                // 写到输出流(out)中
                out.write(buffer, 0, b);
                b = is.read(buffer);
            }
            is.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建gif文件测试
     */
    public static void createTempGifFiles() {
        try {
            InputStream is = VerifyCodeSUtil.createTempGifFile(2, 4, "1ILl0o", 100, 36, 5, true, false, null, new Color(238,242,237), new Color(0,0,0), null);
            OutputStream out = new FileOutputStream(new File("/Users/hexiaofei/Desktop/dynamicTests.gif"), true);
            int b = 0;
            byte[] buffer = new byte[1024];
            b = is.read(buffer);
            while (b != -1){
                // 写到输出流(out)中
                out.write(buffer, 0, b);
                b = is.read(buffer);
            }
            is.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        verifyCodeUtil("/Users/hexiaofei/Desktop/test.jpg");
//        System.out.println("固定验证码生成类随机生成的验证码字符串：" + VerifyCodeUtil.getRandomCode());
//
//        verifyCodeJpgToGif("/Users/hexiaofei/Desktop/dynamic.gif");
//        System.err.println("固定验证码生成类随机生成的验证码字符串(动态的)：" + VerifyCodeUtil.getRandomCode());
//
//        verifyCodeSUtil("/Users/hexiaofei/Desktop/tests.jpg");
//        System.out.println("多种类验证码生成类随机生成的验证码字符串：" + VerifyCodeSUtil.getRandomTextCode());
//
//        verifyCodeJpgToGifs("/Users/hexiaofei/Desktop/dynamics.gif");
//        System.err.println("多种类验证码生成类随机生成的验证码字符串(动态的)：" + VerifyCodeSUtil.getRandomTextCode());
//
//        verifyCodeGifToJpgs("/Users/hexiaofei/Desktopdynamic.gif", "D:\\image");
//
//        createTempGifFile();

        createTempGifFiles();

        // 实际使用gif生成方式
//        FileInputStream fileIn = null;
//        try {
//            // 创建一个临时文件
//            File file = File.createTempFile(System.currentTimeMillis() + "", ".gif");
//            AnimatedGifEncoder e = new AnimatedGifEncoder();
//            // 设置GIF重复次数
//            e.setRepeat(0);
//            // 设置合成位置
//            e.start(file.getCanonicalPath());
//            BufferedImage[] src = VerifyCodeUtil.createImageCodes();
//            for (int i = 0; i < src.length; i++) {
//                // 设置播放的延迟时间
//                e.setDelay(200);
//                // 添加到帧中
//                e.addFrame(src[i]);
//            }
//            e.finish();
//            fileIn = new FileInputStream(file);
//            fileIn.close();
//            // 删除临时文件，实际使用时，因文件字节输入流没有关闭，会导致删除失败，所以建议不要使用返回文件字节输入流的方式，而是直接使用本方法代码块代码
//            file.delete();
//        } catch (Exception e) {
//            System.out.println( "JPG to GIF failed:" + e.getMessage());
//            e.printStackTrace();
//        }
    }
}
