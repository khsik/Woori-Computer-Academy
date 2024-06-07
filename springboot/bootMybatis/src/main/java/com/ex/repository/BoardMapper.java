package com.ex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ex.data.BoardDTO;

@Repository
@Mapper
public interface BoardMapper {
	public int maxNum();
	public void reStepUp(BoardDTO boardDTO);
	public int boardInsert(BoardDTO boardDTO);
	public int boardCount();
	public List<BoardDTO> boardList(@Param("start") int start, @Param("end") int end);
	public void readCountUp(int num);
	public BoardDTO boardNum(int num);
	public String passwdNum(int num);
	public void boardUpdate(BoardDTO boardDTO);
	public void boardDelete(int num);
}
