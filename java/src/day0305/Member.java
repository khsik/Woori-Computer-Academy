package day0305;

// implements Cloneable 복제 가능 명시
public class Member implements Cloneable {
	// 변수
	public String name; // 이름
	public String id; // 아이디
	public String pw; // 비밀번호
	public int age; // 나이
	public boolean adult; // 성인인증

	// 생성자
	public Member(String name, String id, String pw, int age, boolean adult) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.adult = adult;
	}

	// 메서드
	public Member getMember() {
		Member clone = null;
		// 예외 처리 필수
		try {
			clone = (Member) clone(); // 리턴타입 Object 때문에 강제변환 필요
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
