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
		setTitle("��ȭ�����׽�Ʈ");
		bt1 = new JButton("�޽���");
		bt2 = new JButton("�Է�");
		bt3 = new JButton("����");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(bt3);
        		
		//�Է´�ȭ����
		//Ȯ�δ�ȭ����
		setBounds(300,200, 300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}//������
	
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯
		Object ob = e.getSource();
        if(ob == bt1) {//�޽�����ư Ŭ��
        	//�޽�����ȭ����
        	//JOptionPane.showMessageDialog(Component parentComponent,Object message);
			//JOptionPane.showMessageDialog(this, "�ȳ�, �ڹ�SWING~!!");
        	JOptionPane.showMessageDialog(bt1, "�ȳ�, �ڹ�SWING~!!");
		}else if(ob == bt2) {//�Է¹�ư Ŭ��
			//�Է´�ȭ����
			//JOptionPane.showInputDialog(Component parentComponent,Object message)
		   String food = JOptionPane.showInputDialog(this,"������ ���ɽĻ��?"); 
		    //Ȯ��(�Է°� �Ǵ� ���ڿ�), ���(null), X��ư(null)
		   System.out.println("food="+ food);
		   
		  if(food != null && food.trim().length() >0) { 
		   JOptionPane.showMessageDialog(this, "["+food+"] �����ϼ���~^^*");
		  }
		}else if(ob == bt3) {//������ư Ŭ��
		    //Ȯ�δ�ȭ����
			//JOptionPane.showConfirmDialog(Component parentComponent,Object message)
		   int t = JOptionPane.showConfirmDialog(this, "���������Ͻðڽ��ϱ�?");
		   System.out.println("T= "+ t);
		   //�� 0,�ƴϿ� 1,��� 2,X��ư -1
		   
		   if(t==0) {
			   //�����۾�
			   JOptionPane.showMessageDialog(this, "����ó���� �� �Ǿ����ϴ�!!");
		   }
		}
	}//actionPerformed
	
	
	public static void main(String[] args) {
		new SwingDialogTest();
	}

}