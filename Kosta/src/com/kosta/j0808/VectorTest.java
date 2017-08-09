package com.kosta.j0808;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		
		// Vector(int capacity, int increment)
		Vector v = new Vector(5,3);//JDK4��������
		//Vector<Object> v = new Vector<Object>(5,3);//JDK4��������
		
		System.out.println("������ ��ũ��: "+ v.capacity()); //5
		System.out.println("������ ��Ұ���: "+ v.size()); //0��
		
		//�迭: length�Ӽ�, ���ڿ�: length()�޼ҵ�, ����: size()�޼ҵ�
		
		for(int i=1; i<10; i++) {//i = 1~9
			v.addElement(new Integer(i));
		}
		
		System.out.println("������ ��ũ��: "+ v.capacity()); //11
		System.out.println("������ ��Ұ���: "+ v.size()); //9��
		
		v.addElement(new Double(3.14));
		v.addElement(new Double(9.87));
		
		v.addElement(new String("�ڹ�"));
		
		System.out.println("������ ��ũ��: "+ v.capacity()); //14
		System.out.println("������ ��Ұ���: "+ v.size()); //12��
		
		System.out.println("ù��° ���: "+ v.firstElement());
		System.out.println("������ ���: "+ v.lastElement());
		
		System.out.println("3.14����? "+ v.contains(new Double(3.14)));
		
		//��ü��ҿ� ���� ���  
		//Enumeration : ������ �������̽�
		Enumeration enu = v.elements();
		
		while(enu.hasMoreElements()) {//��� üũ
		   System.out.println(enu.nextElement());
		}
		
		
	}//main

}