package com.kosta.j0810;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuTest extends Frame implements ItemListener{
	final String list[]={"아침","점심","저녁","돼지바","수박바","조스바"};
	Checkbox[] ch;
	CheckboxGroup cg;
	Choice cho;
	TextArea ta;
	Panel topP,cenP,botP;
	String state = null;
	public MenuTest() {
		init_Setting();
		layout_Setting();
		this.setLayout(new BorderLayout());
		this.add("North",topP);
		this.add("Center",ta);
		this.add("South", botP);
		action_Setting();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
	     });
		setSize(300, 300);
		setVisible(true);
	}
	public void action_Setting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ch.length; i++) {
			ch[i].addItemListener(this);
		}
		cho.addItemListener(this);
	}
	public void layout_Setting() {
		topP=new Panel();
		botP=new Panel();
		topP.setLayout(new GridLayout(2, 3));
		for (int i = 0; i < 6; i++) {
			topP.add(ch[i]);
		}
		topP.setBackground(Color.ORANGE);
		botP.add(cho);
		botP.setBackground(Color.PINK);
	}
	public void init_Setting() {
		cg=new CheckboxGroup();
		cho=new Choice();
		ch=new Checkbox[6];
		ta=new TextArea();
		for (int i = 0; i < 6; i++) {
			if(i<3) {
				ch[i]=new Checkbox(list[i],false,cg);
				cho.add(list[i]);
			}else
				ch[i]=new Checkbox(list[i]);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		for (int i = 0; i < 3; i++) {
			if(ob==ch[i]) {
				state="******"+ch[i].getLabel()+"******";
				text_Setting(state);
			}
		}
		if(ob==ch[3]||ob==ch[4]||ob==ch[5]) {
			text_Setting(state);
		}
		if(ob==cho) {
			state="******"+cho.getSelectedItem()+"******";
			text_Setting(state);
		}
	}
	public void text_Setting(String str) {
		ta.setText(state);
		ta.append("\n"+"1.돼지바"+ch[3].getState()+"\n"+"2.수박바"+ch[4].getState()+"\n"
				+"3.조스바"+ch[5].getState());
	}
	public static void main(String[] args) {
		new MenuTest();
	}
	
}
