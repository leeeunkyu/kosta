package com.kosta.j0804;

import java.util.Arrays;
import java.util.Random;

class LottoGenerate{
	Random random=new Random();
	int number;
	int lottolist[]=new int[6];
	public void numGenerate(int index) {
		number = (random.nextInt(44)+1);
		//System.out.print("생성된 번호: "+number);
		for (int i = 0; i < lottolist.length; i++) {
			if(lottolist[i]==number) {
				number = (random.nextInt(45)+1);
				i=-1;
			}
		}
		lottolist[index]=number;
		//System.out.println();
	}
	public void numSort(int turn) {
		Arrays.sort(lottolist);
		System.out.print(turn+1+"회: ");
		for (int i = 0; i < lottolist.length; i++) {
			System.out.print("  "+lottolist[i]);
		}
		System.out.println();
	}
}
public class GoodLuckLotto {
	public static void main(String[] args) {
		LottoGenerate lg = new LottoGenerate();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				lg.numGenerate(j);	
			}
			lg.numSort(i);
		}
	}
}
