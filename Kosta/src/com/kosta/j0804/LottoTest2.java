package com.kosta.j0804;

import java.util.Arrays;
import java.util.Random;

public class LottoTest2 {
    public static void main(String[] args) {
		int su[]=new int[45];//{0,0,....,0,0}
		for (int i = 0; i < su.length; i++) {
			su[i] = i+1;  
		}//{44,1,3,2,.....,4,45}
		
		Random r = new Random();
		
		int tmp;
		
		for(int i=0; i<1000; i++) {//i: 단순 반복횟수
			int idx = r.nextInt(44)+1;//0번지를 제외한 나머지 번지(1~44)
			tmp     =su[0];
			su[0]=su[idx];
			su[idx]=tmp;
		}//for
		
		int lotto[] = Arrays.copyOf(su, 6);
		Arrays.sort(lotto);		
		
		//중복되지 않는 6개의 정수를 출력
		for(int i=0; i<6; i++) {//i: 0번지~5번지
			System.out.print(lotto[i]+" ");
		}
		
	}//main   
}