package day0219;

public class Student {
	// 클래스 변수
	int studentNum;
	String name;
	int grade;
	String address;

	// 메서드
	void showInfo() { // 학생 정보 확인 메서드
		System.out.println(name + ", " + address); // 이름, 주소
	}
	
	void setName(String name) { // set 값을 저장할 때 쓰는 이름
		this.name = name;
	}
	
	String getName() { // get 값을 꺼낼 때 쓰는 이름
		return name;
	}
}
