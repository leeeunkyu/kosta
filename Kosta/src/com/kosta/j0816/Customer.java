package com.kosta.j0816;

public class Customer extends Thread{//������ ---> ������(�������� ������)
    Account account;
	
    public Customer(Account account) {
	   //account = new Account();
	   this.account = account;
    }
    
    
	public void run() {
		try {
			for(int i=1; i<=200; i++) {
				Thread.sleep(50);
				account.deposit(1000);//1ȸ õ���� ���
				System.out.println(getName()+":"+i);
				if(account.getTotal() >= 500000)//��ǥ��: 50���� �޼�
				  break;
			}//for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}//run
	
}



