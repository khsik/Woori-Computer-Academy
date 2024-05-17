package day0307;

import java.util.Stack;

/*
	Stack 클래스
	- FILO(=LIFO) : First In Last Out
	- 순서대로 쌓임. 인덱스 없음.
	- push() : 넣기
	- peek() : 값 확인 (제거 안함)
	- pop()	 : 값 꺼낸 후 제거
*/

public class StackEx {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();

		st.push("1");
		st.push("2");
		st.push("3");
		System.out.println(st.peek());

		st.pop();
		System.out.println(st.peek());

		st.pop();
		st.pop();
		System.out.println("stack is empty? : " + st.isEmpty());

		st.push("5");
		System.out.println(st.peek());
	}
}
