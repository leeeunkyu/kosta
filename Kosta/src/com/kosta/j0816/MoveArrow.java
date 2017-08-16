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
	   bt_start = new JButton("����");
	   bt_pause = new JButton("����");
	   
	   setTitle("�����̴� ȭ��");
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
	}//������
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();//��ư�� ��� �� ����
		if(command.equals("����")) {
		   flag=true;	
	       new Thread(this).start();
		}else if(command.equals("����")) {
	   //new Thread(this).stop(); ---> �����
	   //new Thread(this).interrupt(); 
			//---> InterruptedException�� �߻����� run()�޼ҵ� Ż��
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