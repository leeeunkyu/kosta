package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임 ---> WindowEvent정의

public class WindowTest3 extends Frame{
   //프레임창 닫기!!		
   public WindowTest3() {	   
	  setTitle("윈도우이벤트처리3");	  
	  setSize(300,300);
	  setVisible(true);	  
	  //addWindowListener(익명의 내부클래스정의);
	  addWindowListener(new WindowAdapter() {
		  @Override
		public void windowClosing(WindowEvent e) {
		      System.out.println("windowClosing3");
			  System.exit(0);
		}
	  });
	  
	  /*
	       class 무명 extends WindowAdapter{
	       
	       }
	   */
   }//생성자   
   
   public static void main(String[] args) {
	  new WindowTest3();
   }
}
