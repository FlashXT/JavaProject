package Test;

public class testint2HexString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=255;
		byte[] b =new byte[4];
		Int2ByteArray(i,b);
		System.out.println(b[3]+"\t"+b[2]+"\t"+b[1]+"\t"+b[0]);
	}
	
	protected static void Int2ByteArray(int i,byte[] b)
    {	
	   b[3] = (byte) ((i>>24)&0xff);
	   b[2] = (byte) ((i>>16)&0xff);
	   b[1] = (byte) ((i>>8)&0xff);
	   b[0] = (byte) (i&0xff);
    }
}
