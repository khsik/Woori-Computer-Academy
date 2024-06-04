package com.example.ex.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex.member.Member;

public interface BoardRepository extends JpaRepository<Board, Long> {

	// 게시글 목록. 검색, 페이지 처리
	Page<Board> findAll(Specification<Board> spec, Pageable pageable);
	
	// 특정 회원의 글 검색
	List<Board> findByWriter(Member writer);
}
