package com.kosta.j0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest2 {
	
	
    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
      NameMenu2 menu = new NameMenu2();
      
      int no;
      do {	
    	 System.out.println("\n<�̸��޴�>");
    	 System.out.println(" 1.�߰� 2.�˻� 3.���� 4.���� 5.����");
    	 System.out.print(" ��ȣ�Է�==> ");
    	 String noStr = in.readLine();
    	  //���ڰ˻�
    	 
    	 if(noStr.matches("[1-5]")) {
    	   no= Integer.parseInt(noStr);
    	 }else {
    		System.out.println("#�߸��� ���� �Է��Դϴ�!!");
    		no=0;
    	 }
    	 
    	 System.out.println();
    	 switch(no) {
    	   case 1: 
    		       if( menu.names.size() == 5) {
    		    	   System.out.println(" #�� �̻� �Է��� �� �����ϴ�.");
    		    	   System.out.println(" #�� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���!!");
    		           break;
    		       }
    		       System.out.print("�̸��Է�: ");
    		       String name = in.readLine().trim();
    		            //" ȫ�浿".trim() ---> "ȫ�浿"
    		       if(menu.existName(name)) {//�̹� �Էµ� ���� �̸��� �����Ѵٸ�
    		    	  System.out.println(" #�̹� �Էµ� �̸��Դϴ�!!");
    		       }else {
    		          menu.insert(name);//���ڸ��� �Էµ� �̸� �Է�!!
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
    		      
    		   if(!menu.existName(oldName)) {//�������� �ʴ´ٸ�
    			  System.out.println(" #�������� �ʴ� �̸��Դϴ�!!"); 
    		   }else {
    		      menu.update(oldName, newName);   
    		   }
    		   break;    	 
    	   case 4: 
    		   System.out.print("�������̸��Է�: ");
 		       String delName = in.readLine().trim();
 		       if(menu.delete(delName)) {
 		    	  System.out.println(" #�̸� �����Ͽ����ϴ�!!");  
 		       }else {
 		    	  System.out.println(" #�������� �ʴ� �̸��Դϴ�!!");  
 		       }
    	 }//switch    	 
    	 System.out.println();
    	}while(no != 5);
      
         System.out.println("--END--");
	}//main
}