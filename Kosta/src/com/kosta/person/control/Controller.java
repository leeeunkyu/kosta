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

public class Controller implements ActionListener{//Person���ø����̼��� ��ü ����
	
	//�� ���
	MainView mainView;
	InputForm form;
	UpForm upForm;
	
	PersonDAO dao;//����ʵ� Vector�� �ѹ� ��ü�����ؾ� �ϹǷ�.
	int no;//�Էµ� Person�� ������ ��ȣ�� �ο�.
	int index;
	public Controller() {
	   mainView = new MainView();
	   form = new InputForm();
	   upForm = new UpForm();
	   dao = new PersonDAO();
	   
	   eventUp();
	}//������
	
	private void eventUp() {
	   //���κ�
	   mainView.bt_add.addActionListener(this);
	   mainView.bt_up.addActionListener(this);
	   mainView.bt_del.addActionListener(this);
	   	
	   
	   //�Է���
	   form.bt_submit.addActionListener(this);
		
	   //������
	   upForm.bt_submit.addActionListener(this);
	   
	}//eventUp
	
	@Override
	public void actionPerformed(ActionEvent e) {
	  //1. ��û�м�  2. �����;��  3. �𵨰�ü���� 4.������ �̵�
		Object ob = e.getSource();
		
		if(ob==mainView.bt_add) {//1. ���κ�: �߰���ư
			
			form.initForm();//�Է��� �ʱ�ȭ
			
			mainView.setVisible(false);//4.
			form.setVisible(true);//4.
			
		}else if(ob==form.bt_submit) {//1. �Է���: Ȯ�ι�ư
			
			//2.
			String name = form.tf_name.getText();
			String age = form.tf_age.getText();
			String job = form.tf_job.getText();
			
			Person p = new Person(++no, name, Integer.parseInt(age), job);
			
			//---> �Էµ� ���� Vector(�����������)�� ����!!
			dao.insert(p);
			
			//����� Ȯ��
			Vector<Person>  persons = dao.selectAll();
			mainView.displayTable(persons);
			
			form.setVisible(false);//4.
			mainView.setVisible(true);//4.
		}else if(ob== mainView.bt_up) {//���κ�: ����
			//Vector�� ���� �����͸� �� �������� �ѷ��ֱ�
			upForm.setVisible(true);
			mainView.setVisible(false);
			upForm.tf_age.setText(""+dao.select(mainView.table.getSelectedRow()).getAge());
			upForm.tf_job.setText(dao.select(mainView.table.getSelectedRow()).getJob());
			

			//mainView.table
			//mainView.table.getSelectedRow();
			//mainView.table.getValueAt(���õ� ��, ��ȣ�� 0);
			
		}else if(ob== upForm.bt_submit) {//������: Ȯ��
			//������ �����͸� Vector�� �ݿ�
			Person p = new Person(dao.select(mainView.table.getSelectedRow()).getNo(),dao.select(mainView.table.getSelectedRow()).getName()
					,Integer.parseInt(upForm.tf_age.getText()), upForm.tf_job.getText());
			//---> �Էµ� ���� Vector(�����������)�� ����!!
			dao.update(dao.select(mainView.table.getSelectedRow()).getNo(), p);
			Vector<Person>  persons = dao.selectAll();
			mainView.displayTable(persons);
			upForm.setVisible(false);
			mainView.setVisible(true);
			
		}else if(ob== mainView.bt_del) {//���κ�: ����
			//������ ��ȣ�� �� Vector�� ���� ����
			//JOptionPane.showInputDialog(mainView, "������ ��ȣ:");
			Vector<Person>  persons = dao.selectAll();
			int num=Integer.parseInt(mainView.showInput("������ ��ȣ:"));
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