package com.kosta.j0818;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta.j0818.Person;

public class MainView extends JFrame implements ActionListener{
	JButton btn0,btn1,btn2;
	JPanel southp;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scroll;
	Person person;
	PersonDAO dao;
	Vector<Person> v;
	Vector<Person> v2;
	InputForm form;
	int no;
	public MainView() {
		// TODO Auto-generated constructor stub
		Object data[][]=new Object[0][4];
		String []columnNames = {"��ȣ","�̸�","����","����"};
		dtm= new DefaultTableModel(data, columnNames);
		table = new JTable(dtm);		
		scroll = new JScrollPane(table); //��ũ�ѹ� �����ϴ� JTable
		southp = new JPanel();
		btn0=new JButton("�߰�");
		btn1=new JButton("�̸��˻�");
		btn2=new JButton("��ü�˻�");
		dao = new PersonDAO();
		v= new Vector<>();
		v2= new Vector<>();
		form = new InputForm();
		
		southp.add(btn0);
		southp.add(btn1);
		southp.add(btn2);
		this.add("South",southp);
		this.add("Center",scroll);
		eventup();
		setVisible(true);
		setBounds(300,300, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void eventup() {
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		form.bt_submit.addActionListener(this);
	}
	public Vector<Person> searchPerson(String select) {
		v=dao.select(select);
		return v;
	}
	public static void main(String[] args) {
		new MainView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String select;
		if(e.getSource()==btn0) {
			form.setVisible(true);
			this.setVisible(false);
			
		}
		else if(e.getSource()==form.bt_submit) {
			dao.addPerson(new Person(++no, form.tf_name.getText(), Integer.parseInt(form.tf_age.getText()), form.tf_job.getText()));
			form.setVisible(false);
			this.setVisible(true);
		}
		else if (e.getSource()==btn1) {
			  select = JOptionPane.showInputDialog(this,"�˻����̸�:");
			  searchPerson(select);
//			  for (int i = 0; i <= dtm.getRowCount(); i++) {
//					dtm.removeRow(i);
//
//				}
			  dtm.setRowCount(0);//addRow�Ǵ� �������� �����ε��� �����ϱ�
//				//0---> ù��° ����� ���
//				//1---> �ι�° ����� ���
				 
				for(int i=0; i<v.size(); i++) {//���� �ε���
					Person p = v.get(i);
					Object data[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
					dtm.addRow(data);
				}
				dao.reset();
		}else {
			v2=dao.selectAll();
//			for (int i = 0; i <= dtm.getRowCount(); i++) {
//				dtm.removeRow(i);
//
//			}
			  dtm.setRowCount(0);//addRow�Ǵ� �������� �����ε��� �����ϱ�
//					//0---> ù��° ����� ���
//					//1---> �ι�° ����� ���
					 
					for(int i=0; i<v2.size(); i++) {//���� �ε���
						Person p = v2.get(i);
						Object data[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
						dtm.addRow(data);
					}	
		}
	}

}
