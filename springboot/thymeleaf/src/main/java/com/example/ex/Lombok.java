package com.example.ex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class Lombok {

	private String name;
	private int age;
	
	@NonNull
	private String test;
}
/*

@Getter	: set() 메서드 자동으로 생성
@Setter	: get() 메서드 자동으로 생성
@ToString	: 객체의 toString() 메서드를 자동으로 생성
@EqualsAndHashCode	: 객체의 equals() , hashCode() 메서드를 자동으로 생성.
@NoArgsConstructor	: 매개변수가 없는 기본 생성자를 생성
@AllArgsConstructor	: 모든 변수를 매개변수로 받는 생성자를 생성
@RequiredArgsConstructor	: 클래스에 대한 매개변수가 있는 생성자를 생성.
							final, @NonNull 표시된 변수만 매개변수로 사용한다. 
@Builder	: 빌더 패턴을 자동으로 생성
@Data	: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode 한번에 사용한다

*/