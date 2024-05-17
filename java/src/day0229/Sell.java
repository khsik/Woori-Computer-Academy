package day0229;

public interface Sell {
	// 추상 메서드
	void sell();

	// 디폴트 메서드
	default void order() {
		System.out.println("판매 주문");
	}

	// 정적 메서드
	static void pay() {
		System.out.println("Sell pay()");
	}
}
