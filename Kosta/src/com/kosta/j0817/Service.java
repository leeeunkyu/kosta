package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//Service�Ѱ� == Ŭ���̾�Ʈ �Ѱ�
	//���� ����� ����
	
	BufferedReader in;
	OutputStream out;	
	Vector<Service> v;
	String nickName;
	
	public Service(Socket s, Vector<Service> v) {//v: ��ü Ŭ���̾�Ʈ�� ����� ����
	   try {
		   in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		   out = s.getOutputStream();
		   this.v = v;		   
		   start();
	   } catch (IOException e) {
		e.printStackTrace();
	   }
	}//������
	
	//�Է¼��� (Ŭ���̾�ƮsendTF�� ���� �޽���: ���������� ��---> ������)
	public void run() {
	   try {
		   nickName = in.readLine();//��ȭ���Է�
		while(true) {
			  String  msg =	in.readLine();
			  System.out.println("from Client >>> "+ msg);
			  messageAll("["+nickName+"]�� "+msg); //"[ȫ�浿]�� �ȳ��ϼ���!!"
		   }
	   } catch (IOException e) {
		e.printStackTrace();
	  }
	}//run
	
	//��¼��� (������ Ŭ���̾�Ʈ���� �޽��� ������)
	public void messageTo(String msg) throws IOException {//Ư�� �� Ŭ���̾�Ʈ���� �޽��� ������ 
		out.write( (msg+"\n").getBytes());
	}//messageTo
	
	public void messageAll(String msg) {//������ ��� Ŭ���̾�Ʈ���� �޽��� ������
		for(int i=0; i<v.size(); i++) {//���ӵ� ��� Ŭ���̾�Ʈ(���� �ε���)
			Service ser = v.get(i);
			try {
				ser.messageTo(msg);
			} catch (IOException e) {
				//�����߻� ---> Ŭ���̾�Ʈ�� ���� ����!!
				v.remove(i--);
				e.printStackTrace();
			}
		}//for
	}//messageAll

}
