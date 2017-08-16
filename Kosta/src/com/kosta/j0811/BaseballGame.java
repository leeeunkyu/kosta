package com.kosta.j0811;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class BaseballGame extends JFrame implements ActionListener{
	JButton bt_new,bt_clear,bt_answer,bt_exit;
	JTextArea ta;
	JTextField tf;
	JLabel jl;
	JPanel c_pa,b_pa,w_pa;
	Random rd;
	JScrollPane scroll;
	int randomnumber;
	int strikescore;
	int ballscore;
	String pattern="[0-9]{3}";
	int num=0;
	boolean num_state=true;
	public BaseballGame() {
		generater();
		settingLayout();
		eventUp();
		randomnumber=generateNum();
		System.out.println(randomnumber);
		b_pa.setBackground(Color.ORANGE);
		w_pa.setBackground(Color.ORANGE);
		this.setSize(800,500);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// TODO Auto-generated constructor stub
	}
	public void settingLayout() {
		this.setLayout(new BorderLayout());
		c_pa.setBorder(new TitledBorder("기록판"));
		c_pa.setLayout(new BorderLayout());
		c_pa.add(scroll);
		this.add("Center",c_pa);
		b_pa.add(jl);
		b_pa.add(tf);
		this.add("South",b_pa);
		w_pa.setLayout(new GridLayout(4, 1,100,10));
		w_pa.add(bt_new);
		w_pa.add(bt_clear);
		w_pa.add(bt_answer);
		w_pa.add(bt_exit);
		this.add("East",w_pa);
	}
	public void eventUp() {
		tf.addActionListener(this);
		bt_new.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_answer.addActionListener(this);
		bt_exit.addActionListener(this);
	}
	public void generater() {
		bt_new=new JButton("새게임");
		bt_clear=new JButton("지우기");
		bt_answer=new JButton("정답");
		bt_exit=new JButton("나가기");
		ta = new JTextArea();
		ta.setEditable(false);
		scroll = new JScrollPane(ta);
		tf = new JTextField(30);
		jl = new JLabel("입력");
		c_pa=new JPanel();
		b_pa=new JPanel();
		w_pa=new JPanel();
		rd=new Random();
	}
	public void gameStart() {
		randomnumber=generateNum();
		System.out.println(randomnumber);
		tf.setText(" ");
		ta.setText(" ");
	}
	public int generateNum() {
		int i,j,k;
		i=rd.nextInt(10);
		for (int a = 0; true; a++) {
			j=rd.nextInt(10);
			if(j==i)
				continue;
			else
				break;
		}
		for (int a = 0; true; a++) {
			k=rd.nextInt(10);
			if(k==i || k==j)
				continue;
			else
				break;
		}
		
		return i*100+j*10+k;
	}
	public void gameSetting(int usernum) {
		int i,j,k;
		int r_i,r_j,r_k;
		r_i=randomnumber-randomnumber%100;
		r_j=randomnumber%100-randomnumber%10;
		r_k=randomnumber%10;
		i=usernum-usernum%100;
		j=usernum%100-usernum%10;
		k=usernum%10;
		if(i/100==j/10||i/100==k||j/10==k)
			JOptionPane.showMessageDialog(this, "겹치지않는 세자리 숫자를 입력해주세요");
		else {
			System.out.println("들어온숫자"+usernum+"  100자리: "+i+"  10자리:  "+j+"  1자리:  "+k);
			System.out.println("랜덤한 숫자"+"  100자리: "+r_i+"  10자리:  "+r_j+"  1자리:  "+r_k);

		compare(i/100,j/10,k,r_i/100,r_j/10,r_k);
		}
	}
	public void compare(int i, int j, int k,int r_i,int r_j, int r_k) {
		strikescore=0;ballscore=0;
		if(i==r_i) {
			strikescore++;
		}else if(i==r_j) {
			ballscore++;
		}else if(i==r_k) {
			ballscore++;
		}
		if(j==r_j) {
			strikescore++;
		}else if(j==r_i) {
			ballscore++;	
		}else if(j==r_k) {
			ballscore++;
		}if(r_k==k) {
			strikescore++;
		}else if(r_k==i) {
			ballscore++;
		}else if(r_k==j) {
			ballscore++;
		}
		if(strikescore==3) {
			ta.setText("축하합니다 정답입니다.");
		}else {
		ta.append(tf.getText().trim()+"스트라이크점수 "+strikescore+" 볼점수"+ballscore+"\n");
		tf.setText(" ");
		}
	}
	public static void main(String[] args) {
		new BaseballGame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if(ob==tf) {
			System.out.println(tf.getText().trim().matches(pattern));
			try {
				num=Integer.parseInt(tf.getText().trim());
				num_state=true;
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "정수만 입력해 주세요");
				num_state=false;
				// TODO: handle exception
			}
			if(!tf.getText().trim().matches(pattern) && num_state==true) {
				JOptionPane.showMessageDialog(this, "99보다크고 1000보다작은 세자리 숫자를 입력해주세요");
				num_state=false;
			}
			else if(num_state) {
				gameSetting(num);
			}
		}else if(ob==bt_new) {
			gameStart();
		}else if(ob==bt_clear) {
			ta.setText(" ");
		}else if(ob==bt_answer) {
			   JOptionPane.showMessageDialog(this, "정답:  "+randomnumber);
		}else if(ob==bt_exit) {
			System.out.println("나가기");
			System.exit(1);
		}
	}
}
