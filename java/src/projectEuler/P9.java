package projectEuler;
/*
세 자연수 a, b, c 가 피타고라스 정리 a2 + b2 = c2 를 만족하면 피타고라스 수라고 부릅니다 (여기서 a < b < c ).
예를 들면 32 + 42 = 9 + 16 = 25 = 52이므로 3, 4, 5는 피타고라스 수입니다.

a + b + c = 1000 인 피타고라스 수 a, b, c는 한 가지 뿐입니다. 이 때, a × b × c 는 얼마입니까?
*/
// Math.sqrt(); 제곱근
// Math.pow(double a, double b); 제곱 a^b
public class P9 { // 완료
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		double c = 0;
		while(a+b+c!=1000) {
			a=1;
			b++;
			while(a<b) {
				c = Math.sqrt((a*a + b*b));
				if(c==(int)c) {break;}
				a++;
			}
		}
		System.out.println(String.format("a=%d, b=%d, c=%d", a, b, (int)c));
		System.out.println("a*b*c = " + a*b*(int)c);
	}
}
