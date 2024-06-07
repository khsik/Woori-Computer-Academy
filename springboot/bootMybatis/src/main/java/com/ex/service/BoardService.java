package com.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.data.BoardDTO;
import com.ex.repository.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// CRUD
public class BoardService {
	private final BoardMapper boardMapper;
	
	public void boardInsert(BoardDTO boardDTO) {
		int maxNum = boardMapper.maxNum();
		if(boardDTO.getNum() != 0) { // 글번호 있다 -> 답글
			boardMapper.reStepUp(boardDTO);
			boardDTO.setRe_step(boardDTO.getRe_step() + 1);
			boardDTO.setRe_level(boardDTO.getRe_level() + 1);
		}else { // 글번호 없다 -> 새글
			if(maxNum != 1) {
				maxNum++; // 그룹번호(글번호) 겹치지 않게
			}
			boardDTO.setRef(maxNum);
		}
		boardMapper.boardInsert(boardDTO);
	}

	public int boardCount() {
		return boardMapper.boardCount();
	}
	
	public List<BoardDTO> boardList(int start, int end){
		return boardMapper.boardList(start, end);
	}
	
	public BoardDTO boardNum(int num) {
		return boardMapper.boardNum(num);
	}
	
	public void readCountUp(int num) {
		boardMapper.readCountUp(num);
	}
	
	public void boardDelete(int num) {
		boardMapper.boardDelete(num);
	}
	
	public String passwdNum(int num) {
		return boardMapper.passwdNum(num);
	}
	
	public void boardUpdate(BoardDTO boardDTO) {
		boardMapper.boardUpdate(boardDTO);
	}
}
