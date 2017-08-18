package com.kosta.j0817;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//Server: 소켓을 통한 접속 서비스-while(accept)
	//      : 접속한 클라이언트들을 관리- Vector
	
	ServerSocket ss;
	Vector<Service> v;//클라이언트 관리
	
	public Server() {
	  try {
		v = new Vector<>(); 
		ss = new ServerSocket(3000);		   
		new Thread(this).start();
		
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}//생성자
	
	public void run() {//스레드
		try {
			System.out.println("ServerStart.....");
			while(true) {
			   Socket s = ss.accept();//클라이언트 접속대기
			   //Service service = new Service(s); //new Service() == 클라이언트 한개
			   //v.add(service);
			   v.add(new Service(s,v));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//run
	
	public static void main(String[] args) {
		new Server();
	}

}