package HomeWork2;

import MyAlgorithms.algorithms;
import UI.UIFrame;

public class MainClass {

	public static void main(String[] args){
		
		 new UIFrame();     
		String src="images\\Lena.bmp";
		 try {
			 	BMP bmp = new BMP(src);
			 	bmp.toString();
			 	algorithms.Binaryzation(bmp,"lena2.bmp",30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		}
	}

}
