package com.kosta.j0818;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
    //Server클래스: 소켓을 통한 접속서비스(접속대기), 접속클라이언트 관리(Vector)
	
	Vector<Service> allV;//모든 사용자(대기실사용자 + 대화방사용자)
	Vector<Service> waitV;//대기실 사용자	   
	Vector<Room> roomV;//개설된 대화방 
	
	ServerSocket ss;
	
	public Server() {
		allV = new Vector<>();
		waitV = new Vector<>();
		roomV = new Vector<>();
		
		new Thread(this).start();
	}//생성자
	
	
	@Override
	public void run(){
	  
	  try {
		ss = new ServerSocket(8282);//현재 Server가 실행되는 JVM의 ip, 명시된 port
			
		  System.out.println("ServerStart.....");
		  while(true){			
			Socket s = ss.accept(); //접속대기!! <---- 포인트
			//s: 접속한 클라이언트의 소켓정보
		    System.out.println("접속 클라이언트 ["
			       + s.getInetAddress().getHostAddress() +"]");
		    
		    Service service = new Service(s, this);
		    
		    
		    
		  }//while
	   } catch (IOException e) {
		e.printStackTrace();
	  }
	}//run	
	
   public static void main(String[] args) {
	   new Server();
   }


}