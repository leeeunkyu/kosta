package com.kosta.j0803;

interface Animal{//따로 작성시 Animal.java 저장
	//void m1() {}  : 에러---> 바디{} 사용 불가
	
	void walk();
	public abstract void sleep();
	//protected void bark();  : 에러 ---> 접근제한자가 public 고정이기 때문에
	void bark();
}

class Dog implements Animal {
	//Animal인터페이스에 선언된 모든 메소드를 현클래스에 구현하겠음!!
	public void sleep() {
		System.out.println("쿨쿨~");
	}
	public void bark() {
		System.out.println("멍멍~");
	}
	
	@Override
	public void walk() {}
	
	public void run() {
		System.out.println("달려가요~!!");
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





