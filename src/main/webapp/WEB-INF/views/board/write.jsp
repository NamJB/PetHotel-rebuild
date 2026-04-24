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
게시판 글쓰기

<form method = "post" action = "/board/write" id = "writeForm">
   <input type = "hidden" value = "${memberId}" name = "writerId"id = "writerId">
   <select id = "boardType" name = "boardType">
      <option value = "B02">질문게시판</option>
      <option value = "B03">자유게시판</option>
   </select>
   <div>제목<input type = "text" name = "title" id = "title"></div>
   <div>내용<textarea name = "content" id = "content"></textarea></div>
   <div>비밀글<input type = "checkbox" name = "secretYN" value = "Y" ></div>
   <div></div>
   <div>
        <button type="button" id="write-btn">글쓰기</button>
    </div>
</form>

<script>
   
   $("#write-btn").on('click', function(){
	   
	   const formElement = document.querySelector('#writeForm');
	   const formData = new FormData(formElement);
	   const data = Object.fromEntries(formData.entries());
	   
	   console.log("데이터:" , data);
	   	   
	   
	   $.ajax({
		   url : "/api/board/write",
		   type : "POST",
		   contentType : "application/json",
		   data: JSON.stringify(data),
		   success : function(result) {
			   
			   alert("게시글이 등록되었습니다");
			   location.href = "/board/list";
			   
		   },
		   error: function(xhr) {
			   
			   alert(xhr.responseText);
		   }
		   
		   
	   });
	   	   
   });
</script>
</body>
</html>