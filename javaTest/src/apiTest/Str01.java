package apiTest;
/*
	1. 매개변수로 받은 문자열에서 각 단어의 첫 번째 글자만 대문자로 변환하여
		리턴하는 initcap() 메서드를 구현하시오. 
*/
public class Str01 {
	public static String initcap(String str) {
		char[] arr = str.toCharArray();
		if(arr[0] >= 'a' && arr[0] <= 'z') {
			arr[0] -= 32;
		}
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] == ' ' && arr[i] >= 'a' && arr[i] <= 'z') {
				arr[i] -= 32;
			}
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		String a = "u p   d o w n";
		String b = "java spring";
		a = initcap(a);
		b = initcap(b);
		System.out.println(a);
		System.out.println(b);
	}
}
