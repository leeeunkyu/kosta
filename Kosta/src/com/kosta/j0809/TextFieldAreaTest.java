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
	   
	   
	  //����ʱ�ȭ, ��ü���� 
	  //tf1 = new TextField(String text�⺻��, int columns���α���);
	  tf1 = new TextField("�ȳ�", 15);
	  tf2 = new TextField(10);//int columns ---> ���α���
	  ta = new TextArea();
	  la = new Label("�����̸�:");
	  
	  //���� ���� - background(������)  foreground(���ڻ�)
	   //setBackground(Color c);
	   //Color(int r, int g, int b)   �� ����: 0~255  
	  northp = new Panel();
	    northp.setBackground(new Color(0,255,0));
	    northp.setForeground(new Color(255,0,0));
	    northp.add(tf1);
	  
	  southp = new Panel();//���� ��ȭ��
	    //southp.setLayout(new FlowLayout());//��� ����
	    southp.setBackground(Color.ORANGE);//(Color.YELLOW);//(new Color(255,255,0));
	    southp.add(la);
	    southp.add(tf2);
	  
	   
	  setTitle("TextFieldArea�׽�Ʈ");
	  //setLayout(new BorderLayout());//��ġ����
	  
	  //add("North",tf1);
	  add("North",northp);
	  add("Center",ta);
	  //add("South",la);
	  //add("South",tf2);
	  add("South",southp);
	  
	  setSize(300, 300);
	  setVisible(true);
	}//������
   
   public static void main(String[] args) {
	  new TextFieldAreaTest();
   }
}




