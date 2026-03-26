<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인화면

<form method = "post" action = "/user/loginUser">
   <div>아이디<input type= "text" id = "userid"></div>
   <div>비밀번호<input type = "password" id = "pwd"></div>
   <div><input type = "submit" value = "로그인"></div>
</form>
</body>
</html>