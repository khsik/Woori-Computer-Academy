package day0216;

public class Student {
/*
	public	: 접근제어자
	class	: 클래스를 만드는 예약어
	Student	: 클래스 이름
	{}		: 클래스 내용 구현
	개체의 속성 : 멤버 변수
*/	
	// 멤버 변수 - 속성이 무엇이냐에 따라 알맞은 자료형(타입) 선언
	String name;		//이름
	int grade;			//학년
	int age;			//나이
	int studentNum;		//학번
	int phone;			//연락처
	String address;		//주소
}
/*
	자바 프로그램은 모든 요소가 클래스 내부에 있어야 한다.
	클래스 외부에는 package 선언과 import 문장 외에는 아무것도 선언하지 않음.
*/