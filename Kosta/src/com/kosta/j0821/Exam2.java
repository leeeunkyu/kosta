package com.kosta.j0821;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam2 {
	static final int MINNUM=1;
	int num;
	Scanner scan;
	public Exam2() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		try {
			num=scan.nextInt();
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("정수만입력하세요.");
			System.exit(1);
		}
		if(getNumber(num).equals("false"))
			System.exit(1);
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				printNumber(j);	
			}
			System.out.println();
		}
	}
	//여기서 왜 getNumber가 String반환형에 int매개변수를 받는지 모르겠습니다.
	public String getNumber(int length) {

		if(length<MINNUM) {
			System.out.println("1보다 큰정수만입력하세요.");
			return "false";	
		}
		return "true";
	}
	public void printNumber(int length) {
		System.out.print(length);
	}
	public static void main(String[] args) {
		new Exam2();
	}
}
