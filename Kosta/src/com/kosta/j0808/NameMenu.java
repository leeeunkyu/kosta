package com.kosta.j0808;

import java.util.Vector;

public class NameMenu {
   //String names[];//������ �����
   Vector<String> v;
   int count=0;
   final int MAX=4;
   public NameMenu() {
	//   names = new String[5];//������ �ִ� 5���� �̸��� ����
	   v=new Vector<>();
   }//������
   
   public void insert(String name) {//���޵� �̸��� ���ڸ�(null)�� ����
	  
	   for(int i=0; i<v.size(); i++) {//��ü �迭 �˻�
		  if(count>MAX) {
			  System.out.println("���̻� �Է��Ҽ� �����ϴ� �̸��� �������� �Է��ϼ���!");
			  break;
		  }
		  else if(v.get(i).equals(name)) {
			  System.out.println("�ߺ��Ǵ� �̸��� �ֽ��ϴ�.");
			  break;
		  }else{
			 v.add(name); 
		  }
	   }

   }//insert
   
   public void select() {
	   System.out.println("#�̸����");
	   for(int i=0; i<v.size(); i++) {//�ε����� ���� ��ü �迭 ����
		   System.out.println(v.get(i));
	   }
   }//select
   
   public void update(String oldName, String newName) {
	   /*
	       <���ڿ� ���� ��>
	          ���ع��ڿ�.equals(�񱳹��ڿ�)
	          
	       <���ڿ� null(�޸�) ��>
	          ���ع��ڿ� == null   
	    */
	   
	   for(int i=0; i<v.size(); i++) {		  
		   /*if( names[i] != null && //NullPointerException ����
				   names[i].equals(oldName) ) { //���� �̸� ã��
*/			
		   if(oldName.equals(v.get(i))) { //  "".equals(null)   
		      v.set(i, newName);
			   break;
		   }
		   else if(i==v.size()-1) {
			   System.out.println("�������� �ʴ� �̸��Դϴ�.");
		   }
	   }
   }//update
   
   public void delete(String name) {
	   for(int i=0; i<v.size(); i++) {
		   if(name.equals(v.get(i))) {//��ġ�ϴ� �̸�ã��
			  v.remove(i);
			  count--;
			  break;
		   }else if(i==v.size()-1) {
			   System.out.println("�������� �ʴ� �̸��Դϴ�.");
			   
		   }
	   }
   }//delete
   
}




