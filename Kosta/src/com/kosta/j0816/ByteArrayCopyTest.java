package com.kosta.j0816;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayCopyTest {
    public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c.txt");
		FileInputStream fis2 = new FileInputStream("c.txt");
	    //c.txt의 내용 ===> abcd
		
		//fis.read();//97
		
		byte []b = new byte[5];//{0,0,0,0,0}
		int t = fis.read(b); //fis(c.txt)를 읽어서 데이터를 b배열에 복사!!
        System.out.println("T="+t); //t: 읽은 바이트 수
		
		for (int i = 0; i < b.length; i++) {
			System.out.println("b["+i+"]="+ b[i]);
		}
		System.out.println("----------------");
		byte []b2 = new byte[5];//사이즈: 읽은 바이트 최대 수!!
		//fis.read(byte[]b2 복사할 위치, int offset 시작인덱스, int length 복사길이)
		fis2.read(b2, 2, 3); //b2배열의 2인덱스 부터 3개의 바이트를 복사
		
		for (int i = 0; i < b2.length; i++) {
			System.out.println("b2["+i+"]="+ b2[i]);
		}
    }//main
}



