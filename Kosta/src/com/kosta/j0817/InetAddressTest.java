package com.kosta.j0817;

import java.net.InetAddress;
import java.net.UnknownHostException;

class A{
	
	private static A instance;
	
	private A() {
		// TODO Auto-generated constructor stub
	}
	
	public static A getInstance() {
	    if(instance == null)
	    	{instance = new A();}
	   return instance;
	}
	
	void hello() {
		
	}
}


public class InetAddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		//A a = new A();
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		A a3 = A.getInstance();
//		
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(a3);
		
		
		
		String host = "naver.com";
		
		//InetAddress ia = InetAddress.getByName(String host);
		InetAddress ia = InetAddress.getByName(host);
		
		System.out.println("호스트 이름: "+ ia.getHostName());
		System.out.println("호스트 주소: "+ ia.getHostAddress());
		
		System.out.println("==============================");
		//도메인에 매핑된 서버가 여러대 있을 경우.
		InetAddress []  ias = InetAddress.getAllByName(host);
		
		for (int i = 0; i < ias.length; i++) {
		  System.out.println("호스트주소"+(i+1)+" : " + ias[i].getHostAddress());
		}
		
		System.out.println("=============www.================");
		InetAddress []  ias2 = InetAddress.getAllByName("www."+host);
		
		for (int i = 0; i < ias2.length; i++) {
			System.out.println("호스트주소"+(i+1)+" : " + ias2[i].getHostAddress());
		}
		
	}//main

}