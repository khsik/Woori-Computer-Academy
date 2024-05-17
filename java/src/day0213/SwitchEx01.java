package day0213;

class SwitchEx01 {
	public static void main(String[] args) {
/*
		switch-case문
		if문보다 간단하게 쓸 수 있음.
		복잡한 조건 처리하기에는 적합하지 않음.
*/
		String position = "과장";
		switch(position){
			case "부장":
				System.out.println("700만원");
				break;
			case "과장":
				System.out.println("500만원");
				break;
			case "대리":
				System.out.println("300만원");
				break;
			default:
				System.out.println("200만원");
		}

	}
}

/*
		switch(변수){
		case 값:
			실행문;
			break;
		case 값2:
			실행문;
			break;
		default:
			실행문;
		}

		변수==값 이면 해당 case의 실행문 실행
		case 실행 이후 break;가 있으면 switch문 종료. (뒤로 더 조건이 있어도 무시)
		default는 조건없이 실행

		마지막에 default를 썼는데 앞쪽 case들에 break;가 없다면
		변수가 case의 값을 만족해도 switch문이 끝까지 진행되고
		default에 있는 것이 원치 않아도 실행될 수 있음.
*/