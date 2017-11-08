package HomeWork2;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class JPG{
	
	//Constructor
	public JPG(){}
	public JPG(String imagepath,String destpath){
	        File file = new File(imagepath);
	        BufferedImage image = null;
	        FileOutputStream fos = null;
			try {
				image = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Can't find the Image !");
				}
		        int width = image.getWidth();
		        int height = image.getHeight();
			    int [][][] jpgData = new int[height][width][3];
			    System.out.println("Width:"+width);
			   
			    System.out.println("Height:"+height);
			    System.out.println("jpgData.length:"+jpgData.length);
			    System.out.println("jpgData[0].length:"+jpgData[0].length);
			    for (int i = 0; i < height; i++) {
		            for (int j = 0; j < width; j++) {
		                int pixel = image.getRGB(j,i); // 下面三行代码将一个数字转换为RGB数字
		                jpgData[i][j][0] = (pixel & 0xff0000) >> 16;
		            	jpgData[i][j][1] = (pixel & 0xff00) >> 8;
		            	jpgData[i][j][2] = (pixel & 0xff);
			        }
		   }
		    //输出图片的像素数据
			try {
					fos = new FileOutputStream("jpgData.txt");				
					DataOutputStream dos = new DataOutputStream(fos);
					dos.write(" R\t B\t G\n".getBytes("UTF-8"));
					for(int i = 0; i <jpgData.length ; i++){
						 for(int j = 0;j<jpgData[i].length;j++){
							 dos.write((Integer.toString(jpgData[i][j][0])+"\t").getBytes("UTF-8"));
							 dos.write((Integer.toString(jpgData[i][j][1])+"\t").getBytes("UTF-8"));
							 dos.write((Integer.toString(jpgData[i][j][2])+"\t").getBytes("UTF-8"));
							 dos.write("\n".getBytes("UTF-8"));
						 }		
						 
					}	
					dos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	//像素级修改jpg图片
	public void jpgWriter(String src,String dest) throws IOException{
		    File file = new File(src);
	        BufferedImage image = null;
	        //FileOutputStream fos = null,fos2 = null;
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Can't find the Image !");
			}
	        int width = image.getWidth();
	        int height = image.getHeight();
		    int [][][] jpgData = new int[height][width][3];
		    
		    for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	                int pixel = image.getRGB(j,i); // 下面三行代码将一个数字转换为RGB数字
	                jpgData[i][j][0] = (pixel & 0xff0000) >> 16;
	            	jpgData[i][j][1] = (pixel & 0xff00) >> 8;
	            	jpgData[i][j][2] = (pixel & 0xff);
		        }
		    }
		    int temp = 0;
		    for (int i = 0; i < height; i++) {
	            for (int j = 0; j < width; j++) {
	            	temp =  (jpgData[i][j][0]+ jpgData[i][j][1]+ jpgData[i][j][2])/3;
	            	if(temp >150){
	            		int rgb =Rgb2Int(0,255,255);
	            		image.setRGB(j,i,rgb);
	            	}
		        }
		    }
		    ImageIO.write(image,"jpg",new File(dest));
		    System.out.println("Complete!");		
	}
	public int Rgb2Int(int red, int green, int blue){
	
		return red<<16|green<<8|blue;
	
	}
	public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	        new JPG().jpgWriter("images\\flash.jpg","images\\flash2.jpg");
	 }
	
	
	
	
}
	 
	 
	 
	 
	 
	 