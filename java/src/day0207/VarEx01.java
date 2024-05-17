package day0207;

class VarEx01 {
	public static void main(String[] args) {
		//변수 : 하나의 값만을 저장하는 메모리
		//선언 : 데이터타입 변수이름;
		//대입 : 변수이름 = 값;
		int a;	//선언
		a = 10;	//대입
		System.out.println(a);
		//변수 a를 읽는다(사용한다) : 변수 안에 있는 값을 사용한다

		//int a = 10;	변수의 이름은 중복 불가
		
		int dkanrjskdkanrjsk;	// 이름의 길이는 제한 없다.
		dkanrjskdkanrjsk = 20;
		System.out.println(dkanrjskdkanrjsk);

		a = 30;		//대입 또 가능
		System.out.println(a);	//마지막 대입 값이 남는다

		int b;
		b = 200;
		System.out.println(b);
		//System.out.println(a,b); 출력문도 하나의 값만 사용

		int c;	//선언
		c = b;	//대입. 같은 타입이기 대문에 대입 가능. 값의 복사
		System.out.println(c);
	}
}
