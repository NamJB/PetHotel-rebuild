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
마이페이지 입니다
<div>
   <button id = "board-btn">나의 게시글</button>
   <button id = "pet-btn">나의 펫</button>
   <button id = "reservation-btn">나의 예약</button>
</div>

<div id = "my-area">

</div>

<div id = "petForm-area" style = "display:none;">
   <div>새로운 펫 등록</div>
   <form id = "petForm">
      이름 : <input type = "text" name = "name"> <br>
      견종 : <input type = "text" name = "type"> <br>
      나이 : <input type = "number" name = "age"> <br>
      성별 : 
      <select name = "gender">
         <option value = "M">남</option>
         <option value = "F">여</option>
      </select><br>
      무게 : <input type = "number" name = "weight"> <br>
      메모 : <textarea name = "note"></textarea> <br>
      
      <button type = "button" id = "pet-submit-btn">등록하기</button>
      <button type = "button" id = "pet-cancel-btn">취소하기</button>
   </form>
</div>

<script>

  $(document).ready(function(){
	//페이지 열면 디폴트로 나의 게시판 보여줌
	$("#board-btn").trigger("click");
	  
  })

  
 function listBoard(data){
	 let html =`
	    <table>
	       <tr>
	          <td>번호</td>
	          <td>제목</td>
	          <td>작성자</td>
	          <td>조회수</td>
	          <td>작성일</td>
	       </tr>`;
	    
	    if(data.length === 0) {
	    	
	    	html += ` 
	    	   <tr>
	    	      <td>게시된 글이 없습니다</td>
	    	   </tr>`;	    	
	    }else{
	    	$.each(data,function(index,list){
	    		
	    	   html += `
	    	      <tr>
	    		     <td>\${list.boardId}</td>
	    		     <td><a href = "/board/\${list.boardId}">\${list.title}</a></td>
	    		     <td>\${list.nickName}</td>
	    		     <td>\${list.viewCount}</td>
	    		     <td>\${list.createdAt}</td>
	    		  </tr>`;	    		
	    	});	    	
	    }
	    
	    html += `
	       </table>`;    
	 
	 return html;
 } 
  
  $("#board-btn").on('click',function(){
	 
	  $.ajax({
		  
		  url : "/api/board/my",
		  type : "GET",
		  success : function(data){
			  $("#my-area").html(listBoard(data));
			  
		  },
		  error : function(xhr) {
			  
			  alert(xhr.responseText);
		  }
		  
	  });
	  
  });
  
  
  function listPets(data){
	  
	  let html = `
	     <table>
	        <tr>
	           <td>이름</td>
	           <td>견종</td>
	           <td>나이</td>
	           <td>성별</td>
	           <td>무게</td>
	           <td>메모</td>
	           <td>등록일</td>
	        <tr>`;
	        
	    if(data.length === 0) {
	    	
	    	html += `
	    	   <tr>
	    	     <td>등록된 펫이 없습니다</td> 
	    	   </tr>`;
	    }
	    else{
	    	
	    	$.each(data,function(index,list){
	    		
	    		html += `
		    		   <tr>
		    		      <td>\${list.name}</td>
		    		      <td>\${list.type}</td>
		    		      <td>\${list.age}</td>
		    		      <td>\${list.gender}</td>
		    		      <td>\${list.weight}</td>
		    		      <td>\${list.note}</td>
		    		      <td>\${list.createdAt}</td>
		    		   </tr>`;
	    		
	    	});
	    			    			    	
	    }	    
	        html += `
	          <tr>
	             <td>
	             <button id = "petForm-btn">펫추가</button>
	             </td>
	          </table>`;
	     
	     return html;
  }
  
  $("#pet-btn").on('click',function(){
		 
	  $.ajax({
		  
		  url : "/api/pet/my",
		  type : "GET",
		  success : function(data){
			  $("#my-area").html(listPets(data));
			  
		  },
		  error : function(xhr) {
			  
			  alert(xhr.responseText);
		  }
		  
	  });
	  
  });
  //펫추가 클릭시 등록할수있는 펫폼이 뜸
  $(document).on("click", "#petForm-btn", function() {
	    $("#petForm-area").slideDown();
	    $("#petForm-btn").hide(); 
	});
  
  $("#pet-cancel-btn").on('click',function(){
	  $("#petForm-area").slideUp();
	  $("#petForm-btn").show();
  });
  
  $("#pet-submit-btn").on('click',function(e){
	  
	  e.preventDefault();
	  
	  let data = $("#petForm").serialize();
	  console.log(data);
	 
	  $.ajax({
		  
		  url : "/api/pet/add",
		  type : "POST",
		  data : data,
		  success : function(result) {
			  
			  alert("펫등록완료");
			  
			  $("#petForm-area").slideUp();
			  
			  $("#petForm")[0].reset();
			  
			  $("#my-area").html(listPets(result));
			  
		  },
		  error: function(xhr) {
			  
			  alert(xhr.responseText);
		  }		 		  
	  });
	  
  });
  
  
  
  
  
  function listReservation(data){
	  
	  let html = `
	     <table>
	        <tr>
	           <td>체크인</td>
	           <td>체크아웃</td>
	           <td>예약자명</td>
	           <td>상태</td>
	           <td>예약한날</td>
	        </tr>`;
	   if(data.length === 0) {
		   
		   html += `
		   <td>
		      <tr>예약이 없습니다</tr>
		   </td>`;
	   }
	   else{
		   
		   $.each(data,function(index,list){
			   
			   html += `
			      <tr>
			         <td>\${list.checkIn}</td>
			         <td>\${list.checkOut}</td>
			         <td>\${list.nickName}</td>
			         <td>\${list.status}</td>
			         <td>\${list.createdAt}</td>
			         <td><button>예약 취소</button></td>
			      </tr>`;			   
		   });
	   }
	   html += `
	      </table>`;
	   
	   return html;
	      
  }
   $("#reservation-btn").on('click',function(){

	   $.ajax({
				  
	      url : "/api/reservation/my",
		  type : "GET",
		  success : function(data){
		  $("#my-area").html(listReservation(data));
					  
		  },
		  error : function(xhr) {
					  
				alert(xhr.responseText);
		  }
				  
	  });
			  
	});
  
  
  

</script>

</body>
</html>