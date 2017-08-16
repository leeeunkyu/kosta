package com.kosta.person.model;

import java.util.Vector;

public class PersonDAO {//Vector(������ �����)�� �����͸� ����,�˻�,����,����
   
	Vector<Person> v;
	
	public PersonDAO() {
        v = new Vector<>();
    }//������
	
	public void insert(Person p) {//(String name, int age, String job) {
	  //�ܺο��� �޴� �����͸� Vector�� ����!!	
		v.add(p);
	}
	
	public Person select(int no) {//Vector�� ����� �� ���� Person �˻� : �������� ����
	   return v.elementAt(no);
	}
	public Vector<Person> selectAll() {
		//Vector�� ����� ��� Person �˻�(��ȸ) : Main���
	   return v;	
	}
	public void update(int index,Person p) {
		v.set(index-1, p);
		
	}
	public void delete(int no) {//Ư�� Person ���� (��ġ�ϴ� ��ȣ�� ã�Ƽ�)
		v.remove(no-1);
	}
	
}//class end




