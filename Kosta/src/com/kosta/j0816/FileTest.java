package com.kosta.j0816;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
   public static void main(String[] args) throws IOException {
	  //File f = new File(String pathname);
	  File f = new File("a.txt");
	    System.out.println("f.exists(): "+ f.exists());
	    System.out.println("f.isDirectory(): "+f.isDirectory());
	    System.out.println("f.isFile(): "+f.isFile());
	    
	    //���
	  //File f2 = new File("f:/jaelee/workspace/JavaApp/a.txt");
	    //���:   '.' ������, ������丮   '..' �θ���
	  File f2 = new File("../../a.txt");
	    System.out.println("getPath(): "+f2.getPath());
	    System.out.println("getAbsolutePath(): "+f2.getAbsolutePath());
	    System.out.println("getCanonicalPath(): "+f2.getCanonicalPath());
	    
	  //�����̸� , ��ġ����
	  File f3 = new File("f:/jaelee/workspace/JavaApp/a.txt");
	    System.out.println("getName(): "+ f2.getName());
	    System.out.println("getParent(): "+ f3.getParent());

	  
	    //   f:/jaelee/workspace/JavaApp/gildong/sub 
	  String path="gildong/sub";
	  String fileName="baby.jpg";
	  
	  File f4 = new File(path);
	  if(f4.exists()) {
		  System.out.println("���丮�� ����!!");
		  FileOutputStream fos = new FileOutputStream(path+"/"+fileName);
		  //FileOutputStream, FileWriter ===> ���ϻ��� ��� ����.
		  fos.close();
	  }else {
		  System.out.println("���丮�� �������� ����!!");
		  f4.mkdirs();
	  }	  
	  
	  
	  File f5 = new File(path+"/"+fileName);
	    if(f5.delete()) {
	    	System.out.println("f5���� ���� ����!!");
	    }else {
	    	System.out.println("f5���� ���� ����!!");	    	
	    }
	   
	    
	  
   }//main
}








