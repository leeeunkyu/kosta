package com.kosta.j0809;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class CheckboxTest extends Frame{
  Panel northp, southp;
  Checkbox cb1,cb2,cb3,cb4;
  Label la;
  TextArea ta;
	
  public CheckboxTest() {
	 setTitle("체크박스테스트");
     
	 la = new Label("성별:");
	 
	 
	 //Checkbox(String label, CheckboxGroup group, boolean state) 
	 CheckboxGroup cg1 = new CheckboxGroup();
	 CheckboxGroup cg2 = new CheckboxGroup();
	 
	 cb1 = new Checkbox("사과");
	 cb2 = new Checkbox("딸기");
	 
	 cb3 = new Checkbox("남자", cg1, false);
	 cb4 = new Checkbox("여자", cg1, true);
	 //cb4 = new Checkbox("여자", cg2, true);
	 
	 ta = new TextArea(); 
	 
	 northp = new Panel();//기본: FlowLayout(가운데)
	   northp.add(cb1); 
	   northp.add(cb2);
	   northp.setBackground(Color.YELLOW);  
	      
	 southp = new Panel();
	   southp.add(la);  
	   southp.add(cb3);  
	   southp.add(cb4);
	   southp.setBackground(Color.PINK);
	   
	 //Frame기본: BorderLayout(방위정렬-가운데기준)  
	 add("North",northp);
	 add("Center",ta);
	 add("South", southp);
	 
	 setSize(300, 300);
	 setVisible(true);
  }//생성자
  public static void main(String[] args) {
	 new CheckboxTest();
  }
}





