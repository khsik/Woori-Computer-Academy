package apiTest;
/*
	7. 문자와 숫자가 섞여있는 문자열 중 숫자만 추출하여 주어진 순서대로 자연수를 출력
		"tge0a1h205er"가 주어지면 숫자만 추출된이것의 자연수는 1205
		입력 : g0en2T0s8eSoft
		출력 : 208
*/
public class Str07 {
	public static int onlyNum(String str) {
		return Integer.valueOf(str.replaceAll("[^0-9]", ""));
	} // 정규식 안쓰고 할거면 toCharArray로 분리, '0' ~ '9' 크기비교
	  // String(혹은StringBuilder)에 더하고 마지막에 Integer 통해서 타입 변환

	public static void main(String[] args) {
		String str = "tge0a1h205er";
		String str2 = "g0en2T0s8eSoft";

		System.out.println(onlyNum(str));
		System.out.println(onlyNum(str2));
	}
}
