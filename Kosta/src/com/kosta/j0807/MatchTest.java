package com.kosta.j0807;

public class MatchTest {
	public static void main(String[] args) {
		String str = "014142";
		String pattern ="[\\d]{1,4}";
		System.out.println(str.matches(pattern));
	}
}
