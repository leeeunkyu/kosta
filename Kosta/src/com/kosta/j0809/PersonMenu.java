package com.kosta.j0809;

import java.util.Vector;

public class PersonMenu {//�����Ϳ� ���� ����,�˻�,����,����
	
	//������ �����
	Vector<Person> v;
	int count;//0
	
	public PersonMenu() {
	  //������ Ư��: Ŭ�������� �� � �޼ҵ� ���� ���� ���� (1��) ȣ��!!
	  //----> ����ʵ忡 ���� �ʱ�ȭ�۾�
		v = new Vector<>();
	}//
	
	public void insert(Person person) {//(String name,int age,String job) {
		//count++;
		//person.setNo(count);
		person.setNo(++count);
		
		v.add(person);
	}//insert
	
	public void delete(int delNo) {
	   
	   for(int i=0; i<v.size(); i++) {//i: ������ �ε����� ǥ��
		  Person vPerson = v.get(i); 
		  if(vPerson.getNo() == delNo) {//��ġ�ϴ� ��ȣ ã��!!
			  v.remove(i);
		  }
	   }
		
	}//delete
	
	public void update(Person upPerson) {//person : ������ ����	(age,job), Ű��(no)	
	   for(int i=0; i<v.size(); i++) {//��ü ���� search
		   Person vPerson = v.get(i);
		   if(vPerson.getNo() == upPerson.getNo()) { //������ ��ȣ�� ��ġ�ϴ� Personã�� 
			   vPerson.setAge(upPerson.getAge());
			   vPerson.setJob(upPerson.getJob());
			   break;
		   }
	   }//for		
	}//update
	
	public void select() {//���ͳ��� Person���
	   System.out.println("#������");
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









