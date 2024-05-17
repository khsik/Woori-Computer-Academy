package day0207;

public class VarEx03 {
	public static void main(String[] args) {
/*
	기본 타입 (8개)
	정수형
		byte	: -128 ~ 127
		short	: -32,000 ~ 32,000
		char	: 한 글자의 문자 표현, ''(작은따옴표 사용), 아스키코드표
		int		: -21억 ~ 21억
		long	: 2의 63승-1
	실수형(최소 한자리의 소수점 가진다)
		float	: 약 소수점 7자리정도 표현
		double	: 16자리까지 표현
	논리형
		boolean	: 결과가 true/false


	참조타입
	문자형
		String	: ""(큰따옴표)사용, 공백도 문자
*/		


	byte b1 = -128;
	byte b2 = -30;
	byte b3 = 0;
	byte b4 = 30;
	//byte b5 = 128;
	System.out.println(b1);
	System.out.println(b2);
	System.out.println(b3);
	System.out.println(b4);

	byte b6 = 20;
	short s1 = 10;
	System.out.println( b6 + s1 );
	}
}