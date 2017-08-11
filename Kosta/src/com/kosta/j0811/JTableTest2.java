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
    //JTable : 데이터 행과 열의 정렬된 형태로 표현(출력)하고자 할때 사용
	
	JTable table;
	JScrollPane scroll;
	JButton bt_add, bt_find, bt_up, bt_del, bt_exit;
	JPanel southp;
	
	InputForm form;
	
	JFrame f;
	DefaultTableModel dtm;
	int no;//번호값 
	
	public JTableTest2() {
		setTitle("JTable테스트2");
		
		f = this;
		
		form = new InputForm();
		
		//JTable(TableModel dm) 
		//TableModel(interface) 
		//----구현---> DefaultTableModel(Object[][] data, Object[] columnNames)
		Object data[][]=new Object[0][4];
		String []columnNames = {"번호","이름","나이","직업"};
		dtm= new DefaultTableModel(data, columnNames);
		  //dtm.addRow(Object [] rowData);   
		  //dtm.removeRow(int row);
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
		
		eventUp();
	}//생성자
	
	private void eventUp() {
	   //JTable(메인뷰) 이벤트 등록
	   bt_add.addActionListener(this);	
	   bt_find.addActionListener(this);	
	   bt_up.addActionListener(this);	
	   bt_del.addActionListener(this);	
	   bt_exit.addActionListener(this);	
		
	   //InputForm(입력폼) 이벤트 등록
	   form.bt_submit.addActionListener(this);
	   form.bt_cancel.addActionListener(this);
	   form.addWindowListener(new WindowAdapter() {
		              //class 무명 extends  WindowAdapter {   }
		   @Override
		public void windowClosing(WindowEvent e) {
			   //입력폼 ----> 메인    이동
			   form.setVisible(false);
			   f.setVisible(true);
		}});
	}//eventUp
    
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 핸들러
	   Object ob = e.getSource();
		
	   if(ob == bt_add) {//메인: 추가버튼 클릭
		   //메인 ----> 입력폼
		   setVisible(false);
		   form.setVisible(true);
	   }else if(ob == form.bt_submit) {//입력폼: 확인버튼 클릭
		   String name = form.tf_name.getText();
		   int age = Integer.parseInt(form.tf_age.getText());
		   String job = form.tf_job.getText();
		   
		   Object rowData[]= { ++no, name,age,job};
		   
		   dtm.addRow(rowData);//일차원 배열을 데이터!! ---> JTable에 행추가
		   
		   form.setVisible(false);
		   setVisible(true);		   
		   
	   }else if(ob == bt_del) {
		   int t= JOptionPane.showConfirmDialog(this, "정말삭제?");
		   
		   if(t==0) {//'예'버튼 클릭
			  int sIdx = table.getSelectedRow(); //선택된 행에 대한 인덱스: 0,1,2,3,~
		      if(sIdx != -1) {//JTable에서 선택된 행이 있다면
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