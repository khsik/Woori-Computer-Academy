package com.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ex.data.BoardDTO;
import com.ex.service.BoardService;

@SpringBootTest
class BootMybatisApplicationTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	void insertBoards() {
		BoardDTO dto = new BoardDTO();
		dto.setWriter("ㅇㅇ");
		dto.setPasswd("123");
		dto.setContent("냉무");
		for(int i=1; i<=300; i++) {
			dto.setTitle(String.format("게시글 늘리기 %d", i));
			
			boardService.boardInsert(dto);
		}
	}

}
