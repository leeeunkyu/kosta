package com.kosta.j0816;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePad extends JFrame implements ActionListener{
   JTextArea ta;
   JScrollPane ta_scrol;
   
   JMenuItem file_open,file_save,file_exit;//이벤트 소스   
   JMenu menu_file, menu_help;   
   JMenuBar bar;
   JFileChooser jf;
   byte ori_file[];
   FileInputStream fis;
   FileOutputStream fos;
   FileWriter fw;

   public NotePad() throws FileNotFoundException {
	   setTitle("Swing NotePad");
	   ori_file=new byte[512];
	   file_open = new JMenuItem("파일열기");
	   file_save = new JMenuItem("파일저장");
	   file_exit = new JMenuItem("종료");
	   jf = new JFileChooser();
	   menu_file = new JMenu("File");
	     menu_file.add(file_open);
	     menu_file.add(file_save);
	     menu_file.addSeparator();//구분선
	     menu_file.add(file_exit);
	   menu_help = new JMenu("Help");
	   
	   bar = new JMenuBar();
	     bar.add(menu_file);
	     bar.add(menu_help);
	     
	   setJMenuBar(bar);//프레임에 JMenuBar설정하기
	   
	   ta = new JTextArea();
	   ta_scrol = new JScrollPane(ta);
	   
	   add(ta_scrol);
	 //  FileNameExtensionFilter filter = new ;
	   setBounds(200,100,600,600);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   eventUp();	   
   }//생성자
   
   private void eventUp() {
	    file_exit.addActionListener(this);
	    file_open.addActionListener(this);
	    file_save.addActionListener(this);
	    jf.addActionListener(this);
   }
	
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   int i;
	   if(ob==file_open) {
		   if(JFileChooser.APPROVE_OPTION==jf.showOpenDialog(null)) {
			   System.out.println("확인");
			   try {
				fis = new FileInputStream(jf.getSelectedFile().getPath());

				 try {
					while((i=fis.read()) != -1) {//읽은 바이트가 있다면
					     //System.out.print((char)i);
						  //System.out.write(i);
						ta.append(""+(char)i);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			   } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		   }else {
			   System.out.println("취소");
		   }
	   }else if(ob==file_save) {
		   if(JFileChooser.APPROVE_OPTION==jf.showSaveDialog(null)) {
				  try {
					fw = new FileWriter(jf.getSelectedFile());
					System.out.println(jf.getCurrentDirectory()+"\\b.txt");
					System.out.println("   "+jf.getUIClassID()+"     "+jf.getSelectedFile());
					fw.write(ta.getText());
					fw.close();
				  } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		   }else {
			   System.out.println("취소");
		   }
	   }else if(ob==file_exit) {
		   System.exit(0);
	   }
   }//actionPerformed
   
   
   public static void main(String[] args) throws FileNotFoundException {
	   new NotePad();
   }

}