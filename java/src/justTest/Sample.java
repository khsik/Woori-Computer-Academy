package justTest;

import java.util.Scanner;

public class Sample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2a;
		int[] num2 = new int[3];
//		String num2a;
//		char[] num2 = new char[3];
	
		System.out.println("첫번째 3자리 숫자를 입력하세요.");
		num1 = sc.nextInt();
		System.out.println("두번째 3자리 숫자를 입력하세요.");
//		num2a = sc.nextLine();
		num2a = sc.nextInt();
		sc.close();
		System.out.println();
		
//		for(int i=0; i<3; i++) {
//			num2[i] = num2a.charAt(i);
//		}
		
		num2[0] = num2a/100;
		num2[1] = (num2a/10) - (num2[0]*10);
		num2[2] = num2a - (num2[0]*100) - (num2[1]*10);
		
		int[] cal = new int[3];
		for(int i=2; i>=0; i--) {
			cal[i] = num1*num2[i];
			System.out.println(cal[i]);
		}

		int result = cal[0]*100 + cal[1]*10 + cal[2];
		System.out.println(result);
	}
}
