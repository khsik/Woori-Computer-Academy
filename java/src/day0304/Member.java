package day0304;
// ObjectEx01
public class Member {
	// 변수
	public String id;
	
	// 생성자
	public Member(String id) {
		this.id = id;
	}
	
	// 메서드
	@Override
	public boolean equals(Object obj) {
		// 매개값이 Member 타입인지 확인
		// id 변수값이 같은지 확인 -> 같다면 true
		if( obj instanceof Member ) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		// 매개값이 Member 타입이 아니거나
		// id 변수 값이 다르다면 false 리턴
		return false;
	}
}
