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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
게시판 

<!--  <table border = "1">
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
-->

   <table>
      <thead>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th> 조회수</th>
            <th>작성일</th>
         </tr>
      </thead>
      
      <tbody id = "list"></tbody>
   </table>
<script>
   $(document).ready(function(){
	 // 리스트들어오자마자 값보내줘서 아작스로 불러오기 
	   
   });
   
   function loadBoardData(boardType,targetId) {
	   
	   $.ajax({
		   url : "/api/board/list",
		   type : "GET",
		   data : {boardType : boardType} ,
		   success : function(data) {
			   
			   let html = "";
			   
			   if(data && data.length > 0 ) {
				   
				   //html반복문 돌리기 
			   }
			   else{
				   
				   //게시글 없으면 없다는거 html
			   }
			   //타켓아이디로 리스트 html지정하기 
		   },
		   error : function(xhr) {
			   
			   console.error("",xhr.responseText);
		   }
	   
	   });
	   
   }
   
</script>
</body>
</html>