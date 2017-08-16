package com.kosta.person.model;

import java.util.Vector;

public class PersonDAO {//Vector(데이터 저장소)에 데이터를 저장,검색,수정,삭제
   
	Vector<Person> v;
	
	public PersonDAO() {
        v = new Vector<>();
    }//생성자
	
	public void insert(Person p) {//(String name, int age, String job) {
	  //외부에서 받는 데이터를 Vector에 저장!!	
		v.add(p);
	}
	
	public Person select(int no) {//Vector에 저장된 한 건의 Person 검색 : 수정폼을 위한
	   return v.elementAt(no);
	}
	public Vector<Person> selectAll() {
		//Vector에 저장된 모든 Person 검색(조회) : Main출력
	   return v;	
	}
	public void update(int index,Person p) {
		v.set(index-1, p);
		
	}
	public void delete(int no) {//특정 Person 삭제 (일치하는 번호를 찾아서)
		v.remove(no-1);
	}
	
}//class end




