package day0214;

class ForEx05 {
	public static void main(String[] args) {
		// for 구구단
		for(int a=2; a<=9; a++){
			String c;
			for(int b=1; b<10; b++){
				c = a+"x"+b+" = "+(a*b)+"  ";
				System.out.print(c);
				if(a*b<10){System.out.print(" ");}
			}
			System.out.println();
		}
		System.out.println();

		for(int c=1; c<10; c++){
			for(int d=2; d<10; d++){
				System.out.print(d+"x"+c+" = "+(c*d)+"  ");
				if(c*d<10){System.out.print(" ");}
			}
			System.out.println();
		}
		System.out.println();

		for(int x=2; x<=9; x++){
			for(int y=1; y<10; y++){
				System.out.println(x+"x"+y+" = "+(x*y));
			}
			System.out.println();
		}
		System.out.println("================\n");
	
		// while 구구단
		int dan=2;			//여기서 num을 선언과 초기화를 하면 바깥쪽 while 안에서 num=1;이 있어야 한다.
		while(dan<10){		//없으면 dan=3부터 num=10인 상태 그대로라. 내부의 while이 계속 false가 된다.
			int num=1;
			while(num<10){
				System.out.println(dan+" x "+num+" = "+(dan*num));
				num++;
			}
			System.out.println();
			dan++;
		}

	}
}
