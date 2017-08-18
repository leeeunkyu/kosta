package com.kosta.j0818;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements ActionListener,Runnable{//����
   JList<String> roomInfo,roomInwon,waitInfo;
   JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
   JButton bt_create, bt_enter, bt_exit;
   
   JPanel p;
   ChatClient cc;
   
   BufferedReader in;
   OutputStream out;
   
   String selectedRoom;//���õ� ������
      
   public MainChat() {	 
	 setTitle("����");
	 
	 cc = new ChatClient();
	 
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("������"));
	   
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("�ο�����"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("��������"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("�游���");
     bt_enter = new JButton("�����");
     bt_exit = new JButton("������");     
     
     p = new JPanel();
     
     sp_roomInfo.setBounds(10, 10, 300, 300);
     sp_roomInwon.setBounds(320, 10, 150, 300);
     sp_waitInfo.setBounds(10, 320, 300, 130);
     
     bt_create.setBounds(320,330,150,30);
     bt_enter.setBounds(320,370,150,30);
     bt_exit.setBounds(320,410,150,30);
     
     p.setLayout(null);
      p.setBackground(Color.orange);
     p.add(sp_roomInfo);
     p.add(sp_roomInwon);
     p.add(sp_waitInfo);
     p.add(bt_create);
     p.add(bt_enter);
     p.add(bt_exit);
     
     add(p);
     setBounds(300,200, 500, 500);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE);     
     
     String nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
     
     connect();//��������õ� (in,out��ü����)
     sendMsg("500|"+nickName);
     sendMsg("100|");
     
     new Thread(this).start();
     
     eventUp();
   }//������

   private void eventUp(){//�̺�Ʈ�ҽ�-�̺�Ʈó���� ����
	   //����(MainChat)
	   bt_create.addActionListener(this);
	   bt_enter.addActionListener(this);
	   
	   roomInfo.addMouseListener(new MouseAdapter() {//������List ���콺Ŭ��(����)
	   
		   @Override
		  public void mouseClicked(MouseEvent e) {
			   String str = roomInfo.getSelectedValue();
			                   //"�ڹٹ�--1"
			   selectedRoom = str.substring(0, str.indexOf("--"));
		  }	   
	   });
	   
	   
	   
	   
	   
	   //��ȭ��(ChatClient)   
	   cc.bt_exit.addActionListener(this);
	   cc.sendTF.addActionListener(this);
	   cc.bt_change.addActionListener(this);
	   
	   cc.addWindowListener(new WindowAdapter() {
	       @Override
	    public void windowClosing(WindowEvent e) {
	    	 //��ȭ�� ---> ����
	 		  cc.setVisible(false);
	 		  setVisible(true);
	    }
	   });
	   
   }//eventUp
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	  
	  if(ob== bt_create) {//����: �游���
		  String title = JOptionPane.showInputDialog(this, "������");
		  
		  sendMsg("200|"+title);
		  
		  cc.setTitle("ä�ù�-["+title+"]");
		  
		  //���� ---> ��ȭ��
		  setVisible(false);
		  cc.setVisible(true);
	  }else if(ob== cc.bt_exit) {//��ȭ��: ������
		  
		  //��ȭ�� ---> ����
		  cc.setVisible(false);
		  setVisible(true);
	  }else if(ob== cc.sendTF) {//��ȭ��: �ؽ�Ʈ�ʵ� �Է�
		  
		  String msg = cc.sendTF.getText().trim();
		  if(msg.length() < 1) return;
		  
		  sendMsg("300|"+msg);
		  
		  cc.sendTF.setText("");
	  }else if(ob== cc.bt_change) {//��ȭ��: ��ȭ���� 
		  
		  String nickName = JOptionPane.showInputDialog(cc,"�����ȭ��:");
	      sendMsg("500|"+nickName);  
	  }else if(ob== bt_enter) {//����: �����
		  sendMsg("110|"+selectedRoom);
		  		  
		  cc.setTitle("ä�ù�-["+selectedRoom+"]");
		  //���� ---> ��ȭ��
		  setVisible(false);
		  cc.setVisible(true);
	  }
	   
   }//actionPerformed
   
   
   public void connect(){//(����)�������� ��û
	  //Socket s = new Socket("����host-->ip", int port);
	   //"localhost" ---> ���� ������ ����Ǵ� PC ip  ,"127.0.0.1"
	  
	try {
		Socket s = new Socket("192.168.0.111", 8282); //����õ�		  
		  in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		  out = s.getOutputStream();
	 } catch (UnknownHostException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	 }	  
   }//connect
   
   public void sendMsg(String msg){//�������� �޽��� ������
	 try {
		out.write(  (msg+"\n").getBytes()   );
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//sendMsg
   
   @Override
   public void run(){//������ ���� ��� �޽��� �б�	   
	  try {
		while(true){
			 String msg = in.readLine();//"200|�ڹٹ�--1,SQL��--1"
			 
			 String msgs[]=msg.split("\\|");
			 
			 String protocol = msgs[0];
			 switch(protocol) {
			     case "200":  //msgs[1]="�ڹٹ�--1,SQL��--1";
			    	 String listData[]=msgs[1].split(",");			    	 
			    	 roomInfo.setListData(listData);
			    	 break;
			     case "300": 
			    	 cc.ta.append(msgs[1]+"\n");
			    	 cc.ta.setCaretPosition(cc.ta.getText().length());//������ũ�ѹ� �����ֱ�
			 }//switch
		  }//while	 
	   } catch (IOException e) {
		e.printStackTrace();
	   }
	  
   }//run
   
   
   public static void main(String[] args) {
	  new MainChat();
   }


}


