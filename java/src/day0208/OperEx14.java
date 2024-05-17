package day0208;

class OperEx14 {
	public static void main(String[] args) {
		byte b = (byte)(100+30);	//byte -128~127
		System.out.println(b);		//130이 아닌 -126나옴. 127 128 129 130가 아니고 127 -128 -127 -126
									//	Overflow현상

		int i = 100000*100000;	//100억. int범위는 대충 21.47억
		System.out.println(i);
			
		long l = 100000*100000L;	//int범위 벗어나는 숫자에는 식별자 L을 사용한다.
									//소문자 l도 쓸 수 있지만, 숫자1과 헷갈리니까 지양하고 대문자 L 사용을 권장.
		System.out.println(l);
	}
}
