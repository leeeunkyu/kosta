package com.kosta.j0808;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
   
   public static void main(String[] args) {
	  //a.txt파일을 읽어서 콘솔에 출력
	   
      //InputStream, OutputStream
	  //Reader,      Writer
	   
	   
	 
	 try {
		//FileReader fr = new FileReader("f:\\jaelee\\workspace\\JavaApp\\a.txt");
		 FileReader fr = new FileReader("f:/jaelee/workspace/JavaApp/b.txt");
		                     //FileNotFoundException(자식)                
		 
		 //이클립스의 JavaProject에서만 프로젝트명까지의 경로를 생략하는 것이 가능
		 //FileReader fr = new FileReader("a.txt");	   
		   //fr.read();//IOException(부모)
		    
		   int i;
		   
		  while( (i=fr.read())  != -1 ) {//읽은 문자가 있다면
			  System.out.print((char)i);
		  }
		   
		     System.out.println("\n=== 파일읽기 성공 ===");
	 } catch(FileNotFoundException fne) {
		 //fne: 에러메시지 객체 
		 System.out.println("#파일을 찾지 못했습니다!!");
		 System.out.println(fne.toString());
		 System.out.println(fne);
		 
		 System.out.println(fne.getMessage());
		 
		 System.out.println("========================================");
		 fne.printStackTrace();//에러발생 메소드 호출부터 
		                       //연관된 메소드 호출관계를 보여줌. 
		  
	   }catch(IOException e) {
		  System.out.println("#IO예외 발생하였습니다!!");
	   }
	 
	   
   }//main
   
}