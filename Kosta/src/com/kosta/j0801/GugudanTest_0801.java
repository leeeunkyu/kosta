package com.kosta.j0801;
import java.io.IOException;

public class GugudanTest_0801 {
	public static void main(String[] args)  throws IOException 
	{
		System.out.println("1~9���� �����Է�");
		System.out.println("���)");
		int num=System.in.read()-48;
		System.out.println("<"+num+"��>");
		for(int i=1;i<10;i++)
		{
			System.out.println(num+" * "+i+" = " + num*i);
		}

	}
}
