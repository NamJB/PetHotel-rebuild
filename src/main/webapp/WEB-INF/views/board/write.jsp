<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<div>${empty board.boardId ? '게시글쓰기' : '게시글 수정 ' }</div>

<form id = "writeForm">
   <input type = "hidden" value = "${board.boardId}" name = "boardId" id = "boardId">
   <input type = "hidden" value = "${memberId}" name = "writerId"id = "writerId">
   <select id = "boardType" name = "boardType">
      <option value = "B02">질문게시판</option>
      <option value = "B03">자유게시판</option>
   </select>
   
   <div>제목<input type = "text" name = "title" id = "title" value = "${board.title }"></div>
   
   <div>내용<textarea name = "content" id = "content">${board.content}</textarea></div>
   
   <div>비밀글
      <input type = "checkbox" name = "secretYN" value = "Y"
      ${board.secretYN == 'Y' ? 'cheked' : ''}>
   </div>
   
   <div></div>
   <div>
        <button type="button" id="write-btn">${empty board.boardId ? '글쓰기' : '수정하기' }</button>
    </div>
</form>

<script>

   $(document).ready(function(){
	   //수정할때 타입값 불러오기 
	   const type = "${board.boardType}";
	   
	   if(type) {
		   
		   $("#boardType").val(type);
	   }
   });
   
   $("#write-btn").on('click', function(){
	   
	   const formElement = document.querySelector('#writeForm');
	   const formData = new FormData(formElement);
	   const data = Object.fromEntries(formData.entries());
	   
	   console.log("데이터:" , data);
	   
	   // true면 수정  false면 글 작성 
	   const isCheck = data.boardId ? true : false;
	   
	   const apiUrl = isCheck ? "/api/board/update" : "/api/board/write";
	   const httpMethod = isCheck ? "PUT" : "POST";
	   const successMsg = isCheck ? "게시글이 수정되었습니다" : "게시글이 등록되었습니다";
	   const redirectURL = isCheck ? "/board/" + data.boardId : "/board/list";
	   
	   $.ajax({
		   url : apiUrl,
		   type : httpMethod,
		   contentType : "application/json",
		   data: JSON.stringify(data),
		   success : function(result) {
			   
			   alert(successMsg);
			   location.href = redirectURL;
			   
		   },
		   error: function(xhr) {
			   
			   alert(xhr.responseText);
		   }
		   
		   
	   });
	   	   
   });
</script>
</body>
</html>