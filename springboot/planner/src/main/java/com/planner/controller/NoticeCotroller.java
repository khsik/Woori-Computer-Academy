package com.planner.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.planner.dto.request.admin.NoticeDTO;
import com.planner.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class NoticeCotroller {
	private final NoticeService noticeService;
	// 관리자 메인 페이지 
	@GetMapping("/main")
	public String adminMain() {
		return "/admin/adminMain";
	}
	// 공지사항 게시물 페이지 
	@GetMapping("/notice")
	public String notice(Model model,NoticeDTO noticeDTO,
			@RequestParam(name = "ps", defaultValue = "10") int pageSize,
			@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
		int noticeListCount = noticeService.noticeAllSelect();
		List<NoticeDTO>noticeList =  noticeService.noticeSelect(pageNum, pageSize);
		int pageBlock = 10;
		int startPage = ((pageNum - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int totalPage = noticeListCount / pageSize + (noticeListCount % pageSize == 0 ? 0 : 1);
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeListCount", noticeListCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ps", pageSize);
		return "/admin/notice";
	}
	// 공지사항 글 작성 하는 페이지 
	@GetMapping("/noticeWrite")
	public String noticeWriteForm() {
		return "/admin/noticeWrite";
	}
	// 공지사항 글 쓴거 넘겨서받는 페이지 
	@PostMapping("/notice")
	public String noticePro(NoticeDTO noticeDTO) {
		noticeService.noticeInsert(noticeDTO);
		return "redirect:/admin/notice";
	}
	// 공지사항 상세 페이지 
	@GetMapping("/noticeContent/{notice_id}")
	public String noticeContent(@PathVariable("notice_id") Long notice_id,Model model) {
		NoticeDTO noticeDTO = noticeService.noticeContent(notice_id);
		model.addAttribute("noticeDTO", noticeDTO);
		return "/admin/noticeContent";
	}
	// 공지사항 수정 form 페이지 
	@GetMapping("/noticeUpdateForm/{notice_id}")
	public String noticeUpdateForm(@PathVariable("notice_id") Long notice_id,Model model) {
		NoticeDTO noticeDTO = noticeService.noticeContent(notice_id);
		model.addAttribute("noticeDTO", noticeDTO);
		return "/admin/noticeUpdate";
	}
	// 공지사항 수정 pro 페이지
	@PostMapping("/noticeUpdatePro")
	public String noitceUpdate(NoticeDTO noticeDTO) {
		noticeService.noticeUpdate(noticeDTO);
		return "redirect:/admin/noticeContent/"+noticeDTO.getNotice_id();
	}
	
	// 공지사항 삭제 페이지 
	@GetMapping("/noticeDelete/{notice_id}")
	public String noticeDelete(@PathVariable("notice_id") Long notice_id) {
		noticeService.noticeDelete(notice_id);
		return "redirect:/admin/notice" ;
	}
	
	/*이미지 업로드*/
	@PostMapping("/upload/img")
	@ResponseBody
	public String imgUpload(@RequestParam(value = "file")MultipartFile multipartFile) throws IllegalStateException, IOException {
		String imageName = noticeService.imgUpload(multipartFile);
		return imageName;
	}
	
	/*이미지 삭제*/
	@DeleteMapping("/img/delete")
	@ResponseBody
	public ResponseEntity<String> deleteImg(@RequestParam(value = "imgName")String imgName){
		noticeService.deleteImg(imgName);
		return ResponseEntity.ok("ok");
	}
}