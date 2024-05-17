package mvc.board.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.board.model.BoardDAO;
import mvc.board.model.BoardDTO;
import mvc.test.action.SuperAction;

public class WriteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// 첫줄에 인코딩 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String filePath = request.getServletContext().getRealPath("resources/upload");
		int max = 10 * 1024 * 1024;
		String enc = "UTF-8";
		DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy();
		try {
			MultipartRequest mr = new MultipartRequest(request, filePath, max, enc, dp);
			
			// dto 객체 생성
			BoardDTO dto = new BoardDTO();
			dto.setNum(Integer.parseInt(mr.getParameter("num")));
			dto.setWriter(mr.getParameter("writer"));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setPasswd(mr.getParameter("passwd"));
			dto.setRef(Integer.parseInt(mr.getParameter("ref")));
			dto.setRe_step(Integer.parseInt(mr.getParameter("re_step")));
			dto.setRe_level(Integer.parseInt(mr.getParameter("re_level")));
			dto.setImg(mr.getFilesystemName("img"));
			
			// 조회수 readcount는 글 내용 볼 때 +1. 여기서 설정 필요 x
			// 작성날짜reg는 메서드에서 sysdate로 넣어둬서 안해도됨.
			// dto.setReg(new Timestamp(System.currentTimeMillis()));
			
			// DB 처리
			BoardDAO dao = BoardDAO.getInstance();
			int result = dao.boardInsert(dto);
			
			// 해당 뷰에서 사용할 속성
			request.setAttribute("result", result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return "/WEB-INF/views/board/writePro.jsp";
	}

}
