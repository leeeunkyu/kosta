package com.kosta.j0816;


public class TVContribution {//��۱�: ��� ����, ����ڵ� ���
   public static void main(String[] args) {
	   
	   
	   //5�� ����
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
	   
	   //�迭��ü����: �ڷ���[] �迭�� = new �ڷ���[������];
	   Account account = new Account();
	   Customer [] customers = new Customer[5];//[0]~[4]
	   
	   for (int i = 0; i < customers.length; i++) {
		   customers[i]=new Customer(account);
		   customers[i].start();
	   }
	   
	   try {
		for (int i = 0; i < customers.length; i++) {
			   customers[i].join();//���θ޼ҵ尡 Thread���� �� ���� ��ٸ�.
		   }
	   } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	   
	   System.out.println("�� ��ݾ�: "+ customers[0].account.getTotal());
	   
   }//main
}




