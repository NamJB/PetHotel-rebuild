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
         여<input type = "radio" name = "g1" value = "F" class = "gender">  
      </div>
      <div>메모<textarea class = "note"></textarea></div>      
   </div>
</div> 

   <div class = "button">
      <button type = "button" id = "addPet">펫추가</button>
      <button type = "button" onclick ="petList()">등록하기</button>
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
	            남<input type = "radio" name = "g${count}" class = "gender"  value = "M" checked>
	            여<input type = "radio" name = "g${count}" class = "gender" value = "F">
	         </div>
	         <div>메모<textarea class= "note"></textarea></div>
	         <button type = "button" onclick = "$(this).closest('.pet-row').remove()">삭제</button>
	      </div>`;
	   
	      $(".petList").append(rowHtml);
   });
   
    function petList(){
    	
    	let petDataList = [];
    	
    	isPetCheck = true;
    	
    	//배열 세팅 여러마리 일경우
    	$(".pet-row").each(function(index){
    		
    		const pet = {
    				
    		   name : $(this).find(".name").val(),
    		   type : $(this).find(".type").val(),
    		   age : $(this).find(".age").val(),
    		   weight : $(this).find(".weight").val(),
    		   gender : $(this).find(".gender:checked").val(),
    		   note : $(this).find(".note").val()
    		
    		};
    		
    	//값이 있어야 들어가게 note제외	
    	if(!pet.name || !pet.age  || !pet.weight || !pet.gender){
    		  		
            alert((index+1)+"번쨰 펫의 정보를 확인해주세요");
            isPetCheck = false;
            return false; 	      		   
    	}
    	
    	petDataList.push(pet);
    	
    	});
    	
    	//찍으니까 들어온다
    	console.table(petDataList);
    	
    	//트루가아니면 전송안되게 
    	if(!isPetCheck){
    		
    		return;
    	}
    	
    	//펫 0마리이면 안되니까 막아둠
    	if(petDataList.length === 0) {
    		
    		alert("등록할 정보가 없습니다");
    		return;
    	}
    	//아작스
    	$.ajax({
    		url:"/pet/add",
    		type: "post",
    		contentType : "application/json; charset =utf-8",
    		data : JSON.stringify(petDataList),
    		success: function(result) {
    		   
    			alert(result);
    			location.href =  "/board/mypage";
    			
    		},
    		error : function(xhr) {
    			
    			alert(xhr.ResponseText);
    		}
    				
    	});
    	
    }
</script>   
   <!-- 삭제,추가하면 펫추가 등록하기 맨아래로 가게하기,그다음 아작스로 넘어가게 만들어여함 -->
</body>
</html>