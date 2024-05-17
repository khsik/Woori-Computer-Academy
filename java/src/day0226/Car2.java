package day0226;
/*
	배열
	- 동일한 타입은 배열로 관리하는 것이 편하다
	- 인덱스 번호 사용 -> 대입, 제어문 사용시 편하다
*/
public class Car2 {
	// 변수
	Tire[] tires = {
		new Tire("앞 왼쪽", 6),
		new Tire("앞 오른쪽", 2),
		new Tire("뒤 왼쪽", 3),
		new Tire("뒤 오른쪽",4)
	};
	
	// 메서드
	int run() {
		System.out.println("[자동차가 달립니다]");
		for(int i=0; i<tires.length; i++) {
			if(tires[i].roll() == false) {
				stop();
				return (i+1); // 타이어 4개, index는 0~3
			}
		}
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다]");
	}
}
