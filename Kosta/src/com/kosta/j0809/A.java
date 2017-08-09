package com.kosta.j0809;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//기능정의
		System.out.println("끝낼께~^^");
		System.exit(0);//프로그램 종료 메소드
	}

}