package com.kosta.j0808;

import java.util.Vector;

public class VectorTest2 {
	
  public static void main(String[] args) {
	//VectorŬ������ ������ �߰�,����,����,��ȸ��
	  
	  Vector<String> v = new Vector<>();
	  
	  //�߰� add, addElement
	     //v.add(13); //����!! ���׸���� ������ ����� �ڷ����� �Է� ����!!
	  v.add("ȫ�浿");//index 0
	  v.add("�����");//1	  
	  v.add("���ֿ�");//2
	  v.add("ȫ�浿");//3
	  
	  System.out.println("������ ��Ұ���: "+ v.size());
	  //��ȸ,�˻�  : get(int index) ,elementAt(int index) 
	  for(int i=0; i<v.size(); i++) {//Vector�� �ε����� ǥ��
		  // �ε����� ��ü����� ���� �� �ִٸ� for�� ���� ����!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  //����  : "�����" ----> "������"
	  //set(int index, E element) ,   setElementAt(E obj, int index) 
	  for(int i=0; i<v.size(); i++) {
		  if(v.get(i).equals("�����")) {
			  v.set(i,"������");
		  }
	  }	  
	  
	  System.out.println("--------------------------------");
	  for(int i=0; i<v.size(); i++) {//Vector�� �ε����� ǥ��
		  // �ε����� ��ü����� ���� �� �ִٸ� for�� ���� ����!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  //���� : "ȫ�浿"
	  //remove(Object o),  removeElement(Object obj) 
	  //remove(int index),  removeElementAt(int index) 
	  //��ü ����: clear() , removeAllElements() 
	  /*for(int i=0; i<v.size(); i++) {
		  if(v.get(i).equals("ȫ�浿")) {
			  v.remove(i);
		  }
	  }*/
	  v.remove("ȫ�浿");
	  
	  
	  System.out.println("--------------------------------");
	  for(int i=0; i<v.size(); i++) {//Vector�� �ε����� ǥ��
		  // �ε����� ��ü����� ���� �� �ִٸ� for�� ���� ����!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  Vector v2 = new Vector();
	    v2.add(new Person("ȫ�浿",13,"�л�"));
	    
	  //����) v2�� �Էµ� ȫ�浿�� ���̸� ����Ͻÿ�.
       Object ob =  v2.get(0);
	   //System.out.println("ȫ�浿�� ����: "+ ob.getAge());//����!!
       System.out.println("ȫ�浿�� ����: "+ ((Person)ob).getAge());
       
      Vector<Person> v3 = new Vector<>(); 
        Person p = new Person("�����", 15, "�л�");
        v3.add(p); 
      
      //����) v3�� �Էµ� ������� ���̸� ����Ͻÿ�. 
        Person pp = v3.get(0);
       System.out.println("������� ����: "+ v3.get(0).getAge() ); 
        
        
  }//main
}




