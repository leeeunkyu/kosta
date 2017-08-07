package com.kosta.j0807;

public class StringTest {
   public static void main(String[] args) {
	  String s1="java";
	  String s2="JAVA";
	  
	  //���ڿ� �� :  ���ع��ڿ�.equals(�񱳹��ڿ�)  
	  //"java".equals("JAVA")   s1.equals(s2)
	  
	  if(s1.equals(s2)) {
		  System.out.println("���ڿ� ����!!");
	  }else {
		  System.out.println("���ڿ� �ٸ�!!");
	  }
	  System.out.println("===============");
	  
	  if(s1.equalsIgnoreCase(s2)) {//�빮��: upperCase, �ҹ���: lowerCase
		  System.out.println("���ڿ� ����2!!");
	  }else {
		  System.out.println("���ڿ� �ٸ�2!!");
	  }
	  
	  String str = "JavaProgramming";
	  //�ε���           012345678901234        
	  
	  //���ڿ� ����
	  System.out.println("STR���ڿ� ����: "+ str.length());
	  
	  System.out.println("STR �빮�ں�ȯ: "+ str.toUpperCase());
	  System.out.println("STR �ҹ��ں�ȯ: "+ str.toLowerCase());
	 
	  //���ڿ� ��ü(replace)
	  //str.replace(char oldChar, char newChar);
	  //str.replace(CharSequence target, CharSequence replacement)
	  System.out.println("str.replace('a','o') : "+ str.replace('a','o'));
	   //str = str.replace('a','o');
	  System.out.println("STR = "+ str);
	  System.out.println("str.replace(\"Java\",\"�ڹ�\") : "
	                       + str.replace("Java","�ڹ�"));
	  
	  //�ε����� ���εǴ� ���ڸ� ����
	  System.out.println("str.charAt(4) : "+ str.charAt(4));//'P'
	  
	  //���ڿ� ���εǴ� �ε��� ����
	  System.out.println("str.indexOf('P') : "+ str.indexOf('P'));//4

	  //String str = "JavaProgramming";
	  //              012345678901234
	  
	  //����) str���� "Programming" �κй��ڿ��� �����ÿ�.
	  String str2= str.substring(str.indexOf('P'));
	  
	  System.out.println("STR2 : "+ str2);
	  
	  
	  //����) API��������   1.str�� ù��° 'a'�� �ε���  
	  //                 2.str�� �ι�° 'a'�� �ε����� ���Ͻÿ�
	  int idx =str.indexOf('a');
	  System.out.println("str ù��° 'a'�� �ε���: "+ idx);//(97));
	  //str.indexOf(int ch,int fromIndex)
	  int idx2 = str.indexOf('a',idx+1);
	  System.out.println("str �ι�° 'a'�� �ε���: "+ str.indexOf("aP")); //idx2);
	  System.out.println("str ������ 'a'�� �ε���: "+ str.lastIndexOf('a'));
	  
	  //���� ���ڿ� ����
	  System.out.println("STR���ڿ� ����: "+ str.length());
	  str = str+"  ";//���鹮�� 2�� �߰�  : ���� 15 ----> ���� 17 
	  System.out.println("STR���ڿ� ����: "+ str.length());
	  
	  //���ʿ��� �յ��� ������ ���� ----> trim()
	  str = str.trim();
	  System.out.println("���� ���� �� STR���ڿ� ����: "+ str.length());
	  
	  String str3= " ja va "; //--> length() ---> 7
	  System.out.println("STR3���ڿ� ����: "+ str3.length());
	  System.out.println("STR3���ڿ� ���� ������ ����: "+ str3.trim().length());
	  
			  
   }//main
}

