package mvc.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// main.jsp 에서 실행될 java 내용 부분
		// dao, dto 등
		return "/WEB-INF/views/test/main.jsp";
	}
	
}
// http://localhost:8080/mvc/WEB-INF/views/member/main.jsp
// WEB-INF는 브라우저에서 직접 접근할 수 없음.