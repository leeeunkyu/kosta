package com.kosta.j0804;

public class Car {
   String carName;
   int wheelNum;
   int velocity;
    
   
   public Car(String carName, int wheelNum, int velocity) {
	   //생성자: 초기화 메소드
	this.carName = carName;
	this.wheelNum = wheelNum;
	this.velocity = velocity;
   }

   

   @Override
public String toString() {
	return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
}



/*public String toString() {//to~(): 변환메소드 
	              //toString(): 객체의 상태를 표현하는 메소드.
	   return "[이차는 "+ this.carName+"이고 바퀴수는 "+wheelNum
			    +"개이고 속도는 "+velocity+"~!!]"; 
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
	   Car c1 = new Car("소나타",4,100);
	   Car c2 = new Car("그랜저",4,200);
	          //= c1;
	   //c1,c2 ==> 객체들의 대한 비교!!
	   //  1. 객체의 레퍼런스(주소,메모리)를 비교      2. 객체의 내용을 비교	   
	   //1.
	   if(c1 == c2) {
		   System.out.println("레퍼런스 같음!!");
	   }else {
		   System.out.println("레퍼런스 다름!!");
	   }	   
	   //2.객체내용 비교★ (같다-->true, 다르다-->false)
	   if(c1.equals(c2)) {
		   System.out.println("객체 내용 같음!!");
	   }else {
		   System.out.println("객체 내용 다름!!");
	   }
	   
	   
	   String str = c2.toString();//c1.toString();
	   System.out.println("STR="+ str);
   }//main
   
}



