package com.kosta.j0817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
				ois=	  new ObjectInputStream(new FileInputStream("person.ser"));
			//Object ob = ois.readObject();  Person p = (Person)ob;
			Person p = (Person) ois.readObject();
			System.out.println("�̸�: "+p.name);
			System.out.println("����: "+p.age);
			System.out.println("����: "+p.job);

			System.out.println("===================");
			Person p2 = (Person) ois.readObject();
			System.out.println("�̸�: "+p2.name);
			System.out.println("����: "+p2.age);
			System.out.println("����: "+p2.job);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//main

}