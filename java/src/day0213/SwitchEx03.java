package day0213;

class SwitchEx03 {
	public static void main(String[] args) {
		// case(조건)은 다르지만 실행문이 같은 경우
		int month = 14;
		int day;

		switch(month){
			case 1: case 3: case 5: case 7 : case 8: case 10: case 12:
				day = 31;
				break;
			case 4: case 6: case 9: case 11:
			// case 4, 6, 9, 11:  java 14버전부터 사용 가능
				day = 30;
				break;
			case 2:
				day = 28;
				break;
			default:
				day = 0;
				System.out.println("존재하지 않는 달 입니다.");
		}
		if(day!=0){
		System.out.println(month + "월은 "+day+"일까지 있습니다.");
		}
	}
}
