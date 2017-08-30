package com.kosta.j0829;

import java.util.ArrayList;

public class TestList {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("hello");
		list.add(1000);
		System.out.println(list.size());
		
		//조회 반환타입 Object 타입 -> instanceof,type casting
		Object obj = list.get(0);
		System.out.println(obj);
		Member m1 = new Member("user_id", "user_pwd", "user_name", "gender", "usersignup");
		Member m2 = new Member("user_id2", "user_pwd", "user_name"," gender", "user_signup");
		Member m3 = new Member("user_id", "user_pwd", "user_name"," gender", "user_signup");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		
		System.out.println(m1.equals(m3));
	}
}
