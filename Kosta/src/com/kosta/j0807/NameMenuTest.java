package com.kosta.j0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
	
	/*static{
	  System.out.println("안녕안녕~!!");
	}*/
	
    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
      NameMenu menu = new NameMenu();
      
      int no;
      do {	
    	 System.out.println("\n<이름메뉴>");
    	 System.out.println(" 1.추가 2.검색 3.수정 4.삭제 5.종료");
    	 System.out.print(" 번호입력==> ");
    	 no= Integer.parseInt(in.readLine());
    	 
    	 System.out.println();
    	 switch(no) {
    	   case 1: {
    		       System.out.print("이름입력: ");
    		       String name = in.readLine();
    		       menu.insert(name);
    	           }
    		       break;
    		       
    	   case 2: 
    		       menu.select();
    		       break;    	 
    	   case 3: 
    		   System.out.print("수정할이름입력(기존이름): "); 
    		      String oldName = in.readLine();
    		   System.out.print("변경할이름입력(새이름): ");
    		      String newName = in.readLine();
    		      
    		   menu.update(oldName, newName);   
    		      
    		   break;    	 
    	   case 4: 
    		   System.out.print("삭제할이름입력: ");
 		       String delName = in.readLine();
 		       menu.delete(delName);
    	 }//switch    	 
    	 System.out.println();
    	}while(no != 5);
      
         System.out.println("--END--");
	}//main
}