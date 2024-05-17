package day0207;

class VarEx06 {
	public static void main(String[] args) {
		//실수형  float < double	 float 소수점6자리   double 소수점15자리 정밀도도 차이난다.
		double d = 3.14;
		float f = 3.14f;		//식별자 F, f를 붙여준다
		System.out.println(d);
		System.out.println(f);

		double d2 = f;
		System.out.println(d2);
	}
}
