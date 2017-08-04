package com.kosta.j0804;

import java.util.Scanner;
//null은 메모리관련이기때문에 클래스 메모리를 차지했나비교할때는 ==을 사용한다.
//null.equals(value) 는 널포인트익셉션 예외를 유발한다 외워두자!
class User{
	final int MAX_INDEX=5;
	int index;
	Scanner scan;
	String[] names;
	String name;
	String modi_name;
	public User() {
		super();
		scan = new Scanner(System.in);
		names = new String[5];
		index = 0;
//		System.out.println("유저객체생성");
	}
	
	public void insertUser() {
		name=scan.nextLine();
		names[index]=name;
		index++;
//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i]);
//		}
//		for (int i = 0; i < names.length; i++) {
//			if(names[i]==null) {
//				names[i]=name;
//				index++;
//				break;
//			}	
//		}
	}
	public void selectUser() {
		// TODO Auto-generated method stub
		
		name=scan.nextLine();
		System.out.println("입력한이름: "+name);
		
//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i]);
//		}
		
		for (int i = 0; i < index; i++) {
			if(names[i].equals(name)) { 
				System.out.println(names[i]);
				break;
			}
		}
		
		for (int i = 0; i < index; i++) {
			if(names[i].equals(name)) {
				System.out.println("검색한이름: "+names[i]);
				break;
			}else if(i==index-1) {
				System.out.println("'"+name+"'"+" 와 일치하는 이름이 없다");
				break;
			}
		}
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		System.out.print("수정할 이름을  입력하세요==>");
		name=scan.nextLine();
		System.out.print("수정될 이름을  입력하세요==>");
		modi_name=scan.nextLine();
		
		for (int i = 0; i < index; i++) {
			if(names[i].equals(name))
				names[i]=modi_name;
		}
	}

	public void deleteUser() {
		// TODO Auto-generated method stub
		name=scan.nextLine();
		for (int i = 0; i < index; i++) {
			if(names[i].equals(name)) {
				if(names[i+1]!=null) {
					names[i]=names[i+1];
					names[i+1]=null;
					index--;
					break;
				}
			}else if(i==index-1) {
				System.out.println("'"+name+"'"+"와 일치하는 삭제대상 이름이 없습니다.");
			}
		}
	}
}
public class Mission {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int select;
		User user=new User();	
		
		while(true) {
			System.out.println("1.추가 2.검색 3.수정  4.삭제 5.종료");
			System.out.print("번호를 입력하세요==>");
			select=scan.nextInt();
			switch (select) {
			case 1:
				if(user.index==user.MAX_INDEX) {
					System.out.println("더이상 추가할수 없습니다.");
					break;
				}
				System.out.print("추가할 이름을  입력하세요==>");
				user.insertUser();
				break;
				
			case 2:
				System.out.println("검색할 이름을  입력하세요==>");
				user.selectUser();
				break;
				
			case 3:
				user.updateUser();
				break;
				
			case 4:
				System.out.print("삭제할 이름을  입력하세요==>");
				user.deleteUser();
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				break;
			}
		}
	}
}
