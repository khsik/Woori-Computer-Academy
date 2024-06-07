package com.ex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ex.data.MyTestDTO;

// @Controller, @Service, @Component, @RestController, @Configuration 등
// 해당 어노테이션이 지정된 클래스는 의존성 주입(DI)이 가능하다.
@Repository // DB 및 데이터 관련 작업을 하는 클래스 (DAO와 같은 역할)
@Mapper // MyBatis에서 인터페이스가 SQL 매퍼 인식 - *.xml과 연결된다
public interface TestMapper {
	// 회원 가입
	public int mytestInsert(MyTestDTO myTestDTO);
	
	// 로그인
	public int loginCheck(@Param("username") String username, @Param("password") String password);
	
	// 전체 회원 정보
	public List<MyTestDTO> userInfo();
	
	// 내 정보
	public MyTestDTO myInfo(String username);
	
	// 회원 탈퇴
	public int mytestDelete(String username);
	
	// 정보 수정
	public void myInfoUpdate(MyTestDTO myTestDTO);
}
