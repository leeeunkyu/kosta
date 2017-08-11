package com.kosta.j0811;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest2 extends JFrame implements ActionListener{
    //JTable : ������ ��� ���� ���ĵ� ���·� ǥ��(���)�ϰ��� �Ҷ� ���
	
	JTable table;
	JScrollPane scroll;
	JButton bt_add, bt_find, bt_up, bt_del, bt_exit;
	JPanel southp;
	
	InputForm form;
	
	JFrame f;
	DefaultTableModel dtm;
	int no;//��ȣ�� 
	
	public JTableTest2() {
		setTitle("JTable�׽�Ʈ2");
		
		f = this;
		
		form = new InputForm();
		
		//JTable(TableModel dm) 
		//TableModel(interface) 
		//----����---> DefaultTableModel(Object[][] data, Object[] columnNames)
		Object data[][]=new Object[0][4];
		String []columnNames = {"��ȣ","�̸�","����","����"};
		dtm= new DefaultTableModel(data, columnNames);
		  //dtm.addRow(Object [] rowData);   
		  //dtm.removeRow(int row);
		table = new JTable(dtm);		
		scroll = new JScrollPane(table); //��ũ�ѹ� �����ϴ� JTable
		
		bt_add = new JButton("�߰�");
		bt_find = new JButton("�˻�");
		bt_up = new JButton("����");
		bt_del = new JButton("����");
		bt_exit = new JButton("����");
		
		southp = new JPanel();
		  southp.add(bt_add);
		  southp.add(bt_find);
		  southp.add(bt_up);
		  southp.add(bt_del);
		  southp.add(bt_exit);
		
		add(scroll);//add("Center",scroll);//(table);
		add("South",southp);
		
		setBounds(300,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		eventUp();
	}//������
	
	private void eventUp() {
	   //JTable(���κ�) �̺�Ʈ ���
	   bt_add.addActionListener(this);	
	   bt_find.addActionListener(this);	
	   bt_up.addActionListener(this);	
	   bt_del.addActionListener(this);	
	   bt_exit.addActionListener(this);	
		
	   //InputForm(�Է���) �̺�Ʈ ���
	   form.bt_submit.addActionListener(this);
	   form.bt_cancel.addActionListener(this);
	   form.addWindowListener(new WindowAdapter() {
		              //class ���� extends  WindowAdapter {   }
		   @Override
		public void windowClosing(WindowEvent e) {
			   //�Է��� ----> ����    �̵�
			   form.setVisible(false);
			   f.setVisible(true);
		}});
	}//eventUp
    
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯
	   Object ob = e.getSource();
		
	   if(ob == bt_add) {//����: �߰���ư Ŭ��
		   //���� ----> �Է���
		   setVisible(false);
		   form.setVisible(true);
	   }else if(ob == form.bt_submit) {//�Է���: Ȯ�ι�ư Ŭ��
		   String name = form.tf_name.getText();
		   int age = Integer.parseInt(form.tf_age.getText());
		   String job = form.tf_job.getText();
		   
		   Object rowData[]= { ++no, name,age,job};
		   
		   dtm.addRow(rowData);//������ �迭�� ������!! ---> JTable�� ���߰�
		   
		   form.setVisible(false);
		   setVisible(true);		   
		   
	   }else if(ob == bt_del) {
		   int t= JOptionPane.showConfirmDialog(this, "��������?");
		   
		   if(t==0) {//'��'��ư Ŭ��
			  int sIdx = table.getSelectedRow(); //���õ� �࿡ ���� �ε���: 0,1,2,3,~
		      if(sIdx != -1) {//JTable���� ���õ� ���� �ִٸ�
			    dtm.removeRow(sIdx);
		      }
		   }
		   
	   }else if(ob == bt_exit) {
		   System.exit(0);
	   }
	   
	}//actionPerformed
	
	
    public static void main(String[] args) {
		new JTableTest2();
	}

}