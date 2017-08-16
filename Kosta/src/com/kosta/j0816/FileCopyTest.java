package com.kosta.j0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
   //바이트 단위 입출력
   FileInputStream fis;
   FileOutputStream fos;
   
   //문자 단위 입출력
   FileReader fr;
   FileWriter fw;
   
   //버퍼지원 문자 단위 입출력
   BufferedReader br;
   BufferedWriter bw;
   
   //바이트 단위 입출력2
   FileInputStream fis2;
   FileOutputStream fos2;
   
   public FileCopyTest() throws IOException{
	  fis = new FileInputStream("a.txt");//FileNotFoundException 자식
	  fos = new FileOutputStream("b.txt");
	  //FileOutputStream은 b.txt파일 생성 (※주의: 디렉토리 생성은 하지 않는다!!)
	  int i;
	//IOException 부모
	  
	  long start = System.currentTimeMillis();
	  while((i=fis.read()) != -1) {//읽은 바이트가 있다면
	     //System.out.print((char)i);
		  //System.out.write(i);
		  fos.write(i);
	  }
	  long end = System.currentTimeMillis();
	  
	  //System.out.flush();
	  fos.close();
	  fis.close();
	  System.out.println("파일복사(바이트) 성공!! : "+(end-start));
	  
	  fr = new FileReader("a.txt");
	  fw = new FileWriter("b.txt");
	  
	  start = System.currentTimeMillis();
	  while( (i=fr.read()) != -1) {//읽을 문자가 있다면
		  fw.write(i);
	  }
	  end = System.currentTimeMillis();
	  
	  fw.close();
	  fr.close();
	  System.out.println("파일복사(문자) 성공!! : "+(end-start));
	  
	  br = new BufferedReader(new FileReader("a.txt"));
	  bw = new BufferedWriter(new FileWriter("b.txt"));
	  
	  String str;
	  start = System.currentTimeMillis();
	  while((str=br.readLine()) != null) {//읽은 라인이 있다면
		  bw.write(str);
	  }
	  end = System.currentTimeMillis();
	  
	  bw.close();
	  br.close();
	  System.out.println("파일복사(버퍼) 성공!! : "+(end-start));
	  
	  //======================================================
	  fis2 = new FileInputStream("a.txt");
	  fos2 = new FileOutputStream("b.txt");
	  
	 
	  byte b[] = new byte[1024];
	  //c.txt : abcdefgh   b[]사이즈: 5  가정
	  //fis2.read(b)    {a,b,c,d,e}
	  //fis2.read(b)    {f,g,h,d,e}
	  
	  start = System.currentTimeMillis();
	  while((i=fis2.read(b)) != -1) {//읽은 바이트가 있다면	     
		  fos2.write(b,0,i);//b배열을 읽어서 fos2에 출력
	  }
	  end = System.currentTimeMillis();
	  
	  //System.out.flush();
	  fos2.close();
	  fis2.close();
	  System.out.println("파일복사(바이트,배열적용) 성공!! : "+(end-start));
	  
	  
   }//생성자
	
   public static void main(String[] args) throws IOException {
	   new FileCopyTest();
	   
	   //파일읽기
	   //1. FileInputStream fis = new FileInputStream(String path);
	   //2. FileInputStream fis = new FileInputStream(File file);
	   
	   //new JTable();     new JTable(DefaultTableModel dtm);
   }
}