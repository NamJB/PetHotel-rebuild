<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


예약확인페이지

<!--   <div>체크인:${dto.check_in}</div>
 <div>체크아웃:${dto.check_out}</div>
 <div>소형견 ${dto.small_cnt}마리</div>
 <div>중현견 ${dto.medium_cnt}마리</div>
 <div>대형견 ${dto.large_cnt}마리</div>
 
 <form method = "post" action = "/reservation/save">
    <input type = "hidden" name = "check_in" value = "${dto.check_in}">
    <input type = "hidden" name = "check_out" value = "${dto.check_out}">
    <input type = "hidden" name = "small_cnt" value = "${dto.small_cnt}">
    <input type = "hidden" name = "medium_cnt" value = "${dto.medium_cnt}">
    <input type = "hidden" name = "large_cnt" value = "${dto.large_cnt}">
    <input type = "submit" value = "예약 확정하기">
 </form>
-->

   <div>
      체크인 : ${rdto.checkIn}      
   </div>
   <div>
      체크아웃:${rdto.checkOut }
   </div>
   
   <c:forEach var = "pet" items = "${rdto.pets}" varStatus = "status">
      <div>펫${status.count}</div>
      <div>이름:${pet.name}</div>
      <div>나이:${pet.age }</div>
      <div>사이즈:${pet.size }</div>
      <div>주의사항:${pet.content }</div>
   </c:forEach>
   
   
   <form method = "post" action = "/reservation/save">    
      <c:forEach var = "pet" items = "${rdto.pets}" varStatus = "status">
         <input type = "hidden" value = "${pet.name }" name = "pets[${status.index}].name">
         <input type = "hidden" value = "${pet.age}" name = "pets[${status.index }].age">
         <input type = "hidden" value = "${pet.size}" name = "pets[${status.index }].size">
         <input type = "hidden" value = "${pet.content}" name = "pets[${status.index}].content">
      </c:forEach>
         <input type = "hidden" value = "${rdto.checkInn}" name = "checkIn">
         <input type = "hidden" value = "${rdto.checkOut}" name = "checkOut">
         <input type = "submit" value = "예약 확정하기">      
   </form>
   
   
</body>
</html>