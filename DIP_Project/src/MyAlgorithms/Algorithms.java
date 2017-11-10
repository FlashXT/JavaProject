package MyAlgorithms;

import java.io.DataOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.awt.peer.ComponentPeer;
import java.awt.peer.LightweightPeer;

import javax.imageio.ImageIO;

import HomeWork2.BMP;
import HomeWork2.MyImage;
import HomeWork2.JPG;

public class Algorithms  {
	
	
	
	public static void Binaryzation(BMP bitmap,String dest,int threshold) throws Exception{
		
		 FileOutputStream fos=new FileOutputStream(dest);
		 DataOutputStream dos = new DataOutputStream(fos);
		 int average=0;
		 byte [] temp=new byte[4];
		 
		 dos.write(bitmap.getBmpheader());
		 dos.write(bitmap.getFilesize());
		 dos.write(bitmap.getReservedWord());
		 dos.write(bitmap.getBitmapOffset());
		 dos.write(bitmap.getBitmapInfoSize());
		 dos.write(bitmap.getWidth());
		 dos.write(bitmap.getHeight());
		 dos.write(bitmap.getBitPlane());
		 dos.write(bitmap.getBitCount());
		 dos.write(bitmap.getCompressionType());
		 dos.write(bitmap.getImageSize());
		 dos.write(bitmap.getXpixelPerMeter());
		 dos.write(bitmap.getYpixelPerMeter());
		 dos.write(bitmap.getColorUsed());
		 dos.write(bitmap.getImportantColor());
				 
		 for(int m=0;m<bitmap.getColorTable().length;m++){
			 
			   average = (bitmap.getColorTable()[m][0]&0xff+bitmap.getColorTable()[m][1]&0xff+bitmap.getColorTable()[m][2]&0xff)/3;	 
			   if(average >= threshold){
				   temp[0]=(byte) 0xff; temp[1]=(byte)0xff; temp[2]=(byte)0xff; 
				   //temp[3]=(byte)0xff;
				 }
			   else{ 
				   temp[0]=0; temp[1]=0; temp[2]=0; temp[3]=0;
				 }
			   dos.write(temp);
			 }
		 	
		 for(int i = 0; i < bitmap.getBmpData().length; i++)
			 {
				for(int j=0; j<bitmap.getBmpData()[i].length;j++)
				{
					
					dos.write(bitmap.getBmpData()[i][j]);
				}			 
			 }
		fos.close();dos.close();
	}

	public static void ImageFusion(MyImage img1,MyImage img2,double rate1,double rate2,String dest) throws IOException{
		
		
		
		JPG jpg1 = (JPG) img1;
		JPG jpg2 = (JPG) img2;
		 BufferedImage bi = null;
		int  [] mpixels = new int [jpg1.getWidth()*jpg1.getHeight()];
		int [][][]jpg1Data = jpg1.getJpgData();
		int [][][]jpg2Data = jpg2.getJpgData();
		
		int r,g,b;
		for(int i = 0 ; i < jpg1Data.length ; i++){
			for(int j = 0; j < jpg1Data[i].length ; j++){
				
				r = (int) (jpg1Data[i][j][0]*rate1+jpg2Data[i][j][0]*rate2);
				g = (int) (jpg1Data[i][j][1]*rate1+jpg2Data[i][j][1]*rate2);
				b = (int) (jpg1Data[i][j][2]*rate1+jpg2Data[i][j][2]*rate2);
				mpixels[i*jpg1.getWidth()+j] = Rgb2Int(r, g, b);
//				fusionimage.setRGB(j,i,Rgb2Int(jpg1.getJpgData()[i][j][0],jpg1.getJpgData()[i][j][1],jpg1.getJpgData()[i][j][2]));
				
			}
		}    
		bi = new BufferedImage(jpg1.getWidth(),jpg1.getHeight(),BufferedImage.TYPE_INT_RGB);     
        for(int i = 0 ; i < jpg1Data.length ; i++){
			for(int j = 0; j < jpg1Data[i].length ; j++){
				
				bi.setRGB(j,i, mpixels[i*jpg1.getWidth()+j]);
//				fusionimage.setRGB(j,i,Rgb2Int(jpg1.getJpgData()[i][j][0],jpg1.getJpgData()[i][j][1],jpg1.getJpgData()[i][j][2]));
				
			}
		}    
	             
	    ImageIO.write(bi, "jpg",new File("images\\"+dest));
	    System.out.println("Complete!");		
			
	}
	
	public static int Rgb2Int(int red, int green, int blue){
		
		return 255 << 24|red<<16|green<<8|blue;
	
	}
	
	public static void Hist_Equalization(MyImage img,String dest){
		
		JPG image = (JPG)img;
		int [][][] jpgData = image.getJpgData();
		
		int [] graylevel = new int[image.getGraylevel()];
		double [] grayratio = new double[image.getGraylevel()];
		for(int i=0 ; i <image.getWidth();i++){
			for (int j=0; j<image.getHeight();j++){
				graylevel[jpgData[i][j][0]]++;
			
			}
		}
		
		for(int i=0 ; i <grayratio.length;i++){
			
				grayratio[i] = graylevel[i]/(image.getWidth()*image.getHeight());
			
			
		}
//		int sum = 0;
		for( double i:grayratio){
			System.out.println(i);
			
		}
//		for( int i:graylevel){
//			System.out.println(i);
//			
//		}
//		System.out.println(sum);
		
		
		
		
		
		
	}
	
	public static void main(String [] args){
		
		 JPG jpg1 = new JPG("images\\lena.jpg");
		 String dest = "Hist_EQ.jpg";
		 Algorithms.Hist_Equalization(jpg1, dest);
		
		
	}
	
}