package com.kosta.util;

import java.text.NumberFormat;
import java.util.Locale;

//숫자데이터를 받아서 1000단위마다 , 표기
public class Utility {
	public Utility() {
		// TODO Auto-generated constructor stub
		
	}
	public static StringBuffer numSplit(long num) {
		StringBuffer sb=new StringBuffer();
		sb.append(num);
		for (int i=sb.length(); i >3; i-=3) {
			sb.insert(i-3, ",");
		}
		return sb;
	}
	public static StringBuffer numSplit(double num) {
		StringBuffer sb=new StringBuffer();
		sb.append(num);
		int index = sb.indexOf(".");
		int j=3;
		for (int i=0; i <index; i+=3) {
			if(index-j>0) {
			sb.insert(index-j, ",");
			j+=3;
			}
		}
		return sb;
	}
	public static StringBuffer numMoney(long num) {
		StringBuffer sb=new StringBuffer();		
		 NumberFormat nf =NumberFormat.getCurrencyInstance(Locale.KOREA);
		 sb.append(nf.format(num));

		return sb;
	}
	public static StringBuffer numMoney(double num) {
		StringBuffer sb=new StringBuffer();
		 NumberFormat nf =NumberFormat.getCurrencyInstance(Locale.KOREA);
		 sb.append(nf.format(num));

		return sb;
	}
	public static void main(String[] args) {
		System.out.println();
		StringBuffer result;
		result=Utility.numSplit(1234567890);
		System.out.println(result);
		result=Utility.numSplit(1210232.123);
		System.out.println(result);
		result=Utility.numMoney(4500000);
		System.out.println(result);
		result=Utility.numMoney(412352.322);
		System.out.println(result);
		result=Utility.ForeignMoney(4500000,Locale.KOREA);
		System.out.println(result);
		result=Utility.foreignMoney(412352.322,Locale.KOREA);
		System.out.println(result);


	}
	public static StringBuffer foreignMoney(double d, Locale l) {
		// TODO Auto-generated method stub
		return null;
	}
	public static StringBuffer ForeignMoney(long i, Locale l) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
