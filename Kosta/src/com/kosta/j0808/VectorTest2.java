package com.kosta.j0808;

import java.util.Vector;

public class VectorTest2 {
	
  public static void main(String[] args) {
	//Vector클래스에 데이터 추가,삭제,수정,조회★
	  
	  Vector<String> v = new Vector<>();
	  
	  //추가 add, addElement
	     //v.add(13); //에러!! 제네릭명시 때문에 명시한 자료형만 입력 가능!!
	  v.add("홍길동");//index 0
	  v.add("길라임");//1	  
	  v.add("김주원");//2
	  v.add("홍길동");//3
	  
	  System.out.println("벡터의 요소갯수: "+ v.size());
	  //조회,검색  : get(int index) ,elementAt(int index) 
	  for(int i=0; i<v.size(); i++) {//Vector의 인덱스를 표현
		  // 인덱스와 전체사이즈를 구할 수 있다면 for문 적용 가능!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  //수정  : "길라임" ----> "차라임"
	  //set(int index, E element) ,   setElementAt(E obj, int index) 
	  for(int i=0; i<v.size(); i++) {
		  if(v.get(i).equals("길라임")) {
			  v.set(i,"차라임");
		  }
	  }	  
	  
	  System.out.println("--------------------------------");
	  for(int i=0; i<v.size(); i++) {//Vector의 인덱스를 표현
		  // 인덱스와 전체사이즈를 구할 수 있다면 for문 적용 가능!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  //삭제 : "홍길동"
	  //remove(Object o),  removeElement(Object obj) 
	  //remove(int index),  removeElementAt(int index) 
	  //전체 삭제: clear() , removeAllElements() 
	  /*for(int i=0; i<v.size(); i++) {
		  if(v.get(i).equals("홍길동")) {
			  v.remove(i);
		  }
	  }*/
	  v.remove("홍길동");
	  
	  
	  System.out.println("--------------------------------");
	  for(int i=0; i<v.size(); i++) {//Vector의 인덱스를 표현
		  // 인덱스와 전체사이즈를 구할 수 있다면 for문 적용 가능!!
		 String str = v.get(i);
		 System.out.println(i +":"+str);
	  }
	  
	  Vector v2 = new Vector();
	    v2.add(new Person("홍길동",13,"학생"));
	    
	  //문제) v2에 입력된 홍길동의 나이를 출력하시오.
       Object ob =  v2.get(0);
	   //System.out.println("홍길동의 나이: "+ ob.getAge());//에러!!
       System.out.println("홍길동의 나이: "+ ((Person)ob).getAge());
       
      Vector<Person> v3 = new Vector<>(); 
        Person p = new Person("길라임", 15, "학생");
        v3.add(p); 
      
      //문제) v3에 입력된 길라임의 나이를 출력하시오. 
        Person pp = v3.get(0);
       System.out.println("길라임의 나이: "+ v3.get(0).getAge() ); 
        
        
  }//main
}




