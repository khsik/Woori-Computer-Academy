package day0226;

public class SmartPhone extends Phone {
	// 생성자
	public SmartPhone(String user){
		super(user); // 조상 생성자 호출
	}
	
	// 메서드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	
}
