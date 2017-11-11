package MyImageIO;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;


public class JPG extends MyImage{
	
	int width;
	int height;
	String imagepath;
	int [][][] jpgData;
	int graylevel;
	
	public int getGraylevel() {
		return graylevel;
	}
	public void setGraylevel(int graylevel) {
		this.graylevel = graylevel;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int[][][] getJpgData() {
		return jpgData;
	}
	public void setJpgData(int[][][] jpgData) {
		this.jpgData = jpgData;
	}
	
	
	//Constructor
	public JPG(){ }
	public JPG(String path){
		 File file = new File(path);
		 BufferedImage image = null;
		 try {
				image = ImageIO.read(file);
			 } catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Can't find the Image !");
			 }
		 this.width= image.getWidth();
		 this.height= image.getHeight();
		 
		 this.graylevel = 256;
		 this.imagepath = path;
		 this.jpgData = new int [this.height][this.width][3];
		 for (int i = 0; i < this.height; i++) {
	            for (int j = 0; j < this.width; j++) {
	                int pixel = image.getRGB(j,i);
	                this.jpgData[i][j][0] = (pixel & 0xff0000) >> 16;
	            	this.jpgData[i][j][1] = (pixel & 0xff00) >> 8;
	            	this.jpgData[i][j][2] = (pixel & 0xff);
		        }
	     }
		 
	}
	
	public void getJpgInfo(){
		        System.out.println("The info of the image:");
			    System.out.println("\t\t\tWidth:\t\t"+width);
			    System.out.println("\t\t\tHeight:\t\t"+height);
			    System.out.println("\t\t\tGraylevel:\t"+this.graylevel);
			    System.out.println("\tThe piexls info is writed in : images\\jpgData.txt!");
				try {
					 FileOutputStream fos = new FileOutputStream("images\\jpgData.txt");				
				     DataOutputStream dos = new DataOutputStream(fos);
					 dos.write("R\tB\tG\n".getBytes("UTF-8"));
				
					 for(int i = 0; i <jpgData.length ; i++){
						 for(int j = 0;j<jpgData[i].length;j++){
							 dos.write((Integer.toString(jpgData[i][j][0])+"\t").getBytes("UTF-8"));
							 dos.write((Integer.toString(jpgData[i][j][1])+"\t").getBytes("UTF-8"));
							 dos.write((Integer.toString(jpgData[i][j][2])+"\t").getBytes("UTF-8"));
							 dos.write("\n".getBytes("UTF-8"));
						 }		 
					 }	
					 dos.close();
					 fos.close();
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		
	}
	
	public int Rgb2Int(int red, int green, int blue){
	
		return red<<16|green<<8|blue;
	
	}
	
	
	
//	public static void main(String[] args) throws Exception {
//			// TODO Auto-generated method stub
//	        new JPG("images\\sea.jpg").getJpgInfo();;
//	 }
	
	
	
	
}
	 
	 
	 
	 
	 
	 