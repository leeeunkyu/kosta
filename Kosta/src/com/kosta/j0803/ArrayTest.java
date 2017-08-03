package com.kosta.j0803;

public class ArrayTest {
	int x; //기본값 있음
	int arr[]=new int[5]; //각 번지에 자료형에 맞는 기본값 있음
	
   public static void main(String[] args) {
	   int y; //기본값 없음
	   int arr2[]=new int[5];  //각 번지에 자료형에 맞는 기본값 있음
	   
	   
	   int su[]= {1,    2,     3, 4};
	        //  su[0]  su[1]  su[2]  : 0~2까지 bound생김!!
	   
	   System.out.println("su[0]번지="+ su[0]);
	   System.out.println("su[1]번지="+ su[1]);
	   System.out.println("su[2]번지="+ su[2]);
	   //System.out.println("su[3]번지="+ su[3]); //인덱스를 벗어난 에러발생!!
	   
	   System.out.println("========================");
	   System.out.println("배열의 크기(요소갯수): "+ su.length);
	   System.out.println("========================");
	   for(int i=0; i< su.length; i++) {//0,1,2
		   System.out.println("su["+i+"]번지="+ su[i]);
	   }

	   //2차원 배열의 선언과 초기화
	   //                0행         1행          2행      : 총 3행 <----- su2.length
	   int su2[][] = {{11,22}, {33,44}, {55,66}};
	   //             0열 1열     0열 1열     0열 1열   : 각각 2열 <--su2[행인덱스].length
	   
	   //----> 데이터 액세스: 배열명[행인덱스][열인덱스]
	   //          su2 1행 0열 :   su2[1][0] -----> 33
	   System.out.println("========================");
       for(int i=0; i<su2.length; i++) {//행인덱스 표현 : 왜? 행이 기준이기 때문	 0~2  
    	  for(int j=0; j<2; j++) {//열인덱스 표현         0~1
    		  System.out.println("su2["+i+"]["+j+"]="+su2[i][j]);
    	  }    	   
       }	   
	   
       int su3[][] = {{1}, {2,3}, {4,5,6}};
       System.out.println("========================");
       for(int i=0; i<su3.length; i++) {//행인덱스 표현 : 왜? 행이 기준이기 때문	 0~2  
    	  for(int j=0; j<su3[i].length; j++) {//열인덱스 표현        
    		  System.out.println("su3["+i+"]["+j+"]="+su3[i][j]);
    	  }    	   
       }
	   
       System.out.println("========================");
       //int arr2[]=new int[5]; 
       arr2[3]=99;
	   for(int i=0; i<arr2.length; i++) {
		   System.out.println("arr2["+i+"]번지="+ arr2[i]);
	   }
	   
	   int su4[][] = new int[3][2];//행,열의 크기 설정(O)
	   int su5[][] = new int[3][];//행사이즈만 설정(O)
	   //int su6[][] = new int[][];//사이즈 비설정(X)
	       
	       //가변길이 열에 대한 사이즈를 각각 설정
	        su5[0]= new int[2];
	        su5[1]= new int[3];
	        su5[2]= new int[1];
	        
	     su5[1][2] = 123;
	   System.out.println("============================");  
	   for(int i=0; i<su5.length; i++) {//행인덱스 표현
		   for(int j=0; j<su5[i].length; j++) {//열인덱스 표현
			   System.out.println("su5["+i+"]["+j+"]="+ su5[i][j]);
		   }
	   }  
       
	   
	   
	   
	   
   }//main
}





