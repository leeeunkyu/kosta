package com.kosta.j0810;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest2 extends Frame implements ActionListener{
	Button bt1,bt2,bt3;
	public EventTest2() {
		bt1 = new Button("안녕");
		bt2 = new Button("타이틀 카운트");
		bt3 = new Button("종료");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(bt3);
		bt1.addActionListener(this);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new EventTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("안녕");
	}
}
