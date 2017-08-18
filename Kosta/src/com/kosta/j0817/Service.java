package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//Service한개 == 클라이언트 한개
	//소켓 입출력 서비스
	
	BufferedReader in;
	OutputStream out;	
	Vector<Service> v;
	String nickName;
	
	public Service(Socket s, Vector<Service> v) {//v: 전체 클라이언트가 저장된 벡터
	   try {
		   in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		   out = s.getOutputStream();
		   this.v = v;		   
		   start();
	   } catch (IOException e) {
		e.printStackTrace();
	   }
	}//생성자
	
	//입력서비스 (클라이언트sendTF로 부터 메시지: 언제보낼지 모름---> 스레드)
	public void run() {
	   try {
		   nickName = in.readLine();//대화명입력
		while(true) {
			  String  msg =	in.readLine();
			  System.out.println("from Client >>> "+ msg);
			  messageAll("["+nickName+"]▶ "+msg); //"[홍길동]▶ 안녕하세요!!"
		   }
	   } catch (IOException e) {
		e.printStackTrace();
	  }
	}//run
	
	//출력서비스 (접속한 클라이언트에게 메시지 보내기)
	public void messageTo(String msg) throws IOException {//특정 한 클라이언트에게 메시지 보내기 
		out.write( (msg+"\n").getBytes());
	}//messageTo
	
	public void messageAll(String msg) {//접속한 모든 클라이언트에게 메시지 보내기
		for(int i=0; i<v.size(); i++) {//접속된 모든 클라이언트(벡터 인덱스)
			Service ser = v.get(i);
			try {
				ser.messageTo(msg);
			} catch (IOException e) {
				//에러발생 ---> 클라이언트가 접속 끊음!!
				v.remove(i--);
				e.printStackTrace();
			}
		}//for
	}//messageAll

}
