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
  //출력객체들은 공통적으로 flush()메소드 제공 ----> 버퍼에 담긴 내용을 밀어주는 역할
	}//main
}