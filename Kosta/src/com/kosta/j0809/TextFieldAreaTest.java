package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
   TextField tf1,tf2;
   TextArea ta;	
   Label la;   
   Panel southp, northp;
	
   public TextFieldAreaTest() {
	   
	   
	  //멤버초기화, 객체생성 
	  //tf1 = new TextField(String text기본값, int columns가로길이);
	  tf1 = new TextField("안녕", 15);
	  tf2 = new TextField(10);//int columns ---> 가로길이
	  ta = new TextArea();
	  la = new Label("파일이름:");
	  
	  //색상 설정 - background(바탕색)  foreground(글자색)
	   //setBackground(Color c);
	   //Color(int r, int g, int b)   각 색상: 0~255  
	  northp = new Panel();
	    northp.setBackground(new Color(0,255,0));
	    northp.setForeground(new Color(255,0,0));
	    northp.add(tf1);
	  
	  southp = new Panel();//작은 도화지
	    //southp.setLayout(new FlowLayout());//가운데 정렬
	    southp.setBackground(Color.ORANGE);//(Color.YELLOW);//(new Color(255,255,0));
	    southp.add(la);
	    southp.add(tf2);
	  
	   
	  setTitle("TextFieldArea테스트");
	  //setLayout(new BorderLayout());//위치정렬
	  
	  //add("North",tf1);
	  add("North",northp);
	  add("Center",ta);
	  //add("South",la);
	  //add("South",tf2);
	  add("South",southp);
	  
	  setSize(300, 300);
	  setVisible(true);
	}//생성자
   
   public static void main(String[] args) {
	  new TextFieldAreaTest();
   }
}




