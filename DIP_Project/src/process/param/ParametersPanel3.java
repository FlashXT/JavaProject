package process.param;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ParametersPanel3 extends JPanel 
{
	String str1, str2, par1, par2;
	JLabel pLabel, qLabel;
	JTextField pField, qField;
    Checkbox xbox, ybox;
    
	public ParametersPanel3(String s1, String s2, String p1, String p2)//�ı��� 
	{
		str1 = s1;
		str2 = s2;
		par1 = p1;
		par2 = p2;
		
		pLabel = new JLabel(str1);
		qLabel = new JLabel(str2);
		pField = new JTextField("0.5", 5);
		qField = new JTextField("0.5", 5);
						
		add(pLabel);		
		add(pField);
		add(qLabel);
		add(qField);
		
		setBorder(new CompoundBorder(
			BorderFactory.createTitledBorder("����ѡ��"),
			BorderFactory.createEmptyBorder(10, 10, 50, 10)));
	}
	
	public ParametersPanel3(String s1, String s2) //��ť
	{
		CheckboxGroup cbg = new CheckboxGroup();
		xbox = new Checkbox(s1, cbg, true);
		ybox = new Checkbox(s2, cbg, true);
		add(xbox); add(ybox);
		setBorder(new CompoundBorder(
		    BorderFactory.createTitledBorder("��ѡ��������"),
		    BorderFactory.createEmptyBorder(10, 10, 50, 10)));
	}
	
	public float getPadx() 
	{
		return Float.parseFloat(pField.getText());
	}
	
	public float getPady() 
	{
		return Float.parseFloat(qField.getText());
	}
	
	public int getRadioState()
	{
		if(xbox.getState())      return 0;
		else if(ybox.getState()) return 1;
		else return 0;
	}
}
