package com.kosta.j0821;

import java.util.Scanner;

public class Menu {
	Management mana;
	String name;
	String phoneNum;
	String location;
	Scanner scan;
	String info[];
	String temp[];
	String[] no= {"noselect"};
	public Menu() {
		// TODO Auto-generated constructor stub
		mana=new Management();
		info=new String[3];
		temp = new String[3];
		initMenu();
	}
	public void initMenu() {
		int selectNum;
		scan = new Scanner(System.in);
		System.out.println("### 초기화 데이터 추가 ###");
		System.out.println("## -----------------");
		System.out.println("## 전화번호부 메인 메뉴");
		System.out.println("## -----------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 전체 조회");
		System.out.println("3. 전화번호 상세 조회");
		System.out.println("4. 전화번호 변경");
		System.out.println("5. 전화번호 삭제");
		System.out.println("98. 전화번호 저장 후 종료");
		System.out.println("99. 전화번호 종료");
		System.out.println("## -----------------");
		System.out.print("[메뉴번호 입력]");
		selectNum = scan.nextInt();
		choice(selectNum);
	}
	public void choice(int selectNum) {
		// TODO Auto-generated method stub
		switch (selectNum) {
		case 1:
			mana.insert(insertMenu());
			initMenu();
			break;
		case 2:
			searchMenu();
			initMenu();
			break;
		case 3:
			mana.search_detail(search_detailMenu());
			initMenu();
			break;
		case 4:
			changeMenu();
			initMenu();
			break;
		case 5:
			deleteMenu();
			initMenu();
			break;
		case 98:
			saveMenu();
			initMenu();
			break;
		default:
			System.out.println("종료합니다.");
			System.exit(1);
			break;
		}
	}
	public void saveMenu() {
		// TODO Auto-generated method stub
		mana.save();
		System.out.println("## -----------------");
		System.out.println("[Message]:파일저장");
		System.out.println("## -----------------");
		System.out.println("[Message]:전화번호부 파일에 정보를 저장중입니다.");
		System.out.println("## -----------------");
		System.out.println("[Message]:전화번호부 파일에 정보를 저장 완료했습니다.");
		System.out.println("## -----------------");
		System.out.println("## 파일 저장후 프로그램을 종료합니다.");
		System.out.println("## -----------------");
		System.exit(1);
	}
	public void deleteMenu() {
		scan = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## 전화번호 삭제");
		System.out.println("## -----------------");
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.println("## -----------------");
		mana.delete(name);
		System.out.println("[Message] : 회원삭제 완료되었습니다.");
	}
	public void changeMenu() {
		scan = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## 전화번호 변경");
		System.out.println("## -----------------");
		System.out.print("이름: ");
		name = scan.nextLine();
		info = mana.select(name);
		System.out.print("전화번호["+info[1]+"]:");
		info[1] = scan.nextLine();
		System.out.print("주소["+info[2]+"]:");
		info[2] = scan.nextLine();
		System.out.println("## -----------------");
		System.out.println("[Message] : 회원변경이 완료되었습니다.");
		mana.change(info);
	}
	public String[] insertMenu() {
		scan = new Scanner(System.in);

		System.out.println("## -----------------");
		System.out.println("## 전화번호등록");
		System.out.println("## -----------------");
		System.out.print("이름: ");
		info[0] = scan.nextLine();
		if(mana.select_name(info[0])) {
			System.out.println("이미 일치하는 이름이 등록되있습니다. 초기메뉴로 이동합니다.");
			return no;
		}
		System.out.print("전화번호: ");
		info[1] = scan.nextLine();
		System.out.print("주소: ");
		info[2] = scan.nextLine();
		System.out.println("## -----------------");
		System.out.println("[Message] : 회원등록 완료되었습니다.");
		return info;
	}
	public void searchMenu() {
		System.out.println("## -----------------");
		System.out.println("## 전화번호 전체조회");
		System.out.println("## -----------------");
		System.out.println("이름    | 전화전호           | 주소 ");
		System.out.println("--------------------");
		mana.search();
	}
	public String search_detailMenu() {
		scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## 전화번호 상세조회");
		System.out.println("## -----------------");
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.println("이름    | 전화전호           | 주소 ");
		System.out.println("--------------------");
		return name;
	}
	
}
