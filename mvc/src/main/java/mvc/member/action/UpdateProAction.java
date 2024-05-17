package mvc.member.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.member.model.MemberDAO;
import mvc.member.model.MemberDTO;
import mvc.test.action.SuperAction;

public class UpdateProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		
		MemberDTO dto = new MemberDTO();
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setPhone1(request.getParameter("phone1"));
		dto.setPhone2(request.getParameter("phone2"));
		dto.setId(sid);
		
		MemberDAO dao = new MemberDAO();
		dao.updateMember(dto);
		
		return "/WEB-INF/views/member/updatePro.jsp";
	}

}
