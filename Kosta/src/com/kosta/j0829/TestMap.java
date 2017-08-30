package com.kosta.j0829;

import java.util.HashMap;

public class TestMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		Member m1 = new Member("user_id", "user_pwd", "user_name", "gender", "usersignup");
		Member m2 = new Member("user_id2", "user_pwd", "user_name"," gender", "user_signup");
		Member m3 = new Member("user_id3", "user_pwd", "user_name"," gender", "user_signup");
		map.put("user_id", m1);
		map.put("user_id2", m2);
		map.put("user_id3", m3);
		map.get("user_id");
		
		map.put("a", "test");
		map.put("a", "test2");
		
		
	}
}
