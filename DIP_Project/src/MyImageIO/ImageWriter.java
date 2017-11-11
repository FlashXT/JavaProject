package MyImageIO;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageWriter {
	
	public static void JPGWriter(int pixels[][][],int width,int height,String dest){
		
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);     
	    for(int i = 0 ; i < width ; i++){
			for(int j = 0; j < height ; j++){
				bi.setRGB(j,i, Rgb2Int(pixels[i][j][0],pixels[i][j][1],pixels[i][j][2]));
			}
		}    
	             
	    try {
				ImageIO.write(bi, "jpg",new File("images\\"+dest));
				System.out.println("Complete!");	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Failure!");	
			}
	    	
	
}
	public static void BMPWriter(BMP bitmap,byte[][] colortable,String dest){
		 FileOutputStream fos;
		try {
			 fos = new FileOutputStream(dest);
			 DataOutputStream dos = new DataOutputStream(fos);
		
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
					 
			 for(int i=0;i < bitmap.getColorTable().length;i++){
				   dos.write(colortable[i]);
				 }
			 	
			 for(int i = 0; i < bitmap.getBmpData().length; i++)
				 {
					for(int j=0; j<bitmap.getBmpData()[i].length;j++)
					{
						
						dos.write(bitmap.getBmpData()[i][j]);
					}			 
				 }
			fos.close();dos.close();
			System.out.println("Complete!");
		
		  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static int Rgb2Int(int red, int green, int blue){
		
		return red<<16|green<<8|blue;
	
	}

}
