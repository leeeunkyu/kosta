package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
   public static void main(String[] args) throws Exception{
	
	//Socket s = new Socket(String host,int port);   
	//��3. ���ϰ�ü����(�������� �õ�)
	Socket s = new Socket("192.168.0.111", 5000);   
	System.out.println("�������� ����!!");   
	
	//��4. ����°�ü ����   (������: ��°�ü, ������: �Է°�ü)
	OutputStream out= s.getOutputStream();//Client ---msg---> Server
	BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
	//--------------------------------------------------------
	
	String msg="�ȳ��ϼ���~~~\n";
	   out.write(msg.getBytes());//��5. ������ ������
	   
	System.out.println(in.readLine());// ��8. ������ �б�   
	   
	   
   }//main
}



