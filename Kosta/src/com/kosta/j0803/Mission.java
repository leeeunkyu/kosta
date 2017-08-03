package com.kosta.j0803;

public class Mission {
	public static void main(String[] args) {
		int su[]= {1,2,3,4,5};
		System.out.println("문제1) su배열을 차례대로 출력");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		System.out.println("\n문제2) su배열을 역순으로로 출력");
		for (int i = su.length-1; i >=0; i--) {
			System.out.print(su[i]+"  ");
		}
		System.out.println("\n문제3) su2배열을 번지값과 함께 출력");
		int su2[][]= {{1},{1,2},{1,2,3}};
		for (int i = 0; i < su2.length; i++) {
			for (int j = 0; j < su2[i].length; j++) {
				System.out.print("su2["+i+"]["+j+"]"+su2[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("\n문제4) su3배열을 만들어서 su배열값 복사");
		int su3[]=new int[su.length];
		for (int i = 0; i < su3.length; i++) {
			su3[i]=su[i];
		}
		for (int i = 0; i < su3.length; i++) {
			System.out.print(su3[i]+" ");
		}
		System.out.println("\n"
				+ "문제5)");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		System.out.println();

		int temp;
		for (int i = 0; i < su.length/2+1; i++) {
			System.out.println("바뀌기전"+"su["+i+"]=>"+su[i]+"su["+(su.length-1-i)+"]=>"+su[su.length-1-i]);
			temp=su[i];
			su[i]=su[su.length-1-i];
			su[su.length-1-i]=temp;
			System.out.println("바뀐후에"+"su["+i+"]=>"+su[i]+"su["+(su.length-1-i)+"]=>"+su[su.length-1-i]);
		}
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		
	}
}
