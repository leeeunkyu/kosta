package com.kosta.j0811;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame{

   JRadioButton rbt1,rbt2,rbt3;	
	
   public JRadioButtonTest() {
	   ImageIcon icon1 = new ImageIcon("image/left.gif");
       ImageIcon icon2 = new ImageIcon("image/leftrollover.gif");
       ImageIcon icon3 = new ImageIcon("image/leftdown.gif");	   
	   
	   rbt1 = new JRadioButton("첫번째라디오버튼",icon1);
	     rbt1.setRolloverIcon(icon2);
	     rbt1.setPressedIcon(icon3);
	   rbt2 = new JRadioButton("두번째라디오버튼");
	   rbt3 = new JRadioButton("세번째라디오버튼");
	   
	   ButtonGroup bg = new ButtonGroup();
	      bg.add(rbt1);
	      bg.add(rbt2);
	      bg.add(rbt3);	   
	   
	   setTitle("JRadioButton테스트");
	   setLayout(new GridLayout(3, 1));
	   add(rbt1);
	   add(rbt2);
	   add(rbt3);
	   
	   setSize(300,300);
	   setVisible(true);
	   
	   setDefaultCloseOperation(EXIT_ON_CLOSE);	   
   }//생성자
      
   public static void main(String[] args) {
	  new JRadioButtonTest();
   }
}