package com.kosta.j0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraySortTest {
   public static void main(String[] args) throws IOException {
	 System.out.println("#�����ϰ��� �ϴ� �ټ����� ���� �Է��ϼ���!");
	 
	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
	 //5���� ������ ������ ����
	 int su[] = new int[5];//0�ε���~4�ε���
	 
	 /*su[0]= Integer.parseInt(in.readLine());
	 su[1]= Integer.parseInt(in.readLine());
	 su[2]= Integer.parseInt(in.readLine());
	 su[3]= Integer.parseInt(in.readLine());
	 su[4]= Integer.parseInt(in.readLine());*/
	 
	String koStr[]= {"ù","��","��","��","�ټ�"}; 
	 
	//������ �Է�
	for(int i=0; i<su.length; i++) {//0~4 
	  //System.out.print( (i+1)+"��°��: ");
	  System.out.print( koStr[i]+"��°��: ");
	  su[i]= Integer.parseInt(in.readLine());//�Է½���
	}
	
	//���� ���
	System.out.print("�Էµ� ��: [");
	for(int i=0; i<su.length; i++) {//0~4 
       System.out.print(su[i]);
       if(i<su.length-1)
    	  System.out.print(", ");//i=0,1,2,3
	}
	System.out.print("]");
	
	//������������(ascending sort)
	// su[] =  {13, 109, 80,  9, 22}
	//      su [0]  [1]  [2] [3] [4]

	
	int temp;
	
	for(int i=0; i< su.length-1; i++) {//�� ���ʵ����� (0~3)
		/*
		     i=0  : j=1,2,3,4
		     i=1  : j=  2,3,4
		     i=2  : j=    3,4
		     i=3  : j=      4
		 */		
		for(int j= i+1 ; j< su.length; j++) {//�� �����ʵ����� (1~4)
		   if(su[i] > su[j]) {
			   //���� ������(i)�� �����ʵ�����(j) ���� ũ�ٸ�			     
			  temp  = su[i];
			  su[i] = su[j];
			  su[j] = temp;
		   }
		}//for	
	}//for
	
	//������ ���� ���
	System.out.print("\n���ĵ� ��: [");
		for(int i=0; i<su.length; i++) {//0~4 
	       System.out.print(su[i]);
	       if(i<su.length-1)
	    	  System.out.print(", ");//i=0,1,2,3
		}
	System.out.print("]");
	
	
	 int su2[]= {22,33,9,56,10};
	 char ch[]= {'j','a','v','b'};
	 
	  //'a' < 'b'  ----> true
	 String str[]= {"ȫ�浿","�����","�ֿ�","������"};
	 
	 Arrays.sort(su2);
	 Arrays.sort(ch);
	 Arrays.sort(str);
	 
	 
	 System.out.println("\n----------����-----------");
	 for (int i = 0; i < su2.length; i++) {
		 System.out.print(su2[i]+" ");
	 }
	 System.out.println("\n-----------����----------");
	 for (int i = 0; i < ch.length; i++) {
		 System.out.print(ch[i]+" ");
	 }
	 System.out.println("\n-----------���ڿ�----------");
	 for (int i = 0; i < str.length; i++) {
		 System.out.print(str[i]+" ");
	 }
	 
	
	
   }//main
}


