package com.kosta.calc.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.calc.view.CalcView;

public class CalcController implements ActionListener{
	CalcView view;
	public CalcController() {
		// TODO Auto-generated constructor stub
		view = new CalcView();
	}
	public static void main(String[] args) {
		new CalcController();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String su1Stw = view.tf_su1.getText();
		String su1Stq = view.tf_su2.getText();
		
	}
}
