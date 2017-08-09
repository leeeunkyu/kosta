package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{//컨테이너 동서남북,중앙에 컴포넌트 배치
   //컴포넌트, 컨테이너 선언
   Button bt1,bt2,bt3,bt4,bt5;	
   //Frame f;  
   
   public BorderTest(String title) {
	 super(title);//상위클래스 생성자를 명시적으로 호출 ---> 타이틀 설정  
	 setTitle("방위정렬테스트");  
   
	 //필드 초기화
	 bt1 = new Button("1");
	 bt2 = new Button("2");
	 bt3 = new Button("3");
	 bt4 = new Button("4");
	 bt5 = new Button("5");
	 
	 //컨테이너.add(컴포넌트);
	 //컨테이너.add("붙일위치",컴포넌트);
	  // ------------>붙일 위치: "North","South","West","East","Center"
	 
	 //속성지정
	 //setLayout(new BorderLayout());
	 //setLayout(new BorderLayout(int hgap,int vgap));
	 setLayout(new BorderLayout(20,0));//수평 나열된 컴포넌트 간의 간격
	 
	 this.add("North",bt1);
	 add("East",bt2);
	 add("South",bt3);
	 add("West",bt4);
	 add("Center",bt5);	   
	 
	 //마무리(프레임사이즈,보이기 설정)
     setSize(300, 300);
     setVisible(true);
   }//생성자	
   	
	
   public static void main(String[] args) {//main()포함 클래스 --> Java Application
	  new BorderTest("Border테스트"); // == new Frame()의 역할
   }
}



