package com.kosta.j0807;


public class StringConvertTest {
   
	public void convert1() {
		String s1="�츮����";
		String s2="���ѹα�����!!";
		
		s1 = s1+s2;
		System.out.println(s1);
		
		/*
		    StringŬ����: �������� ���ڿ� ǥ��
		    1. StringŬ���� ��ü����
		    2. ���ڿ� ��ȯ�� ���ؼ� �ӽ÷� StringBuffer��ü ����.
		    3. append()�޼ҵ� ȣ��
		    4. StringBuffer��ü�� String��ü�� ��ȯ
		    5. �ӽû����� StringBuffer��ü �Ҹ�.
		    
		    
		    
		    s1 = s1+s2+s3+s4+s5;
		 */
	}//convert1
	
	public void convert2() {
		StringBuffer s1 = new StringBuffer("�츮����");
		s1.append("���ѹα�����!!");	
		System.out.println(s1);
		
		/*
		    s1 = s1.append(s2)
		           .append(s3)
		           .append(s4)
		           .append(s5); 
		  
		 StringBufferŬ����: �������� ���ڿ� ǥ��
		 
		 1.StringBufferŬ���� ��ü����.
		 2.append()�޼ҵ带 �����ؼ� ���ڿ� ����.
		 
		 */
	}//convert2
	
	
	public static void main(String[] args) {
	    StringConvertTest sct = new StringConvertTest();
          sct.convert1();
          sct.convert2();
	}//main
}



