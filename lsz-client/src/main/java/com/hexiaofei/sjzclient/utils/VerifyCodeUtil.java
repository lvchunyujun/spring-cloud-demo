package com.hexiaofei.sjzclient.utils;

import com.madgag.gif.fmsware.AnimatedGifEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class VerifyCodeUtil {

    private static String randomTextCode = null;

    /**
     * 返回验证码值
     *
     * @return
     */
    public static String getRandomCode() {
        return randomTextCode;
    }
    /**
     * 设置验证码值
     *
     * @param randomCode
     */
    private static void setRandomCode(String randomTextCode) {
        VerifyCodeUtil.randomTextCode = randomTextCode;
    }

    /**
     * 定义验证码序列，没有1 I L l 0 o
     */
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T','U', 'V', 'W', 'X', 'Y',
            'Z', '2', '3', '4', '5', '6', '7', '8', '9' ,'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z'};
    /**
     * 验证码长度
     */
    private static int charNum = codeSequence.length;

    public static String textCode() {
        // 创建一个随机数生成器类 用于随机选取验证码字符
        Random random = new Random();
        // 字符个数
        int fontCount = 4;
        // 定义StringBuffer，用于接收生成的验证码
        StringBuffer verifyCode = new StringBuffer();
        // 随机产生fontCount数字的验证码。
        for (int i = 0; i < fontCount; i++) {
            // 每次随机拿一个字符
            String str = String.valueOf(codeSequence[random.nextInt(charNum)]);
            verifyCode.append(str);
        }
        return verifyCode.toString();
    }

    /**
     * 获取验证码图片
     *
     * @return 图片缓存对象
     */
    public static BufferedImage createImageCode() {
        String textCode = textCode();
        setRandomCode(textCode);
        return createImageCode(textCode);
    }

    /**
     * 获取验证码图片组，用于合成gif动态图 ，长度固定为10
     *
     * @return 图片缓存对象
     */
    public static BufferedImage[] createImageCodes() {
        String textCode = textCode();
        BufferedImage[] bImg = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            bImg[i] = createImageCode(textCode);
        }
        setRandomCode(textCode);
        return bImg;
    }

    /**
     * 获取验证码图片组，用于合成gif动态图 ，长度固定为10
     * @param textCode
     * @return
     */
    public static BufferedImage[] createImageCodes(String textCode) {
        BufferedImage[] bImg = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            bImg[i] = createImageCode(textCode);
        }
        setRandomCode(textCode);
        return bImg;
    }

    /**
     * 绘制验证码图片
     *
     * @return 图片缓存对象
     */
    public static BufferedImage createImageCode(String textCode) {
        // 定义验证码图片框
        // 验证码图片的宽度，可自行修改
        int width = 100;
        // 验证码图片的高度，可自行修改
        int height = 36;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 定义图片上的图形和干扰线
        Graphics graphics = bufferedImage.createGraphics();
        // 绘制背景图 为浅灰色
        graphics.setColor(Color.LIGHT_GRAY);
        // 填充一个矩形，第一个参数：要填充的矩形的起始x坐标；第二个参数：要填充的矩形的起始y坐标；第三个参数：要填充的矩形的宽度；第四个参数：要填充的矩形的高度；
        graphics.fillRect(0, 0, width, height);
        // 画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 随机产生16条灰色干扰线，使图像中的认证码不易识别
        graphics.setColor(Color.gray);
        // 创建一个随机数生成器类 用于随机产生干扰线
        Random random = new Random();
        int x1, y1, x2, y2;
        for (int i = 0; i < 16; i++) {
            x1 = random.nextInt(width);
            y1 = random.nextInt(height);
            x2 = random.nextInt(12);
            y2 = random.nextInt(12);
            // 第一个参数：第一个点的x坐标；第二个参数：第一个点的y坐标；第三个参数：第二个点的x坐标；第四个参数：第二个点的y坐标；
            graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
        }
        // 字符个数
        int fontCount = 4;
        // 字体大小为图片高度的80%
        int fontSize = (int) (height * 0.8);
        // 第一个字符的x坐标，因为后面的字符坐标依次递增，所以它们的x轴值是fontX的倍数
        int fontX;
        // 验证字符的y坐标，因为并排所以值一样
        int fontY;
        // width-3 除去左右多余的位置，使验证码更加集中显示，减得越多越集中。
        // fontCount+1//等比分配显示的宽度，包括左右两边的空格
        fontX = (width - 3) / (fontCount + 1);// 第一个字母的起始位置
        fontY = height - 7;
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.PLAIN, fontSize);
        graphics.setFont(font);
        // 随机产生fontCount数字的验证码。
        for (int i = 0; i < textCode.length(); i++) {
            // 赋予随机的颜色
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            // 验证码字符显示到图象中
            graphics.drawString(textCode.charAt(i) + "", (i + 1) * fontX, fontY);
        }
        return bufferedImage;
    }

    /**
     * 获取gif图片输入流
     *
     * @return 文件字节输入流
     */
    public static FileInputStream createTempGifFile(){
        // 创建文件字节输入流
        FileInputStream fileIn = null;
        try {
            // 创建一个临时文件
            File file = File.createTempFile(System.currentTimeMillis() + "", ".gif");
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            // 设置GIF重复次数
            e.setRepeat(0);
            // 设置合成位置
            e.start(file.getCanonicalPath());
            BufferedImage[] src = createImageCodes();
            for (int i = 0; i < src.length; i++) {
                // 设置播放的延迟时间
                e.setDelay(200);
                // 添加到帧中
                e.addFrame(src[i]);
            }
            e.finish();
            fileIn = new FileInputStream(file);
            // 因为返回时InputStream已经关闭，所以不需要关闭文件字节输入流
            /// fileIn.close();
            // 删除临时文件，实际使用时，因文件字节输入流没有关闭，会导致删除失败，所以建议不要使用返回文件字节输入流的方式，而是直接使用本方法代码块代码
            file.delete();
        } catch (Exception e) {
            System.out.println("JPG to GIF failed:" + e.getMessage());
            e.printStackTrace();
        }
        return fileIn;
    }

}
