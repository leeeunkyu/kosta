package com.kosta.j0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//���� ����� ����!!,Vector(Service,Room)����
   //Service == ����Ŭ���̾�Ʈ �Ѱ�!!	
   public static final String SEND_MESSAGE="300";
	
	
   Room myRoom;//Ŭ���̾�Ʈ�� ����(�游���, �����)�� ��ȭ��		
   String nickName;
   
   BufferedReader in;//fromŬ���̾�Ʈ �޽��� ó��
   OutputStream out;//toŬ���̾�Ʈ �޽��� ó��
   
   //������ ���ǵǾ� �ִ� ����
   Vector<Service> allV;
   Vector<Service> waitV;
   Vector<Room> roomV;
   
   public Service(Socket s, Server server) { 
	try {
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));  
		out = s.getOutputStream();
		   
	    this.allV = server.allV;
	    this.waitV = server.waitV;
	    this.roomV = server.roomV;
	    
		start();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//������
   
   @Override
   public void run() {		
	 try {
		while(true){
			String msg = in.readLine(); //Ŭ���̾�Ʈ�� ���� ��� �޽��� �ޱ� 
			//"300|�ȳ��ϼ���"   "500|������½"
			//"200|�ڹٹ�"
			
			String msgs[] = msg.split("\\|"); 
			//msgs[]={"300","�ȳ��ϼ���"}
			//msgs[]={"500","������½"}
			
			String protocol=msgs[0];	
			
			switch(protocol) {
			   case "100"://���� ����(��������)
				   
				    //�����ޱ� ���� ���Ϳ� ���
				    allV.add(this);//��ü�����
				    waitV.add(this);//���ǻ����
				    
				    if(getRoomInfo().length()>0)//������ ���� �Ѱ� �̻��̿�����!!
				      messageWait("200|"+ getRoomInfo());
				    
				    break;
				    
			   case "110"://�����
				    //msgs[1];//��Ÿ��Ʋ 
				   
				    for(int i=0; i< roomV.size(); i++) {
				    	Room room = roomV.get(i);
				        if(room.title.equals(msgs[1])) {//�� ã�Ҵ�!!
				        	myRoom = room;
				        	room.count++;
				        	break;
				        }
				    }
				    
				    //���� ---> ��ȭ��
				    waitV.remove(this);
				    myRoom.userV.add(this);
				    
				    messageWait("200|"+ getRoomInfo());
				    
				    break;
			   case "200"://�游���
				     //Room room = new Room(title, count, boss)
				     Room room = new Room(msgs[1], 1, nickName);				   
				     
				     myRoom = room;
				     
				     //���� ----> ��ȭ��
				     waitV.remove(this);
				     room.userV.add(this);				     
				     roomV.add(room);//���θ��� ��ȭ���� ���Ϳ� ���� 
				     
				     //messageWait("200|�ڹٹ�--1,SQL��--1");
				     messageWait("200|"+ getRoomInfo());				     
				   
				     break;
			   case  SEND_MESSAGE: //"300"://�޽��� ����
				     messageRoom("300|["+ nickName+"]�� "+ msgs[1]);
				     break;
				     
			   case "500"://��ȭ�� ����
				     nickName = msgs[1];
			}
		 }//while
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
   }//run  
   
   //���������
   public String getRoomInfo() {
	   //���ǿ� ���� ������ ��� (��: �ڹٹ�--1 )
	     String roomInfo="";
	     for(int i=0; i<roomV.size(); i++) {//������ ����ŭ �ݺ�
	    	 Room r = roomV.get(i);
	    	 roomInfo += r.title +"--"+ r.count;
	    	 if(i < roomV.size()-1 )roomInfo+=",";
	     }
	     //roomInfo = "�ڹٹ�--1,SQL��--1";	
	   return  roomInfo;
   }//getRoomInfo
   
   
   public void messageAll(String msg){//��ü�����
	  //���ӵ� ��� Ŭ���̾�Ʈ(����+��ȭ��)���� �޽��� ����	   
	  for(int i=0; i<allV.size(); i++) {
		  Service service = allV.get(i);		  
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Ŭ���̾�Ʈ ���� ����!!: "+ e);
			allV.remove(i--);
		}
	  }//for
	   
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //Ư�� Ŭ���̾�Ʈ���� �޽��� ���� (���� ����--->Ŭ���̾�Ʈ �޽��� ����)
	   out.write(  (msg+"\n").getBytes() );
   }
   
   public void messageWait(String msg){//���� �����	   
	   for(int i=0; i<waitV.size(); i++) {
			  Service service = waitV.get(i);		  
			  try {
				service.messageTo(msg);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("���� ����(���α׷�����,��ȭ������)!!: "+ e);
				waitV.remove(i--);
			}
		  }//for  
   }//messageWait
   
   public void messageRoom(String msg){//��ȭ������
	   for(int i=0; i< myRoom.userV.size(); i++) {
			  Service service = myRoom.userV.get(i);
			  //service: ���� ��ȭ�濡 �ִ� �����
			  try {
				service.messageTo(msg);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("��ȭ�� ����!!: "+ e);
				myRoom.userV.remove(i--);
			}
		  }//for
   }//messageRoom
   
	
}


