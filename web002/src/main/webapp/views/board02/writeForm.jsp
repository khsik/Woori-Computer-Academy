<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>/board02/writeForm</h1>

<% 
	String sid = (String)session.getAttribute("sid");
	if(sid == null){	//로그인 상태 아님 %>
		<script>
			alert("로그인 후 글작성이 가능합니다.");
			window.location="../member/main.jsp";
		</script>
<%	} %>
<%
	int num=0,ref=1,re_step=0,re_level=0;
	try{  
		if(request.getParameter("num")!= null){	// 받아온 글번호가 있음 -> 답글
			num		= Integer.parseInt(request.getParameter("num"));
			ref		= Integer.parseInt(request.getParameter("ref"));
			re_step	= Integer.parseInt(request.getParameter("re_step"));
			re_level= Integer.parseInt(request.getParameter("re_level"));
		}
%>

<center><b>글쓰기</b></center>
<br />
<form method="post" name="writeform" action="writePro.jsp" onsubmit="return writeCheck()">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="re_step" value="<%=re_step%>">
	<input type="hidden" name="re_level" value="<%=re_level%>">
	
<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="right" colspan="2">
		    <a href="list.jsp">글목록</a> 
		</td>
	</tr>
	<tr>
	    <td  width="70" align="center">작성자</td>
	    <td  width="330">
	    	<%=sid %>
	       <input type="hidden" name="writer" value="<%=sid %>">
	    </td>
	</tr>
	<tr>
	    <td  width="70" align="center" >글제목</td>
	    <td  width="330">
<%		if(request.getParameter("num") == null){%>
	       <input type="text" size="40" maxlength="50" name="title">
<%		}else{%> <%-- 답글인 경우 --%>
		   <input type="text" size="40" maxlength="50" name="title" value="[답글]">
<%		}%>
		</td>
	</tr>
	<tr>
		<td  width="70" align="center" >글내용</td>
		<td  width="330" >
			<textarea name="content" rows="13" cols="40"></textarea> 
		</td>
	</tr>
	<tr>
	    <td  width="70" align="center" >비밀번호</td>
	    <td  width="330" >
			<input type="password" size="8" maxlength="12" name="passwd"> 
		</td>
	</tr>
	<tr>      
		<td colspan=2 align="center"> 
			<input type="submit"	value="글쓰기" >  
			<input type="reset"		value="다시작성">
			<input type="button"	value="글목록" OnClick="window.location='list.jsp'">
		</td>
	</tr>
</table>    
<%	}catch(Exception e){} %>     
</form>      