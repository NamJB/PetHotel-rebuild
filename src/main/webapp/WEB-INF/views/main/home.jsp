<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

	
 <div>메인화면</div> 
  
  <c:if test = "${empty sessionScope.nickname}">
     <a href = "/user/login">로그인</a>
     <a href = "/user/member">회원가입</a>
  </c:if>  
  
  <c:if test = "${not empty sessionScope.nickname}">
     <a href = "/user/mypage">${sessionScope.nickname}</a>
         님 반갑습니다
     <form method = "post" action ="/user/logout">
        <input type = "submit" value = "로그아웃">
     </form>
  </c:if>
  
  <div>
     <a href = "/board/list">질문게시판</a> 
     <a href = "/reservation/main">예약 게시판</a>
  </div>

</body>
</html>