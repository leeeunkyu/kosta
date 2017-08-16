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
    //JTable : 데이터 행과 열의 정렬된 형태로 표현(출력)하고자 할때 사용
	/*
	   문제)
	             0       1      2      열인덱스
	       0  "홍길동" - 13  - "학생"          :행데이터
	       1  "길라임" - 15  - "학생"          :rowData
	       2  "김주원" - 17  - "학생"
	       
	     행인덱스  
	         ===> JTable을 통해 데이터를 출력하시오.
	 */
	JTable table;
	JScrollPane scroll;
	JPanel northp;
	JLabel jl;
	boolean flag=true;
	public JTableTest() {
		setTitle("JTable테스트");
		/*table = new JTable(3,3);
		  //table.setValueAt(Object aValue, int row, int column);
		  table.setValueAt("길라임", 1,0);
		  table.setValueAt(15, 1,1);*/
		
		//JTable(Object[][] rowData, Object[] columnNames)
		
		//String[][] rowData= { 
		Object[][] rowData= { 
				             {"홍길동",13,"학생"},
				             {"길라임",15,"학생"},
				             {"김주원",17,"학생"}
				             };
		String []columnNames = {"이름","나이","직업"};
		table = new JTable(rowData,columnNames);
		northp = new JPanel();
		jl = new JLabel();
		scroll = new JScrollPane(table); //스크롤바 지원하는 JTable
		
		add(scroll);//(table);
		northp.add(jl);
		add("North",northp);
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Calendar cal = new GregorianCalendar();
		jl.setText(cal.get(Calendar.YEAR)+"년 8 월 16일 10시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND)+"초");
	}//생성자
    
    public static void main(String[] args) {
		new JTableTest();
	}
}