package com.kosta.j0808;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
   
   public static void main(String[] args) {
	  //a.txt������ �о �ֿܼ� ���
	   
      //InputStream, OutputStream
	  //Reader,      Writer
	   
	   
	 
	 try {
		//FileReader fr = new FileReader("f:\\jaelee\\workspace\\JavaApp\\a.txt");
		 FileReader fr = new FileReader("f:/jaelee/workspace/JavaApp/b.txt");
		                     //FileNotFoundException(�ڽ�)                
		 
		 //��Ŭ������ JavaProject������ ������Ʈ������� ��θ� �����ϴ� ���� ����
		 //FileReader fr = new FileReader("a.txt");	   
		   //fr.read();//IOException(�θ�)
		    
		   int i;
		   
		  while( (i=fr.read())  != -1 ) {//���� ���ڰ� �ִٸ�
			  System.out.print((char)i);
		  }
		   
		     System.out.println("\n=== �����б� ���� ===");
	 } catch(FileNotFoundException fne) {
		 //fne: �����޽��� ��ü 
		 System.out.println("#������ ã�� ���߽��ϴ�!!");
		 System.out.println(fne.toString());
		 System.out.println(fne);
		 
		 System.out.println(fne.getMessage());
		 
		 System.out.println("========================================");
		 fne.printStackTrace();//�����߻� �޼ҵ� ȣ����� 
		                       //������ �޼ҵ� ȣ����踦 ������. 
		  
	   }catch(IOException e) {
		  System.out.println("#IO���� �߻��Ͽ����ϴ�!!");
	   }
	 
	   
   }//main
   
}