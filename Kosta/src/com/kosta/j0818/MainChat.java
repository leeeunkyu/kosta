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

public class MainChat extends JFrame implements ActionListener,Runnable{//대기실
   JList<String> roomInfo,roomInwon,waitInfo;
   JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
   JButton bt_create, bt_enter, bt_exit;
   
   JPanel p;
   ChatClient cc;
   
   BufferedReader in;
   OutputStream out;
   
   String selectedRoom;//선택된 방제목
      
   public MainChat() {	 
	 setTitle("대기실");
	 
	 cc = new ChatClient();
	 
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("방정보"));
	   
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("인원정보"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("대기실정보"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("방만들기");
     bt_enter = new JButton("방들어가기");
     bt_exit = new JButton("나가기");     
     
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
     
     String nickName = JOptionPane.showInputDialog(this,"대화명:");
     
     connect();//서버연결시도 (in,out객체생성)
     sendMsg("500|"+nickName);
     sendMsg("100|");
     
     new Thread(this).start();
     
     eventUp();
   }//생성자

   private void eventUp(){//이벤트소스-이벤트처리부 연결
	   //대기실(MainChat)
	   bt_create.addActionListener(this);
	   bt_enter.addActionListener(this);
	   
	   roomInfo.addMouseListener(new MouseAdapter() {//방정보List 마우스클릭(선택)
	   
		   @Override
		  public void mouseClicked(MouseEvent e) {
			   String str = roomInfo.getSelectedValue();
			                   //"자바방--1"
			   selectedRoom = str.substring(0, str.indexOf("--"));
		  }	   
	   });
	   
	   
	   
	   
	   
	   //대화방(ChatClient)   
	   cc.bt_exit.addActionListener(this);
	   cc.sendTF.addActionListener(this);
	   cc.bt_change.addActionListener(this);
	   
	   cc.addWindowListener(new WindowAdapter() {
	       @Override
	    public void windowClosing(WindowEvent e) {
	    	 //대화방 ---> 대기실
	 		  cc.setVisible(false);
	 		  setVisible(true);
	    }
	   });
	   
   }//eventUp
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	  
	  if(ob== bt_create) {//대기실: 방만들기
		  String title = JOptionPane.showInputDialog(this, "방제목");
		  
		  sendMsg("200|"+title);
		  
		  cc.setTitle("채팅방-["+title+"]");
		  
		  //대기실 ---> 대화방
		  setVisible(false);
		  cc.setVisible(true);
	  }else if(ob== cc.bt_exit) {//대화방: 나가기
		  
		  //대화방 ---> 대기실
		  cc.setVisible(false);
		  setVisible(true);
	  }else if(ob== cc.sendTF) {//대화방: 텍스트필드 입력
		  
		  String msg = cc.sendTF.getText().trim();
		  if(msg.length() < 1) return;
		  
		  sendMsg("300|"+msg);
		  
		  cc.sendTF.setText("");
	  }else if(ob== cc.bt_change) {//대화방: 대화명변경 
		  
		  String nickName = JOptionPane.showInputDialog(cc,"변경대화명:");
	      sendMsg("500|"+nickName);  
	  }else if(ob== bt_enter) {//대기실: 방들어가기
		  sendMsg("110|"+selectedRoom);
		  		  
		  cc.setTitle("채팅방-["+selectedRoom+"]");
		  //대기실 ---> 대화방
		  setVisible(false);
		  cc.setVisible(true);
	  }
	   
   }//actionPerformed
   
   
   public void connect(){//(소켓)서버연결 요청
	  //Socket s = new Socket("서버host-->ip", int port);
	   //"localhost" ---> 현재 소켓이 실행되는 PC ip  ,"127.0.0.1"
	  
	try {
		Socket s = new Socket("192.168.0.111", 8282); //연결시도		  
		  in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		  out = s.getOutputStream();
	 } catch (UnknownHostException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	 }	  
   }//connect
   
   public void sendMsg(String msg){//서버에게 메시지 보내기
	 try {
		out.write(  (msg+"\n").getBytes()   );
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//sendMsg
   
   @Override
   public void run(){//서버가 보낸 모든 메시지 읽기	   
	  try {
		while(true){
			 String msg = in.readLine();//"200|자바방--1,SQL방--1"
			 
			 String msgs[]=msg.split("\\|");
			 
			 String protocol = msgs[0];
			 switch(protocol) {
			     case "200":  //msgs[1]="자바방--1,SQL방--1";
			    	 String listData[]=msgs[1].split(",");			    	 
			    	 roomInfo.setListData(listData);
			    	 break;
			     case "300": 
			    	 cc.ta.append(msgs[1]+"\n");
			    	 cc.ta.setCaretPosition(cc.ta.getText().length());//수직스크롤바 내려주기
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


