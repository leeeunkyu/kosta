package com.kosta.j0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonMenuTest {
	public static void main(String[] args) {
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   PersonMenu menu = new PersonMenu();

	   String num;//int num;
	 try {
		do {
			
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호입력==> ");
			num = in.readLine();//"1" "2" "3"
			System.out.println(); 
			 switch(num) {
			    case "1":
			       {
			    	System.out.print("이름: ");
			    	  String name=in.readLine();
			    	System.out.print("나이: ");
			    	  int age= Integer.parseInt(in.readLine());
			    	System.out.print("직업: ");
			    	  String job=in.readLine();
			  
			    	//기본생성자
			    	/*Person person = new Person();
			    	 //no:0 name:null age:0 job:null
			    	  
			    	   person.setName(name);//no:0 name:"홍길동" age:0 job:null
			    	   person.setAge(age);//no:0 name:"홍길동" age:13 job:null
			    	   person.setJob(job);//no:0 name:"홍길동" age:13 job:"학생"
			    	   
			    	   */
			     
			    	//오버로딩생성자
			    	Person person = new Person(0,name,age,job); 
			    	menu.insert(person); 
			       }
			    	break;
			    case "2":
			    	menu.select();
			    	break;
			    case "3":
			    	System.out.print("수정할 번호: ");
			    	 int upNo = Integer.parseInt(in.readLine());
			    	System.out.print("나이: ");
			    	 int age = Integer.parseInt(in.readLine());
			    	System.out.print("직업: ");
			    	 String job = in.readLine();
			    	 
			    	//Person p = new Person(upNo,null,age,job);
			    	
			    	menu.update(new Person(upNo,null,age,job));//p);//(upNo,age,job);
			    	break;
			    case "4":
			    	System.out.print("삭제할 번호: ");
			    	int delNo = Integer.parseInt(in.readLine());
			    	menu.delete(delNo);
			 }//switch
			 
			System.out.println();
		   }while(!num.equals("5"));//(num != 5);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		System.out.println("--END--");
	}//main
}