package com.example.ex.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.ex.customException.DataNotFoundException;
import com.example.ex.member.Member;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public Board getBoard(long num) {
		Optional<Board> _board = this.boardRepository.findById(num);
		if(_board.isEmpty()) {
			throw new DataNotFoundException("존재하지 않는 게시글 입니다.");
		}
		return _board.get();
	}
	
	private Specification<Board> search(String search){ // 검색 조건 설정. 게시글의 제목, 내용, 작성자.
		return new Specification<Board>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Board> boards, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Join<Board, Member> member = boards.join("writer", JoinType.LEFT);
				return cb.or(
						cb.like(boards.get("title"), "%"+search+"%"),
						cb.like(boards.get("content"), "%"+search+"%"),
						cb.like(member.get("id"), "%"+search+"%")
						);
			}
		};
	}
	
	public Page<Board> getPaging(int page, String search){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("boardId"));
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(sorts));
		Specification<Board> spec = search(search);
		return this.boardRepository.findAll(spec, pageable);
	}
	
	public long save(BoardForm boardForm, Member member) {
		Board board = new Board();
		board.setWriter(member);
		board.setCreateDate(LocalDateTime.now());
		board.setTitle(boardForm.getTitle());
		board.setContent(boardForm.getContent());
		
		this.boardRepository.save(board);
		return board.getBoardId();
	}
}
