<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시판 글쓰기

<form method = "post" action = "/board/write">
   <input type = "hidden" value = "${user}" name = "userid">
   <div>제목<input type = "text" name = "title"></div>
   <div>내용<textarea name = "content"></textarea></div>
   <div><input type = "submit" value = "글쓰기"></div>
</form>
</body>
</html>