package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{
  Label la;
  Scrollbar sb;
  Choice cho;
  List list;	

  Panel topP, smallP ,bottomP;  
  
  public ScrollChoiceListTest() {
    la = new Label("빨강");
    
    //Scrollbar(int orientation, int value, int visible, int minimum, int maximum) 
    //orientation: 방향, value: 조절바 위치, visible: 조절바 너비, min:최소 , max:최대값
    sb = new Scrollbar(Scrollbar.HORIZONTAL,50,20,0,100);
    cho = new Choice();
       //아이템(text)추가
      cho.add("서울");
      cho.add("청주");
      cho.add("제주");
      cho.add("대구");
      cho.add("광주");
      
    //list = new List(int rows,boolean multipleMode)
      //rows: 보여지는 아이템(행)의 갯수, multipleMode: 다중선택
      list = new List(2,true);
      list.add("야구");  
      list.add("축구");  
      list.add("농구");  
      list.add("배구");  
    
    smallP = new Panel(); //la,sb추가
      smallP.setLayout(new BorderLayout());
      smallP.add("West", la);
      smallP.add("Center", sb);
      
    topP = new Panel();
      topP.setLayout(new GridLayout(3, 1 , 0, 20));
        topP.add(new Label());
        topP.add(smallP);
        //topP.add(new Label());
    
      topP.setBackground(Color.ORANGE);
//      topP.add(la);
//      topP.add(sb);
      
    bottomP = new Panel();
      bottomP.add(list);
      bottomP.setBackground(Color.GREEN);
      
    setTitle("비주얼컴포넌트 테스트");
    setLayout(new GridLayout(3, 1));
    
    add(topP);
    add(cho);
    //add(list);
    add(bottomP);
    
    setSize(300, 600);
    setVisible(true);
  }//생성자
  
  public static void main(String[] args) {
	 new ScrollChoiceListTest();
  }
}




