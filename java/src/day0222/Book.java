package day0222;

// 객체지향 특징
// 캡슐화 - 의도와 다른 접근, 제어로부터 보호

public class Book {
	// 변수
	private String bName; // 책제목
	private String pName; // 작가이름
	
	// 생성자
	public Book() {}

	public Book(String bName, String pName) {
		this.bName = bName;
		this.pName = pName;
	}

	// 메서드		리턴타입 메서드이름(){}
	// 책 제목 입력
	public void setBookName(String bName) {
		this.bName = bName;
	}
	// 책 제목 꺼내기
	public String getBookName() {
		return bName;
	}
	// 작가 이름 입력
	public void setPName(String pName) {
		this.pName = pName;
	}
	// 작가 이름 꺼내기
	public String getPName() {
		return pName;
	}
	// 책 정보 출력 (책제목 : 작가이름)
	public void bookInfo() {
		System.out.println(bName + " : " + pName);
	}
}
