package day0213;

class SwitchEx04 {
	public static void main(String[] args) {
		// 5층 건물
		// 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스장
		// 층수따라 어디인지 출력되게 만들기
		// 결과 : 5층 헬스장입니다
		int floor=5;
		String a;
		switch(floor){
			case 1:
				a="1층 약국";
				break;
			case 2:
				a="2층 정형외과";
				break;
			case 3:
				a="3층 피부과";
				break;
			case 4:
				a="4층 치과";
				break;
			case 5:
				a="5층 헬스장";
				break;
			default:
				a = "존재하지 않는 층";
			//default로 a에 대입 안할거면 a 초기화 필요함.
		}
		System.out.println(a+"입니다.");
	}
}
