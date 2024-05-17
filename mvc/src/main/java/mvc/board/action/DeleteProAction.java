package mvc.board.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.board.model.BoardDAO;
import mvc.test.action.SuperAction;

public class DeleteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		

		String sid =  request.getParameter("sid");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");

		BoardDAO dao = BoardDAO.getInstance();
		String[] result = dao.boardDelete(num, sid, passwd);
		
		if(result[1] != null) {
			String filePath = request.getServletContext().getRealPath("resources/upload");
			File f = new File(filePath + "/" + result[1]);
			f.delete();
		}
		
		request.setAttribute("result", result[0]);
		request.setAttribute("pageNum", pageNum);
		
		return "/WEB-INF/views/board/deletePro.jsp";
	}

}
