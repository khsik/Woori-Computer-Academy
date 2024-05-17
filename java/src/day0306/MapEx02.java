package day0306;

import java.util.HashMap;
import java.util.Scanner;

public class MapEx02 {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("java", "1234");
		hm.put("vue", "g98");
		hm.put("log4j", "1234");
		hm.put("log4j", "4444");
		System.out.println(hm);

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("계정을 입력하세요.");
			String id = sc.nextLine().trim();
			System.out.println("비밀번호를 입력하세요.");
			String pw = sc.nextLine().strip();
			if(!hm.containsKey(id)) {
				System.out.println("존재하지 않는 계정 입니다.\n");
				continue;
			}
			if(!pw.equals(hm.get(id))) {
				System.out.println("비밀번호가 일치하지 않습니다.\n");
				continue;
			}
			System.out.println("로그인 되었습니다.");
			break;
		}
		sc.close();
	}
}
