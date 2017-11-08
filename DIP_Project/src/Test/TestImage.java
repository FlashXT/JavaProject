package Test;


import java.awt.AWTException;
import java.awt.Dimension;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TestImage {
	/**
     * 读取一张图片的RGB值
     * 
     * @throws Exception
     */
    public void getImagePixel(String image) throws Exception {
        int[] rgb = new int[3];
        File file = new File(image);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
//        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
//        
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");
//                int rbg=253<<16+70<<8+66;
//                bi.setRGB(123, 123,rbg );
            }
        }
//        bi.setRGB(123, 123,rbg);
    }
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
//			int x = 0;
			TestImage rc = new TestImage();
//		    x = rc.getScreenPixel(100, 345);
//		    System.out.println(x + " - ");
		    rc.getImagePixel("images\\flash.jpg");
		    

		}

}
