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
       <td>${b.boardId}</td>
       <td><a href = "/board/view?boardId=${b.boardId }">${b.title}</a></td>
       <td>${b.nickName }</td>
       <td>${b.createdAt }</td>
    </tr>
 </c:forEach>
</table>
<hr>
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
        <td>${r.resId }
        </td>
        <td>${r.checkIn}</td>
        <td>${r.checkOut}</td>
        <td>${r.status}</td>
        <td>${r.createdAt }</td>
        <td><a href = "/reservation/${r.resId}">상세보기</a></td>
     </tr>
     </c:forEach>
 </table>
 
 <hr>
 등록된 펫
 <table>
    <tr>
       <td></td>
       <td>펫이름</td>
       <td>견종</td>
       <td>성별</td>
       <td>몸무게</td>
       <td>주의사항</td>
       <td>등록한날</td>
    </tr>
    
    <c:forEach var = "p" items = "${petList}">
       <tr>
          <td></td>
          <td>${p.name}</td>
          <td>${p.type}</td>
          <td>
             <c:if test = "${p.gender eq 'M'}">남</c:if>
             <c:if test = "${p.gender eq 'F'}">여</c:if>
          </td>   
          <td>${p.weight}kg</td>
          <td>${p.note}</td>
          <td>${p.createdAt}</td>
          <td><a href = "/pet/${p.petId}/update">수정하기</a></td>
          <td>
             <form method = "post" action ="/pet/${p.petId}/delete">
                <input type = "submit" value = "펫 삭제">
             </form>
          </td>
       </tr>
    </c:forEach>
 </table>
 
 <a href = "/pet/register">펫등록</a>
</body>
</html>