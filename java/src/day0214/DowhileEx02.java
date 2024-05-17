package day0214;

import java.util.Scanner;

class DowhileEx02 {
	public static void main(String[] args) {
		System.out.println("메세지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in);
		String inputString;

		do{
			System.out.println(">");
			inputString = scanner.nextLine();	// 키보드 입력을 받겠다
		}while(! inputString.equals("q"));		// 입력한 내용이 q가 아니면 반복
		System.out.println();
		System.out.println("프로그램 종료.");
	}
}
