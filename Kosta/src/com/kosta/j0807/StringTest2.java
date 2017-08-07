package com.kosta.j0807;

public class StringTest2 {
   public static void main(String[] args) {
	   
	  /*
	               str.getBytes()              str.toCharArray()                   
	             <-------------                ------------>
	     byte b[]              String str="abc";              char ch[]
	    ={97,98,99}                                         ={'a','b','c'}
	             -------------->              <-------------
	               new String(b);                new String(ch);
	   */
	   
	 String str="Java3Pro4gra0mm5ing";  
	 char ch[];
	 int count=0;
	 ch=str.toCharArray();
	 for (int i = 0; i < ch.length; i++) {
		//System.out.println(ch[i]);
		if(((int)ch[i])>=48 && ((int)ch[i])<=57) {
			count++;
		}
	}
	 System.out.println(count);
	 
	 //����) str������ ������ ������ ����Ͻÿ�!! ----> 4��
	 System.out.println("==================================");
	 /*
	     ����) String tel="010-123-4567"
	      ---> '-'�� ���еǴ� ������ ��ȣ�� ���δٸ� ������ �����Ͻÿ�.
	                                                            ���� ����Ͻÿ�.
	  */
	 String tel="010-123-4567";
	 String tel1=tel.substring(0, tel.indexOf('-'));
	 String tel2=tel.substring(tel.indexOf('-')+1, tel.lastIndexOf('-'));
	 String tel3=tel.substring(tel.lastIndexOf('-')+1, tel.length());
	 System.out.println("tel1:  "+tel1+"  tel2:  "+tel2+"  tel3:  "+tel3);
   }//main
}





