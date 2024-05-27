package com.example.sbst.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	public List<Reply> findByBoard(Board board);
}
