package com.example.sbst.board;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.sbst.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public Page<Board> getList(int currentPage){
		int pageSize = 10;
		Sort sort = Sort.by(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
		Page<Board> list = this.boardRepository.findAll(pageable);
		return list;
	}

	public Board getBoard(Integer id) {
		Optional<Board> board = this.boardRepository.findById(id);
		if(board.isEmpty()) {
			throw new DataNotFoundException("invalid board id");
		}
		return board.get();
	}
	
	public Integer saveBoard(List<MultipartFile> imgList, BoardForm boardForm) {

		Board board = new Board();
		board.setContent(boardForm.getContent());
		board.setTitle(boardForm.getTitle());
		board.setWriter(boardForm.getWriter());
		board.setReg(LocalDateTime.now());

		// board에서는 imgs -> img로 받아온 후 있으면 업로드하고 board.setImgs() 해야됨.
		if(!imgList.isEmpty()) { // 받아온 이미지가 있다면
			List<String> imgs = new ArrayList<>();
			String uploadPath = new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\upload\\";
			for(MultipartFile mf : imgList) {
				if(mf.getContentType().startsWith("image")) { // 이미지만 업로드
					String uuid = UUID.randomUUID().toString().replace("-", "");
					String name = mf.getOriginalFilename();
					File copy = new File(uploadPath + uuid + name);
					try {
						mf.transferTo(copy);
						imgs.add(copy.getName());
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
			board.setImgs(imgs);
		}
		
		Integer id = this.boardRepository.save(board).getId();
		return id;
	}
}
