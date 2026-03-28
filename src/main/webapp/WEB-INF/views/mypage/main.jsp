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
마이페이지 입니다

<div>내가 쓴 글</div>
<table>
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>작성자</td>
      <td>작성일</td>
   </tr>
 <c:forEach var = "b" items ="${boardlist}">
    <tr>
       <td>${b.id}</td>
       <td>${b.title}</td>
       <td>${b.user_id }</td>
       <td>${b.created_at }</td>
    </tr>
 </c:forEach>
</table>
</body>
</html>