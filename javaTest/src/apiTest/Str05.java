package apiTest;
/*
	5. 주어진 문자열에서 순서를 유지한 상태로 중북된 문자열을 제거한 결과를 출력하기
	문자열은 소문자로 주어짐
	입력 : ksekkset
	출력 : kset
*/
public class Str05 {
	public static String removeRepeat(String str) {
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			boolean rp = true;
			for(int j=i-1; j>=0; j--) {
				if(arr[j] == arr[i]) {
					rp = false;
					break;
				}
			}
			if(rp) {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "ksekkset";
		String str2 = removeRepeat(str);

		System.out.println(str);
		System.out.println(str2);
	}
}
