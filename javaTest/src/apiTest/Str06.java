package apiTest;
/*
	6. 한 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하여 문자열 출력
	단, 모든 문자열은 알파벳 대문자로 주어지고 반복횟수가 1인 경우는 생략
	입력 : KKHSSSSSSSE
	출력 : K2HS7E
*/
public class Str06 {
	public static void sn(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		int n = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			while (str.charAt(i) == str.charAt(n)) {
				count++;
				i++;
			}
			if (count != 1) {
				sb.append(count);
			}
			sb.append(str.charAt(i));
			count = 1;
			n = i;
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		String str = "KKHSSSSSSSE";
		sn(str);
	}
}
