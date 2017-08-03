package com.kosta.j0803;

import java.util.Random;

class A{
	void hello() {
		System.out.println("A안녕~!!");
	}
}


public class RandomArrayTest {
	
	public static void main(String[] args) {
		A arry[] = new A[3];
		  A obj = new A();
		  
		  arry[0] = obj;
		  arry[1] = new A();
		  
		for (int i = 0; i < arry.length; i++) {
			System.out.println(arry[i]);
		}
		
		arry[0].hello();
		//arry[2].hello(); ----> null.hello(); ----> NullPointerException발생
		
		//배열 객체 선언  :  자료형 변수명[]= new 자료형[배열크기];
		int su[]=new int[5];
		
		
		Random r = new Random(); 
		//자바 랜덤관련 클래스: java.lang.Math-random()   java.util.Random-next~()
	    for(int i=0; i<su.length; i++) {//su배열에 임의의 수(난수)를 입력
	    	//su[i]= (int) Math.random(); //(int캐스팅)double데이터
	    	//random() : 0.0 <= 수  < 1.0   : 0.0, 0.001, 0.1111~ 0.999999999
	    	
	    	//수의 확장
	    	//su[i]= (int) (Math.random()*100); //(int)0.000~99.9999 : 0~99
	    	//su[i] = r.nextInt(int bound);
	    	su[i] = r.nextInt(1000);//0~999
	    }
	    
	    System.out.println("======================");
	    //저장된 랜덤 데이터 출력
	    for(int i=0; i<su.length; i++) {
	    	System.out.println("su["+i+"]="+ su[i]);
	    }
	
	}//main

}



