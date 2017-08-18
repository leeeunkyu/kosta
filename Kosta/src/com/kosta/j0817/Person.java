package com.kosta.j0817;

import java.io.Serializable;

public class Person implements Serializable{
	        //현 클래스를 객체직렬화 가능한 클래스로 선언하겠음!!
   String name="나길동";
   transient int age=13;//객체직렬화시 데이터 전달을 하지 않겠다.
   String job="학생";
}