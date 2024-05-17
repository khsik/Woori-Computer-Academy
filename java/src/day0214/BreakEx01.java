package day0214;

class BreakEx01 {
	public static void main(String[] args) {
/*		
		break문
		break문을 만나면 그 지점에서 더이상 수행하지 않고
		반복문을 빠져나온다.
*/
		// (1~num의 합) sum의 값이 100 이상이 될 때 num값
		// ForEx08 에서는 num이 14가 아닌 15 나옴 (if, break 없이 for문만 사용)
		int sum = 0;
		int num = 0;
		for(num=0; ; num++){		//조건식 대신 if와 break 사용
			sum+=num;
			if(sum>=100){
				break;
			}
		}
		System.out.println(num);
		System.out.println(sum);
	}
}
