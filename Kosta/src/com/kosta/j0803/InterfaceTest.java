package com.kosta.j0803;

interface Animal{//���� �ۼ��� Animal.java ����
	//void m1() {}  : ����---> �ٵ�{} ��� �Ұ�
	
	void walk();
	public abstract void sleep();
	//protected void bark();  : ���� ---> ���������ڰ� public �����̱� ������
	void bark();
}

class Dog implements Animal {
	//Animal�������̽��� ����� ��� �޼ҵ带 ��Ŭ������ �����ϰ���!!
	public void sleep() {
		System.out.println("����~");
	}
	public void bark() {
		System.out.println("�۸�~");
	}
	
	@Override
	public void walk() {}
	
	public void run() {
		System.out.println("�޷�����~!!");
    }	
}

public class InterfaceTest {
    public static void main(String[] args) {
		Animal ani;
		       ani = new Dog();
		       
		       ani.bark();
		       ani.sleep();
		       ani.walk();
	}
}





