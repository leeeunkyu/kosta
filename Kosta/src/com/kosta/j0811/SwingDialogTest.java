package com.kosta.j0811;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingDialogTest extends JFrame implements ActionListener{

	JButton bt1,bt2,bt3;
	
	public SwingDialogTest() {
		setTitle("대화상자테스트");
		bt1 = new JButton("메시지");
		bt2 = new JButton("입력");
		bt3 = new JButton("삭제");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(bt3);
        		
		//입력대화상자
		//확인대화상자
		setBounds(300,200, 300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 핸들러
		Object ob = e.getSource();
        if(ob == bt1) {//메시지버튼 클릭
        	//메시지대화상자
        	//JOptionPane.showMessageDialog(Component parentComponent,Object message);
			//JOptionPane.showMessageDialog(this, "안녕, 자바SWING~!!");
        	JOptionPane.showMessageDialog(bt1, "안녕, 자바SWING~!!");
		}else if(ob == bt2) {//입력버튼 클릭
			//입력대화상자
			//JOptionPane.showInputDialog(Component parentComponent,Object message)
		   String food = JOptionPane.showInputDialog(this,"오늘의 점심식사는?"); 
		    //확인(입력값 또는 빈문자열), 취소(null), X버튼(null)
		   System.out.println("food="+ food);
		   
		  if(food != null && food.trim().length() >0) { 
		   JOptionPane.showMessageDialog(this, "["+food+"] 맛점하세요~^^*");
		  }
		}else if(ob == bt3) {//삭제버튼 클릭
		    //확인대화상자
			//JOptionPane.showConfirmDialog(Component parentComponent,Object message)
		   int t = JOptionPane.showConfirmDialog(this, "정말삭제하시겠습니까?");
		   System.out.println("T= "+ t);
		   //예 0,아니오 1,취소 2,X버튼 -1
		   
		   if(t==0) {
			   //삭제작업
			   JOptionPane.showMessageDialog(this, "삭제처리가 잘 되었습니다!!");
		   }
		}
	}//actionPerformed
	
	
	public static void main(String[] args) {
		new SwingDialogTest();
	}

}