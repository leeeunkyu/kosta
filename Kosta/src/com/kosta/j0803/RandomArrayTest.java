package com.kosta.j0803;

import java.util.Random;

class A{
	void hello() {
		System.out.println("A�ȳ�~!!");
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
		//arry[2].hello(); ----> null.hello(); ----> NullPointerException�߻�
		
		//�迭 ��ü ����  :  �ڷ��� ������[]= new �ڷ���[�迭ũ��];
		int su[]=new int[5];
		
		
		Random r = new Random(); 
		//�ڹ� �������� Ŭ����: java.lang.Math-random()   java.util.Random-next~()
	    for(int i=0; i<su.length; i++) {//su�迭�� ������ ��(����)�� �Է�
	    	//su[i]= (int) Math.random(); //(intĳ����)double������
	    	//random() : 0.0 <= ��  < 1.0   : 0.0, 0.001, 0.1111~ 0.999999999
	    	
	    	//���� Ȯ��
	    	//su[i]= (int) (Math.random()*100); //(int)0.000~99.9999 : 0~99
	    	//su[i] = r.nextInt(int bound);
	    	su[i] = r.nextInt(1000);//0~999
	    }
	    
	    System.out.println("======================");
	    //����� ���� ������ ���
	    for(int i=0; i<su.length; i++) {
	    	System.out.println("su["+i+"]="+ su[i]);
	    }
	
	}//main

}



