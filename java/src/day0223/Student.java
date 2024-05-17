package day0223;
/*
	People 의 자손 클래스

	자식 객체만 생성되는 것처럼 보이지만
	부모 객체 먼저 생성 후 자식 개체 생성

	super();
		생략하면 컴파일러가 자동으로 추가 (기본생성자)
		조상의 기본 생성자가 반드시 존재해야 함

	super(매개변수1, 매개변수2, ...);
		조상에 기본 생성자가 없고, 매개변수가 있는 생성자만 있다면
		반드시 매개변수가 있는 생성자를 호출해야 한다.
		조상의 생성자에 맞춰 매개변수 넣기
*/
public class Student extends People {
	// 변수
	public int studentNo;

	// 생성자
	public Student(String name, String peopleNo, int studentNo) {
		super(name, peopleNo);
		this.studentNo = studentNo;
	}
}
