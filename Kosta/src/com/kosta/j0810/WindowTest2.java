package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//������ ---> WindowEvent����

public class WindowTest2  extends WindowAdapter{
   //������â �ݱ�!!	
   Frame f;
	
   public WindowTest2() {
	  f = new Frame(); 
	   
	  f.setTitle("�������̺�Ʈó��2");
	  
	  f.setSize(300,300);
	  f.setVisible(true);
	  
	  f.addWindowListener(this);
   }//������
   
   @Override
	public void windowClosing(WindowEvent e) {
	   System.out.println("windowClosing2");
	   System.exit(0);
	}
   
   public static void main(String[] args) {
	  new WindowTest2();
   }

}