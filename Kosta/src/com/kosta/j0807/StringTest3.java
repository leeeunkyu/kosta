package com.kosta.j0807;

public class StringTest3 {
  
	public static void main(String[] args) {
		
		//�ܺο��� �޴� �����Ϳ� ���� ��ȿ�� �˻�!!(���� �������� �ƴ���)
		String str = args[0];
		
		//str.matches(String regex); regex:������ ����
		
		
		/*
		    <�߻�Ƚ�� ���õ� ����>
		    ���� :  1��
		   ?   : 0,1��
		   *   : 0~���Ѵ�
		   +   : 1~���Ѵ�
		    
		 */
		str="100";
		String suPattern="[\\d]+";//"[0-9]+";
		System.out.println("matches: "+str.matches(suPattern));
		
		if(str.matches(suPattern)) {
		   int su1=   Integer.parseInt(str);  //"100"
		
		   int su2=100;
		
		   System.out.println("su1+su2 = "+ (su1+su2));
		}else {
		   System.out.println("#�߸��� �� �Է��Դϴ�!!");
		}
		
		String enName="abCD";//�����˻� (���� �빮��,�ҹ���)
		String id="gildong7";//���̵�˻�  (����+���� ���� )
		String name="ȫ�浿";//�ѱ۰˻�  (�ѱ�)
		
		System.out.println("enName�˻�: "+ enName.matches("[a-zA-Z]{1,5}"));
		System.out.println("id�˻�: "+ id.matches("[a-zA-Z0-9]{3,8}"));
		System.out.println("name�˻�: "+ name.matches("[��-�R]{1,5}"));
		
		String juminBunho = "900205-2012345";
		String juminPattern ="[\\d]{6}-[\\d]{7}";
		
		System.out.println("�ֹι�ȣ�˻�: "+ juminBunho.matches(juminPattern));
		
	}//main
	
	
}