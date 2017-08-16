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
		setTitle("메인뷰");
			
		Object data[][]=new Object[0][4];
		String []columnNames = {"번호","이름","나이","직업"};
		dtm= new DefaultTableModel(data, columnNames);
		table = new JTable(dtm);		
		scroll = new JScrollPane(table); //스크롤바 지원하는 JTable
		
		bt_add = new JButton("추가");
		bt_find = new JButton("검색");
		bt_up = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_exit = new JButton("종료");
		
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
		
	}//생성자
	

	 public void displayTable(Vector<Person> v){
		 //외부에서 데이터(Person)를 전달받아 JTable에 뿌려주기
		
		dtm.setRowCount(0);//addRow되는 데이터의 시작인덱스 설정하기
		//0---> 첫번째 행부터 출력
		//1---> 두번째 행부터 출력
		 
		for(int i=0; i<v.size(); i++) {//벡터 인덱스
			Person p = v.get(i);
			Object data[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
			dtm.addRow(data);
		}	 
		 //포인트
		 //Object data[]= {1,"홍길동",13,"학생"};
		 //dtm.addRow(data);
	 }//displayTable
	
	 public String showInput(String msg) {
		 return JOptionPane.showInputDialog(this, msg);
	 }//showInput
	 
}//MainView




