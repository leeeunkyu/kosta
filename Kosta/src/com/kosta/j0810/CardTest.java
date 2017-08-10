package com.kosta.j0810;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardTest extends Frame implements ActionListener{
   Button bt1,bt2,bt3;
   Panel yellowp, bluep, redp,//���� �г�
         p1,p2,p3; //ī��� ���
   CardLayout card; 
   
   public CardTest() {
     bt1 = new Button("����");
     bt2 = new Button("����");
     bt3 = new Button("����");
     
     yellowp = new Panel();
      yellowp.setBackground(Color.yellow);
     bluep = new Panel();
      bluep.setBackground(Color.blue);
     redp = new Panel();
      redp.setBackground(Color.red);
      
     p1 = new Panel();
      p1.setLayout(new BorderLayout());
      p1.add("Center", yellowp);
      p1.add("South", bt1);
    
     p2 = new Panel();
      p2.setLayout(new BorderLayout());
      p2.add("Center", bluep);
      p2.add("South", bt2);
      
     p3 = new Panel();
      p3.setLayout(new BorderLayout());
      p3.add("Center", redp);
      p3.add("South", bt3);
      
      
      card = new CardLayout();
     //setLayout(new BorderLayout());//������: �⺻���̾ƿ� 
     setLayout(card);//(new CardLayout());
     //add("����alias",p1); 
     add("a1",p1); //���
     add("a2",p2); //�Ķ�
     add("a3",p3); //����
    
       //card.show(Container parent,String name);
       // ��   ������             ���           ������
       card.show(this, "a2");
     
     setTitle("ī���׽�Ʈ");
     setSize(300, 200);
     setVisible(true); 
     addWindowListener(new WindowAdapter() {
		  @Override
		public void windowClosing(WindowEvent e) {
			  System.exit(0);
     }});
     
     
      eventUp();
   }//������
   
   private void eventUp(){
	   bt1.addActionListener(this);
	   bt2.addActionListener(this);
	   bt3.addActionListener(this);	   
   }  
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó����
	  Object ob =e.getSource();
	  if(ob==bt1)  card.show(this, "a2");
	  else if(ob==bt2) card.show(this, "a3");
	  else  card.show(this, "a1");	   
   }
   
   public static void main(String[] args) {
	   new CardTest();
   }


}