package com.kosta.j0804;

public class Car {
   String carName;
   int wheelNum;
   int velocity;
    
   
   public Car(String carName, int wheelNum, int velocity) {
	   //������: �ʱ�ȭ �޼ҵ�
	this.carName = carName;
	this.wheelNum = wheelNum;
	this.velocity = velocity;
   }

   

   @Override
public String toString() {
	return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
}



/*public String toString() {//to~(): ��ȯ�޼ҵ� 
	              //toString(): ��ü�� ���¸� ǥ���ϴ� �޼ҵ�.
	   return "[������ "+ this.carName+"�̰� �������� "+wheelNum
			    +"���̰� �ӵ��� "+velocity+"~!!]"; 
   }   
   
   public boolean equals(Car c){//Car c = c2;
	  if(carName == c.carName &&
	     wheelNum == c.wheelNum &&
	     velocity == c.velocity) {
		  return true;
	  }else { 
	   
	  return false;
	  }
   }//equals
*/   
   public static void main(String args[]) {
	   Car c1 = new Car("�ҳ�Ÿ",4,100);
	   Car c2 = new Car("�׷���",4,200);
	          //= c1;
	   //c1,c2 ==> ��ü���� ���� ��!!
	   //  1. ��ü�� ���۷���(�ּ�,�޸�)�� ��      2. ��ü�� ������ ��	   
	   //1.
	   if(c1 == c2) {
		   System.out.println("���۷��� ����!!");
	   }else {
		   System.out.println("���۷��� �ٸ�!!");
	   }	   
	   //2.��ü���� �񱳡� (����-->true, �ٸ���-->false)
	   if(c1.equals(c2)) {
		   System.out.println("��ü ���� ����!!");
	   }else {
		   System.out.println("��ü ���� �ٸ�!!");
	   }
	   
	   
	   String str = c2.toString();//c1.toString();
	   System.out.println("STR="+ str);
   }//main
   
}



