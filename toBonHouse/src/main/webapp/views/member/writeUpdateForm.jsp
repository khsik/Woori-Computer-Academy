<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="member.ReviewDAO" %> <%-- ReviewDAO 클래스 import --%>
<%@ page import ="member.ReviewDTO" %> <%-- ReviewDTO 클래스 import --%>

<%-- 글 수정 폼 --%>
<!DOCTYPE html>
<html>
<head>
    <title>Review/writeForm</title>
    <style>
        /* 스타일링 */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }
        
        .form-container {
            width: 400px; /* 폼의 너비 조절 */
            text-align: center;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .rating {
            font-size: 24px;
        }

        .star {
            cursor: pointer;
            color: #ccc;
        }

        .star.active {
            color: #fdd835; /* 활성화된 별 색상 */
        }

        /* 이미지 크기 조절 */
        img {
            max-width: 100%;
            max-height: 200px; /* 이미지의 최대 높이 조절 */
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Review/updateForm</h1>

    <%-- 요청 파라미터로 받은 글 번호(num)와 페이지 번호(pageNum)를 가져와서 변수에 저장 --%>
    <% int num = Integer.parseInt(request.getParameter("num"));
       String pageNum = request.getParameter("pageNum");
    
       // ReviewDAO 객체와 ReviewDTO 객체 생성
       ReviewDAO dao = ReviewDAO.getInstance();
       ReviewDTO dto = dao.content(num);
    %>
    <%
	// 현재 세션에서 사용자 아이디 가져오기
	String sid = (String)session.getAttribute("sid");
	// 만약 로그인되어 있지 않다면 로그인 페이지로 이동
	if(sid == null){%>
		<script>
			alert("로그인 후 작성해주세요");
			window.location="loginForm.jsp";
		</script>
<%	}%>
	<% // TODO 테이블 컬럼 추가한거 맞춰서 수정해야됨 %>
	
    <%-- 글 수정을 위한 폼 생성 --%>
    <form action="writeUpdatePro.jsp" method="post" enctype="multipart/form-data">
        <input type="hidden" name="num" value="<%=num %>" />
        <input type="hidden" name="pageNum" value="<%=pageNum %>" />
    	<input type="hidden" name="pnum" value="<%= dto.getPnum() %>">
    
        제목 : <input type="text" name="title" value="<%=dto.getTitle() %>" /><br />
        내용 : <textarea name="content" value="<%=dto.getContent() %>"></textarea> <br />
    
        <%-- 이미지가 없는 경우 파일 업로드 입력란 표시 --%>
        <% if(dto.getImg() == null){ %>
            img : <input type="file" name="img" /><br />
        <% } else { %>
            <%-- 이미지가 있는 경우 이미지 변경을 위한 파일 업로드 입력란과 기존 이미지 표시 --%>
            변경img :<input type="file" name="img" /><br />
            <input type="hidden" name="orgImg" value="<%=dto.getImg() %>"/>
            <img src="/toBonHouse/views/upload/<%=dto.getImg() %>" /> <br />
            <input type="hidden" name="id" value="<%=sid %>"/>
        <% } %>

        <!-- 별점 입력 폼 -->
        <div class="rating">
            <span class="star" data-rating="1">&#9733;</span>
            <span class="star" data-rating="2">&#9733;</span>
            <span class="star" data-rating="3">&#9733;</span>
            <span class="star" data-rating="4">&#9733;</span>
            <span class="star" data-rating="5">&#9733;</span>
            <input type="hidden" name="rating" id="rating" value="0">
        </div>

        <input type="submit" value="수정" />
    </form>
</div>

<!-- JavaScript로 별점 선택 기능 구현 -->
<script>
document.addEventListener("DOMContentLoaded", function() {
    const stars = document.querySelectorAll(".star");

    // 각 별을 클릭했을 때 이벤트 처리
    stars.forEach(star => {
        star.addEventListener("click", function() {
            const rating = parseInt(star.getAttribute("data-rating"));
            document.getElementById("rating").value = rating;
            highlightStars(rating);
        });
    });

    // 별점에 따라 선택된 별의 색상을 변경하는 함수
    function highlightStars(rating) {
        stars.forEach(star => {
            const starRating = parseInt(star.getAttribute("data-rating"));
            if (starRating <= rating) {
                star.classList.add("active");
            } else {
                star.classList.remove("active");
            }
        });
    }
});
</script>
</body>
</html>
