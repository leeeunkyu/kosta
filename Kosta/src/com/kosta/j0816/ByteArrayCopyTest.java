package com.kosta.j0816;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayCopyTest {
    public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c.txt");
		FileInputStream fis2 = new FileInputStream("c.txt");
	    //c.txt�� ���� ===> abcd
		
		//fis.read();//97
		
		byte []b = new byte[5];//{0,0,0,0,0}
		int t = fis.read(b); //fis(c.txt)�� �о �����͸� b�迭�� ����!!
        System.out.println("T="+t); //t: ���� ����Ʈ ��
		
		for (int i = 0; i < b.length; i++) {
			System.out.println("b["+i+"]="+ b[i]);
		}
		System.out.println("----------------");
		byte []b2 = new byte[5];//������: ���� ����Ʈ �ִ� ��!!
		//fis.read(byte[]b2 ������ ��ġ, int offset �����ε���, int length �������)
		fis2.read(b2, 2, 3); //b2�迭�� 2�ε��� ���� 3���� ����Ʈ�� ����
		
		for (int i = 0; i < b2.length; i++) {
			System.out.println("b2["+i+"]="+ b2[i]);
		}
    }//main
}



