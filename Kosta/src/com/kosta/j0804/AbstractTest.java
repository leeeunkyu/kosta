package com.kosta.j0804;

abstract class Shape{
	abstract void draw();
}
class Circle extends Shape{
	void draw() {
		System.out.println("원 그리기");
	}
}
class Rectangle extends Shape{
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형 그리기");
	}
	
}

class Triangle extends Shape{

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형 그리기");
	}
	
}

public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shape s = new Shape(); //추상클래스는 객체생성 불가
		Shape s = new Circle();
	}

}
