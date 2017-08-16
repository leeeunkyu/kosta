package com.kosta.person.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kosta.person.model.Person;
import com.kosta.person.model.PersonDAO;
import com.kosta.person.view.InputForm;
import com.kosta.person.view.MainView;
import com.kosta.person.view.UpForm;

public class Controller implements ActionListener{//Person애플리케이션의 전체 제어
	
	//뷰 등록
	MainView mainView;
	InputForm form;
	UpForm upForm;
	
	PersonDAO dao;//멤버필드 Vector가 한번 객체생성해야 하므로.
	int no;//입력된 Person에 유일한 번호를 부여.
	int index;
	public Controller() {
	   mainView = new MainView();
	   form = new InputForm();
	   upForm = new UpForm();
	   dao = new PersonDAO();
	   
	   eventUp();
	}//생성자
	
	private void eventUp() {
	   //메인뷰
	   mainView.bt_add.addActionListener(this);
	   mainView.bt_up.addActionListener(this);
	   mainView.bt_del.addActionListener(this);
	   	
	   
	   //입력폼
	   form.bt_submit.addActionListener(this);
		
	   //수정폼
	   upForm.bt_submit.addActionListener(this);
	   
	}//eventUp
	
	@Override
	public void actionPerformed(ActionEvent e) {
	  //1. 요청분석  2. 데이터얻기  3. 모델객체생성 4.페이지 이동
		Object ob = e.getSource();
		
		if(ob==mainView.bt_add) {//1. 메인뷰: 추가버튼
			
			form.initForm();//입력폼 초기화
			
			mainView.setVisible(false);//4.
			form.setVisible(true);//4.
			
		}else if(ob==form.bt_submit) {//1. 입력폼: 확인버튼
			
			//2.
			String name = form.tf_name.getText();
			String age = form.tf_age.getText();
			String job = form.tf_job.getText();
			
			Person p = new Person(++no, name, Integer.parseInt(age), job);
			
			//---> 입력된 값을 Vector(데이터저장소)에 저장!!
			dao.insert(p);
			
			//결과값 확인
			Vector<Person>  persons = dao.selectAll();
			mainView.displayTable(persons);
			
			form.setVisible(false);//4.
			mainView.setVisible(true);//4.
		}else if(ob== mainView.bt_up) {//메인뷰: 수정
			//Vector로 부터 데이터를 얻어서 수정폼에 뿌려주기
			upForm.setVisible(true);
			mainView.setVisible(false);
			upForm.tf_age.setText(""+dao.select(mainView.table.getSelectedRow()).getAge());
			upForm.tf_job.setText(dao.select(mainView.table.getSelectedRow()).getJob());
			

			//mainView.table
			//mainView.table.getSelectedRow();
			//mainView.table.getValueAt(선택된 행, 번호열 0);
			
		}else if(ob== upForm.bt_submit) {//수정폼: 확인
			//수정된 데이터를 Vector에 반영
			Person p = new Person(dao.select(mainView.table.getSelectedRow()).getNo(),dao.select(mainView.table.getSelectedRow()).getName()
					,Integer.parseInt(upForm.tf_age.getText()), upForm.tf_job.getText());
			//---> 입력된 값을 Vector(데이터저장소)에 저장!!
			dao.update(dao.select(mainView.table.getSelectedRow()).getNo(), p);
			Vector<Person>  persons = dao.selectAll();
			mainView.displayTable(persons);
			upForm.setVisible(false);
			mainView.setVisible(true);
			
		}else if(ob== mainView.bt_del) {//메인뷰: 삭제
			//삭제할 번호를 얻어서 Vector로 부터 삭제
			//JOptionPane.showInputDialog(mainView, "삭제할 번호:");
			Vector<Person>  persons = dao.selectAll();
			int num=Integer.parseInt(mainView.showInput("삭제할 번호:"));
			for(int i =num;i<persons.size();i++) {
				persons.get(i).setNo(persons.get(i).getNo()-1);
			}
			dao.delete(num);
			System.out.println(persons);
			mainView.displayTable(persons);
		}else if(ob==mainView.bt_exit) {
			System.exit(1);
		}
	}//actionPerformd
	
	public static void main(String[] args) {
		new Controller();
	}


}