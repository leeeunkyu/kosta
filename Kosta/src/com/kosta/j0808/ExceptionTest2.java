package com.kosta.j0808;




public class ExceptionTest2 {
   public static void main(String[] args) {
	   /*
	       args[0]   args[1]
	         su1      su2
	        ----------------
	         "10"     "5"
	          
	      1.  10       5       -----> String args[]={"10","5"} 
	      2.  10               -----> String args[]={"10"}
	      3.  ab      cd       -----> String args[]={"ab","cd"}
	      4.  10       0       -----> String args[]={"10","0"}
	    */
	   
	 try{ 
		   System.out.println("매개변수로 받은 두개의 정수값");
		      int su1 = Integer.parseInt(args[0]);//NumberFormatException
		      int su2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException
		   System.out.println("su1="+su1+", su2="+su2);	   
		   System.out.println(su1+"을 "+su2+"로 나눈 몫 = " + (su1/su2));
		                                         //ArithmeticException
		   System.out.println("나눗셈을 원활히 수행하였습니다!!");
	   
	   }catch(NumberFormatException e) {
		   System.out.println("#숫자만 입력: "+ e.getMessage());
	   }catch(Exception e) {
		   System.out.println("#모든 예외처리: "+ e);
		   return;
	   }finally {
		   //보통 파일입출력객체 또는 DB관련된 객체에 대한 자원반환 : close();
		   System.out.println("### 예외와 상관없이 무조건 실행되는 finally블럭!!");
	   }
	 
	   System.out.println("마지막 문장~!!");
	 
	 /*catch(ArrayIndexOutOfBoundsException e) {
		   System.out.println("#두개의 수를 입력: "+ e);
	   }catch(ArithmeticException e) {
		   System.out.println("#0으로 나눌 수 없습니다!! : "+ e.toString());
	   }*/
	   
   }//main
}