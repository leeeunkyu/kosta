package com.kosta.j0808;


class A{
   void hello() {
	   System.out.println("AŬ���� �ȳ�~!!");
   }
}

abstract class B{
	abstract void draw();
}

interface C{
	void print();
}


public class AnonymousInnerTest { //�͸��� ����Ŭ����
    public static void main(String[] args) {
    	/*A a = class Temp extends A{
    		     void hell() {}
    	      };*/  
    	
    	// A a = new A(){}; // {} ---> ������ Ŭ���� body��ȣ
		A a = new A() //new A() == class Temp extends A
				{
			      int su=10;
			      
			      void gildong() {}
			      
			      @Override
			      void hello()
			      {   
			    	  System.out.println("AŬ���� �ȳ��ϼ���~!!");
			      }
			     };
			     
		  
		  a.hello();
		  //a.gildong();//�θ��۷��� ���� �ڽ� ȣ�� �Ұ�!! : �����߻�
		  
		//�߻�Ŭ����!!   class ���� extends B {}
		B b = new B() {

			@Override
			void draw() {
				System.out.println("���۱׸�~!!");				
			}};	
		b.draw();
	     //�������̽� !!  class ���� implements C{}  
	     C c = new C() {
			@Override
			public void print() {
				 System.out.println("�ڽĿ������̵� ����Ʈ~!!");
			}};
			c.print();
			
	}//main
}


