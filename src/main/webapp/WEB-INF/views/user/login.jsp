<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인화면

<form method = "post" action = "/user/login">
   <div>아이디<input type= "text" name = "user_id"></div>
   <div>비밀번호<input type = "password" name = "pwd"></div>
   <div><input type = "submit" value = "로그인"></div>
   
  
</form>
</body>
</html>