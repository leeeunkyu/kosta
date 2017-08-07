package com.kosta.j0807;

public class StringTest3 {
  
	public static void main(String[] args) {
		
		//외부에서 받는 데이터에 대한 유효성 검사!!(숫자 조합인지 아닌지)
		String str = args[0];
		
		//str.matches(String regex); regex:패턴을 정의
		
		
		/*
		    <발생횟수 관련된 문자>
		    없음 :  1번
		   ?   : 0,1번
		   *   : 0~무한대
		   +   : 1~무한대
		    
		 */
		str="100";
		String suPattern="[\\d]+";//"[0-9]+";
		System.out.println("matches: "+str.matches(suPattern));
		
		if(str.matches(suPattern)) {
		   int su1=   Integer.parseInt(str);  //"100"
		
		   int su2=100;
		
		   System.out.println("su1+su2 = "+ (su1+su2));
		}else {
		   System.out.println("#잘못된 수 입력입니다!!");
		}
		
		String enName="abCD";//영문검사 (영문 대문자,소문자)
		String id="gildong7";//아이디검사  (영문+숫자 조합 )
		String name="홍길동";//한글검사  (한글)
		
		System.out.println("enName검사: "+ enName.matches("[a-zA-Z]{1,5}"));
		System.out.println("id검사: "+ id.matches("[a-zA-Z0-9]{3,8}"));
		System.out.println("name검사: "+ name.matches("[ㄱ-힣]{1,5}"));
		
		String juminBunho = "900205-2012345";
		String juminPattern ="[\\d]{6}-[\\d]{7}";
		
		System.out.println("주민번호검사: "+ juminBunho.matches(juminPattern));
		
	}//main
	
	
}