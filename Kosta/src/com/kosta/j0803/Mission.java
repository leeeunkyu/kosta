package com.kosta.j0803;

public class Mission {
	public static void main(String[] args) {
		int su[]= {1,2,3,4,5};
		System.out.println("����1) su�迭�� ���ʴ�� ���");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		System.out.println("\n����2) su�迭�� �������η� ���");
		for (int i = su.length-1; i >=0; i--) {
			System.out.print(su[i]+"  ");
		}
		System.out.println("\n����3) su2�迭�� �������� �Բ� ���");
		int su2[][]= {{1},{1,2},{1,2,3}};
		for (int i = 0; i < su2.length; i++) {
			for (int j = 0; j < su2[i].length; j++) {
				System.out.print("su2["+i+"]["+j+"]"+su2[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("\n����4) su3�迭�� ���� su�迭�� ����");
		int su3[]=new int[su.length];
		for (int i = 0; i < su3.length; i++) {
			su3[i]=su[i];
		}
		for (int i = 0; i < su3.length; i++) {
			System.out.print(su3[i]+" ");
		}
		System.out.println("\n"
				+ "����5)");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		System.out.println();

		int temp;
		for (int i = 0; i < su.length/2+1; i++) {
			System.out.println("�ٲ����"+"su["+i+"]=>"+su[i]+"su["+(su.length-1-i)+"]=>"+su[su.length-1-i]);
			temp=su[i];
			su[i]=su[su.length-1-i];
			su[su.length-1-i]=temp;
			System.out.println("�ٲ��Ŀ�"+"su["+i+"]=>"+su[i]+"su["+(su.length-1-i)+"]=>"+su[su.length-1-i]);
		}
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]+" ");
		}
		
	}
}
