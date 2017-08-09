package com.kosta.j0808;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		
		// Vector(int capacity, int increment)
		Vector v = new Vector(5,3);//JDK4버전까지
		//Vector<Object> v = new Vector<Object>(5,3);//JDK4버전까지
		
		System.out.println("벡터의 방크기: "+ v.capacity()); //5
		System.out.println("벡터의 요소갯수: "+ v.size()); //0★
		
		//배열: length속성, 문자열: length()메소드, 벡터: size()메소드
		
		for(int i=1; i<10; i++) {//i = 1~9
			v.addElement(new Integer(i));
		}
		
		System.out.println("벡터의 방크기: "+ v.capacity()); //11
		System.out.println("벡터의 요소갯수: "+ v.size()); //9★
		
		v.addElement(new Double(3.14));
		v.addElement(new Double(9.87));
		
		v.addElement(new String("자바"));
		
		System.out.println("벡터의 방크기: "+ v.capacity()); //14
		System.out.println("벡터의 요소갯수: "+ v.size()); //12★
		
		System.out.println("첫번째 요소: "+ v.firstElement());
		System.out.println("마지막 요소: "+ v.lastElement());
		
		System.out.println("3.14포함? "+ v.contains(new Double(3.14)));
		
		//전체요소에 대한 출력  
		//Enumeration : 열거형 인터페이스
		Enumeration enu = v.elements();
		
		while(enu.hasMoreElements()) {//요소 체크
		   System.out.println(enu.nextElement());
		}
		
		
	}//main

}