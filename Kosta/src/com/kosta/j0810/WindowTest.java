package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//������ ---> WindowEvent����

public class WindowTest extends Frame implements WindowListener{
   //������â �ݱ�!!	
	
   public WindowTest() {	   
	  setTitle("�������̺�Ʈó��");
	  
	  setSize(300,300);
	  setVisible(true);
	  
	  addWindowListener(this);
   }//������
   
   
   public static void main(String[] args) {
	  new WindowTest();
   }


@Override
public void windowActivated(WindowEvent e) {}
@Override
public void windowClosed(WindowEvent e) {}
@Override
public void windowClosing(WindowEvent e) {//X��ư �������� ȣ��Ǵ� �޼ҵ�
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