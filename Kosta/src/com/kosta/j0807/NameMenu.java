package com.kosta.j0807;

public class NameMenu {
   String names[];//������ �����
   int count=0;
   final int MAX=4;
   public NameMenu() {
	   names = new String[5];//������ �ִ� 5���� �̸��� ����
   }//������
   
   public void insert(String name) {//���޵� �̸��� ���ڸ�(null)�� ����
	  
	   for(int i=0; i<names.length; i++) {//��ü �迭 �˻�
		  if(count>MAX) {
			  System.out.println("���̻� �Է��Ҽ� �����ϴ� �̸��� �������� �Է��ϼ���!");
			  break;
		  }
		  if(names[i]!=null && names[i].equals(name)) {
			  System.out.println("�̹� �Էµ� �̸��Դϴ�.");
		  }else {
			  if(names[i] == null) {//���ڸ����, ������ null�̶��
				  names[i] = name;
				  count++;
				  break;
			  }
		  }
	  }
   }//insert
   
   public void select() {
	   System.out.println("#�̸����");
	   for(int i=0; i<names.length; i++) {//�ε����� ���� ��ü �迭 ����
		   if(names[i] != null)
			 System.out.println(" "+ names[i]);
	   }
   }//select
   
   public void update(String oldName, String newName) {
	   /*
	       <���ڿ� ���� ��>
	          ���ع��ڿ�.equals(�񱳹��ڿ�)
	          
	       <���ڿ� null(�޸�) ��>
	          ���ع��ڿ� == null   
	    */
	   
	   for(int i=0; i<names.length; i++) {		  
		   /*if( names[i] != null && //NullPointerException ����
				   names[i].equals(oldName) ) { //���� �̸� ã��
*/			
		   if(oldName.equals(names[i])) { //  "".equals(null)   
		      names[i]=newName;
			   break;
		   }
		   else if(names[i]==null && i==names.length-1) {
			   System.out.println("�������� �ʴ� �̸��Դϴ�.");
		   }
	   }
   }//update
   
   public void delete(String name) {
	   for(int i=0; i<names.length; i++) {
		   if(names[i] != null && names[i].equals(name)) {//��ġ�ϴ� �̸�ã��
			  names[i]=null;
			  count--;
			  break;
		   }else if(names[i]==null && i==names.length-1) {
			   System.out.println("�������� �ʴ� �̸��Դϴ�.");
			   
		   }
	   }
   }//delete
   
}




