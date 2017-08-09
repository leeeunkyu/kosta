package com.kosta.j0809;

import java.util.Vector;

public class PersonMenu {//데이터에 대한 저장,검색,수정,삭제
	
	//데이터 저장소
	Vector<Person> v;
	int count;//0
	
	public PersonMenu() {
	  //생성자 특성: 클래스내의 그 어떤 메소드 보다 제일 먼저 (1번) 호출!!
	  //----> 멤버필드에 대한 초기화작업
		v = new Vector<>();
	}//
	
	public void insert(Person person) {//(String name,int age,String job) {
		//count++;
		//person.setNo(count);
		person.setNo(++count);
		
		v.add(person);
	}//insert
	
	public void delete(int delNo) {
	   
	   for(int i=0; i<v.size(); i++) {//i: 벡터의 인덱스를 표현
		  Person vPerson = v.get(i); 
		  if(vPerson.getNo() == delNo) {//일치하는 번호 찾기!!
			  v.remove(i);
		  }
	   }
		
	}//delete
	
	public void update(Person upPerson) {//person : 수정할 정보	(age,job), 키값(no)	
	   for(int i=0; i<v.size(); i++) {//전체 벡터 search
		   Person vPerson = v.get(i);
		   if(vPerson.getNo() == upPerson.getNo()) { //수정할 번호와 일치하는 Person찾기 
			   vPerson.setAge(upPerson.getAge());
			   vPerson.setJob(upPerson.getJob());
			   break;
		   }
	   }//for		
	}//update
	
	public void select() {//벡터내의 Person출력
	   System.out.println("#사람목록");
	   for(int i=0; i<v.size(); i++) {
		  /*Person p = v.get(i);
		  System.out.println( (i+1) +": ["+p.getName()+
				     ", "+p.getAge()+", "+p.getJob()+"]");*/
		   
		  /* Person p = v.get(i);
		   System.out.println(p);//p.toString());//
		   */
		   System.out.println(v.get(i));
	   }
	}//select

}









