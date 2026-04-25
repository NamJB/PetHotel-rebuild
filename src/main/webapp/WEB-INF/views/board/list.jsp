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

   <div>
      <button onclick ="loadBoardData('ALL')">전체보기</button>
      <button onclick ="loadBoardData('B01')">공지사항</button>
      <button onclick ="loadBoardData('B02')">질문게시판</button>
      <button onclick ="loadBoardData('B03')">자유게시판</button>      
   </div>
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
      
      <tbody id = "list">
      
      </tbody>
   </table>
   
   <a href = "/board/write">글쓰기 </a>
<script>
   $(document).ready(function(){
	 // 리스트들어오자마자 값보내줘서 아작스로 불러오기 
	   loadBoardData('ALL');
   });
   
   function loadBoardData(boardType) {
	   
	   $.ajax({
		   url : "/api/board",
		   type : "GET",
		   data : {boardType : boardType} ,
		   success : function(data) {
			   
			   let html = "";
			   //html반복문 돌리기 
			   if(data && data.length > 0 ) {
				   
				   $(data).each(function(i,list){
					  console.log(list);
					    html += ` 
					 <tr>
	                    <td>\${list.boardId}</td>
	                    <td><a href="/board/\${list.boardId}">\${list.title}</a></td>
	                    <td>\${list.nickName || '(탈퇴한 사용자)'}</td>
	                    <td>\${list.viewCount}</td>
	                    <td>\${list.createdAt}</td>
	                </tr>
	            `;
					   
				   });
				  
			   }
			   else{
				   
				   html = "<tr><td>게시글이 없습니다 </td></tr>";
				   //게시글 없으면 없다는거 html
			   }
			   $('#list').html(html);
			  //html지정 
		   },
		   error : function(xhr) {
			   
			   console.error("",xhr.responseText);
		   }
	   
	   });
	   
   }
   
</script>
</body>
</html>