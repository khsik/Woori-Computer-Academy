package com.example.sbst.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
	private final BoardService boardService;
	private final ReplyService replyService;

	@GetMapping("list")
	public String boardList(Model model) {
		List<Board> boardList = this.boardService.getList();
		model.addAttribute("boardList", boardList);
		return "/board/boardList";
	}

	@GetMapping("content/{id}")
	public String boardContent(Model model, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
		List<Reply> replyList = this.replyService.getReply(board);
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		
		return "/board/boardContent";
	}

	@GetMapping("write")
	public String boardWrite(Model model) {
		return "/board/boardWrite";
	}
	
	@PostMapping("doWrite")
	public String boardDoWrite(@RequestParam("img") List<MultipartFile> imgList, Board board) {
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
		
		Integer id = this.boardService.saveBoard(board).getId();
		return "redirect:/board/content/"+id;
	}
	
	@GetMapping("images")
	public String images(@RequestParam("imgName") String imgName) {
		
		
		return "";
	}
}
