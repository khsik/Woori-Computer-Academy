package day0222;

public class Student {
	private int studentNum; // 번호
	private String name; // 이름

	public Student() {}
	public Student(int num, String name){
		studentNum = num;
		this.name = name;
	}

	public void studentInfo() { // 번호 이름 출력
		System.out.println(studentNum + "번 " + name);
	}

	public void setNum(int num) { // 번호 대입
		studentNum = num;
	}
	public int getNum() { // 번호 리턴
		return studentNum;
	}
	public void setName(String name) { // 이름 대입
		this.name = name;
	}
	public String getName() { // 이름 리턴
		return name;
	}
}
