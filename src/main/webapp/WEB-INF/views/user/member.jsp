<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 화면

<form method = "post" action = "/user/member">
   <div>아이디<input type = "text" name = userid></div>
   <div>비밀번호<input type = "password" name = "pwd"></div>
   <div><input type = "submit" value = "회원가입"></div>
</form>

</body>
</html>