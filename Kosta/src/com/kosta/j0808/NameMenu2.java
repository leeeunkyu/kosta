package com.kosta.j0808;

import java.util.Vector;

public class NameMenu2 {
   
   Vector<String> names;//데이터 저장소
   
   public NameMenu2() {
	   names = new Vector<>();//고정된 최대 5명의 이름을 저장
   }//생성자
   
   public void insert(String name) {//전달된 이름을 빈자리(null)에 저장
	   names.add(name);	  
   }//insert
   
   public void select() {
	   System.out.println("#이름목록");
	   for(int i=0; i<names.size(); i++) {//인덱스를 통한 전체 배열 접근		   
			 System.out.println(" "+ names.get(i));
	   }
   }//select
   
   public void update(String oldName, String newName) {	   
	   
	   /*for(int i=0; i<names.size(); i++) {		  
		   if( names.get(i).equals(oldName) ) { //기존 이름 찾기			
		       //names.set(int index, String element)
			   names.set(i, newName);
			   break;
		   }
	   }*/
	   
	   //만약, 중복된 이름이 존재하지 않는다면
	   names.set(names.indexOf(oldName),  newName);
	   
   }//update
   
   public boolean delete(String name) {
	   /*for(int i=0; i<names.size(); i++) {
		   if(names.get(i).equals(name)) {//일치하는 이름찾기
			  names.remove(i);
			  return true;//삭제 성공!!
		   }
	   }*/
	   if(names.remove(name)) return true;
	   
	   return false;
   }//delete
   
   //이름 저장(존재) 유무 판단
   public boolean existName(String name) {//이름 존재: true 리턴
	  if(names.contains(name)) return true;
	  
	  return false;
   }//existName
   
}








