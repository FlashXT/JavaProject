package MyImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {
	
	int [][] ImageData;
	
	public int[][] getImageData() {
		return ImageData;
	}
	public void setImageData(int[][] imageData) {
		ImageData = imageData;
	}
	
	public ImageWriter(int [][] ImageData) {
		this.ImageData = ImageData;
	}
	
	
	public void imageWriter(int w,int h,String dest){
		
//		 BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB); 
//		 for(int i = 0 ; i < jpg1Data.length ; i++){
//				for(int j = 0; j < jpg1Data[i].length ; j++){
//					
//					r = (int) (jpg1Data[i][j][0]*rate1+jpg2Data[i][j][0]*rate2);
//					g = (int) (jpg1Data[i][j][1]*rate1+jpg2Data[i][j][1]*rate2);
//					b = (int) (jpg1Data[i][j][2]*rate1+jpg2Data[i][j][2]*rate2);
//					mpixels[i*jpg1.getWidth()+j] = Rgb2Int(r, g, b);
//					fusionimage.setRGB(j,i,Rgb2Int(jpg1.getJpgData()[i][j][0],jpg1.getJpgData()[i][j][1],jpg1.getJpgData()[i][j][2]));
//					
//				}
//			}    
//		 try {
//			ImageIO.write(bi, "jpg",new File("images\\"+dest));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Error : Save the image faliure!");
//		}      
		
	}
	

}
