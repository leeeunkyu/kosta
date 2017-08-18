package com.kosta.j0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//소켓 입출력 서비스!!,Vector(Service,Room)관리
   //Service == 접속클라이언트 한개!!	
   public static final String SEND_MESSAGE="300";
	
	
   Room myRoom;//클라이언트가 입장(방만들기, 방들어가기)한 대화방		
   String nickName;
   
   BufferedReader in;//from클라이언트 메시지 처리
   OutputStream out;//to클라이언트 메시지 처리
   
   //서버에 정의되어 있는 벡터
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
   }//생성자
   
   @Override
   public void run() {		
	 try {
		while(true){
			String msg = in.readLine(); //클라이언트가 보낸 모든 메시지 받기 
			//"300|안녕하세요"   "500|동에번쩍"
			//"200|자바방"
			
			String msgs[] = msg.split("\\|"); 
			//msgs[]={"300","안녕하세요"}
			//msgs[]={"500","동에번쩍"}
			
			String protocol=msgs[0];	
			
			switch(protocol) {
			   case "100"://대기실 입장(최초접속)
				   
				    //관리받기 위한 벡터에 등록
				    allV.add(this);//전체사용자
				    waitV.add(this);//대기실사용자
				    
				    if(getRoomInfo().length()>0)//개설된 방이 한개 이상이였을때!!
				      messageWait("200|"+ getRoomInfo());
				    
				    break;
				    
			   case "110"://방들어가기
				    //msgs[1];//방타이틀 
				   
				    for(int i=0; i< roomV.size(); i++) {
				    	Room room = roomV.get(i);
				        if(room.title.equals(msgs[1])) {//방 찾았다!!
				        	myRoom = room;
				        	room.count++;
				        	break;
				        }
				    }
				    
				    //대기실 ---> 대화방
				    waitV.remove(this);
				    myRoom.userV.add(this);
				    
				    messageWait("200|"+ getRoomInfo());
				    
				    break;
			   case "200"://방만들기
				     //Room room = new Room(title, count, boss)
				     Room room = new Room(msgs[1], 1, nickName);				   
				     
				     myRoom = room;
				     
				     //대기실 ----> 대화방
				     waitV.remove(this);
				     room.userV.add(this);				     
				     roomV.add(room);//새로만든 대화방을 벡터에 저장 
				     
				     //messageWait("200|자바방--1,SQL방--1");
				     messageWait("200|"+ getRoomInfo());				     
				   
				     break;
			   case  SEND_MESSAGE: //"300"://메시지 전달
				     messageRoom("300|["+ nickName+"]▶ "+ msgs[1]);
				     break;
				     
			   case "500"://대화명 변경
				     nickName = msgs[1];
			}
		 }//while
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
   }//run  
   
   //방정보얻기
   public String getRoomInfo() {
	   //대기실에 방의 정보를 출력 (예: 자바방--1 )
	     String roomInfo="";
	     for(int i=0; i<roomV.size(); i++) {//개설방 수만큼 반복
	    	 Room r = roomV.get(i);
	    	 roomInfo += r.title +"--"+ r.count;
	    	 if(i < roomV.size()-1 )roomInfo+=",";
	     }
	     //roomInfo = "자바방--1,SQL방--1";	
	   return  roomInfo;
   }//getRoomInfo
   
   
   public void messageAll(String msg){//전체사용자
	  //접속된 모든 클라이언트(대기실+대화방)에게 메시지 전달	   
	  for(int i=0; i<allV.size(); i++) {
		  Service service = allV.get(i);		  
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("클라이언트 접속 끊음!!: "+ e);
			allV.remove(i--);
		}
	  }//for
	   
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //특정 클라이언트에게 메시지 전달 (실제 서버--->클라이언트 메시지 전달)
	   out.write(  (msg+"\n").getBytes() );
   }
   
   public void messageWait(String msg){//대기실 사용자	   
	   for(int i=0; i<waitV.size(); i++) {
			  Service service = waitV.get(i);		  
			  try {
				service.messageTo(msg);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("대기실 나감(프로그램종료,대화방입장)!!: "+ e);
				waitV.remove(i--);
			}
		  }//for  
   }//messageWait
   
   public void messageRoom(String msg){//대화방사용자
	   for(int i=0; i< myRoom.userV.size(); i++) {
			  Service service = myRoom.userV.get(i);
			  //service: 동일 대화방에 있는 사용자
			  try {
				service.messageTo(msg);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("대화방 나감!!: "+ e);
				myRoom.userV.remove(i--);
			}
		  }//for
   }//messageRoom
   
	
}


