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
		   System.out.println("�Ű������� ���� �ΰ��� ������");
		      int su1 = Integer.parseInt(args[0]);//NumberFormatException
		      int su2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException
		   System.out.println("su1="+su1+", su2="+su2);	   
		   System.out.println(su1+"�� "+su2+"�� ���� �� = " + (su1/su2));
		                                         //ArithmeticException
		   System.out.println("�������� ��Ȱ�� �����Ͽ����ϴ�!!");
	   
	   }catch(NumberFormatException e) {
		   System.out.println("#���ڸ� �Է�: "+ e.getMessage());
	   }catch(Exception e) {
		   System.out.println("#��� ����ó��: "+ e);
		   return;
	   }finally {
		   //���� ��������°�ü �Ǵ� DB���õ� ��ü�� ���� �ڿ���ȯ : close();
		   System.out.println("### ���ܿ� ������� ������ ����Ǵ� finally��!!");
	   }
	 
	   System.out.println("������ ����~!!");
	 
	 /*catch(ArrayIndexOutOfBoundsException e) {
		   System.out.println("#�ΰ��� ���� �Է�: "+ e);
	   }catch(ArithmeticException e) {
		   System.out.println("#0���� ���� �� �����ϴ�!! : "+ e.toString());
	   }*/
	   
   }//main
}