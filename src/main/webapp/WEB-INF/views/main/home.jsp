<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  메인화면
  
  <div><a href = "/board/question">질문게시판</a></div>
${user}

<a href = "/user/login">로그인</a>

<a href = "/user/member">회원가입</a>

<form method = "post" action ="/user/logout">
  <input type = "submit" value = "로그아웃">
</form>


</body>
</html>