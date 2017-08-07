package com.kosta.j0807;


public class StringConvertTest {
   
	public void convert1() {
		String s1="우리나라";
		String s2="대한민국만세!!";
		
		s1 = s1+s2;
		System.out.println(s1);
		
		/*
		    String클래스: 고정길이 문자열 표현
		    1. String클래스 객체생성
		    2. 문자열 변환을 위해서 임시로 StringBuffer객체 생성.
		    3. append()메소드 호출
		    4. StringBuffer객체를 String객체로 변환
		    5. 임시생성된 StringBuffer객체 소멸.
		    
		    
		    
		    s1 = s1+s2+s3+s4+s5;
		 */
	}//convert1
	
	public void convert2() {
		StringBuffer s1 = new StringBuffer("우리나라");
		s1.append("대한민국만세!!");	
		System.out.println(s1);
		
		/*
		    s1 = s1.append(s2)
		           .append(s3)
		           .append(s4)
		           .append(s5); 
		  
		 StringBuffer클래스: 가변길이 문자열 표현
		 
		 1.StringBuffer클래스 객체생성.
		 2.append()메소드를 실행해서 문자열 변경.
		 
		 */
	}//convert2
	
	
	public static void main(String[] args) {
	    StringConvertTest sct = new StringConvertTest();
          sct.convert1();
          sct.convert2();
	}//main
}



