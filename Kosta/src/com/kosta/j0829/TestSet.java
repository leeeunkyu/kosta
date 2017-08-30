package com.kosta.j0829;

import java.util.Date;
import java.util.HashSet;

public class TestSet {
	
	public static void main(String[] args) {
		HashSet set = new HashSet();
		//HashMap map = new 
		System.out.println(set.add("hellod"));
		System.out.println(set.add("hellod"));
		System.out.println(set.add("hellod"));
		System.out.println(set.add("hellod"));
		System.out.println(set.add(1000));
		System.out.println(set.add(new Integer(1000)));
		System.out.println(set.add(new Date()));
		System.out.println(set.iterator().next());
		System.out.println(set.iterator().next());
		System.out.println(set.iterator().next());

	}
}
