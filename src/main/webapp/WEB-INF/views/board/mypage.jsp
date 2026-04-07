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
       <td>${b.board_id}</td>
       <td><a href = "/board/view?board_id=${b.board_id }">${b.title}</a></td>
       <td>${b.nickname }</td>
       <td>${b.created_at }</td>
    </tr>
 </c:forEach>
</table>

 <div>나의 예약</div>
 <table>
     <tr>
        <td>번호</td>
        <td>체크인</td>
        <td>체크아웃</td>
        <td>예약 상태</td>
        <td>예약한 날짜</td>
     </tr>
  <c:forEach var = "r" items = "${reslist }">
     <tr>
        <td>${r.res_id }
        </td>
        <td>${r.check_in}</td>
        <td>${r.check_out}</td>
        <td>${r.status}</td>
        <td>${r.created_at }</td>
        <td><a href = "/reservation/resview?res_id=${r.res_id }">상세보기</a></td>
     </tr>
     </c:forEach>
 </table>
</body>
</html>