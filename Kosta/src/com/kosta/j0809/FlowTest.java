package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	
	//프로그램에 필요한 컴포넌트, 컨테이너에 대한 선언
	Button bt1,bt2,bt3,bt4,bt5;
	Frame f;
	
	public FlowTest() {
	  //컴포넌트, 컨테이너에 대한 초기화
	   bt1 = new Button("1버튼");	   
	   bt2 = new Button("2버튼");	   
	   bt3 = new Button("3버튼");	   
	   bt4 = new Button("4버튼");	   
	   bt5 = new Button("5버튼");
	   
	   f = new Frame("Flow테스트");
	   
	  //속성지정
	   //FlowLayout fl = new FlowLayout();
	   f.setLayout(new FlowLayout());//(fl);
	   f.add(bt1); //컨테이너.add(컴포넌트);
	   f.add(bt2);
	   f.add(bt3);
	   f.add(bt4);
	   f.add(bt5);
		
	  //마무리 (메소드 호출 2개 - 프레임 크기(가로,세로), 프레임보이기)
	   //f.setSize(int width가로,int height세로);
	   f.setSize(300, 300);
	   f.setVisible(true);
	}//생성자
	
	
	
	public static void main(String[] args) {
		//FlowTest ft = new FlowTest();
		new FlowTest();
	}//main

}




