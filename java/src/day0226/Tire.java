package day0226;
// 조상
public class Tire {
	// 변수
	public int maxRotation;			// 최대 회전수(수명)
	public int accumulateRotation;	// 누적 회전수
	public String location;			// 타이어 위치
	
	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 메서드
	public boolean roll() { // 타이어 1회전
		accumulateRotation++;
		// 누적 < 최대 : 수명 남아있음
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " Tire 수명 : " + (maxRotation - accumulateRotation));
			return true;
		}else { // 누적 = 최대 : 수명x -> 펑크
			System.out.println("*** "+location+"Tire 펑크 ***");
			return false;
		}
	}
}
