package com.example.sbst.board;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReplyService {

	private ReplyRepository replyRepository;
	
	public List<Reply> getReply(Board board){
		List<Reply> list = this.replyRepository.findByBoard(board);
		return list;
	}
	
}
