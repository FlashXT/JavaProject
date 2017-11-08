package Test;

public class TestColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rgb =255<<16|255<<8;
		int hexrgb=0xffff00;
		
		System.out.println(rgb);
		System.out.println(hexrgb);
		System.out.println(hexrgb == rgb);
	}

}
