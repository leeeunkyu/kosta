package com.kosta.j0821;

public class Management {
	String info[];
	PhoneBook phonebook;
	public Management() {
		// TODO Auto-generated constructor stub
		phonebook = new PhoneBook();
	}
	public void save() {
		phonebook.saveInfo();
	}
	public void delete(String name) {
		// TODO Auto-generated method stub
		phonebook.deleteInfo(name);
	}
	public void change(String[] info) {
		// TODO Auto-generated method stub
		phonebook.changeInfo(info);
	}
	public void search_detail(String detail) {
		// TODO Auto-generated method stub
		phonebook.detailInfo(detail);
	}
	public void search() {
		// TODO Auto-generated method stub
		phonebook.searchInfo();
	}
	public void insert(String[] info) {
		// TODO Auto-generated method stub
		if("noselect".equals(info[0])) {
			return;
		}
		phonebook.insertInfo(info);
	}

	public String[] select(String name) {
		// TODO Auto-generated method stub
		return phonebook.selectInfo(name);
	}
	public boolean select_name(String string) {
		// TODO Auto-generated method stub
		//이미 있으면 true
		return phonebook.select_nameInfo(string);
	}
}
