package day0208;

class OperEx15 {
	public static void main(String[] args) {
		//피연산자 중 문자열이 있으면 문자열로 결합
		
		String str1 = "JDK"+6.0;
		String str2 = str1 + " 특징";
		System.out.println(str2);

		String str3 = "JDK" + 3 + 3.0;	//문자열 먼저 나와서 숫자도 바로 문자열로 취급
		String str4 = 3 + 3.0 + "JDK";	//숫자가 먼저 나와서 연산하고 나서 문자열로 취급
		System.out.println(str3);
		System.out.println(str4);
	}
}
