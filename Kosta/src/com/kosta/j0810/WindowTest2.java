package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//프레임 ---> WindowEvent정의

public class WindowTest2  extends WindowAdapter{
   //프레임창 닫기!!	
   Frame f;
	
   public WindowTest2() {
	  f = new Frame(); 
	   
	  f.setTitle("윈도우이벤트처리2");
	  
	  f.setSize(300,300);
	  f.setVisible(true);
	  
	  f.addWindowListener(this);
   }//생성자
   
   @Override
	public void windowClosing(WindowEvent e) {
	   System.out.println("windowClosing2");
	   System.exit(0);
	}
   
   public static void main(String[] args) {
	  new WindowTest2();
   }

}