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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
로그인화면

<form method = "post" action = "/user/login" id = "loginForm">
   <div>아이디<input type= "text" name = "userId" id = "userId"></div>
   <div>비밀번호<input type = "password" name = "pwd" id = "pwd"></div>
   <div><input type = "submit" value = "로그인" id = "login-btn"></div>
   <div>${msg }</div>
   <div id = "login-msg"></div>
</form>

<script>
   $('#login-btn').on('click',function(e){
	   
	   e.preventDefault();
	   
	   const msg = $('#login-msg');
	   
	   const loginData = {
		 
		   userId : $('#userId').val(),
		   pwd : $('#pwd').val()
		   
	   };
	   
	   $.ajax({
		  
		   url : "/user/login",
		   type : "POST",
		   contentType : "application/json",
		   data : JSON.stringify(loginData),
		   success: function(result){
			   
			   location.href = "/main/home";
			   
		   },
		   error: function(xhr) {
			   		   
			   msg.text(xhr.responseText);
			   
		   }
		   		   
	   });
	   
   });
</script>
</body>
</html>