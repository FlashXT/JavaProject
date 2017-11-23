package MyAlgorithms;

import MyImageIO.JPG;
import MyImageIO.MyImage;

public class Algorithms  {
	
	
	//二值化处理
	public static byte[][] Binaryzation(byte[][] bmcolortable,int threshold){
		
		 int average=0;
				 
		 for(int i = 0;i < bmcolortable.length;i++){
			 
			   average = (bmcolortable[i][0]&0xff+bmcolortable[i][1]&0xff+bmcolortable[i][2]&0xff)/3;	 
			   if(average >= threshold){
		
				   bmcolortable[i][0] = (byte) 0xff;
				   bmcolortable[i][1] = (byte) 0xff;
				   bmcolortable[i][2] = (byte) 0xff;
				 
				 }
			   else{ 
				   bmcolortable[i][0] = 0;
				   bmcolortable[i][1] = 0;
				   bmcolortable[i][2] = 0;
				 }
		 }
		 return bmcolortable;
	}
	
	//图像融合
	public static int [][][] ImageFusion(MyImage img1,MyImage img2,double rate1,double rate2) {
		
		
		
		JPG jpg1 = (JPG) img1;
		JPG jpg2 = (JPG) img2;
	
		int [][][] mpixels = new int [jpg1.getWidth()][jpg1.getHeight()][3];
		int [][][]jpg1Data = jpg1.getJpgData();
		int [][][]jpg2Data = jpg2.getJpgData();

		for(int i = 0 ; i < jpg1Data.length ; i++){
			for(int j = 0; j < jpg1Data[i].length ; j++){
				
				mpixels[i][j][0] = (int) (jpg1Data[i][j][0]*rate1+jpg2Data[i][j][0]*rate2);
				mpixels[i][j][1] = (int) (jpg1Data[i][j][1]*rate1+jpg2Data[i][j][1]*rate2);
				mpixels[i][j][2] = (int) (jpg1Data[i][j][2]*rate1+jpg2Data[i][j][2]*rate2);

			}
		}   
		return mpixels;	
			
	}

	//直方图均衡
	public static int [][][] Hist_Equalization(MyImage img) {
		
		JPG image = (JPG)img;
		int [][][] jpgData = image.getJpgData();
		int [] graylevel = new int[image.getGraylevel()];
		double [] grayratio = new double[image.getGraylevel()];

		for(int i=0 ; i <image.getHeight();i++){
			for (int j=0; j<image.getWidth();j++){
				graylevel[jpgData[i][j][0]]++;
			}
		}
		
		int sum = 0;
		for(int i=0 ; i <grayratio.length;i++){
			 sum+=graylevel[i];
		     grayratio[i] = sum*1.0/(image.getWidth()*image.getHeight());  
		}
		
		for(int i=0 ; i <image.getHeight();i++){
			for (int j=0; j<image.getWidth();j++){
				jpgData[i][j][0] = (int) Math.floor(grayratio[jpgData[i][j][0]]*255);
				jpgData[i][j][1] = (int) Math.floor(grayratio[jpgData[i][j][1]]*255);
				jpgData[i][j][2] = (int) Math.floor(grayratio[jpgData[i][j][2]]*255);
			}
		}
		return image.getJpgData();
	}
	

	//灰度处理
	public static int [][][] ImageGray(MyImage img){
			JPG image = (JPG)img; 
	        int width = image.getWidth();
	        int height = image.getHeight();
	        int temp = 0;
		    for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	            	temp = (image.getJpgData()[i][j][0]*30+image.getJpgData()[i][j][1]*59+image.getJpgData()[i][j][2]*11+50)/100;
	            	image.getJpgData()[i][j][0]=temp;
	            	image.getJpgData()[i][j][1]=temp;
	            	image.getJpgData()[i][j][2]=temp;
		        }
		    }	
		    
		    return image.getJpgData();
	}
	
}