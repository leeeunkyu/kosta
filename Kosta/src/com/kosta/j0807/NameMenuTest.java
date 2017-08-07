package com.kosta.j0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
	
	/*static{
	  System.out.println("�ȳ�ȳ�~!!");
	}*/
	
    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
      NameMenu menu = new NameMenu();
      
      int no;
      do {	
    	 System.out.println("\n<�̸��޴�>");
    	 System.out.println(" 1.�߰� 2.�˻� 3.���� 4.���� 5.����");
    	 System.out.print(" ��ȣ�Է�==> ");
    	 no= Integer.parseInt(in.readLine());
    	 
    	 System.out.println();
    	 switch(no) {
    	   case 1: {
    		       System.out.print("�̸��Է�: ");
    		       String name = in.readLine();
    		       menu.insert(name);
    	           }
    		       break;
    		       
    	   case 2: 
    		       menu.select();
    		       break;    	 
    	   case 3: 
    		   System.out.print("�������̸��Է�(�����̸�): "); 
    		      String oldName = in.readLine();
    		   System.out.print("�������̸��Է�(���̸�): ");
    		      String newName = in.readLine();
    		      
    		   menu.update(oldName, newName);   
    		      
    		   break;    	 
    	   case 4: 
    		   System.out.print("�������̸��Է�: ");
 		       String delName = in.readLine();
 		       menu.delete(delName);
    	 }//switch    	 
    	 System.out.println();
    	}while(no != 5);
      
         System.out.println("--END--");
	}//main
}