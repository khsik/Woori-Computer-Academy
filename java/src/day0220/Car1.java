package day0220;
/*
	인스턴스 멤버
	- 객체를 생성해야만 사용 가능
	- 인스턴스 변수
	- 인스턴스 메서드
*/
public class Car1 {
	// 클래스 변수 (= 인스턴스 변수)
	int gas;
	
	// 메서드
	// 가스 주입
	void setGas(int gas) {
		this.gas = gas;	//가스
	}
	
	boolean isGas() {	// 가스 유무 확인
		if(gas == 0) {
			System.out.println("가스가 없습니다.");
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("자동차가 달립니다." + " 가스량 : " + gas);
				gas -= 1;
			}else {
				System.out.println("자동차가 멈춥니다." + " 가스량 : " + gas);
				return;	 
			}
		}
	} // return 타입이 없는 void 에서 사용하는 return 은 메서드 종료
}