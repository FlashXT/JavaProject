package Test;

import java.io.ByteArrayInputStream;  
import java.io.DataInputStream;  
import java.io.IOException; 
public class Test_JVM_Endian {
	
	    /** 
	     * 检验JVM的大小端模式 
	     */  
	    public static void main(String[] args) throws IOException  
	    {  
	        byte[] byteAr = new byte[4];  
	        byteAr[0] = 0x78;  
	        byteAr[1] = 0x56;  
	        byteAr[2] = 0x34;  
	        byteAr[3] = 0x12;  
	        ByteArrayInputStream bais = new ByteArrayInputStream(byteAr);  
	        DataInputStream dis = new DataInputStream(bais);  
	        System.out.println(Integer.toHexString(dis.readInt()));  
	    }   

}
