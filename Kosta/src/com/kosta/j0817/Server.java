package com.kosta.j0817;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//Server: ������ ���� ���� ����-while(accept)
	//      : ������ Ŭ���̾�Ʈ���� ����- Vector
	
	ServerSocket ss;
	Vector<Service> v;//Ŭ���̾�Ʈ ����
	
	public Server() {
	  try {
		v = new Vector<>(); 
		ss = new ServerSocket(3000);		   
		new Thread(this).start();
		
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}//������
	
	public void run() {//������
		try {
			System.out.println("ServerStart.....");
			while(true) {
			   Socket s = ss.accept();//Ŭ���̾�Ʈ ���Ӵ��
			   //Service service = new Service(s); //new Service() == Ŭ���̾�Ʈ �Ѱ�
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