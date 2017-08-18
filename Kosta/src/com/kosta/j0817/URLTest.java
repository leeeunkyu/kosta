package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args)throws Exception {
		
		URL url = new URL("https://www.naver.com/index.html");
		
		System.out.println("프로토콜(통신규약): "+ url.getProtocol());
		System.out.println("호스트: "+ url.getHost());
	    System.out.println("서비스 파일명: "+ url.getFile());
	    //System.in.read();
	    //new InputStreamReader(InputStream);
	   /* BufferedReader br = new BufferedReader
	    		  (new InputStreamReader(System.in)); //콘솔read
	    
	         br = new BufferedReader
	          (new InputStreamReader(new FileInputStream("경로"))); //파일read
	         //(new FileReader("파일경로")); //파일read
        */	
	    
	    
	    //new InputStreamReader(InputStream in,String charsetName)
	    
	    //웹소스 긁어오기   ----> index.html 파일 저장
	    BufferedReader br = new BufferedReader(
	    		new InputStreamReader(url.openStream(),"UTF-8")); 
	        
        /*
          
           BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"));
        
	       String str;
	       //br.read(char []cbuf)
	       while(  (str=br.readLine()) !=  null  ) {//읽을 라인이 있다면
	    	   //콘솔출력
	    	   System.out.println(str);
	    	   
	    	   //파일출력
	    	   //bw.write(str);
	    	   //bw.newLine();
	       }*/
	      
	       
	       //new OutputStreamWriter(OutputStream out,String charsetName);   
	       OutputStreamWriter osw  
	       = new OutputStreamWriter(new FileOutputStream("index.html"),"UTF-8");   
	       
	       char ch[]=new char[512];
	       int i;
	       while( (i=br.read(ch)) != -1) {
	    	   osw.write(ch,0,i);	    	   
	       }	       
	       System.out.println("웹소스 긁어오기 성공!!");
	       
	       osw.close();
	       //bw.close();
	       br.close();
	}//main

}


