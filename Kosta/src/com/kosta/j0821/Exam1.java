package com.kosta.j0821;
import java.util.Scanner;

public class Exam1 {
	static final int MAXRANGE=50;
	static final int MINRANGE=0;
	Scanner scan;
	int start;
	int end;
	int temp;
	FileAdder fa;
	public Exam1() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		fa = new FileAdder();
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		start = scan.nextInt();
		end = scan.nextInt();
		if((start> MAXRANGE || end> MAXRANGE)&& (start<MINRANGE || end <MINRANGE)) {
			System.out.println("���� ������ Ȯ�����ּ���");
			return;
		}
		swap(start,end);
		fa.setting(start,end);
	}
	private void swap(int start, int end) {
		if(start>end) {
			temp=this.start;
			this.start=this.end;
			this.end=temp;
			System.out.println("[Warning] ���۹����� ��������� �ڵ� ���� �մϴ�.");
		}
	}
	public static void main(String[] args) {
		new Exam1();
	}
}
