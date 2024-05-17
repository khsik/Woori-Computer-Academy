package day0214;

class BreakEx03 {
	public static void main(String[] args) {
		// 중첩 반복문 속 break문
		int a, b;
		for(a=1; a<=5; a++){
			for(b=1; b<=5; b++){
				if(b==3){break;}		//반복문이 중첩되있으면 break는 가장 가까운 반복문만 종료함.
				System.out.println(a+"  "+b);
			}
		}
	}
}
