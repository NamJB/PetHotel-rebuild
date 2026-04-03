<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>
예약글 상세보기 입니다
  <!--   
   <div>체크인:${res.check_in}</div>
   <div>체크아웃 ${res.check_out }</div>
   <div>상태:${res.status}</div>
   <div>예약한 날짜 ${res.created_at}</div>
  
  
   <c:forEach var="p" items="${plist}">
       <c:choose>
          <c:when test="${p.dog_type == 'small'}">소형견</c:when>
          <c:when test="${p.dog_type == 'medium'}">중형견</c:when>
          <c:when test="${p.dog_type == 'large'}">대형견</c:when>
      </c:choose>
    : ${p.count}마리 <br>
   </c:forEach>
     -->
   <div>체크인:${rdto.check_in}</div>
   <div>체크아웃${rdto.check_out}</div>
   <div>에약상태:${rdto.status}</div>
   <div>예약한 날짜 ${rdto.created_at}</div>  
   
   
   <c:forEach var = "p" items = "${rdto.pets}">
      <div>펫이름:${p.name}</div>
      <div>나이:${p.age}</div>
      <div>사이즈:${p.size}</div>
      <div>주의사항:${p.content}</div>
      <hr>
   </c:forEach>
     
   <c:if test = "${res.status != '예약 취소' }">
      <div> <a href = "/reservation/update?id=${res.id}">수정하기</a></div>
   </c:if>
   
   <div>
    <c:if test = "${res.status != '예약 취소'}">
      <form method ="post" action = "/reservation/delete">
         <input type = "hidden" value = "${res.id}" name = "id">
         <input type = "submit" value = "예악 취소">
      </form>
    </c:if>
   </div>
   
</body>
</html>