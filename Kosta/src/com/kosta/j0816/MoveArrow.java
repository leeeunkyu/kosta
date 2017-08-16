package com.kosta.j0816;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveArrow extends JFrame implements ActionListener, Runnable{
    JLabel la;	
    JButton bt_start, bt_pause;
    int x,y;
    boolean flag;
    
	public MoveArrow() {
	   flag=true;
		
	   ImageIcon icon = new ImageIcon("image/right.gif");	
	   la = new JLabel(icon);
	   bt_start = new JButton("시작");
	   bt_pause = new JButton("정지");
	   
	   setTitle("움직이는 화살");
	   setLayout(null);
	   
	   la.setBounds(0, 0, 60, 60);//setLocation()+setSize()
	   bt_start.setBounds(10, 520, 60, 30);
	   bt_pause.setBounds(80, 520, 60, 30);
	   
	   add(la);
	   add(bt_start);
	   add(bt_pause);
	   
	   setBounds(200,100,600,600);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
       bt_start.addActionListener(this);
       bt_pause.addActionListener(this);
	}//생성자
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();//버튼의 경우 라벨 리턴
		if(command.equals("시작")) {
		   flag=true;	
	       new Thread(this).start();
		}else if(command.equals("정지")) {
	   //new Thread(this).stop(); ---> 비권장
	   //new Thread(this).interrupt(); 
			//---> InterruptedException을 발생시켜 run()메소드 탈출
		   flag=false;
		}
	}
	
	@Override
	public void run() {
	   try {
		while(flag) {
			  Thread.sleep(40);			  
			  
			  if(x < 526) {//600-60: 540 -10 
			   x+=4;
			  }else if(y < 500){
				y+=4;  
			  }			  
			  la.setLocation(x,y);
			  
		   }
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }		
	}//run
	
    public static void main(String[] args) {
		new MoveArrow();
	}

}