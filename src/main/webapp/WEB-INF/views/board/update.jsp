<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글수정

<form method = "post" action = "/board/update">
   
   <input type = "hidden" value = "${board.boardId}" name = "boardId">
   <div>제목<input type = "text" name = "title" value = "${board.title}"></div>
   <div>내용<textarea name = "content">${board.content }</textarea></div>
   <div><input type = "submit" value = "글 수정"></div>

</form>

</body>
</html>