package com.kosta.j0811;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
    //JTable : ������ ��� ���� ���ĵ� ���·� ǥ��(���)�ϰ��� �Ҷ� ���
	/*
	   ����)
	             0       1      2      ���ε���
	       0  "ȫ�浿" - 13  - "�л�"          :�൥����
	       1  "�����" - 15  - "�л�"          :rowData
	       2  "���ֿ�" - 17  - "�л�"
	       
	     ���ε���  
	         ===> JTable�� ���� �����͸� ����Ͻÿ�.
	 */
	JTable table;
	JScrollPane scroll;
	JPanel northp;
	JLabel jl;
	boolean flag=true;
	public JTableTest() {
		setTitle("JTable�׽�Ʈ");
		/*table = new JTable(3,3);
		  //table.setValueAt(Object aValue, int row, int column);
		  table.setValueAt("�����", 1,0);
		  table.setValueAt(15, 1,1);*/
		
		//JTable(Object[][] rowData, Object[] columnNames)
		
		//String[][] rowData= { 
		Object[][] rowData= { 
				             {"ȫ�浿",13,"�л�"},
				             {"�����",15,"�л�"},
				             {"���ֿ�",17,"�л�"}
				             };
		String []columnNames = {"�̸�","����","����"};
		table = new JTable(rowData,columnNames);
		northp = new JPanel();
		jl = new JLabel();
		scroll = new JScrollPane(table); //��ũ�ѹ� �����ϴ� JTable
		
		add(scroll);//(table);
		northp.add(jl);
		add("North",northp);
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Calendar cal = new GregorianCalendar();
		jl.setText(cal.get(Calendar.YEAR)+"�� 8 �� 16�� 10��"+cal.get(Calendar.MINUTE)+"��"+cal.get(Calendar.SECOND)+"��");
	}//������
    
    public static void main(String[] args) {
		new JTableTest();
	}
}