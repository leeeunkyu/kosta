package com.kosta.j0818;

import java.util.Vector;

import com.kosta.j0818.Person;

public class PersonDAO {
	Vector<Person> v;
	Vector<Person> v2;
	public PersonDAO() {
		// TODO Auto-generated constructor stub
		v = new Vector<>();
		v2 = new Vector<>();
	}
	public void reset() {
		v2.removeAllElements();
	}
	public void addPerson(Person p) {
		v.add(p);
	}
	public Vector<Person> select(String name) {
		for (int i = 0; i < v.size(); i++) {
			//System.out.println("���� name: "+name+"  sub��"+v.get(i).getName().substring(0,1)+" �׶���: "+v.get(i).getName());
			if(v.get(i).getName().substring(0, 1).equals(name)) {
				//System.out.println("���� name: "+name+"  sub��"+v.get(i).getName().substring(0));
				v2.add(v.get(i));
			}
		}
		return v2;
	}
	public Vector<Person> selectAll() {
		//Vector�� ����� ��� Person �˻�(��ȸ) : Main���
	   return v;	
	}
}
