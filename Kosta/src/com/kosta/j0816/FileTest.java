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
	    
	    //경로
	  //File f2 = new File("f:/jaelee/workspace/JavaApp/a.txt");
	    //경로:   '.' 현재경로, 현재디렉토리   '..' 부모경로
	  File f2 = new File("../../a.txt");
	    System.out.println("getPath(): "+f2.getPath());
	    System.out.println("getAbsolutePath(): "+f2.getAbsolutePath());
	    System.out.println("getCanonicalPath(): "+f2.getCanonicalPath());
	    
	  //파일이름 , 위치정보
	  File f3 = new File("f:/jaelee/workspace/JavaApp/a.txt");
	    System.out.println("getName(): "+ f2.getName());
	    System.out.println("getParent(): "+ f3.getParent());

	  
	    //   f:/jaelee/workspace/JavaApp/gildong/sub 
	  String path="gildong/sub";
	  String fileName="baby.jpg";
	  
	  File f4 = new File(path);
	  if(f4.exists()) {
		  System.out.println("디렉토리가 존재!!");
		  FileOutputStream fos = new FileOutputStream(path+"/"+fileName);
		  //FileOutputStream, FileWriter ===> 파일생성 기능 갖음.
		  fos.close();
	  }else {
		  System.out.println("디렉토리가 존재하지 않음!!");
		  f4.mkdirs();
	  }	  
	  
	  
	  File f5 = new File(path+"/"+fileName);
	    if(f5.delete()) {
	    	System.out.println("f5파일 삭제 성공!!");
	    }else {
	    	System.out.println("f5파일 삭제 실패!!");	    	
	    }
	   
	    
	  
   }//main
}








