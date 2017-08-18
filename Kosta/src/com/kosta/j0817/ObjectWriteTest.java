package com.kosta.j0817;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {
   public static void main(String[] args) {
	   ObjectOutputStream oos = null; 
	  try {
				 oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
		  //oos.writeObject(Object obj);
		  oos.writeObject(new Person());
		
		  Person p = new Person();
		         p.name="차라임";
		         p.age=15;
		         p.job="학생";
		         
		   oos.writeObject(p);
		   
		  
		System.out.println("객체쓰기 성공!!");  		
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if(oos != null)oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   }//main
}