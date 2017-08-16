package com.kosta.j0816;


class MyThread3 extends Thread{ 
	
	public MyThread3(String name) {
	   super(name);
	}
	
	public void run() {
	   try {
		for(int i=0; i<10; i++) {
			   sleep(500);
			   System.out.println(i+": "+getName()+"������ : �켱���� ("
			                 + getPriority()+")");
		   }
	   } catch (InterruptedException e) {
		e.printStackTrace();
	   }
	}//run
	
}//MyThread3



public class ThreadTest2 {
   public static void main(String[] args) {
       Thread t1= new MyThread3("�浿");
         //�켱���� : 1(����)~10(����)
         t1.setPriority(Thread.MAX_PRIORITY);//10
       Thread t2= new MyThread3("����");	
         t2.setPriority(Thread.MIN_PRIORITY);//1
       Thread t3= new MyThread3("�ֿ�");      
         t3.setPriority(Thread.NORM_PRIORITY);//�⺻��: 5
       
       t1.start();
       t2.start();
       t3.start();
   }
}



