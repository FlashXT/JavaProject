package UI;

import java.awt.Frame;

import javax.swing.JFrame;

import java.awt.Color;

public class TestJUI  extends Frame{
	
	public TestJUI(String str){
		super(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame JUI = new JFrame ("Hello AWT Frame !");
		JUI.setSize(400, 300);
//		JUI.setBackground(Color.red);
		JUI.setVisible(true);
		JUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
