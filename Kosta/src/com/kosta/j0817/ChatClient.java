package com.kosta.j0817;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
   
   JTextArea ta;
   JScrollPane ta_scroll;
   
   JTextField sendTF;   
   JPanel southp;
   JButton btn;
   //��������� ��ü
   BufferedReader in;
   OutputStream out;
   String nickName;
   boolean flag=true;
   public ChatClient() {
	  setTitle("ä�ù�");
	  btn= new JButton("�̸�����");
	  ta = new JTextArea();
	   ta.setEditable(false);
	  ta_scroll = new JScrollPane(ta);
	  
	  sendTF = new JTextField(15);
	  southp = new JPanel();
	    southp.add(new JLabel("Message:"));
	    southp.add(sendTF);
	    southp.add(btn);
	  add("Center",ta_scroll);
	  add("South", southp);
	  
	  setBounds(300,200, 300,500);
	  setVisible(true);	  
	  sendTF.requestFocus();
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  connProcess();//in,out��ü ����
	  chat();

	  
      eventUp();
   }//������
   public void chat() {
	   	flag=true;
		  nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
		  try {
			out.write( (nickName+"\n").getBytes());
		   } catch (IOException e) {
			e.printStackTrace();
		  }   
		  new Thread(this).start();//in.readLine() 
   }
   public void connProcess() {//��������	  
	  try {
		Socket s = new Socket("192.168.0.111", 3000);
		  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  out = s.getOutputStream();
		System.out.println("�������� ����!!");
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//connProcess
   
   public void sendProcess(String msg) {//�������� �޽��� ����
	  try {
		out.write( (msg+"\n").getBytes());
	} catch (IOException e) {
		e.printStackTrace();
	} 
   }//sendProcess
   
   public void run() {//�����带 ����� ����: GUI�� ������ ���������͸� �ޱ� ����
	  try {
		while(flag) { 
		    String msg = in.readLine();
		    ta.append(msg+"\n");
		    
		    ta.setCaretPosition(ta.getText().length());
		  }
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//run
   
   private void eventUp() {
	  sendTF.addActionListener(this);
	  btn.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	
	  if(e.getSource()==btn) {
		  flag=false;
		  chat();
		  
	  }else {
		  String msg = sendTF.getText().trim();
		  sendProcess(msg);
		  sendTF.setText("");
	  }
   }
   
   public static void main(String[] args) {
	   new ChatClient();
   }


}