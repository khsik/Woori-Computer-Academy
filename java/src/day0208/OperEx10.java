package day0208;

class OperEx10 {
	public static void main(String[] args) {
		int num = 10;
		int a = 2;
		boolean result = ((num = num+10) < 10) && ((a = a+2)<10);	//20<10 false
		//					num+=10					a+=2
		System.out.println(result);	//false
		System.out.println(num);	//20
		System.out.println(a);		//2		result에서 false가 먼저 나와서 &&는 어차피 false니까 뒤쪽 연산을 안함.
		
/*
		int b = 5;
		boolean re = a>0||b++==5;	// a>0이 true라 || 뒤쪽의 값이 상관없어서 연산없이 넘어감
		System.out.println(re); //true
		System.out.println(b);	//5
*/
/*
		int c = 7;
		boolean re2 = a<0 || (c+=3)>=10;
		System.out.println(re2);	//true
		System.out.println(c);		//10
*/
	}
}
