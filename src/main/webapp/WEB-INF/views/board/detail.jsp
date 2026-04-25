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

<div>${board.boardId} 제목:  ${board.title}    작성자:${empty board.nickName ? '(탈퇴한 사용자)' : board.nickName}</div>
<div>내용:  ${board.content}</div>


<div><a href = "/board/${board.boardId}/update">글수정</a></div>
<div>
   <form method = "post" action = "/board/delete">
     <input type = "hidden" value = "${board.boardId}" name = "boardId">
     <input type = "submit" value = "글 삭제">
   </form>
</div>
</body>
</html>