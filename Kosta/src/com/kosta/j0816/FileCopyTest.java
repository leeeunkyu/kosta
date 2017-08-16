package com.kosta.j0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
   //����Ʈ ���� �����
   FileInputStream fis;
   FileOutputStream fos;
   
   //���� ���� �����
   FileReader fr;
   FileWriter fw;
   
   //�������� ���� ���� �����
   BufferedReader br;
   BufferedWriter bw;
   
   //����Ʈ ���� �����2
   FileInputStream fis2;
   FileOutputStream fos2;
   
   public FileCopyTest() throws IOException{
	  fis = new FileInputStream("a.txt");//FileNotFoundException �ڽ�
	  fos = new FileOutputStream("b.txt");
	  //FileOutputStream�� b.txt���� ���� (������: ���丮 ������ ���� �ʴ´�!!)
	  int i;
	//IOException �θ�
	  
	  long start = System.currentTimeMillis();
	  while((i=fis.read()) != -1) {//���� ����Ʈ�� �ִٸ�
	     //System.out.print((char)i);
		  //System.out.write(i);
		  fos.write(i);
	  }
	  long end = System.currentTimeMillis();
	  
	  //System.out.flush();
	  fos.close();
	  fis.close();
	  System.out.println("���Ϻ���(����Ʈ) ����!! : "+(end-start));
	  
	  fr = new FileReader("a.txt");
	  fw = new FileWriter("b.txt");
	  
	  start = System.currentTimeMillis();
	  while( (i=fr.read()) != -1) {//���� ���ڰ� �ִٸ�
		  fw.write(i);
	  }
	  end = System.currentTimeMillis();
	  
	  fw.close();
	  fr.close();
	  System.out.println("���Ϻ���(����) ����!! : "+(end-start));
	  
	  br = new BufferedReader(new FileReader("a.txt"));
	  bw = new BufferedWriter(new FileWriter("b.txt"));
	  
	  String str;
	  start = System.currentTimeMillis();
	  while((str=br.readLine()) != null) {//���� ������ �ִٸ�
		  bw.write(str);
	  }
	  end = System.currentTimeMillis();
	  
	  bw.close();
	  br.close();
	  System.out.println("���Ϻ���(����) ����!! : "+(end-start));
	  
	  //======================================================
	  fis2 = new FileInputStream("a.txt");
	  fos2 = new FileOutputStream("b.txt");
	  
	 
	  byte b[] = new byte[1024];
	  //c.txt : abcdefgh   b[]������: 5  ����
	  //fis2.read(b)    {a,b,c,d,e}
	  //fis2.read(b)    {f,g,h,d,e}
	  
	  start = System.currentTimeMillis();
	  while((i=fis2.read(b)) != -1) {//���� ����Ʈ�� �ִٸ�	     
		  fos2.write(b,0,i);//b�迭�� �о fos2�� ���
	  }
	  end = System.currentTimeMillis();
	  
	  //System.out.flush();
	  fos2.close();
	  fis2.close();
	  System.out.println("���Ϻ���(����Ʈ,�迭����) ����!! : "+(end-start));
	  
	  
   }//������
	
   public static void main(String[] args) throws IOException {
	   new FileCopyTest();
	   
	   //�����б�
	   //1. FileInputStream fis = new FileInputStream(String path);
	   //2. FileInputStream fis = new FileInputStream(File file);
	   
	   //new JTable();     new JTable(DefaultTableModel dtm);
   }
}