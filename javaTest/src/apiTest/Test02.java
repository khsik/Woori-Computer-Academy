package apiTest;
/*
	2. Set 계열의 클래스를 이용하여 로또번호를 랜덤메서드를 이용하여 생성하고  
	List 계열의 클래스를 이용하여 정렬하여 출력하는 로또구매 프로그램을 작성하시오.
	- 금액을 입력받아 금액만큼 로또 번호 생성 (금액 1000원 단위 ~100000) 
*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

class Number6 {
	public ArrayList<Integer> getNum() {
		HashSet<Integer> nums = new HashSet<>();
		while(nums.size()<6) {
			nums.add((int)(Math.random()*45+1));
		}
		ArrayList<Integer> num = new ArrayList<>(nums);
		num.sort(null);
		return num;
	}
}

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Number6 n6 = new Number6();

		String paystr;
		int pay = 0;
		boolean esc = false;
		while(true) {
			try {
				System.out.println("구매하실 금액을 입력하세요.");
				paystr = sc.nextLine();
				pay = Integer.valueOf(paystr);
				if(pay>100000||pay<1000) {
					System.out.println("1,000 ~ 100,000 범위의 금액을 입력해 주세요.");
					continue;
				}
				esc = true;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해 주세요.");
			}
			if(esc) {break;}
		}
		sc.close();

		int line = pay / 1000;
		System.out.printf("로또 번호 %d개를 생성합니다.\n",line);
		for(int i=0; i<line; i++) {
			System.out.println(n6.getNum());
		}
	}
}
