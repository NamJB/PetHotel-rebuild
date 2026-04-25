<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
글쓴 화면

<div>${board.boardId} 제목:  ${board.title}    작성자:${empty board.nickName ? '(탈퇴한 사용자)' : board.nickName}</div>
<div>내용:  ${board.content}</div>


<div><a href = "/board/${board.boardId}/update">글수정</a></div>
<div>
  
<button id = "delete-btn" data-id = "${board.boardId}">글삭제</button>
   
   
<script>


$("#delete-btn").on('click',function(){
	   
	
	const boardId = $(this).data("id");
	   
	if(!confirm("이글을 삭제하시겠습니까?")){
		   
		return;
	}
	   
	$.ajax({
		   
		url : "/api/board/" + boardId,
		type :"DELETE",
		success:function(result) {
			   
			alert("게시글 삭제 ");
			location.href = "/board/list";
		},
	    error : function(xhr) {
	    	   
	    	alert(xhr.responseText);
	    }
		   		   
	});

});

</script>
</div>
</body>
</html>