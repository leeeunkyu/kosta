package com.kosta.j0808;


class D{
   int i=11;
}
class E extends D{
	int j=22;
}
class F extends E{
	int k=33;
}

public class InstanceofTest {
   public static void main(String[] args) {
       //참조변수 instanceof Type	  ---> boolean
        D d = new D();
        E e = new E();
        F f = new F();
        
        if(d instanceof D) {
          System.out.println("d는 클래스D의 객체");  	
        }
        
        if(d instanceof F) {
        	System.out.println("d는 클래스F의 객체");  	
        }
        if(f instanceof D) {
        	System.out.println("f는 클래스D의 객체");  	
        }
        
        int su=1;//4;//주민번호 뒷자리 첫번째 숫자(1~8)
        
        //성별구하기
        /*if(su%2==0) {"여성"}
        else {"남성"}*/
        //삼항연산자 ----> 조건식 ? A데이터 : B데이터;
        String gender = (su%2==0) ? "여성" : "남성";
        System.out.println("성별 = "+ gender);
        
   }//main
}


