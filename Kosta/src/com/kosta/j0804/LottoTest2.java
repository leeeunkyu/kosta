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
		
		for(int i=0; i<1000; i++) {//i: �ܼ� �ݺ�Ƚ��
			int idx = r.nextInt(44)+1;//0������ ������ ������ ����(1~44)
			tmp     =su[0];
			su[0]=su[idx];
			su[idx]=tmp;
		}//for
		
		int lotto[] = Arrays.copyOf(su, 6);
		Arrays.sort(lotto);		
		
		//�ߺ����� �ʴ� 6���� ������ ���
		for(int i=0; i<6; i++) {//i: 0����~5����
			System.out.print(lotto[i]+" ");
		}
		
	}//main   
}