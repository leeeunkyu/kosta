package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{//�����̳� ��������,�߾ӿ� ������Ʈ ��ġ
   //������Ʈ, �����̳� ����
   Button bt1,bt2,bt3,bt4,bt5;	
   //Frame f;  
   
   public BorderTest(String title) {
	 super(title);//����Ŭ���� �����ڸ� ��������� ȣ�� ---> Ÿ��Ʋ ����  
	 setTitle("���������׽�Ʈ");  
   
	 //�ʵ� �ʱ�ȭ
	 bt1 = new Button("1");
	 bt2 = new Button("2");
	 bt3 = new Button("3");
	 bt4 = new Button("4");
	 bt5 = new Button("5");
	 
	 //�����̳�.add(������Ʈ);
	 //�����̳�.add("������ġ",������Ʈ);
	  // ------------>���� ��ġ: "North","South","West","East","Center"
	 
	 //�Ӽ�����
	 //setLayout(new BorderLayout());
	 //setLayout(new BorderLayout(int hgap,int vgap));
	 setLayout(new BorderLayout(20,0));//���� ������ ������Ʈ ���� ����
	 
	 this.add("North",bt1);
	 add("East",bt2);
	 add("South",bt3);
	 add("West",bt4);
	 add("Center",bt5);	   
	 
	 //������(�����ӻ�����,���̱� ����)
     setSize(300, 300);
     setVisible(true);
   }//������	
   	
	
   public static void main(String[] args) {//main()���� Ŭ���� --> Java Application
	  new BorderTest("Border�׽�Ʈ"); // == new Frame()�� ����
   }
}



