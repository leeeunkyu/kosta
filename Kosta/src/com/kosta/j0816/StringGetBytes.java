package com.kosta.j0816;


public class StringGetBytes {
    public static void main(String[] args) {
		String str="hi java stream!!";
		byte [] b= str.getBytes();
		for (int i = 0; i < b.length; i++) {
		   System.out.write(b[i]);
		   if(i%3==2)System.out.write('\n');
		}		
		System.out.flush();
		//System.out.close();
  //��°�ü���� ���������� flush()�޼ҵ� ���� ----> ���ۿ� ��� ������ �о��ִ� ����
	}//main
}