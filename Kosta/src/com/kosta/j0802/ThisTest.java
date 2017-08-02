package com.kosta.j0802;
class Abc{
	String str=null;
	Abc(){
		
	}
	Abc(String str){
		this.str=str;
	}
}
public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abc abc = new Abc();
		System.out.println("STR= "+abc.str);
	}

}
