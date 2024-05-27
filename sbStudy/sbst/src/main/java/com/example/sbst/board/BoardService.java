package com.example.sbst.board;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.sbst.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public List<Board> getList(){
		List<Board> list = this.boardRepository.findAll();
		return list;
	}

	public Board getBoard(Integer id) {
		Optional<Board> board = this.boardRepository.findById(id);
		if(board.isEmpty()) {
			throw new DataNotFoundException("invalid board id");
		}
		return board.get();
	}
	
	public Board saveBoard(Board write) {
		Board board = this.boardRepository.save(write);
		return board;
	}
}
