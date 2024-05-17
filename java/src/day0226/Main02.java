package day0226;

public class Main02 {
	public static void main(String[] args) {
		Car car = new Car();
		
		// run() 반복 
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			switch(problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 HankookTire로 교체");
				car.frontLeft = new HankookTire("앞 왼쪽", 14);
				break;
			case 2:
				System.out.println("앞 오른쪽 KumhoTire로 교체");
				car.frontRight = new KumhoTire("앞 오른쪽", 18);
				break;
			case 3:
				System.out.println("뒤 왼쪽 HankookTire로 교체");
				car.backLeft = new HankookTire("뒤 왼쪽", 17);
				break;
			case 4:
				System.out.println("뒤 오른쪽 KumhoTire로 교체");
				car.backRight = new KumhoTire("뒤 오른쪽", 16);
				break;
			}
			System.out.println("=============================");
		}
	}
}
