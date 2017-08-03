package com.kosta.j0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraySortTest {
   public static void main(String[] args) throws IOException {
	 System.out.println("#정렬하고자 하는 다섯개의 수를 입력하세요!");
	 
	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
	 //5개의 정수를 저장할 변수
	 int su[] = new int[5];//0인덱스~4인덱스
	 
	 /*su[0]= Integer.parseInt(in.readLine());
	 su[1]= Integer.parseInt(in.readLine());
	 su[2]= Integer.parseInt(in.readLine());
	 su[3]= Integer.parseInt(in.readLine());
	 su[4]= Integer.parseInt(in.readLine());*/
	 
	String koStr[]= {"첫","두","세","네","다섯"}; 
	 
	//데이터 입력
	for(int i=0; i<su.length; i++) {//0~4 
	  //System.out.print( (i+1)+"번째수: ");
	  System.out.print( koStr[i]+"번째수: ");
	  su[i]= Integer.parseInt(in.readLine());//입력시점
	}
	
	//내용 출력
	System.out.print("입력된 수: [");
	for(int i=0; i<su.length; i++) {//0~4 
       System.out.print(su[i]);
       if(i<su.length-1)
    	  System.out.print(", ");//i=0,1,2,3
	}
	System.out.print("]");
	
	//오름차순정렬(ascending sort)
	// su[] =  {13, 109, 80,  9, 22}
	//      su [0]  [1]  [2] [3] [4]

	
	int temp;
	
	for(int i=0; i< su.length-1; i++) {//비교 왼쪽데이터 (0~3)
		/*
		     i=0  : j=1,2,3,4
		     i=1  : j=  2,3,4
		     i=2  : j=    3,4
		     i=3  : j=      4
		 */		
		for(int j= i+1 ; j< su.length; j++) {//비교 오른쪽데이터 (1~4)
		   if(su[i] > su[j]) {
			   //왼쪽 데이터(i)가 오른쪽데이터(j) 보다 크다면			     
			  temp  = su[i];
			  su[i] = su[j];
			  su[j] = temp;
		   }
		}//for	
	}//for
	
	//정렬후 내용 출력
	System.out.print("\n정렬된 수: [");
		for(int i=0; i<su.length; i++) {//0~4 
	       System.out.print(su[i]);
	       if(i<su.length-1)
	    	  System.out.print(", ");//i=0,1,2,3
		}
	System.out.print("]");
	
	
	 int su2[]= {22,33,9,56,10};
	 char ch[]= {'j','a','v','b'};
	 
	  //'a' < 'b'  ----> true
	 String str[]= {"홍길동","길라임","주원","김유신"};
	 
	 Arrays.sort(su2);
	 Arrays.sort(ch);
	 Arrays.sort(str);
	 
	 
	 System.out.println("\n----------숫자-----------");
	 for (int i = 0; i < su2.length; i++) {
		 System.out.print(su2[i]+" ");
	 }
	 System.out.println("\n-----------문자----------");
	 for (int i = 0; i < ch.length; i++) {
		 System.out.print(ch[i]+" ");
	 }
	 System.out.println("\n-----------문자열----------");
	 for (int i = 0; i < str.length; i++) {
		 System.out.print(str[i]+" ");
	 }
	 
	
	
   }//main
}


