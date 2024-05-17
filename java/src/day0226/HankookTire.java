package day0226;

public class HankookTire extends Tire {
	// 생성자
	public HankookTire(String location, int maxRotation) {
		// 조상 클래스에 기본생성자 없기 때문에 호출
		super(location, maxRotation);
	}
	
	//메서드
	// 출력 내용을 달리하기 위해 오버라이딩
	public boolean roll() {
		accumulateRotation++;
		if(accumulateRotation < maxRotation) {
			System.out.println(location+" HankookTire 수명 : "
					+(maxRotation-accumulateRotation)+"회");
			return true;
		}else {
			System.out.println("*** "+location+"HankookTire 펑크 ***");
			return false;
		}
	}
}
