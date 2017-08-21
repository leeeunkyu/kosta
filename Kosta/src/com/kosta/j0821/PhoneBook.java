package com.kosta.j0821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class PhoneBook {
	HashMap<String, String> map;
	int count=0;
	FileWriter fw;
	String line;
	String[] ch;
	String[] no= {"noselect"};
	String space;

	public PhoneBook() {
		// TODO Auto-generated constructor stub
		map = new HashMap<String,String>();
		ch = new String[3];
		line = System.getProperty("line.separator");
		space="\n";

	}
	public void insertInfo(String[] info) {
		map.put(count+"name", info[0]);
		map.put(count+"phone", info[1]);
		map.put(count+"location", info[2]);
		this.count++;
	}
	public void searchInfo() {
		for (int i = 0; i < count; i++) {
			map.get(i+"name");
			map.get(i+"phone");
			map.get(i+"loaction");
			System.out.println(map.get(i+"name") + "  |  "+map.get(i+"phone")+"  |  "+map.get(i+"location"));
		}
	}
	public void detailInfo(String searchinfo) {
		for (int i = 0; i < count; i++) {
			if(searchinfo.equals(map.get(i+"name"))) {
				System.out.println(map.get(i+"name") + "  |  "+map.get(i+"phone")+"  |  "+map.get(i+"location"));
			}else if(map.size()-1==i){
				System.out.println("일치하는 결과가 없습니다.");
			}
		}	
	}
	public void changeInfo(String[] changeinfo) {
		for (int i = 0; i < count; i++) {
			if(changeinfo[0].equals(map.get(i+"name"))) {
				map.replace(i+"name", changeinfo[0]);
				map.replace(i+"phone", changeinfo[1]);
				map.replace(i+"location", changeinfo[2]);
			}else if(map.size()-1==i){
				System.out.println("일치하는 결과가 없습니다.");
			}
		}	
	}
	public void deleteInfo(String name) {
		for (int i = 0; i < count; i++) {
			if(name.equals(map.get(i+"name"))) {
				System.out.println(map.get(i+"name")+"가 삭제됨");
				for (int j = 0; j < map.size()/3; j++) {
					map.replace(i+j+"name", map.get(i+1+j+"name"));
					map.replace(i+j+"phone", map.get(i+1+j+"phone"));
					map.replace(i+j+"location", map.get(i+j+1+"location"));
				}				
				count--;
			}else if(map.size()-1==i){
				System.out.println("일치하는 결과가 없습니다.");
			}
		}
		map.remove(count+"name");
		map.remove(count+"phone");
		map.remove(count+"location");
	}
	public String[] selectInfo(String name) {
		for (int i = 0; i < map.size()/3; i++) {
			if(name.equals(map.get(i+"name"))) {
				ch[0]=map.get(i+"name");
				ch[1]=map.get(i+"phone");
				ch[2]=map.get(i+"location");
			}else if(map.size()-1==i){
				System.out.println("일치하는 결과가 없습니다.");
				return no;
			}
		}
		return ch;
	}
	public void saveInfo () {
		//  byte b[] = new byte[1024];
//		  fis2 = new FileInputStream(new Inputstr);
		  try {
			  space=space.replace("\n",line);
			  fw = new FileWriter("phonebook.txt");
			  //git 디렉토리에 프로젝트소스가있어서 파일경로를 다르게 설정했습니다.
			  for (int i = 0; i < map.size()/3; i++) {
				fw.write(map.get(i+"name"));
				fw.write("\t|");

				fw.write(map.get(i+"phone"));
				fw.write("\t|");

				fw.write(map.get(i+"location"));
				fw.write(space);
			  }
			  fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean select_nameInfo(String n) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= count; i++) {
			if(n.equals(map.get(i+"name"))) {
				return true;
			}
		}
		return false;
	}
}
