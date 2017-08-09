package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame  implements ActionListener{
   Button bt;//이벤트 소스!!(사건 발생시키는 컴포넌트)
	
   //bt ----> ActionEvent적용  -----> Action+Listener
   //ActionListener   -----> 선언된 메소드 : actionPerformed();
   
   public EventTest() {
	   bt = new Button("눌러봐~!!");
	   
	   setTitle("이벤트 테스트");
	   setLayout(new FlowLayout());
	   add(bt);
	   
	   setSize(300,300);
	   setVisible(true);
	   
	   //연결자(소스-핸들러)메소드 등록(호출)
	   //이벤트소스.add인터페이스명(핸들러위치);
	   
	   //bt.addActionListener(this);
	   
	   A a = new A();
	   bt.addActionListener(a);
   }//생성자
   
   @Override
   public void actionPerformed(ActionEvent arg0) {//이벤트 처리부(Event Handler)
	   //사건(이벤트) 발생시 처리할 내용 코드.
	   //기능 정의!!
	   System.out.println("너 눌렀니??");
	   
   }//actionPerformed
   
   
   public static void main(String[] args) {
	  new EventTest();
   }

}