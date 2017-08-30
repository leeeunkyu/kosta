package com.kosta.j0829;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestIterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add(1000);
		list.add("마지막");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		while(list.remove("hello")) {}
		//or 위아래 같은코드
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			if(iter.next().equals("hello")) {
				iter.remove();
			}
		}
		
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		HashSet set = new HashSet();
		//HashMap map = new 
		set.add("test");
		set.add("test2");
		set.add("test3");
		set.add("test4");
		Iterator it =(Iterator) set.iterator();

		while(it.hasNext()) {
			String str=""+it.next();
			System.out.println(str);
		}
//		
//		
		System.out.println();
		HashMap map = new HashMap();
		Member m1 = new Member("user_id", "user_pwd", "user_name", "gender", "usersignup");
		Member m2 = new Member("user_id2", "user_pwd", "user_name"," gender", "user_signup");
		Member m3 = new Member("user_id3", "user_pwd", "user_name"," gender", "user_signup");
		map.put("user_id", m1.toString());
		map.put("user_id2", m2.toString());
		map.put("user_id3", m3.toString());
		Iterator it2 = (Iterator)map.keySet().iterator();
		
		while(it2.hasNext()) {
			String key=""+it2.next();
			System.out.println(key+"   "+map.get(key));
		}
		
	}
}	
