package com.kosta.j0808;

import java.util.Vector;

public class NameMenu2 {
   
   Vector<String> names;//������ �����
   
   public NameMenu2() {
	   names = new Vector<>();//������ �ִ� 5���� �̸��� ����
   }//������
   
   public void insert(String name) {//���޵� �̸��� ���ڸ�(null)�� ����
	   names.add(name);	  
   }//insert
   
   public void select() {
	   System.out.println("#�̸����");
	   for(int i=0; i<names.size(); i++) {//�ε����� ���� ��ü �迭 ����		   
			 System.out.println(" "+ names.get(i));
	   }
   }//select
   
   public void update(String oldName, String newName) {	   
	   
	   /*for(int i=0; i<names.size(); i++) {		  
		   if( names.get(i).equals(oldName) ) { //���� �̸� ã��			
		       //names.set(int index, String element)
			   names.set(i, newName);
			   break;
		   }
	   }*/
	   
	   //����, �ߺ��� �̸��� �������� �ʴ´ٸ�
	   names.set(names.indexOf(oldName),  newName);
	   
   }//update
   
   public boolean delete(String name) {
	   /*for(int i=0; i<names.size(); i++) {
		   if(names.get(i).equals(name)) {//��ġ�ϴ� �̸�ã��
			  names.remove(i);
			  return true;//���� ����!!
		   }
	   }*/
	   if(names.remove(name)) return true;
	   
	   return false;
   }//delete
   
   //�̸� ����(����) ���� �Ǵ�
   public boolean existName(String name) {//�̸� ����: true ����
	  if(names.contains(name)) return true;
	  
	  return false;
   }//existName
   
}








