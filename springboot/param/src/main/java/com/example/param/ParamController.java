package com.example.param;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/param/*")
@Log4j2
public class ParamController {
/*
	로그 레벨
	( TRACE < DEBUG < INFO < WARN < ERROR < FATAL )
*/	
	
	@GetMapping("form")
	public String form() {
		log.trace("[trace] url-/param/form");
		log.debug("[debug] url-/param/form");
		log.info("[info] url-/param/form");
		log.warn("[warn] url-/param/form");
		log.error("[error] url-/param/form");
		log.fatal("[fatal] url-/param/form");
		
		return "form";
	}
	
	@PostMapping("ex01")
	public String ex01(Member member) { // member 객체가 자동으로 view 페이지로 전달됨
		log.info("ex01 -- parameter id : "+member.getId());
		log.info("ex01 -- parameter pw : "+member.getPw());
		
		return "ex01";
	}
	
	@PostMapping("ex02")
	public String ex02( 
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model
			)	// @RequestParam() = request.getParameter()
				// @RequestParam()로 받아오면 view 페이지에자동으로 전달 x 
	{
		log.info("ex2 --> parameter id : "+id);
		log.info("ex2 --> parameter pw : "+pw);
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
 		
		return "ex02";
	}
	
	@PostMapping("ex03")
	public String ex03(
			@RequestParam("hobbies") List<String> hobbies,
			@RequestParam("hobbies") String[] arr,
			Model model
			) 
	{
		log.info("ex03 --> parameter hobbies : "+hobbies);
		log.info("ex03 --> parameter hobbies : "+Arrays.asList(arr));
		
		model.addAttribute("hobbies", hobbies);
		model.addAttribute("arr", arr);
		
		return "ex03";
	}
	
	@PostMapping("ex04")
	public String ex04(Model model, @ModelAttribute("id") String id) {
		// @ModelAttribute 사용하면 파라미터를 뷰까지 전달가능
		// 여기서는 뷰에서 ${id} 바로 사용 가능
		// @RequestParam, Model이 합쳐진 기능
		log.info("ex04 -- parameter id : "+id);
		
		return "ex04";
	}
	
	@PostMapping("ex05")
	public String ex05(@RequestParam("id") String id, RedirectAttributes rttr) {
		// RedirectAttributes
		// 일회성 데이터 전달시 사용 - 브라우저에 한번만 사용 된다. 새로고침하면 없어진다.
		log.info("ex05 -- parameter id : "+id);
		rttr.addFlashAttribute("id", id);
		rttr.addFlashAttribute("pw", "1234");

		// redirect로 이동 시 뷰로 가는것이 아니라
		// 해당 매핑으로 GET 방식으로 이동한다.
		return "redirect:ex05"; // @GetMapping("ex05") 으로 이동한다.
	}

	@GetMapping("ex05")
	public String ex05() {
		return "ex05";
	}

	@GetMapping("ex06")
	public @ResponseBody String ex06() {
		// @ResponseBody view 이동 안함.
		// return되는 객체를 바로 화면에 보여줌.
		return "Hello Parameter"+"<h1>hello param</h1>";
	}
	
	@GetMapping("ex07")
	@ResponseBody
	public Member ex07() {
		Member dto = new Member();
		dto.setId("java");
		dto.setPw("boot");
		
		return dto; // 데이터가 json 파일로 전달됨
	}
	
	@GetMapping("ex08")
	public ResponseEntity<String> ex08(){
		// ResponseEntity Http의 응답을 표현하는 클래스, 상태 코드, 헤더
		
		String msg = "{\"name\":\"춘식이\"}"; // K:V
		// 이스케이프 문자 \
		// json 방식 {"키":"밸류", "키2":밸류2, ...}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<>(msg, header, HttpStatus.OK); // HttpStatus.OK 대신 그냥 200 써도 됨.
	}

	@PostMapping("ex09")
	public String ex09(@RequestParam("save") MultipartFile mf, @ModelAttribute("id") String id, Model model) {
		// 파일 업로드 시 MultipartFile 객체 사용 -> 업로드 직접 해줘야한다.
		// 파일 이름 중복처리 기능이 없다.
		// c드라이브 upload 폴더
		model.addAttribute("contentType", mf.getContentType());
		model.addAttribute("orgName", mf.getOriginalFilename());
		model.addAttribute("fileSize", mf.getSize());
		
		File copy = new File("C:/upload/"+mf.getOriginalFilename());
		try {
			mf.transferTo(copy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ex09";
	}
	
	@PostMapping("ex10")
	public String ex10( // 다중 업로드
			@RequestParam("save") List<MultipartFile> files,
			@ModelAttribute("id") String id,
			Model model
			)
	{
		// 다중 업로드 시 List 받아서 처리할 수 있다.
		for(MultipartFile mf : files) {
//			log.info("=====================");
//			log.info("name - "+mf.getName());
//			log.info("orgFileName - "+mf.getOriginalFilename());
			File copy = new File("c:/upload/"+mf.getOriginalFilename());
			try {
				if(mf.getContentType().split("/")[0].equals("image")) {	// mf.getContentType().startsWith("image") 써도 될거같음.
					mf.transferTo(copy);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileCount", files.size());
		
		return "ex10";
	}
	
	@PostMapping("ex11")
	public String ex11(@RequestParam("save") MultipartFile mf, Model model) { // 파일 이름 처리
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		String rn = Integer.toString(random.nextInt(Integer.MAX_VALUE));
		// .nextInt(int bound) 랜덤값이 int로 나오게 하는 메서드, 0 ~ bound 사이의 랜덤값.
		
		String ts = df.format(new Date());
		// 현재 시간 df(포맷) 적용
		
		String uploadFileName = ts+rn+mf.getOriginalFilename();
		
		File copy = new File("c:/upload/"+uploadFileName);
		try {
			mf.transferTo(copy);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("orgName", mf.getOriginalFilename());
		model.addAttribute("uploadFileName", uploadFileName);
		
		return "ex11";
	}

	@PostMapping("ex12")
	public String ex12(@RequestParam("save") MultipartFile mf, HttpServletRequest request, Model model) {
		// 네트워크 UUID 활용한 파일 이름 설정
		// UUID : Universally Unique IDentifier
		// 네트워크 고유한 식별자를 생성하는 표준 방식
		// 예시) 550e8400-e29b-41d4-a716-446655440000
		// 파일 명에 - 있으면 읽지 못하는 경우 => replace 사용
		String sysName = UUID.randomUUID().toString().replace("-","")+mf.getOriginalFilename();
		String uploadPath = new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\upload\\";
		log.info(uploadPath);
		
		File copy = new File(uploadPath + sysName);
		try {
			mf.transferTo(copy);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("sysName", sysName);
		
		return "ex12";
	}
	
	@GetMapping("display")
	public ResponseEntity<Resource> display(@RequestParam("fileName") String fileName){
		String path = new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\upload\\";
		
		// 파일 읽어오기
		Resource re = new FileSystemResource(path+fileName);
		
		if(!re.exists()) { // 파일 없으면
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		// 응답 이미지 정보를 설정하기 위한 객체
		HttpHeaders head = new HttpHeaders();
		Path filePath = null;
		
		// 파일의 MIME 타입을 결정하기 위해 Path 클래스로 변환
		// 웹에서 사용하는 모든 파일 타입을 통틀어서 MIME 타입이라고 한다.
		filePath = Paths.get(path);
		try {
			head.add("content-type",Files.probeContentType(filePath));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(re, head, HttpStatus.OK);
	}
	
}
