package com.kosta.j0807;

public class NameMenu {
   String names[];//데이터 저장소
   int count=0;
   final int MAX=4;
   public NameMenu() {
	   names = new String[5];//고정된 최대 5명의 이름을 저장
   }//생성자
   
   public void insert(String name) {//전달된 이름을 빈자리(null)에 저장
	  
	   for(int i=0; i<names.length; i++) {//전체 배열 검색
		  if(count>MAX) {
			  System.out.println("더이상 입력할수 없습니다 이름을 삭제한후 입력하세요!");
			  break;
		  }
		  if(names[i]!=null && names[i].equals(name)) {
			  System.out.println("이미 입력된 이름입니다.");
		  }else {
			  if(names[i] == null) {//빈자리라면, 번지에 null이라면
				  names[i] = name;
				  count++;
				  break;
			  }
		  }
	  }
   }//insert
   
   public void select() {
	   System.out.println("#이름목록");
	   for(int i=0; i<names.length; i++) {//인덱스를 통한 전체 배열 접근
		   if(names[i] != null)
			 System.out.println(" "+ names[i]);
	   }
   }//select
   
   public void update(String oldName, String newName) {
	   /*
	       <문자열 내용 비교>
	          기준문자열.equals(비교문자열)
	          
	       <문자열 null(메모리) 비교>
	          기준문자열 == null   
	    */
	   
	   for(int i=0; i<names.length; i++) {		  
		   /*if( names[i] != null && //NullPointerException 방지
				   names[i].equals(oldName) ) { //기존 이름 찾기
*/			
		   if(oldName.equals(names[i])) { //  "".equals(null)   
		      names[i]=newName;
			   break;
		   }
		   else if(names[i]==null && i==names.length-1) {
			   System.out.println("존재하지 않는 이름입니다.");
		   }
	   }
   }//update
   
   public void delete(String name) {
	   for(int i=0; i<names.length; i++) {
		   if(names[i] != null && names[i].equals(name)) {//일치하는 이름찾기
			  names[i]=null;
			  count--;
			  break;
		   }else if(names[i]==null && i==names.length-1) {
			   System.out.println("존재하지 않는 이름입니다.");
			   
		   }
	   }
   }//delete
   
}




