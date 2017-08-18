package com.kosta.j0818;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
    //ServerŬ����: ������ ���� ���Ӽ���(���Ӵ��), ����Ŭ���̾�Ʈ ����(Vector)
	
	Vector<Service> allV;//��� �����(���ǻ���� + ��ȭ������)
	Vector<Service> waitV;//���� �����	   
	Vector<Room> roomV;//������ ��ȭ�� 
	
	ServerSocket ss;
	
	public Server() {
		allV = new Vector<>();
		waitV = new Vector<>();
		roomV = new Vector<>();
		
		new Thread(this).start();
	}//������
	
	
	@Override
	public void run(){
	  
	  try {
		ss = new ServerSocket(8282);//���� Server�� ����Ǵ� JVM�� ip, ��õ� port
			
		  System.out.println("ServerStart.....");
		  while(true){			
			Socket s = ss.accept(); //���Ӵ��!! <---- ����Ʈ
			//s: ������ Ŭ���̾�Ʈ�� ��������
		    System.out.println("���� Ŭ���̾�Ʈ ["
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