package justTest;

import java.util.Scanner;

public class Test05 {
	Scanner sc = new Scanner(System.in);
	double plus(double x, double y) {
		return x + y;
	}
	double minus(double x, double y) {
		return x - y;
	}
	double multi(double x, double y) {
		return x * y;
	}
	double divide(double x, double y) {
		return x/y;
	}
	
	double x, y;
	void setXY () {
		System.out.println("x를 입력해 주세요.");
		double x = sc.nextDouble();
		System.out.println("y를 입려해 주세요.");
		double y = sc.nextDouble();
		this.x = x;
		this.y = y;
	}
/*	
	int checkInt() {
		int num = 0;
		boolean validInput = false;
		
		while (!validInput) {
		  System.out.print("숫자를 입력하세요: ");
		  String input = sc.nextLine();
		
		  try {
		    num = Integer.parseInt(input);
		    validInput = true;
		  } catch (NumberFormatException e) {
		    System.out.println("정수만 입력하세요.");
		  }
		}
		
		return num;
	}
*/	
}	