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
		
		System.out.println("��������(��űԾ�): "+ url.getProtocol());
		System.out.println("ȣ��Ʈ: "+ url.getHost());
	    System.out.println("���� ���ϸ�: "+ url.getFile());
	    //System.in.read();
	    //new InputStreamReader(InputStream);
	   /* BufferedReader br = new BufferedReader
	    		  (new InputStreamReader(System.in)); //�ܼ�read
	    
	         br = new BufferedReader
	          (new InputStreamReader(new FileInputStream("���"))); //����read
	         //(new FileReader("���ϰ��")); //����read
        */	
	    
	    
	    //new InputStreamReader(InputStream in,String charsetName)
	    
	    //���ҽ� �ܾ����   ----> index.html ���� ����
	    BufferedReader br = new BufferedReader(
	    		new InputStreamReader(url.openStream(),"UTF-8")); 
	        
        /*
          
           BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"));
        
	       String str;
	       //br.read(char []cbuf)
	       while(  (str=br.readLine()) !=  null  ) {//���� ������ �ִٸ�
	    	   //�ܼ����
	    	   System.out.println(str);
	    	   
	    	   //�������
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
	       System.out.println("���ҽ� �ܾ���� ����!!");
	       
	       osw.close();
	       //bw.close();
	       br.close();
	}//main

}


