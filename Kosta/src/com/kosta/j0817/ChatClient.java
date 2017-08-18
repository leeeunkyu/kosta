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
   //소켓입출력 객체
   BufferedReader in;
   OutputStream out;
   String nickName;
   boolean flag=true;
   public ChatClient() {
	  setTitle("채팅방");
	  btn= new JButton("이름변경");
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
	  
	  connProcess();//in,out객체 생성
	  chat();

	  
      eventUp();
   }//생성자
   public void chat() {
	   	flag=true;
		  nickName = JOptionPane.showInputDialog(this,"대화명:");
		  try {
			out.write( (nickName+"\n").getBytes());
		   } catch (IOException e) {
			e.printStackTrace();
		  }   
		  new Thread(this).start();//in.readLine() 
   }
   public void connProcess() {//서버연결	  
	  try {
		Socket s = new Socket("192.168.0.111", 3000);
		  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  out = s.getOutputStream();
		System.out.println("서버연결 성공!!");
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//connProcess
   
   public void sendProcess(String msg) {//서버에게 메시지 전달
	  try {
		out.write( (msg+"\n").getBytes());
	} catch (IOException e) {
		e.printStackTrace();
	} 
   }//sendProcess
   
   public void run() {//스레드를 사용한 이유: GUI와 별개로 서버데이터를 받기 위해
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