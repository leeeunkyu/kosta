package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	
	//���α׷��� �ʿ��� ������Ʈ, �����̳ʿ� ���� ����
	Button bt1,bt2,bt3,bt4,bt5;
	Frame f;
	
	public FlowTest() {
	  //������Ʈ, �����̳ʿ� ���� �ʱ�ȭ
	   bt1 = new Button("1��ư");	   
	   bt2 = new Button("2��ư");	   
	   bt3 = new Button("3��ư");	   
	   bt4 = new Button("4��ư");	   
	   bt5 = new Button("5��ư");
	   
	   f = new Frame("Flow�׽�Ʈ");
	   
	  //�Ӽ�����
	   //FlowLayout fl = new FlowLayout();
	   f.setLayout(new FlowLayout());//(fl);
	   f.add(bt1); //�����̳�.add(������Ʈ);
	   f.add(bt2);
	   f.add(bt3);
	   f.add(bt4);
	   f.add(bt5);
		
	  //������ (�޼ҵ� ȣ�� 2�� - ������ ũ��(����,����), �����Ӻ��̱�)
	   //f.setSize(int width����,int height����);
	   f.setSize(300, 300);
	   f.setVisible(true);
	}//������
	
	
	
	public static void main(String[] args) {
		//FlowTest ft = new FlowTest();
		new FlowTest();
	}//main

}




