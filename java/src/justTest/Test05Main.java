package justTest;

import java.util.Scanner;

public class Test05Main { // 계산기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test05 cal = new Test05();

		int a = 0;
		boolean b = false;
		while (!b) {
			System.out.println("원하시는 계산을 입력해주세요.");
			System.out.println("x ( + - * / ) y = ?");
			System.out.println("1. 더하기 / 2. 빼기 / 3. 곱하기 / 4. 나누기 / 5. 나가기");
			a = sc.nextInt();
//			a = cal.checkInt();
			switch (a) {
			case 1:
				cal.setXY();
				System.out.println(cal.x + " + " + cal.y + " = " + cal.plus(cal.x, cal.y));
				break;
			case 2:
				cal.setXY();
				System.out.println(cal.x + " - " + cal.y + " = " + cal.minus(cal.x, cal.y));
				break;
			case 3:
				cal.setXY();
				System.out.println(cal.x + " * " + cal.y + " = " + cal.multi(cal.x, cal.y));
				break;
			case 4:
				cal.setXY();
				System.out.println(cal.x + " / " + cal.y + " = " + cal.divide(cal.x, cal.y));
				break;
			case 5:
				System.out.println("계산기를 종료합니다.");
				b = true;
				break;
			default:
				System.out.println("1, 2, 3, 4, 5중에 입력해야 합니다.");
				a=0;
			}
		}
		sc.close();
	}
}
/*
 	a = sc.nextInt(); 에서 int 범위를 벗어나거나, 정수가 아닌것을 입력하면 오류나옴
 	그래서 nextLine();으로 String 타입으로 입력을 받고 정수를 추출하는 방법을 쓰려면
 	아래의 코드를 참고해서 수정하면 가능함.
 	Test05에 메서드로 넣어봄.
 	 
	Integer.valueOf()는 Integer Object를 리턴
	Integer.parseInt()는 primitive type인 int를 리턴
	

	Scanner scanner = new Scanner(System.in);
	
	int num;
	boolean validInput = false;
	
	while (!validInput) {
	  System.out.print("숫자를 입력하세요: ");
	  String input = scanner.nextLine();
	
	  try {
	    num = Integer.parseInt(input);
	    validInput = true;
	  } catch (NumberFormatException e) {
	    System.out.println("정수만 입력하세요.");
	  }
	}

	System.out.println("입력된 숫자: " + num);
*/
