package MyAlgorithms;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import HomeWork2.BMP;

public class algorithms {
	
		public static void   Binaryzation(BMP bitmap,String dest,int threshold) throws Exception{
			
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

}
