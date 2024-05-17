<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<%@ page import="member.MemberDTO" %>
<%	// 자동로그인
	String sid = (String)session.getAttribute("sid");
	if(sid == null
		|| session.getAttribute("grade") == null
		|| session.getAttribute("mem_num") == null)  /* 로그인 여부 체크 */
	{
		Cookie[] cookies = request.getCookies(); //모든 쿠키를 가져옴
		String id = null;
		String pw = null;
		String auto = null;
		if(cookies != null && cookies.length > 2){
			for( Cookie c : cookies ){
				if( c.getName().equals("cid")){id = c.getValue();} // 아이디 쿠키
				if( c.getName().equals("cpw")){pw = c.getValue();} // 비밀번호 쿠키
				if( c.getName().equals("cauto")){auto = c.getValue();} // 자동 로그인 쿠키
			}
	
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPw(pw);
			MemberDAO dao = MemberDAO.getInstance();
	
			int result = dao.loginCheck(dto);
			if(result==2){
				//	세션 생성(로그인)
				session.setAttribute("sid", id);
				int[] mg = dao.getMG(id);
				session.setAttribute("mem_num", mg[0]);
				session.setAttribute("grade", mg[1]);
				for(Cookie c : cookies){	// 자동로그인에 사용하는 쿠키 시간 갱신
					if( c.getName().equals("cid")
						|| c.getName().equals("cpw")
						|| c.getName().equals("cauto") )
					{
						c.setMaxAge(60*60*24*2);
						response.addCookie(c);
					}
				}
				%>
				<script>
					location.reload(true); // 자동로그인 이후 새로고침
				</script>
				<%
			}
		}
	}
%>

<style>
	#header {
		margin:0px;
		padding:7px;
		font-size:1.3em;
		position:fixed;
		background:rgba(210,210,210,0.2);
		width:156px;
		height:100%;
		z-index:9999;
	}
	#header * {margin:0px; padding:0px;}
	#shop {display:none; padding:1px 14px; overflow:hidden;}
	#shopa:hover ~ #shop{display:block;}
	#shop:hover{display:block;}
	#header a{text-decoration:none; color:black; font-weight:700;}
	#header a:hover {color:red;}
	#shop a{font-weight:400; font-size:16px;}
	#logo {width:156px; height:94px; cursor:pointer;}
</style>

<div id="header" >
 <img id="logo" src="/toBonHouse/views/inc/logo.png" onclick="window.location='/toBonHouse/views/main.jsp'">
 <a id="shopa" href="/toBonHouse/views/products/list.jsp">shop</a>
 <div id="shop">
 <a href="/toBonHouse/views/products/list.jsp?cook=비조리">간편조리</a> <br>
 <a href="/toBonHouse/views/products/list.jsp?cook=끓이기">찌개,찜</a> <br>
 <a href="/toBonHouse/views/products/list.jsp?cook=굽기">구이</a> <br>
 <a href="/toBonHouse/views/products/list.jsp?cook=에어프라이">에어프라이어</a>
 </div>
 <div>
 <b>-</b> <br>
 <a href="/toBonHouse/views/announce/annList.jsp">news</a> <br>
 <a href="/toBonHouse/views/announce/eventList.jsp">event</a> <br>
 <a href="/toBonHouse/views/about.jsp">about</a> <br>
 <br>
 <%if(sid == null){ %>
 <a href="/toBonHouse/views/member/loginForm.jsp">login</a> <br>
 <%}else{ %>
 <a href="/toBonHouse/views/member/logout.jsp">logOut</a> <br>
 <a href="/toBonHouse/views/member/myPage.jsp">My Page</a> <br>
<%  }%>
 <a href="/toBonHouse/views/announce/qna.jsp">QnA</a> <br>
 <a href="/toBonHouse/views/member/list.jsp">Review</a> <br>
 </div>
</div>
