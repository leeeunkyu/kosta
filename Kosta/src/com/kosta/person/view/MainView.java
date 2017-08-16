package com.kosta.person.view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta.person.model.Person;

public class MainView extends JFrame {
	
	public JTable table;
	JScrollPane scroll;
	public JButton bt_add, bt_find, bt_up, bt_del, bt_exit;
	JPanel southp;
	
	DefaultTableModel dtm;
	
	public MainView() {
		setTitle("���κ�");
			
		Object data[][]=new Object[0][4];
		String []columnNames = {"��ȣ","�̸�","����","����"};
		dtm= new DefaultTableModel(data, columnNames);
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
		
	}//������
	

	 public void displayTable(Vector<Person> v){
		 //�ܺο��� ������(Person)�� ���޹޾� JTable�� �ѷ��ֱ�
		
		dtm.setRowCount(0);//addRow�Ǵ� �������� �����ε��� �����ϱ�
		//0---> ù��° ����� ���
		//1---> �ι�° ����� ���
		 
		for(int i=0; i<v.size(); i++) {//���� �ε���
			Person p = v.get(i);
			Object data[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
			dtm.addRow(data);
		}	 
		 //����Ʈ
		 //Object data[]= {1,"ȫ�浿",13,"�л�"};
		 //dtm.addRow(data);
	 }//displayTable
	
	 public String showInput(String msg) {
		 return JOptionPane.showInputDialog(this, msg);
	 }//showInput
	 
}//MainView




