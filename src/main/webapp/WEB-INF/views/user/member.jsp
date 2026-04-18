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
회원가입 화면


<form method = "post" action = "/user/member">
   <div>아이디<input type = "text" name = userId  maxlength="10" pattern="[a-z0-9]{5,20}" required value = "${mdto.userId }" id = "userId"></div>
   <span id = "userId-msg"></span>
   <div>비밀번호<input type = "password" name = "pwd" required maxlength = "20"></div>
   <div>성함<input type = "text" name = "userName"required value = "${mdto.userName }"></div>
   <div>닉네임<input type = "text" name = "nickName" maxlength="10" required value = "${mdto.nickName}"></div>
   <div>휴대폰
      <select name = "phoneFirst">
         <option value = "010">010</option>
         <option value = "011">011</option>
      </select>
     -<input type = "text" name = "phoneMiddel" size= "4" maxlength = "4" required value = "${mdto.phoneMiddle }">
     -<input type = "text" name = "phoneLast" size = "4" maxlength = "4" required value = "${mdto.phoneLast }">
   </div>
   <div><input type = "submit" value = "회원가입"></div>
</form>
<div>${msg}</div>


<script>
   
   $('#userId').on('blur',function(){
	 
	   const userId = $(this).val().trim();
	   
	   const msg = $('#userId-msg');
	   
	   const idReg = /^[a-z0-9]+$/g; // 영문,숫자
	   
	   
	   
	   if(userId === ""){
		   
		   msg.text("아이디를 입력해세요");
		   
		   return;
	   }
	   
	   if(!idReg.test(userId)){
		   
		   msg.text("영어와 숫자만 가능합니다");
		   
		   return;
		   
	   }
	   
	   if(userId.length < 5){
		   
		   msg.text("아이디는 최소 5글자 이상 적어주세요 ");
		   
		   return;
	   }
	   
	   $.ajax({
		   
		   url : '/user/idCehck',
		   method : 'GET',
		   data : {userId : userId},
		   success : function(result){
			   
			   if (result === 0) {
				   
				   msg.text("사용가능한 아이디입니다 ");
				   
			   }
			   else if(result === 1){
				   
				   msg.text("이미 사용중인 아이디입니다");
			   }
			   else if(result === -1) {
				   
				   msg.text("아이디형식이 올바르지않습니다");
			   }
		   },
		   error: function() {
			   
			   msg.text("서버오류");
		   }
		   
	   });
   });
</script>
</body>
</html>