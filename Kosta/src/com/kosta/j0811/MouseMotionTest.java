package com.kosta.j0811;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest  extends JFrame implements MouseMotionListener{
    
	JLabel green,red;
	
	public MouseMotionTest() {
		setTitle("마우스모션");
		
	    green = new JLabel("MOVE");	     
	    red   = new JLabel("DRAG");
	    
	    green.setOpaque(true);//불투명 설정
	    red.setOpaque(true);
	    
	    //바탕색 설정
	    green.setBackground(Color.GREEN);
	    red.setBackground(Color.RED);
	    
	    /*
	    //사이즈 설정
	    //green.setSize(int width,int height);
	    green.setSize(80,80);
        red.setSize(80,80);
        
        //위치 설정
        //green.setLocation(int x, int y);
        green.setLocation(10, 10);
        red.setLocation(10, 100);
        */
	    
	    
        //green.setBounds(int x, int y, int width, int height); location+size
        green.setBounds(10,10,  80,80);
        red.setBounds(10,100,  80,80);
	    
        //컴포넌트에 사이즈와 붙여질위치를 지정하려면 NullLayout이 필요!!
        
        setLayout(null);//NullLayout!! ----> 컴포넌트 (위치,사이즈가 반드시 필요) 
	    add(green);
	    add(red);
	    
	    //setSize(600,600);
	    setBounds(300,100, 600,600);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);	
        
       
        addMouseMotionListener(this);
        
	}//생성자
	
	@Override
	public void mouseDragged(MouseEvent e) {
		 red.setLocation(e.getX()-80, e.getY()-80);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		 int x = e.getX();//현재 마우스의 x좌표 얻어오기
		 int y = e.getY();
		 
		 green.setLocation(x-80,y-80);
	}
    
    public static void main(String[] args) {
		new MouseMotionTest();
	}

}


