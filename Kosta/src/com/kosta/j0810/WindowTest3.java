package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//������ ---> WindowEvent����

public class WindowTest3 extends Frame{
   //������â �ݱ�!!		
   public WindowTest3() {	   
	  setTitle("�������̺�Ʈó��3");	  
	  setSize(300,300);
	  setVisible(true);	  
	  //addWindowListener(�͸��� ����Ŭ��������);
	  addWindowListener(new WindowAdapter() {
		  @Override
		public void windowClosing(WindowEvent e) {
		      System.out.println("windowClosing3");
			  System.exit(0);
		}
	  });
	  
	  /*
	       class ���� extends WindowAdapter{
	       
	       }
	   */
   }//������   
   
   public static void main(String[] args) {
	  new WindowTest3();
   }
}
