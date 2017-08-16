package com.kosta.person.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputForm extends JFrame{//�Է���
   
   JLabel la_name, la_age, la_job;	
   public JTextField tf_name, tf_age, tf_job;
   public JButton bt_submit, bt_cancel;
   
   public InputForm() {
	  setTitle("�Է���"); 
	   
      la_name = new JLabel("�̸�");  
      la_age = new JLabel("����");  
      la_job = new JLabel("����");  

      tf_name = new JTextField();
      tf_age = new JTextField();
      tf_job = new JTextField();

      bt_submit = new JButton("Ȯ��");
      bt_cancel = new JButton("���");
      
      
      la_name.setBounds(30,30,40,30);
      la_age.setBounds(30,80,40,30);
      la_job.setBounds(30,130,40,30);      
      
      tf_name.setBounds(70,30,80,30);
      tf_age.setBounds(70,80,80,30);
      tf_job.setBounds(70,130,80,30);
      
      bt_submit.setBounds(30,190,60,30);
      bt_cancel.setBounds(100,190,60,30);
      
      setLayout(null);
      add(la_name);
      add(la_age);
      add(la_job);
      add(tf_name);      
      add(tf_age);      
      add(tf_job);      
      add(bt_submit);      
      add(bt_cancel);
      
      setBounds(300,200,200,300);
      //setVisible(true);
      
      tf_name.requestFocus();
   }//������
  
   public void initForm() {
	  tf_name.setText("");
	  tf_age.setText("");
	  tf_job.setText("");
	  tf_name.requestFocus();
   }//initForm
   
   
}//InputForm




