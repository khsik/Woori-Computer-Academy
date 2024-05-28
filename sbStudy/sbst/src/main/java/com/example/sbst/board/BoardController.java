package com.example.sbst.board;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
	private final BoardService boardService;
	private final ReplyService replyService;

	@GetMapping("/")
	public String main() {
		return "redirect:list";
	}

	// 목록
	@GetMapping("list")
	public String boardList(Model model, @RequestParam(value = "page", defaultValue = "0") int currentPage) {
		Page<Board> page = this.boardService.getList(currentPage);
		model.addAttribute("page", page);
		return "/board/boardList";
	}

	// 내용
	@GetMapping("content/{id}")
	public String boardContent(Model model, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
		List<Reply> replyList = this.replyService.getReply(board);
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		
		return "/board/boardContent";
	}

	// 글작성
	@GetMapping("write")
	public String boardWrite(Model model) {
		return "/board/boardWrite";
	}

	// 작성된 글 업로드
	@PostMapping("write")
	public String boardDoWrite(@RequestParam("img") List<MultipartFile> imgList
			,@Valid BoardForm boardForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/board/boardWrite";
		}

		Integer id = this.boardService.saveBoard(imgList, boardForm);
		return "redirect:/board/content/"+id;
	}

	// 이미지 경로
	@GetMapping("images")
	public ResponseEntity<Resource> images(@RequestParam("imgName") String imgName) {
		String path = new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\upload\\";
		
		Resource re = new FileSystemResource(path+imgName);
		
		if(!re.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders httpHead = new HttpHeaders();
		
		try {
			httpHead.add("content-type", Files.probeContentType(re.getFile().toPath()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(re, httpHead, HttpStatus.OK);
	}
}
