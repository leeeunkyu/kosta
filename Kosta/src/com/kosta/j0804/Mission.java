package com.kosta.j0804;

import java.util.Scanner;
//null�� �޸𸮰����̱⶧���� Ŭ���� �޸𸮸� �����߳����Ҷ��� ==�� ����Ѵ�.
//null.equals(value) �� ������Ʈ�ͼ��� ���ܸ� �����Ѵ� �ܿ�����!
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
//		System.out.println("������ü����");
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
		System.out.println("�Է����̸�: "+name);
		
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
				System.out.println("�˻����̸�: "+names[i]);
				break;
			}else if(i==index-1) {
				System.out.println("'"+name+"'"+" �� ��ġ�ϴ� �̸��� ����");
				break;
			}
		}
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		System.out.print("������ �̸���  �Է��ϼ���==>");
		name=scan.nextLine();
		System.out.print("������ �̸���  �Է��ϼ���==>");
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
				System.out.println("'"+name+"'"+"�� ��ġ�ϴ� ������� �̸��� �����ϴ�.");
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
			System.out.println("1.�߰� 2.�˻� 3.����  4.���� 5.����");
			System.out.print("��ȣ�� �Է��ϼ���==>");
			select=scan.nextInt();
			switch (select) {
			case 1:
				if(user.index==user.MAX_INDEX) {
					System.out.println("���̻� �߰��Ҽ� �����ϴ�.");
					break;
				}
				System.out.print("�߰��� �̸���  �Է��ϼ���==>");
				user.insertUser();
				break;
				
			case 2:
				System.out.println("�˻��� �̸���  �Է��ϼ���==>");
				user.selectUser();
				break;
				
			case 3:
				user.updateUser();
				break;
				
			case 4:
				System.out.print("������ �̸���  �Է��ϼ���==>");
				user.deleteUser();
				break;
				
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				return;
				
			default:
				break;
			}
		}
	}
}
