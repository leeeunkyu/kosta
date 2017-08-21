package com.kosta.j0821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileAdder {
	FileInputStream fis;
	FileOutputStream fos;
	FileReader fr;
	String line;
	String newline;
	String space;
	byte b[];
	int real_start;
	int real_end;
	public FileAdder() {
		// TODO Auto-generated constructor stub
		line = System.getProperty("line.separator");
		b= new byte[2048];
		newline="\n";
		space="\t";
	}
	
	public void setting(int start, int end) {
		// TODO Auto-generated method stub
		String str="고객코드|배송차 코드| 고객등급|주유량| 단가|지역코드|휴게소방문횟수|지불코드|거래점수|배송거리\n";
		str = str.replace("\n", line);
		real_start=((start-1)*34);
		real_end=end-1;
		newline = newline.replace("\n", line);
		readfile(str);
	}

	private void readfile(String str) {
		// TODO Auto-generated method stub
		int i; 
		try {
			fis = new FileInputStream("sample_data.txt");
			fos = new FileOutputStream("result_data.txt");		
		    fr = new FileReader("result_data.txt");
			fos.write(str.getBytes());
			while((i=fis.read(b)) != -1) {
				for(int j=0,k=0;(real_start+j)<(real_end)*34;j+=32,k+=2) {//읽은 바이트가 있다면
				  fos.write(b,real_start+0+j+k,8);//b배열을 읽어서 fos2에 출력
				  fos.write(space.getBytes());
				  fos.write(b,real_start+8+j+k,1);
				  fos.write(space.getBytes());
				  fos.write(b,real_start+9+j+k,1);//b배열을 읽어서 fos2에 출력
				  fos.write(space.getBytes());
				  fos.write(b,real_start+10+j+k,3); 
				  fos.write(space.getBytes());
				  fos.write(b,real_start+14+j+k,3);//b배열을 읽어서 fos2에 출력
				  fos.write(space.getBytes());				  
				  fos.write(b,real_start+17+j+k,1);//b배열을 읽어서 fos2에 출력
				  fos.write(space.getBytes());
				  fos.write(b,real_start+18+j+k,3);
				  fos.write(space.getBytes());
				  fos.write(b,real_start+21+j+k,1);//b배열을 읽어서 fos2에 출력
				  fos.write(space.getBytes());
				  fos.write(b,real_start+22+j+k,4);
				  fos.write(space.getBytes());
				  fos.write(b,real_start+26+j+k,6);
				  fos.write(newline.getBytes());				  
			}
		} 
	    while( (i=fr.read()) != -1) {//읽을 문자가 있다면
	    	System.out.print((char)i);
	    }
		System.out.println("복사완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
