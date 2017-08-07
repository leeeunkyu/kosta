package com.kosta.j0807;

public class StringTest {
   public static void main(String[] args) {
	  String s1="java";
	  String s2="JAVA";
	  
	  //문자열 비교 :  기준문자열.equals(비교문자열)  
	  //"java".equals("JAVA")   s1.equals(s2)
	  
	  if(s1.equals(s2)) {
		  System.out.println("문자열 같음!!");
	  }else {
		  System.out.println("문자열 다름!!");
	  }
	  System.out.println("===============");
	  
	  if(s1.equalsIgnoreCase(s2)) {//대문자: upperCase, 소문자: lowerCase
		  System.out.println("문자열 같음2!!");
	  }else {
		  System.out.println("문자열 다름2!!");
	  }
	  
	  String str = "JavaProgramming";
	  //인덱스           012345678901234        
	  
	  //문자열 길이
	  System.out.println("STR문자열 길이: "+ str.length());
	  
	  System.out.println("STR 대문자변환: "+ str.toUpperCase());
	  System.out.println("STR 소문자변환: "+ str.toLowerCase());
	 
	  //문자열 대체(replace)
	  //str.replace(char oldChar, char newChar);
	  //str.replace(CharSequence target, CharSequence replacement)
	  System.out.println("str.replace('a','o') : "+ str.replace('a','o'));
	   //str = str.replace('a','o');
	  System.out.println("STR = "+ str);
	  System.out.println("str.replace(\"Java\",\"자바\") : "
	                       + str.replace("Java","자바"));
	  
	  //인덱스에 매핑되는 문자를 리턴
	  System.out.println("str.charAt(4) : "+ str.charAt(4));//'P'
	  
	  //문자에 매핑되는 인덱스 리턴
	  System.out.println("str.indexOf('P') : "+ str.indexOf('P'));//4

	  //String str = "JavaProgramming";
	  //              012345678901234
	  
	  //문제) str에서 "Programming" 부분문자열을 얻어오시오.
	  String str2= str.substring(str.indexOf('P'));
	  
	  System.out.println("STR2 : "+ str2);
	  
	  
	  //문제) API문서참조   1.str의 첫번째 'a'의 인덱스  
	  //                 2.str의 두번째 'a'의 인덱스를 구하시오
	  int idx =str.indexOf('a');
	  System.out.println("str 첫번째 'a'의 인덱스: "+ idx);//(97));
	  //str.indexOf(int ch,int fromIndex)
	  int idx2 = str.indexOf('a',idx+1);
	  System.out.println("str 두번째 'a'의 인덱스: "+ str.indexOf("aP")); //idx2);
	  System.out.println("str 마지막 'a'의 인덱스: "+ str.lastIndexOf('a'));
	  
	  //현재 문자열 길이
	  System.out.println("STR문자열 길이: "+ str.length());
	  str = str+"  ";//공백문자 2개 추가  : 길이 15 ----> 길이 17 
	  System.out.println("STR문자열 길이: "+ str.length());
	  
	  //불필요한 앞뒤의 공백을 제거 ----> trim()
	  str = str.trim();
	  System.out.println("공백 제거 후 STR문자열 길이: "+ str.length());
	  
	  String str3= " ja va "; //--> length() ---> 7
	  System.out.println("STR3문자열 길이: "+ str3.length());
	  System.out.println("STR3문자열 공백 제거후 길이: "+ str3.trim().length());
	  
			  
   }//main
}

