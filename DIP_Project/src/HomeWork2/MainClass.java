package HomeWork2;

import MyAlgorithms.Algorithms;
import MyImageIO.BMP;
import MyImageIO.ImageWriter;
import MyImageIO.JPG;

public class MainClass {

	public static void main(String[] args){
		
		
		
		
		//二值化处理
		BMP bmp = new BMP("images\\lena.bmp");
	    ImageWriter.BMPWriter(bmp, Algorithms.Binaryzation(bmp.getColorTable(),30),"images\\lena_binaryzation.bmp");
	    
	    //灰度处理
		JPG jpg = new JPG("images\\lena_color_512.jpg");
	    ImageWriter.JPGWriter(Algorithms.ImageGray(jpg),jpg.getWidth(),jpg.getHeight(),"lena_512_gray.jpg");
		
		//图像融合
	    JPG Fig1 = new JPG("images\\Fig1.jpg");
	    JPG Fig2 = new JPG("images\\Fig2.jpg");
	    ImageWriter.JPGWriter(Algorithms.ImageFusion(Fig1, Fig2, 0.5, 0.5),Fig1.getWidth(),Fig2.getHeight(),"Fig1&2fusion.jpg");
	    
		//直方图均衡
	    JPG jpg1 = new JPG("images\\Fig2.jpg");
		ImageWriter.JPGWriter(Algorithms.Hist_Equalization(jpg1),jpg1.getWidth(),jpg1.getHeight(),"Fusion_Histeq.jpg");
		 
	}

}
