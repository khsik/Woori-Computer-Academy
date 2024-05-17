package day0208;

class OperEx03 {
	public static void main(String[] args) {
		int mathScore = 90;
		int engScore = 70;

		int totalScore = mathScore + engScore;
		System.out.println(totalScore);

		double avgScore = totalScore/2.0;
		System.out.println(avgScore);
		/*
		int끼리 나누면 값도 int가 나오는지 double형에 대입이 되어도 소수점 아래 값이 사라짐.
		int와 double로 나누면 값이 double형으로 계산되서 소수점 아래 값이 사라지지 않음.
		*/
		System.out.println(10/3);
		System.out.println(10.0/3);
	}
}
