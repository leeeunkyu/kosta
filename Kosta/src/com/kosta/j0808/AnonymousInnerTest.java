package com.kosta.j0808;


class A{
   void hello() {
	   System.out.println("A클래스 안녕~!!");
   }
}

abstract class B{
	abstract void draw();
}

interface C{
	void print();
}


public class AnonymousInnerTest { //익명의 내부클래스
    public static void main(String[] args) {
    	/*A a = class Temp extends A{
    		     void hell() {}
    	      };*/  
    	
    	// A a = new A(){}; // {} ---> 무명의 클래스 body괄호
		A a = new A() //new A() == class Temp extends A
				{
			      int su=10;
			      
			      void gildong() {}
			      
			      @Override
			      void hello()
			      {   
			    	  System.out.println("A클래스 안녕하세요~!!");
			      }
			     };
			     
		  
		  a.hello();
		  //a.gildong();//부모레퍼런스 통해 자식 호출 불가!! : 에러발생
		  
		//추상클래스!!   class 무명 extends B {}
		B b = new B() {

			@Override
			void draw() {
				System.out.println("예쁜그림~!!");				
			}};	
		b.draw();
	     //인터페이스 !!  class 무명 implements C{}  
	     C c = new C() {
			@Override
			public void print() {
				 System.out.println("자식오버라이딩 프린트~!!");
			}};
			c.print();
			
	}//main
}


