package com.kosta.calc.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcView extends JFrame{
	public JTextField tf_su1,tf_su2;
	public JComboBox<String> oper;
	public JButton bt_calc;
	public JLabel la_result;
	
	public CalcView() {
		// TODO Auto-generated constructor stub
		tf_su2= new JTextField(10);
		oper = new JComboBox<>();
		oper.addItem("+");
		oper.addItem("-");
		oper.addItem("*");
		oper.addItem("/");
		
		bt_calc = new JButton("°è»ê");
		la_result=new JLabel("");
		setLayout(new FlowLayout());
		add(tf_su1);
		add(oper);
		add(tf_su2);
		add(bt_calc);
		add(la_result);
		setBounds(300,300,270,270);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
