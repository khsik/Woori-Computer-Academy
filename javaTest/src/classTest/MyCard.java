package classTest;

public class MyCard {
	int num; // 변수1
	boolean isGwang; // 변수2
	
	public static void main(String[] args) {
		MyCard card = new MyCard();
		card.num = 3;
		card.isGwang = true;
		System.out.println(card.num);
		System.out.println(card.isGwang);
	}
}
