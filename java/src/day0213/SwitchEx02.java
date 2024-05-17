package day0213;

class SwitchEx02 {
	public static void main(String[] args) {

		int rank = 1;
		char medalColor;
		switch(rank){
			case 1:
				medalColor='G';
				break;
			case 2:
				medalColor='S';
				break;
			case 3:
				medalColor='B';
				break;
			default:		// if문의 else와 같은 역할. 선택 사항. 위치는 상관 없음.(마지막 아니여도 사용 가능)
				medalColor = 'A';
		}
		System.out.println(medalColor);

		int rank2 = 1;
		char medalColor2;
		switch(rank2){
			case 1:
				medalColor2='G';
//				break;
			case 2:
				medalColor2='S';
//				break;
			case 3:
				medalColor2='B';
//				break;
			default:
				medalColor2 = 'A';
		}
		System.out.println(medalColor2);

		// case 수행 이후 break;가 있으면 switch문을 끝내고 나옴.
		// break;가 없다면 마지막 case까지 계속 진행. 
	}
}
