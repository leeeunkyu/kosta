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
    	 System.out.println("\n<이름메뉴>");
    	 System.out.println(" 1.추가 2.검색 3.수정 4.삭제 5.종료");
    	 System.out.print(" 번호입력==> ");
    	 String noStr = in.readLine();
    	  //숫자검사
    	 
    	 if(noStr.matches("[1-5]")) {
    	   no= Integer.parseInt(noStr);
    	 }else {
    		System.out.println("#잘못된 숫자 입력입니다!!");
    		no=0;
    	 }
    	 
    	 System.out.println();
    	 switch(no) {
    	   case 1: 
    		       if( menu.names.size() == 5) {
    		    	   System.out.println(" #더 이상 입력할 수 없습니다.");
    		    	   System.out.println(" #한 개 이상의 이름을 먼저 삭제한 후 입력하세요!!");
    		           break;
    		       }
    		       System.out.print("이름입력: ");
    		       String name = in.readLine().trim();
    		            //" 홍길동".trim() ---> "홍길동"
    		       if(menu.existName(name)) {//이미 입력된 같은 이름이 존재한다면
    		    	  System.out.println(" #이미 입력된 이름입니다!!");
    		       }else {
    		          menu.insert(name);//빈자리에 입력된 이름 입력!!
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
    		      
    		   if(!menu.existName(oldName)) {//존재하지 않는다면
    			  System.out.println(" #존재하지 않는 이름입니다!!"); 
    		   }else {
    		      menu.update(oldName, newName);   
    		   }
    		   break;    	 
    	   case 4: 
    		   System.out.print("삭제할이름입력: ");
 		       String delName = in.readLine().trim();
 		       if(menu.delete(delName)) {
 		    	  System.out.println(" #이름 삭제하였습니다!!");  
 		       }else {
 		    	  System.out.println(" #존재하지 않는 이름입니다!!");  
 		       }
    	 }//switch    	 
    	 System.out.println();
    	}while(no != 5);
      
         System.out.println("--END--");
	}//main
}