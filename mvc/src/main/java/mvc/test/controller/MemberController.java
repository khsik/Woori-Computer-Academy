package mvc.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
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

public class MemberController extends HttpServlet {

	// properties 파일은 map 타입
	private Map<String, SuperAction> map = new HashMap<>();

	// init() : 요청 시 최초 한번 동작
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertiesPath = config.getInitParameter("memberURI");

		// Key와 Value로 읽기 위함
		Properties p = new Properties();
		
		// properties 파일 읽기 위해 생성
		FileInputStream f = null;
		
		try {
			f = new FileInputStream(propertiesPath);
			p.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(f != null) { try{ f.close(); } catch(IOException e) {}}
		}
		
		Iterator iter = p.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = (String)iter.next();
			String value = p.getProperty(key);
			
			try {
				Class c = Class.forName(value);
				SuperAction action = (SuperAction)c.newInstance(); // 객체생성
				map.put(key, action);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
	}

	// service()	= doGet() + doPost()
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 uri : properties 의 key
		String uri = request.getRequestURI();
		
		SuperAction sa = map.get(uri);
		
		String view = sa.action(request, response);
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}
