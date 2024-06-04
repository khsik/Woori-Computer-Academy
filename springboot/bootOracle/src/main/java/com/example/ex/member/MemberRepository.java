package com.example.ex.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

	// email로 member 검색
	Optional<Member> findByEmail(String eamil);
}
