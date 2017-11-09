package HomeWork2;

import java.io.IOException;

import MyAlgorithms.Algorithms;
import UI.UIFrame;

public class MainClass extends JPannel{

	public static void main(String[] args) throws IOException{
		
//		new UIFrame();  
		
//		String src="images\\Lena.bmp";
//		 try {
//			 	BMP bmp = new BMP(src);
//			 	bmp.toString();
//			 	Algorithms.Binaryzation(bmp,"lena2.bmp",30);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			    e.printStackTrace();
//		}
		
	    JPG jpg1 = new JPG("images\\lena2.jpg");
	    JPG jpg2 = new JPG("images\\sea.jpg");
	    String dest = "images\\fusion.jpg";
	    Algorithms.ImageFusion(jpg1,jpg2,0.5,0.5,dest);
	    
	}

}
