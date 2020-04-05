package com.hexiaofei.sjzclient.utils;

import com.madgag.gif.fmsware.AnimatedGifEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class VerifyCodeSUtil {

    /**
     * 生成的字符串验证码
     */
    private static String randomTextCode = null;
    /**
     * 返回验证码值
     * @return
     */
    public static String getRandomTextCode() {
        return randomTextCode;
    }
    /**
     * 设置验证码值
     * @param randomTextCode
     */
    private static void setRandomTextCode(String randomTextCode) {
        VerifyCodeSUtil.randomTextCode = randomTextCode;
    }
    /**获取随机颜色
     * @return
     */
    private static Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /**
     * 生成图片验证码
     *
     * @param type 验证码类型
     * <br/> type=0，验证码类型为仅数字,即0~9
     * <br/> type=1，验证码类型为仅字母,即大小写字母混合
     * <br/> type=2， 验证码类型为数字和大小写字母混合
     * <br/> type=3，验证码类型为数字和大写字母混合
     * <br/> type=4，验证码类型为数字和小写字母混合
     * <br/> type=5，验证码类型为仅大写字母
     * <br/> type=6，验证码类型为仅小写字母
     * @param length 验证码字符长度,（即验证码的个数），如果长度小于0，则默认为4
     * @param excludeString 需排除的特殊字符
     * @param width 图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
     * @param height 图片高度
     * @param interLine 图片中干扰线的条数
     * @param randomPosition 每个字符的高低位置是否随机
     * @param hasBoder 是否画边框
     * @param boderColor 边框颜色，若为null则表示采用随机颜色
     * @param backColor 图片颜色,若为null则表示采用随机颜色
     * @param fontColor 字体颜色,若为null则表示采用随机颜色
     * @param lineColor 干扰线颜色,若为null则表示采用随机颜色
     * @return 图片缓存对象
     */
    public static BufferedImage createImageCode(int type, int length, String excludeString, int width, int height, int interLine, boolean randomPosition, boolean hasBoder, Color boderColor, Color backColor, Color fontColor, Color lineColor) {
        randomTextCode = createTextCode(type, length, excludeString);
        setRandomTextCode(randomTextCode);
        return createImageCode(randomTextCode, width, height, interLine, randomPosition, hasBoder, boderColor, backColor, fontColor, lineColor);
    }

    /**
     * 生成图片验证码组，用于合成gif动态图 ，长度固定为10
     *
     * @param type 验证码类型
     * <br/> type=0，验证码类型为仅数字,即0~9
     * <br/> type=1，验证码类型为仅字母,即大小写字母混合
     * <br/> type=2， 验证码类型为数字和大小写字母混合
     * <br/> type=3，验证码类型为数字和大写字母混合
     * <br/> type=4，验证码类型为数字和小写字母混合
     * <br/> type=5，验证码类型为仅大写字母
     * <br/> type=6，验证码类型为仅小写字母
     * @param length 验证码字符长度,（即验证码的个数），如果长度小于0，则默认为4
     * @param excludeString 需排除的特殊字符
     * @param width 图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
     * @param height 图片高度
     * @param interLine 图片中干扰线的条数
     * @param randomPosition 每个字符的高低位置是否随机
     * @param hasBoder 是否画边框
     * @param boderColor 边框颜色，若为null则表示采用随机颜色
     * @param backColor 图片颜色,若为null则表示采用随机颜色
     * @param fontColor 字体颜色,若为null则表示采用随机颜色
     * @param lineColor 干扰线颜色,若为null则表示采用随机颜色
     * @return 图片缓存对象
     */
    public static BufferedImage[] createImageCodes(int type, int length, String excludeString, int width, int height, int interLine, boolean randomPosition, boolean hasBoder, Color boderColor, Color backColor, Color fontColor, Color lineColor) {
        randomTextCode = createTextCode(type, length, excludeString);
        BufferedImage[] bImg = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            bImg[i] = createImageCode(randomTextCode, width, height, interLine, randomPosition, hasBoder, boderColor, backColor, fontColor, lineColor);
        }
        setRandomTextCode(randomTextCode);
        return bImg;
    }

    /**
     * 生成验证码字符串
     *
     * @param type 验证码类型
     * <br/> type=0，验证码类型为仅数字,即0~9
     * <br/> type=1，验证码类型为仅字母,即大小写字母混合
     * <br/> type=2， 验证码类型为数字和大小写字母混合
     * <br/> type=3，验证码类型为数字和大写字母混合
     * <br/> type=4，验证码类型为数字和小写字母混合
     * <br/> type=5，验证码类型为仅大写字母
     * <br/> type=6，验证码类型为仅小写字母
     * @param length 验证码长度,要求大于0的整数 ，如果小于0，则默认为4
     * @param excludeString 需排除的特殊字符（无需排除则为null）
     * @return 验证码字符串
     */
    private static String createTextCode(int type, int length, String excludeString) {
        if (length <= 0) {
            length = 4;
        }
        StringBuffer verifyCode = new StringBuffer();
        int i = 0;
        Random random = new Random();
        switch (type) {
            case 0:
                while (i < length) {
                    int t = random.nextInt(10);
                    // 排除特殊字符
                    if (null == excludeString || excludeString.indexOf(t + "") < 0) {
                        verifyCode.append(t);
                        i++;
                    }
                }
                break;
            case 1:
                while (i < length) {
                    // ASCII码表中，A-Z对应十进制是65-90，a-z对应十进制97-122
                    int t = random.nextInt(123);
                    if ((t >= 97 || (t >= 65 && t <= 90))
                            && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case 2:
                while (i < length) {
                    int t = random.nextInt(123);
                    // ASCII码表中，0-9对应十进制是48-57
                    if ((t >= 97 || (t >= 65 && t <= 90) || (t >= 48 && t <= 57))
                            && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case 3:
                while (i < length) {
                    int t = random.nextInt(91);
                    if ((t >= 65 || (t >= 48 && t <= 57))
                            && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case 4:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97 || (t >= 48 && t <= 57))
                            && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case 5:
                while (i < length) {
                    int t = random.nextInt(91);
                    if ((t >= 65) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case 6:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
        }
        return verifyCode.toString();
    }

    /**
     * 生成验证码图片
     *
     * @param textCode 文本验证码
     * @param width 图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
     * @param height 图片高度
     * @param interLine 图片中干扰线的条数
     * @param randomPosition 每个字符的高低位置是否随机
     * @param hasBoder 是否画边框
     * @param boderColor 边框颜色，若为null则表示采用随机颜色
     * @param backColor 图片颜色,若为null则表示采用随机颜色
     * @param fontColor 字体颜色,若为null则表示采用随机颜色
     * @param lineColor 干扰线颜色,若为null则表示采用随机颜色
     * @return 图片缓存对象
     */
    private static BufferedImage createImageCode(String textCode, int width, int height, int interLine, boolean randomPosition, boolean hasBoder, Color boderColor, Color backColor, Color fontColor, Color lineColor) {
        // 创建 图片缓存对象
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics graphics = bufferedImage.getGraphics();
        // 绘制背景图
        graphics.setColor(null == backColor ? getRandomColor() : backColor);
        // 填充一个矩形，第一个参数：要填充的矩形的起始x坐标；第二个参数：要填充的矩形的起始y坐标；第三个参数：要填充的矩形的宽度；第四个参数：要填充的矩形的高度；
        graphics.fillRect(0, 0, width, height);
        if (hasBoder) {
            // 画边框
            graphics.setColor(null == boderColor ? getRandomColor() : boderColor);
            graphics.drawRect(0, 0, width - 1, height - 1);
        }
        // 画干扰线
        Random random = new Random();
        if (interLine > 0) {
            // 定义坐标
            int x1 = 0, y1 = 0, x2 = width, y2 = 0;
            for (int i = 0; i < interLine; i++) {
                graphics.setColor(null == lineColor ? getRandomColor() : lineColor);
                // 重直方向随机起点
                y1 = random.nextInt(height);
                // 重直方向随机终点
                y2 = random.nextInt(height);
                // 第一个参数：第一个点的x坐标；第二个参数：第一个点的y坐标；第三个参数：第二个点的x坐标；第四个参数：第二个点的y坐标；
                graphics.drawLine(x1, y1, x2, y2);
            }
        }
        // 字体大小为图片高度的80%
        int fontSize = (int) (height * 0.8);
        // 设置第一个字符x坐标
        int fontX = height - fontSize;
        // 设置第一个字符y坐标
        int fontY = fontSize;
        // 设定字体
        graphics.setFont(new Font("Default", Font.PLAIN, fontSize));
        // 写验证码字符
        for (int i = 0; i < textCode.length(); i++) {
            fontY = randomPosition ? (int) ((Math.random() * 0.3 + 0.6) * height) : fontY;
            graphics.setColor(null == fontColor ? getRandomColor() : fontColor);
            // 将验证码字符显示到图象中，画字符串，x坐标即字符串左边位置，y坐标是指baseline的y坐标，即字体所在矩形的左上角y坐标+ascent
            graphics.drawString(textCode.charAt(i) + "", fontX, fontY);
            // 移动下一个字符的x坐标
            fontX += fontSize * 0.9;
        }
        graphics.dispose();
        return bufferedImage;
    }

    /**
     * 获取gif图片输入流
     *
     * @param type 验证码类型
     * <br/> type=0，验证码类型为仅数字,即0~9
     * <br/> type=1，验证码类型为仅字母,即大小写字母混合
     * <br/> type=2， 验证码类型为数字和大小写字母混合
     * <br/> type=3，验证码类型为数字和大写字母混合
     * <br/> type=4，验证码类型为数字和小写字母混合
     * <br/> type=5，验证码类型为仅大写字母
     * <br/> type=6，验证码类型为仅小写字母
     * @param length 验证码字符长度,（即验证码的个数），如果长度小于0，则默认为4
     * @param excludeString 需排除的特殊字符
     * @param width 图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
     * @param height 图片高度
     * @param interLine 图片中干扰线的条数
     * @param randomPosition 每个字符的高低位置是否随机
     * @param hasBoder 是否画边框
     * @param boderColor 边框颜色，若为null则表示采用随机颜色
     * @param backColor 图片颜色,若为null则表示采用随机颜色
     * @param fontColor 字体颜色,若为null则表示采用随机颜色
     * @param lineColor 干扰线颜色,若为null则表示采用随机颜色
     * @return 文件字节输入流
     */
    public static FileInputStream createTempGifFile(int type, int length, String excludeString, int width, int height, int interLine, boolean randomPosition, boolean hasBoder, Color boderColor, Color backColor, Color fontColor, Color lineColor) {
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
            BufferedImage[] src = createImageCodes(type, length, excludeString, width, height, interLine, randomPosition, hasBoder, boderColor, backColor, fontColor, lineColor);
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
