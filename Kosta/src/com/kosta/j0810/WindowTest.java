package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임 ---> WindowEvent정의

public class WindowTest extends Frame implements WindowListener{
   //프레임창 닫기!!	
	
   public WindowTest() {	   
	  setTitle("윈도우이벤트처리");
	  
	  setSize(300,300);
	  setVisible(true);
	  
	  addWindowListener(this);
   }//생성자
   
   
   public static void main(String[] args) {
	  new WindowTest();
   }


@Override
public void windowActivated(WindowEvent e) {}
@Override
public void windowClosed(WindowEvent e) {}
@Override
public void windowClosing(WindowEvent e) {//X버튼 눌렀을때 호출되는 메소드
	System.out.println("windowClosing");
	System.exit(0);
}
@Override
public void windowDeactivated(WindowEvent e) {}
@Override
public void windowDeiconified(WindowEvent e) {}
@Override
public void windowIconified(WindowEvent e) {}
@Override
public void windowOpened(WindowEvent e) {} 
}