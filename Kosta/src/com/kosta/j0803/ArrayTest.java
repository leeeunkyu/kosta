package com.kosta.j0803;

public class ArrayTest {
	int x; //�⺻�� ����
	int arr[]=new int[5]; //�� ������ �ڷ����� �´� �⺻�� ����
	
   public static void main(String[] args) {
	   int y; //�⺻�� ����
	   int arr2[]=new int[5];  //�� ������ �ڷ����� �´� �⺻�� ����
	   
	   
	   int su[]= {1,    2,     3, 4};
	        //  su[0]  su[1]  su[2]  : 0~2���� bound����!!
	   
	   System.out.println("su[0]����="+ su[0]);
	   System.out.println("su[1]����="+ su[1]);
	   System.out.println("su[2]����="+ su[2]);
	   //System.out.println("su[3]����="+ su[3]); //�ε����� ��� �����߻�!!
	   
	   System.out.println("========================");
	   System.out.println("�迭�� ũ��(��Ұ���): "+ su.length);
	   System.out.println("========================");
	   for(int i=0; i< su.length; i++) {//0,1,2
		   System.out.println("su["+i+"]����="+ su[i]);
	   }

	   //2���� �迭�� ����� �ʱ�ȭ
	   //                0��         1��          2��      : �� 3�� <----- su2.length
	   int su2[][] = {{11,22}, {33,44}, {55,66}};
	   //             0�� 1��     0�� 1��     0�� 1��   : ���� 2�� <--su2[���ε���].length
	   
	   //----> ������ �׼���: �迭��[���ε���][���ε���]
	   //          su2 1�� 0�� :   su2[1][0] -----> 33
	   System.out.println("========================");
       for(int i=0; i<su2.length; i++) {//���ε��� ǥ�� : ��? ���� �����̱� ����	 0~2  
    	  for(int j=0; j<2; j++) {//���ε��� ǥ��         0~1
    		  System.out.println("su2["+i+"]["+j+"]="+su2[i][j]);
    	  }    	   
       }	   
	   
       int su3[][] = {{1}, {2,3}, {4,5,6}};
       System.out.println("========================");
       for(int i=0; i<su3.length; i++) {//���ε��� ǥ�� : ��? ���� �����̱� ����	 0~2  
    	  for(int j=0; j<su3[i].length; j++) {//���ε��� ǥ��        
    		  System.out.println("su3["+i+"]["+j+"]="+su3[i][j]);
    	  }    	   
       }
	   
       System.out.println("========================");
       //int arr2[]=new int[5]; 
       arr2[3]=99;
	   for(int i=0; i<arr2.length; i++) {
		   System.out.println("arr2["+i+"]����="+ arr2[i]);
	   }
	   
	   int su4[][] = new int[3][2];//��,���� ũ�� ����(O)
	   int su5[][] = new int[3][];//������ ����(O)
	   //int su6[][] = new int[][];//������ ����(X)
	       
	       //�������� ���� ���� ����� ���� ����
	        su5[0]= new int[2];
	        su5[1]= new int[3];
	        su5[2]= new int[1];
	        
	     su5[1][2] = 123;
	   System.out.println("============================");  
	   for(int i=0; i<su5.length; i++) {//���ε��� ǥ��
		   for(int j=0; j<su5[i].length; j++) {//���ε��� ǥ��
			   System.out.println("su5["+i+"]["+j+"]="+ su5[i][j]);
		   }
	   }  
       
	   
	   
	   
	   
   }//main
}





