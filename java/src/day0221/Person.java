package day0221;
// 변수에 private 없으면 직접 어떠한 값도 대입 가능(데이터 타입만 맞추면)
// private 변수로 사용하면 메서드를 통해야 하는데
// 메서드를 통해 원하는 조건으로 대입을 제한시킬 수 있음.
public class Person {
	// 이름, 주민번호
	private String name; // 2 ~ 5 글자
	private final String NUM;

	Person(String n) {
		NUM = n;
	}
	
	public void setName(String name) {
		int len = name.length();	// .lnegth()  String 의 메서드 호출
		if(len >= 2 && len <= 5) {	// 문자열의 길이 int 타입으로 반환
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public String getNUM() {
		return NUM;
	}
}
