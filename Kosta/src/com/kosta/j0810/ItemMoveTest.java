package com.kosta.j0810;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest extends Frame implements ActionListener{
   final String BUTTONSTATE[]= {"¢¹","¢º","¢·","¢¸"};
   List list_l, list_r;
   TextField tf_l, tf_r;
   Button btn[];
   Panel leftp, centerp, rightp;
   
   public ItemMoveTest() {
	 list_l = new List();
	 list_r = new List();   
	 tf_l = new TextField();
	 tf_r = new TextField();
	 leftp = new Panel();
	 btn=new Button[4];
	 leftp.setLayout(new BorderLayout());  
	 leftp.add("Center", list_l);
	 leftp.add("South", tf_l);
	 centerp = new Panel(new GridLayout(6, 3,0,10));
	 setting_layout();
	 centerp.setBackground(Color.orange); 
	 rightp = new Panel();
	 rightp.setLayout(new BorderLayout());  
	 rightp.add("Center", list_r);
	 rightp.add("South", tf_r);
	 add(leftp);
	 add(centerp);
	 add(rightp);
	 setting_event();
	 setTitle("ItemMove");
	 setLayout(new GridLayout(1, 3));	 
	 setBounds(300, 200, 300, 300);
	 setVisible(true);
	 
	 addWindowListener(new WindowAdapter() {
		 @Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
     });
   }//»ý¼ºÀÚ
   public static void main(String[] args) {
	  new ItemMoveTest();
   }
   public void setting_event() {
		 tf_l.addActionListener(this);
		 tf_r.addActionListener(this);
		 for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}
   }
   public void setting_layout() {
		 for (int i = 0; i < btn.length; i++) {
			btn[i]=new Button(BUTTONSTATE[i]);
		}
		 for (int i = 0 , j=0; i < 15; i++) {
			 if(i%3==1 &&i!=1) {
				centerp.add(btn[j]);
				j++;
			 }
			else
				centerp.add(new Label());		
		 }
   }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object ob = e.getSource();
	if(ob==tf_l) {
		list_l.add(tf_l.getText());
		tf_l.setText(" ");

	}else if(ob==tf_r) {
		list_r.add(tf_r.getText());
		tf_r.setText(" ");

	}else if(ob==btn[0]) {
		list_r.add(list_l.getItem(list_l.getSelectedIndex()));
		list_l.remove(list_l.getSelectedIndex());
	}else if(ob==btn[2]) {
		list_l.add(list_r.getItem(list_r.getSelectedIndex()));
		list_r.remove(list_r.getSelectedIndex());
	}else if(ob==btn[1]) {
		for (int i = 0; i < list_l.getItemCount(); i++) {
			list_r.add(list_l.getItem(i));
		}
		list_l.removeAll();;

	}else if(ob==btn[3]) {
		for (int i = 0; i < list_r.getItemCount(); i++) {
			list_l.add(list_r.getItem(i));
		}
		list_r.removeAll();;
	}
}

}