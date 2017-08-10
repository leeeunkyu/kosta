package com.kosta.j0810;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	
   JButton bt,bt2;	
	
   public SwingTest() {
	   bt = new JButton("<html><font size=10 color=red face=궁서체>나버튼</font><br>"
	   		+ "<font size=10 color=blue face=궁서체>너버튼</font></html>");
	   bt2 = new JButton("가나다");
	   setLayout(new FlowLayout());
	   add(bt);
	   add(bt2);
	
	   setTitle("스윙GUI");
	   setSize(300,300);
	   setVisible(true);
	   
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//생성자

   public static void main(String[] args) {
	  new SwingTest();
   }
}