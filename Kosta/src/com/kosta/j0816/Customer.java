package com.kosta.j0816;

public class Customer extends Thread{//성금자 ---> 스레드(경쟁적인 성금자)
    Account account;
	
    public Customer(Account account) {
	   //account = new Account();
	   this.account = account;
    }
    
    
	public void run() {
		try {
			for(int i=1; i<=200; i++) {
				Thread.sleep(50);
				account.deposit(1000);//1회 천원씩 모금
				System.out.println(getName()+":"+i);
				if(account.getTotal() >= 500000)//목표액: 50만원 달성
				  break;
			}//for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}//run
	
}



