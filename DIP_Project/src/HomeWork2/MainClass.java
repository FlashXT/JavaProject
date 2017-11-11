package HomeWork2;

import java.io.IOException;
import javax.swing.JPanel;

import MyAlgorithms.Algorithms;
import MyImageIO.ImageWriter;
import MyImageIO.JPG;
import MyImageIO.MyImage;

public class MainClass extends JPanel{

	public static void main(String[] args) throws IOException{
		
		//二值化
//		String src="images\\lena.bmp";
//		 try {
//			 	BMP bmp = new BMP(src);
//			 	byte[][] colortable = Algorithms.Binaryzation(bmp.getColorTable(),30);
//			 	ImageWriter.BMPWriter(bmp,colortable,"images\\lenabinaryzation.bmp");
//			 	
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			    e.printStackTrace();
//		}
		//图像融合
//	    JPG jpg1 = new JPG("images\\lena.jpg");
//	    JPG jpg2 = new JPG("images\\sea.jpg");
//	    String dest = "lena&sea.jpg";
//	    Algorithms.ImageFusion(jpg1,jpg2,0.6,0.4);
	    
		//直方图均衡
		JPG jpg1 = new JPG("images\\lena_color_512.jpg");
		String dest = "lena_512_gray.jpg";
//		ImageWriter.JPGWriter(Algorithms.Hist_Equalization(jpg1),jpg1.getWidth(),jpg1.getHeight(),dest);
		
		
		ImageWriter.JPGWriter(Algorithms.ImageGray(jpg1),jpg1.getWidth(),jpg1.getHeight(),dest);
		 
	}

}
