package com.kosta.j0818;



import java.util.Vector;

public class Room {//��ȭ���� ����ǥ�� ��ü
    String title;//������
    int count;//�� �ο���
    String boss;//����(�� ������)
    Vector<Service> userV;//userV: ���� �濡 ������ Client���� ����
   
	public Room(String title, int count, String boss) {
		this.title = title;
		this.count = count;
		this.boss = boss;
		
		userV = new Vector<>();
	}
    
    
    
    
    
    
}