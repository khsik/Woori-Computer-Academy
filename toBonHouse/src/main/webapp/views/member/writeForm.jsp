<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 글작성 폼 --%>
<!DOCTYPE html>
<html>
<head>
    <title>member/writeForm</title>
    <style>
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
    </style>
</head>
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
<body>
    <h1>Review/writeForm</h1>
    <form action="writePro.jsp" method="post" enctype="multipart/form-data">
        제목: <input type="text" name="title"/><br/> <%-- 제목 입력 필드 --%>
        내용 : <textarea name="content" cols="40" rows="8"></textarea><br/>
        이미지: <input type="file" name="img"/><br/> <%-- 이미지 업로드 필드 --%>
        
        <%-- TODO: 수정 필요 --%>
        <input type="hidden" name="pnum" value="1"><%-- 상품 번호를 나타내는 숨은 필드 --%>
        
         <%-- 아이디 --%><input type="hidden" name ="id" value=<%= sid %> /><br/> <%-- 현재 로그인한 사용자의 아이디를 숨은 필드로 전달 --%>

        <!-- 별점 -->
        <div class="rating">
            <span class="star" data-rating="1">&#9733;</span> <%-- 별 모양의 평점을 나타내는 아이콘 --%>
            <span class="star" data-rating="2">&#9733;</span>
            <span class="star" data-rating="3">&#9733;</span>
            <span class="star" data-rating="4">&#9733;</span>
            <span class="star" data-rating="5">&#9733;</span>
            <input type="hidden" name="rating" id="rating" value="0"> <%-- 선택된 별점 값을 저장하는 숨은 필드 --%>
        </div>
        <br/>
        <input type="submit" value="등록"/> <%-- 폼 제출 버튼 --%>
    </form>

    <script>
        // 문서 로드 후 실행되는 스크립트
        document.addEventListener("DOMContentLoaded", function() {
            const stars = document.querySelectorAll(".star");

            // 각 별 아이콘에 클릭 이벤트 추가
            stars.forEach(star => {
                star.addEventListener("click", function() {
                    const rating = parseInt(star.getAttribute("data-rating"));
                    document.getElementById("rating").value = rating; <%-- 선택된 별점 값을 숨은 필드에 설정 --%>
                    highlightStars(rating);
                });
            });

            // 선택된 별 이하의 별 아이콘들을 활성화하는 함수
            function highlightStars(rating) {
                stars.forEach(star => {
                    const starRating = parseInt(star.getAttribute("data-rating"));
                    if (starRating <= rating) {
                        star.classList.add("active"); <%-- 선택된 별점 이하의 별 아이콘에 활성화 클래스 추가 --%>
                    } else {
                        star.classList.remove("active"); <%-- 선택된 별점 이상의 별 아이콘의 활성화 클래스 제거 --%>
                    }
                });
            }
        });
    </script>
</body>
</html>
