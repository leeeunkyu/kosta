package com.kosta.j0811;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest  extends JFrame implements MouseMotionListener{
    
	JLabel green,red;
	
	public MouseMotionTest() {
		setTitle("���콺���");
		
	    green = new JLabel("MOVE");	     
	    red   = new JLabel("DRAG");
	    
	    green.setOpaque(true);//������ ����
	    red.setOpaque(true);
	    
	    //������ ����
	    green.setBackground(Color.GREEN);
	    red.setBackground(Color.RED);
	    
	    /*
	    //������ ����
	    //green.setSize(int width,int height);
	    green.setSize(80,80);
        red.setSize(80,80);
        
        //��ġ ����
        //green.setLocation(int x, int y);
        green.setLocation(10, 10);
        red.setLocation(10, 100);
        */
	    
	    
        //green.setBounds(int x, int y, int width, int height); location+size
        green.setBounds(10,10,  80,80);
        red.setBounds(10,100,  80,80);
	    
        //������Ʈ�� ������� �ٿ�����ġ�� �����Ϸ��� NullLayout�� �ʿ�!!
        
        setLayout(null);//NullLayout!! ----> ������Ʈ (��ġ,����� �ݵ�� �ʿ�) 
	    add(green);
	    add(red);
	    
	    //setSize(600,600);
	    setBounds(300,100, 600,600);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);	
        
       
        addMouseMotionListener(this);
        
	}//������
	
	@Override
	public void mouseDragged(MouseEvent e) {
		 red.setLocation(e.getX()-80, e.getY()-80);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		 int x = e.getX();//���� ���콺�� x��ǥ ������
		 int y = e.getY();
		 
		 green.setLocation(x-80,y-80);
	}
    
    public static void main(String[] args) {
		new MouseMotionTest();
	}

}


