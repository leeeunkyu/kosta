package com.kosta.j0802;

import java.io.IOException;

public class Gugudan {
	public int danInput() throws IOException {
		System.out.println("원하는단?");
		int dan = System.in.read()-48;
		System.in.read();
		System.in.read();
		return dan;
		
	}
	public void danOutput(int dan) {
		for (int i = 0; i < 10; i++) {
			System.out.println(dan+" * "+i+" = "+dan*i);
		}
	}
	public char danContinue() throws IOException {
		System.out.println("겨속 y or n?");
		char yn = (char)System.in.read();
		System.in.read();
		System.in.read();
		return yn;
	}
}
