package com.kosta.j0804;

abstract class Shape{
	abstract void draw();
}
class Circle extends Shape{
	void draw() {
		System.out.println("�� �׸���");
	}
}
class Rectangle extends Shape{
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("�簢�� �׸���");
	}
	
}

class Triangle extends Shape{

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("�ﰢ�� �׸���");
	}
	
}

public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shape s = new Shape(); //�߻�Ŭ������ ��ü���� �Ұ�
		Shape s = new Circle();
	}

}
