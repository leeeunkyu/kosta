package com.kosta.j0804;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoTest3 {
   public static void main(String[] args) {
	  Set<Integer> set = new HashSet<>(); //�ߺ������� �Է� ����
	  Random r = new Random();
	  
	  while(true) {
	    set.add(r.nextInt(45)+1);//1~45
	    if(set.size() == 6)break;
	  }
	   
	  System.out.println(set);    
	   
   }//main
}