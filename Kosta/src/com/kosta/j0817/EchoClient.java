package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
   public static void main(String[] args) throws Exception{
	
	//Socket s = new Socket(String host,int port);   
	//★3. 소켓객체생성(서버접속 시도)
	Socket s = new Socket("192.168.0.111", 5000);   
	System.out.println("서버접속 성공!!");   
	
	//★4. 입출력객체 생성   (보낼때: 출력객체, 읽을때: 입력객체)
	OutputStream out= s.getOutputStream();//Client ---msg---> Server
	BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
	//--------------------------------------------------------
	
	String msg="안녕하세요~~~\n";
	   out.write(msg.getBytes());//★5. 데이터 보내기
	   
	System.out.println(in.readLine());// ★8. 데이터 읽기   
	   
	   
   }//main
}



