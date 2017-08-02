package com.kosta.j0801;
import java.io.IOException;

public class GugudanTest_0801 {
	public static void main(String[] args)  throws IOException 
	{
		System.out.println("1~9까지 숫자입력");
		System.out.println("출력)");
		int num=System.in.read()-48;
		System.out.println("<"+num+"단>");
		for(int i=1;i<10;i++)
		{
			System.out.println(num+" * "+i+" = " + num*i);
		}

	}
}
