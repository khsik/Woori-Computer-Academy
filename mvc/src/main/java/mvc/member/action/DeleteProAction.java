package mvc.member.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.member.model.MemberDAO;
import mvc.member.model.MemberDTO;
import mvc.test.action.SuperAction;

public class DeleteProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession sessison = request.getSession();
		String sid = (String)sessison.getAttribute("sid");
		String pw = request.getParameter("pw");

		MemberDTO dto = new MemberDTO();
		dto.setId(sid);
		dto.setPw(pw);

		MemberDAO dao = new MemberDAO();
		int result = dao.deleteMember(dto);
		if(result == 1) {
			sessison.invalidate();
		}
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/member/deletePro.jsp";
	}
	
}
