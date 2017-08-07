package com.kosta.j0807;

public class StringTest3 {
  
	public static void main(String[] args) {
		
		//¿ÜºÎ¿¡¼­ ¹Ş´Â µ¥ÀÌÅÍ¿¡ ´ëÇÑ À¯È¿¼º °Ë»ç!!(¼ıÀÚ Á¶ÇÕÀÎÁö ¾Æ´ÑÁö)
		String str = args[0];
		
		//str.matches(String regex); regex:ÆĞÅÏÀ» Á¤ÀÇ
		
		
		/*
		    <¹ß»ıÈ½¼ö °ü·ÃµÈ ¹®ÀÚ>
		    ¾øÀ½ :  1¹ø
		   ?   : 0,1¹ø
		   *   : 0~¹«ÇÑ´ë
		   +   : 1~¹«ÇÑ´ë
		    
		 */
		str="100";
		String suPattern="[\\d]+";//"[0-9]+";
		System.out.println("matches: "+str.matches(suPattern));
		
		if(str.matches(suPattern)) {
		   int su1=   Integer.parseInt(str);  //"100"
		
		   int su2=100;
		
		   System.out.println("su1+su2 = "+ (su1+su2));
		}else {
		   System.out.println("#Àß¸øµÈ ¼ö ÀÔ·ÂÀÔ´Ï´Ù!!");
		}
		
		String enName="abCD";//¿µ¹®°Ë»ç (¿µ¹® ´ë¹®ÀÚ,¼Ò¹®ÀÚ)
		String id="gildong7";//¾ÆÀÌµğ°Ë»ç  (¿µ¹®+¼ıÀÚ Á¶ÇÕ )
		String name="È«±æµ¿";//ÇÑ±Û°Ë»ç  (ÇÑ±Û)
		
		System.out.println("enName°Ë»ç: "+ enName.matches("[a-zA-Z]{1,5}"));
		System.out.println("id°Ë»ç: "+ id.matches("[a-zA-Z0-9]{3,8}"));
		System.out.println("name°Ë»ç: "+ name.matches("[¤¡-ÆR]{1,5}"));
		
		String juminBunho = "900205-2012345";
		String juminPattern ="[\\d]{6}-[\\d]{7}";
		
		System.out.println("ÁÖ¹Î¹øÈ£°Ë»ç: "+ juminBunho.matches(juminPattern));
		
	}//main
	
	
}