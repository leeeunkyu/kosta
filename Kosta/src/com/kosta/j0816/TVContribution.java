package com.kosta.j0816;


public class TVContribution {//방송국: 모금 제어, 모금자들 출력
   public static void main(String[] args) {
	   
	   
	   //5명 모집
	  /* Customer c1 = new Customer(); 
	   Customer c2 = new Customer(); 
	   Customer c3 = new Customer(); 
	   Customer c4 = new Customer(); 
	   Customer c5 = new Customer();
	   
	   c1.start();
	   c2.start();
	   c3.start();
	   c4.start();
	   c5.start();*/
	   
	   //배열객체생성: 자료형[] 배열명 = new 자료형[사이즈];
	   Account account = new Account();
	   Customer [] customers = new Customer[5];//[0]~[4]
	   
	   for (int i = 0; i < customers.length; i++) {
		   customers[i]=new Customer(account);
		   customers[i].start();
	   }
	   
	   try {
		for (int i = 0; i < customers.length; i++) {
			   customers[i].join();//메인메소드가 Thread끝날 때 까지 기다림.
		   }
	   } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	   
	   System.out.println("총 모금액: "+ customers[0].account.getTotal());
	   
   }//main
}




