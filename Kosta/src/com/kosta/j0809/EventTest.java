package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame  implements ActionListener{
   Button bt;//�̺�Ʈ �ҽ�!!(��� �߻���Ű�� ������Ʈ)
	
   //bt ----> ActionEvent����  -----> Action+Listener
   //ActionListener   -----> ����� �޼ҵ� : actionPerformed();
   
   public EventTest() {
	   bt = new Button("������~!!");
	   
	   setTitle("�̺�Ʈ �׽�Ʈ");
	   setLayout(new FlowLayout());
	   add(bt);
	   
	   setSize(300,300);
	   setVisible(true);
	   
	   //������(�ҽ�-�ڵ鷯)�޼ҵ� ���(ȣ��)
	   //�̺�Ʈ�ҽ�.add�������̽���(�ڵ鷯��ġ);
	   
	   //bt.addActionListener(this);
	   
	   A a = new A();
	   bt.addActionListener(a);
   }//������
   
   @Override
   public void actionPerformed(ActionEvent arg0) {//�̺�Ʈ ó����(Event Handler)
	   //���(�̺�Ʈ) �߻��� ó���� ���� �ڵ�.
	   //��� ����!!
	   System.out.println("�� ������??");
	   
   }//actionPerformed
   
   
   public static void main(String[] args) {
	  new EventTest();
   }

}