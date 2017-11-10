package HomeWork2;

import java.io.IOException;

import javax.swing.JPanel;

import MyAlgorithms.Algorithms;
import UI.UIFrame;

public class MainClass extends JPanel{

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
		
	    JPG jpg1 = new JPG("images\\Fig1.jpg");
	    JPG jpg2 = new JPG("images\\Fig1.jpg");
	    String dest = "Figfusion.jpg";
	    Algorithms.ImageFusion(jpg1,jpg2,0.5,0.5,dest);
	    
	}

}
