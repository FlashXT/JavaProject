package Test;

public class Test_0xFF {
	
	public static void main(String [] args){
		byte [] b= new byte[1];
		b[0]= (byte)257;
		System.out.println(bytes2HexString(b));
		byte height=4;
		byte width =8;
		System.out.println(height*width);
	}
	
	public static String bytes2HexString(byte[] b){
		String ret="";
		for(int i=0;i<b.length;i++){
			String hex = Integer.toHexString(b[i]&0xFF);
			if(hex.length() == 1)
				hex='0'+ hex;
			
			ret += hex.toUpperCase();
		}
	    return ret;
	}
}