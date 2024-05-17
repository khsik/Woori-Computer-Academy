package mvc.test.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.test.action.SuperAction;

public class HelloController extends HttpServlet {
	// properties 타입은 Map 타입
	private Map<String, SuperAction> map = new HashMap<>();
	
	// init() : 서버 실행 후 요청시의 최초 한번만 동작하는 메서드
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertiesPath = config.getInitParameter("commandURI");
		Properties p = new Properties();	// .properties 파일 내용 K=V 형태로 읽음
		FileInputStream f = null;
		
		try {
			f = new FileInputStream(propertiesPath);	// FileNotFoundException
			p.load(f);	// IOException
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(f != null) {	try{f.close();}catch(Exception e) {} }
		}
		
		Iterator<Object> iter = p.keySet().iterator();	// key만 꺼냄. value는 class 풀네임 -> 객체생성

		// properties 파일의 value 부분을 반복적으로 꺼내 객체생성 후 map 대입
		while(iter.hasNext()) {
			String key = (String)iter.next();
			String value = p.getProperty(key);
			try {
				Class c = Class.forName(value);
				SuperAction action = (SuperAction)c.newInstance();
				// newInstance() 대신 권장하는 방식
				// c.getDeclaredConstructor().newInstance();
				map.put(key, action);	// 여기서 value는 객체 
			} catch (ClassNotFoundException e) {	// Class.forName
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {	// c.newInstance
				e.printStackTrace();
			}
		}
	}

	// doXX, service : 요청이 들어올 때마다 실행하는 메서드
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// properites의 key : uri
		String uri = request.getRequestURI();

		// 모든 Action 클래스는 SuperAction을 구현한다.
		// 다형성 (조상 타입에 대입)
		SuperAction sa = map.get(uri);	// init 에서 대입된 객체 꺼낸다.
		String view = sa.action(request, response);	// action 메서드 호출

		// map.containsKey(uri); 이용해서 if문 작성하면
		// 없는 uri 접근시의 처리 가능

		// view로 이동
		request.getRequestDispatcher(view).forward(request, response);
		
		return;
	}
	
/*
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if - else if : 요청 uri에 맞는 view로 이동
		String uri = request.getRequestURI();
		String view = "";
		if(uri.equals("/mvc/ccc/login.do")) {
			// dao, dto 등 호출
			// 여러 코드들 작성
			request.getParameter("");
			view = "/ccc/login.jsp";
		}else if(uri.equals("/mvc/ccc/list.do")) {
			view = "/ccc/list.jsp";
		}else {
			view = "/mvc/ccc/main.jsp";
		}
	}
*/
/*
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 실행 : " + request.getRequestURI());
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>Hello Controller</h1>");
		out.write("</body>");
		out.write("</html>");
		out.flush();
		out.close();
		
		// request.getRequestDispatcher("test.jsp");
		request.getRequestDispatcher("test.jsp").forward(request, response);
		return;
	}
*/
	
/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
*/
}
