package com.kosta.j0809;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame{
	Button b1,b2,b3,b4,b5;
	public GridTest() {
		// TODO Auto-generated constructor stub
		b1=new Button("1");
		b2=new Button("2");
		b3=new Button("3");
		b4=new Button("4");
		b5=new Button("5");
		
		setTitle("grid Å×½ºÆ®");
		setLayout(new GridLayout(2,3));
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridTest();
	}
}
