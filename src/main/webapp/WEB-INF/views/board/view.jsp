<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글쓴 화면

<div>${board.id} 제목  ${board.title}    작성자${board.user_id}</div>
<div>내용  ${board.content}</div>


<div><a href = "/board/update?id=${board.id}">글수정</a></div>
<div>
   <form method = "post" action = "/board/delete">
     <input type = "hidden" value = "${board.id}" name = "id">
     <input type = "submit" value = "글 삭제">
   </form>
</div>
</body>
</html>