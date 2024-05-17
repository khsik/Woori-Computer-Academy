package apiTest;

import java.util.Scanner;

/*
	8. 10이하의 정수 를 입력받아.
	입력받은 정수의 횟수 만큼 "hello world" 출력한다.
*/
public class Str08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "hello world\n";
		System.out.println("반복할 횟수를 입력하세요.");
		int rn = sc.nextInt();
		sc.close();
		System.out.print(str.repeat(rn));
	}
}
