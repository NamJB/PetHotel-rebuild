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
펫 등록하는곳
<div class = "petList">
   <div class = "pet-row">
      <div>이름:<input type = "text" class = "name"></div>
      <div>견종:<input type = "text" class = "type"></div>
      <div>나이:<input type = "number" class ="age"></div>
      <div>몸무게: <input type = "number" class = "weight"></div>
      <div>
         성별 :
         남<input type = "radio" name ="g1" value = "M" class = "gender" checked>
         여<input type = "radio" name = "g1" value = "F">  
      </div>
      <div>메모<textarea class = "note"></textarea></div>      
   </div>
   
   <div class = "button">
      <button type = "button" id = "addPet">펫추가</button>
      <button type = "button" onclick ="petList()">등록하기</button>
   </div>
</div>   
<script>

   let count = 1;

   $("#addPet").click(function(){
	   
	   count++;
	   
	   const rowHtml = `
	      <div class  = "pet-row"> 
	      <hr>
	         <div>이름:<input type = "text" class = "name"></div>
	         <div>견종:<input type = "text" class = "type"></div>
	         <div>나이:<input type = "number" class = "age"></div>
	         <div>몸무게:<input type = "number" class = "weight"></div>
	         <div>
	            성별:
	            남<input type = "radio" name = "g${count}" class = "gender"  value = "M">
	            여<input type = "radio" name = "g${count}" class = "gender" value = "F"
	         </div>
	         <div>메모<textarea class= "note"></textarea></div>
	         <button type = "button" onclick = "$(this).parent().romove()">삭제</button>
	      </div>`;
	   
	      $(".petList").append(rowHtml);
   });
</script>   
   
</body>
</html>