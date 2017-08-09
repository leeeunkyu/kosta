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
    la = new Label("����");
    
    //Scrollbar(int orientation, int value, int visible, int minimum, int maximum) 
    //orientation: ����, value: ������ ��ġ, visible: ������ �ʺ�, min:�ּ� , max:�ִ밪
    sb = new Scrollbar(Scrollbar.HORIZONTAL,50,20,0,100);
    cho = new Choice();
       //������(text)�߰�
      cho.add("����");
      cho.add("û��");
      cho.add("����");
      cho.add("�뱸");
      cho.add("����");
      
    //list = new List(int rows,boolean multipleMode)
      //rows: �������� ������(��)�� ����, multipleMode: ���߼���
      list = new List(2,true);
      list.add("�߱�");  
      list.add("�౸");  
      list.add("��");  
      list.add("�豸");  
    
    smallP = new Panel(); //la,sb�߰�
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
      
    setTitle("���־�������Ʈ �׽�Ʈ");
    setLayout(new GridLayout(3, 1));
    
    add(topP);
    add(cho);
    //add(list);
    add(bottomP);
    
    setSize(300, 600);
    setVisible(true);
  }//������
  
  public static void main(String[] args) {
	 new ScrollChoiceListTest();
  }
}




