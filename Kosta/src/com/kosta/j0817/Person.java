package com.kosta.j0817;

import java.io.Serializable;

public class Person implements Serializable{
	        //�� Ŭ������ ��ü����ȭ ������ Ŭ������ �����ϰ���!!
   String name="���浿";
   transient int age=13;//��ü����ȭ�� ������ ������ ���� �ʰڴ�.
   String job="�л�";
}