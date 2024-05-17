package day0229;
/*
	다중 인터페이스 구현
	
	- 추상 메서드의 이름이 같을 때
		구현클래스에서 구현하므로 문제 없음.

	- 디폴트 메서드의 이름이 같을 때
		구현 클래스에서 오류 발생
		반드시 구현클래스에서 오버라이딩(재정의)해야함.

	- 정적 메서드의 이름이 같을 때
		생성과 상관없이 사용 가능하기 때문에 문제 없음.
*/
public class InterfaceEx04 {
	public static void main(String[] args) {
		Customer customer = new Customer();

		// Buy 인터페이스 타입의 변수 buyer 에 대입 가능
		// buyer 는 Buy 타입 메서드만 사용 가능
		Buy buyer = customer;
		buyer.buy(); // 구현 완료된 메서드 호출
		buyer.order(); // 오버라이딩된 메서드 호출
		Buy.pay();

		System.out.println();

		// Sell 인터페이스 타입의 변수 seller 에 대입 가능
		// seller 는 Sell 타입 메서드만 사용 가능
		Sell seller = customer;
		seller.sell(); // 구현 완료된 메서드 호출
		seller.order(); // 오버라이딩된 메서드 호출
		Sell.pay();
		
		System.out.println();

		if (seller instanceof Customer) {
			// seller 를 하위클래스 형인 Customer 로 다시 강제타입변환
			// instanceof 를 사용하여 자식의 타입으로 안전하게 변환 가능
			Customer customer2 = (Customer) seller;
			customer2.buy();
			customer2.sell();
			customer2.order();
		}
		customer.order();
	}
}
