package com.kosta.j0810;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloEventTest extends Frame implements ActionListener,ItemListener{
	TextField tf;
	Checkbox cb1,cb2,cb3;
	Button bt_hello,bt_clear,bt_exit;
	Panel pan_t,pan_m,pan_b;
	public HelloEventTest() {
		tf=new TextField(30);
		cb1=new Checkbox("�ڹ� �ʱ�"); 
		cb2=new Checkbox("�ڹ� �߱�"); 
		cb3=new Checkbox("�ڹ� ���");
		bt_hello=new Button("�ȳ�");
		bt_clear=new Button("�����");
		bt_exit=new Button("����");
		
		pan_t=new Panel();
		pan_m=new Panel();
		pan_b=new Panel();
		
		pan_t.add(tf);
		pan_m.add(cb1);
		pan_m.add(cb2);
		pan_m.add(cb3);
		pan_b.add(bt_hello);
		pan_b.add(bt_clear);
		pan_b.add(bt_exit);
		setLayout(new BorderLayout());
		setSize(300, 300);
		add("North", pan_t).setBackground(Color.ORANGE);
		add("Center", pan_m);
		add("South", pan_b).setBackground(Color.PINK);
		
		//cb1.addItemListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		bt_hello.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_exit.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new HelloEventTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==bt_hello) {
			System.out.println("�ȳ�");
			tf.setText("�ȳ�");
		}else if(e.getSource()==bt_clear) {
			System.out.println("�����");
			
			
		}else if(e.getSource()==bt_exit){
			System.out.println("����");
			System.exit(0);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(cb1.getState()) {
			System.out.println("�ڹ��ʱ�");
			tf.setText("�ڹ��ʱ�");
		}else if(cb2.getState()) {
			System.out.println("�ڹ��߱�");
			tf.setText("�ڹ��߱�");
		}else if(cb3.getState()) {
			System.out.println("�ڹٰ��");
			tf.setText("�ڹٰ��");
		}else {
			tf.setText("");
		}
	}

}
