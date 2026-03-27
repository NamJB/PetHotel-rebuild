<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/user/mypage">${user}</a>
  메인화면
  
  <div><a href = "/board/list">질문게시판</a></div>
  <div><a href = "/reservation/main">예약 게시판</a></div>


<a href = "/user/login">로그인</a>

<a href = "/user/member">회원가입</a>

<form method = "post" action ="/user/logout">
  <input type = "submit" value = "로그아웃">
</form>


</body>
</html>