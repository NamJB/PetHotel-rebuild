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
질문 게시판

<table border = "1">
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>작성자</td>
      <td>작성일</td>
   </tr>
   
<c:forEach var = "b" items = "${list}">
   <tr>
      <td>${b.boardId }</td>
      <td><a href = "/board/view?boardId=${b.boardId}">${b.title}</a></td>
      <td>${b.nickName}</td>,
      <td>${b.createdAt }</td>
   </tr>
   </c:forEach>
</table>

 <a href = "/board/write">글쓰기</a>

</body>
</html>