<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="member.ReviewDAO" %>
<%@ page import ="member.ReviewDTO" %>

<%-- 
    이 페이지는 특정 리뷰의 내용을 표시하는 역할을 합니다.
    사용자가 선택한 리뷰의 번호를 요청 파라미터에서 가져와서 해당 리뷰의 내용을 데이터베이스에서 조회하여 표시합니다.
--%>

<style>
    /* 
        border-collapse: collapse;는 테이블의 테두리를 겹치게 설정합니다.
        text-align: center;는 테이블 안의 텍스트를 가운데 정렬합니다.
    */
    table {
        border-collapse: collapse;
        text-align: center;
    }
    
    /* 
        테이블의 행(tr), 열(td), 헤더(th)의 테두리 스타일을 설정합니다.
        border: 1px solid darkgray;는 테두리 두께 1px, 다크그레이 색상으로 설정합니다.
    */
    tr, td, th {
        border: 1px solid darkgray;
    }
    table {
    table-layout: fixed;
    width: 25%; /* 테이블 전체의 너비 */
}

    
</style>


<h1>리뷰 내용</h1>

<%
    // 요청 파라미터로부터 리뷰 번호와 페이지 번호를 가져옵니다.
    int num = Integer.parseInt(request.getParameter("num"));
    String pageNum = request.getParameter("pageNum");
    
    // ReviewDAO 객체를 생성합니다.
    ReviewDAO dao = ReviewDAO.getInstance();
    
    // 선택한 리뷰의 정보를 조회하여 DTO 객체에 저장합니다.
    ReviewDTO dto = dao.content(num);
%>

<%-- 리뷰 내용을 테이블 형식으로 표시합니다. --%>
<%-- TODO: pnum 없음 --%>
<center>
    <b>리뷰 내용 보기</b>
    <br/><br/>
    <table>
     
        <tr>
            <th>리뷰 제목</th>
            <td colspan="5"><%= dto.getTitle() %></td>
        </tr>
        <tr>             
            <th>별점</th>
            <td colspan="5"><%= dto.getRating() %></td>
        </tr>
        <tr>
             <th>리뷰 내용</th>
            <td ><%= dto.getContent() %></td>  
        
            <td colspan="4">
                <%-- 이미지가 있는 경우 이미지를 표시하고, 없는 경우 기본 이미지를 표시합니다. --%>
                <% if(dto.getImg() == null) { %>
                    <img src="/toBonHouse/views/images/noimages.png" width="300" height="300"/>
                <% } else { %>
                    <img src="../upload/<%= dto.getImg() %>" width="300" height="300"/>
                <% } %>
            </td>
         </tr>
         <tr>
              <th>등록 일시</th>
            <td colspan="5"><%= dto.getReg() %></td>
        </tr>
        <tr>
            <td colspan="6">
                <%-- 리뷰 수정, 삭제, 목록 버튼을 생성하고 각각의 기능을 수행하는 페이지로 이동합니다. --%>
                <input type="button" value="리뷰 수정" onclick="window.location='writeUpdateForm.jsp?num=<%= num %>&pageNum=<%= pageNum %>'"/>
                &nbsp;&nbsp;
                <input type="button" value="리뷰 삭제" onclick="window.location='writeDeletePro.jsp?num=<%= num %>&pageNum=<%= pageNum %>'"/>
                &nbsp;&nbsp;
                <input type="button" value="리뷰 목록" onclick="window.location='list.jsp?pageNum=<%= pageNum %>'"/>
            </td>
        </tr>
    </table>
</center>
