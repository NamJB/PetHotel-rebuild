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
   
</body>
</html>