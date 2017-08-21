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
		System.out.println("### �ʱ�ȭ ������ �߰� ###");
		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ�� ���� �޴�");
		System.out.println("## -----------------");
		System.out.println("1. ��ȭ��ȣ ���");
		System.out.println("2. ��ȭ��ȣ ��ü ��ȸ");
		System.out.println("3. ��ȭ��ȣ �� ��ȸ");
		System.out.println("4. ��ȭ��ȣ ����");
		System.out.println("5. ��ȭ��ȣ ����");
		System.out.println("98. ��ȭ��ȣ ���� �� ����");
		System.out.println("99. ��ȭ��ȣ ����");
		System.out.println("## -----------------");
		System.out.print("[�޴���ȣ �Է�]");
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
			System.out.println("�����մϴ�.");
			System.exit(1);
			break;
		}
	}
	public void saveMenu() {
		// TODO Auto-generated method stub
		mana.save();
		System.out.println("## -----------------");
		System.out.println("[Message]:��������");
		System.out.println("## -----------------");
		System.out.println("[Message]:��ȭ��ȣ�� ���Ͽ� ������ �������Դϴ�.");
		System.out.println("## -----------------");
		System.out.println("[Message]:��ȭ��ȣ�� ���Ͽ� ������ ���� �Ϸ��߽��ϴ�.");
		System.out.println("## -----------------");
		System.out.println("## ���� ������ ���α׷��� �����մϴ�.");
		System.out.println("## -----------------");
		System.exit(1);
	}
	public void deleteMenu() {
		scan = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ ����");
		System.out.println("## -----------------");
		System.out.print("�̸�: ");
		name = scan.nextLine();
		System.out.println("## -----------------");
		mana.delete(name);
		System.out.println("[Message] : ȸ������ �Ϸ�Ǿ����ϴ�.");
	}
	public void changeMenu() {
		scan = new Scanner(System.in);

		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ ����");
		System.out.println("## -----------------");
		System.out.print("�̸�: ");
		name = scan.nextLine();
		info = mana.select(name);
		System.out.print("��ȭ��ȣ["+info[1]+"]:");
		info[1] = scan.nextLine();
		System.out.print("�ּ�["+info[2]+"]:");
		info[2] = scan.nextLine();
		System.out.println("## -----------------");
		System.out.println("[Message] : ȸ�������� �Ϸ�Ǿ����ϴ�.");
		mana.change(info);
	}
	public String[] insertMenu() {
		scan = new Scanner(System.in);

		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ���");
		System.out.println("## -----------------");
		System.out.print("�̸�: ");
		info[0] = scan.nextLine();
		if(mana.select_name(info[0])) {
			System.out.println("�̹� ��ġ�ϴ� �̸��� ��ϵ��ֽ��ϴ�. �ʱ�޴��� �̵��մϴ�.");
			return no;
		}
		System.out.print("��ȭ��ȣ: ");
		info[1] = scan.nextLine();
		System.out.print("�ּ�: ");
		info[2] = scan.nextLine();
		System.out.println("## -----------------");
		System.out.println("[Message] : ȸ����� �Ϸ�Ǿ����ϴ�.");
		return info;
	}
	public void searchMenu() {
		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ ��ü��ȸ");
		System.out.println("## -----------------");
		System.out.println("�̸�    | ��ȭ��ȣ           | �ּ� ");
		System.out.println("--------------------");
		mana.search();
	}
	public String search_detailMenu() {
		scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("## -----------------");
		System.out.println("## ��ȭ��ȣ ����ȸ");
		System.out.println("## -----------------");
		System.out.print("�̸�: ");
		name = scan.nextLine();
		System.out.println("�̸�    | ��ȭ��ȣ           | �ּ� ");
		System.out.println("--------------------");
		return name;
	}
	
}
