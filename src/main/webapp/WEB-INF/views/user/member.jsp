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


<form method = "post" action = "/user/member" id = "joinForm">
   <div>아이디<input type = "text" name = userId  maxlength="10" pattern="[a-z0-9]{5,20}" required  id = "userId"></div>
   <span id = "userId-msg"></span>
   
   <div>비밀번호<input type = "password" name = "pwd" required maxlength = "20" id = "pwd"></div>
   <div id = "pwd-msg"></div>
   <div>비밀번호 체크<input type = "password" id = "pwdCheck"></div>
   <div id = "pwdCheck-msg"></div>
   
   <div>성함<input type = "text" name = "userName"required  id = "userName"></div>
   <div id = "userName-msg"></div>
   
   <div>닉네임<input type = "text" name = "nickName" maxlength="10" required  id = "nickName"></div>
   <div id = "nickName-msg"></div>
   
   <div>휴대폰
      <select name = "phoneFirst" id = "phoneFirst">
         <option value = "010">010</option>
         <option value = "011">011</option>
      </select>
     -<input type = "text" name = "phoneMiddle" size= "4" maxlength = "4" required id = "phoneMiddle">
     -<input type = "text" name = "phoneLast" size = "4" maxlength = "4" required  id = "phoneLast">
   </div>
   <div id = "phone-msg"></div>
   <div><input type = "submit" value = "회원가입" id = "join-btn"></div>
</form>
<div>${msg}</div>


<script>
   const $userId = $('#userId');
   const $userIdMsg = $('#userId-msg');

   const $pwd = $('#pwd');
   const $pwdMsg = $('#pwd-msg');
   const $pwdCheck = $('#pwdCheck');
   const $pwdCheckMsg = $('#pwdCheck-msg');

   const $userName = $('#userName');
   const $userNameMsg = $('#userName-msg')
   
   const $nickName = $('#nickName');
   const $nickNameMsg = $('#nickName-msg')
   
   const $phoneMiddle = $('#phoneMiddle');
   const $phoneLast = $('#phoneLast');
   const $phoneMsg = $('#phone-msg');

   const $joinForm = $('#joinForm');
   const $joinBtn = $('#join-btn');

   
   
   let isIdCheck = false;
   let isPwdCheck = false;
   let isNameCheck = false;
   let isNickNameCheck = false;
   let isPhoneCheck = false;
   

   //아이디 중복체
   $userId.on('blur',function(){
	 
	   const userId = $(this).val().trim();
	   	   
	   const idReg = /^[a-z0-9]+$/; // 영문,숫자
	   
	   
	   
	   if(userId === ""){
		   
		   $userIdMsg.text("아이디를 입력해세요");
		   isIdCheck = false;
		   
		   return;
	   }
	   
	   if(!idReg.test(userId)){
		   
		   $userIdMsg.text("영어와 숫자만 가능합니다");
		   isIdCheck = false;
		   
		   return;
		   
	   }
	   
	   if(userId.length < 5){
		   
		   $userIdMsg.text("아이디는 최소 5글자 이상 적어주세요 ");
		   isIdCheck = false;
		   
		   return;
	   }
	   
	   $.ajax({
		   
		   url : '/user/idCheck',
		   method : 'GET',
		   data : {userId : userId},
		   success : function(result){
			   
			   $userIdMsg.text(result);
			   isIdCheck = true;
			   			   			   
		   },
		   error: function(xhr) {
			   isIdCheck = false;
			   
			   if(xhr.status === 400|| xhr.status === 409) {
				   
				 $userIdMsg.text(xhr.responseText);
			   
			   }else if(xhr.status === 500){
				   
				   $userIdMsg.text("서버오류가 생겼습니다");
			   }
			   else {
				   
				   $userIdMsg.text("알수없는 오류");   
			   }
			   			   		   
		   }
		   
	   });
   });
   
   
   //비밀번호 유효성검
   $pwd.on('blur',function(){
	  
	   const pwd = $(this).val();
	   
	   const pwdReg = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`@$!%*#?&]).{8,16}$/; //8~16 영문 숫자 특수문자 
	   
	   
	   if(!pwdReg.test(pwd)) {
		   
		   $pwdMsg.text('영문/숫자/특수문자 포함 8~16자여야합니다');
		   isPwdCheck = false;
		   
	   }
	   else{
		  
		   $pwdMsg.text("사용가능한 비밀번호 입니다");
		   
		   if($pwdCheck.val().trim() !== ""){
			   
			    pwdCheckMatch();
		   }
		   else {
			   
			   $pwdCheckMsg.text("");
			   isPwdCheck = false;
		   }
	   }   
	   
	   
   });
   //비밀번호 체크 서로 일치한지 
   function pwdCheckMatch() {
	   
	   const pwd = $pwd.val();
	   const pwdCheck = $pwdCheck.val();
	   
	   if(pwd === pwdCheck) {
		   
		   $pwdCheckMsg.text("비밀번호가 일치합니다");
		   isPwdCheck = true;
	   }
	   else{
		   
		   $pwdCheckMsg.text("비밀번호가 일치하지않습니");
		   isPwdCheck = false;
	   }
	   
   }
   
   $pwdCheck.on('blur',function(){
	   
	   
	   const pwdCheck = $(this).val();	  
	   
	   if(pwdCheck !== ""){
		   
		   pwdCheckMatch();
		   
	   }
	   else{
		   
		   $pwdCheckMsg.text("");
		   isPwdCheck = false;
	   }	   
	   
   });
   //사용자 이름 
   $userName.on('blur',function(){
	  
	   const name = $(this).val().trim();
	   
	   if(name.length < 2) {
		   
		   $userNameMsg.text("이름을 확인해주세요");
		   isNameCheck = false;
	   }
	   else{
		   
		   $userNameMsg.text("");
		   isNameCheck = true;
	   }
	   
   });
   // 닉네임 
   $nickName.on('blur',function(){
	   
	   const nickName = $(this).val().trim();
	   
	   if(nickName.length < 2){
		   
		   $nickNameMsg.text("닉네임은 2글자 이상 입력해주세요 ");
		   isNickNameCheck = false;
		   
	   }
	   else{
		   
		   $nickNameMsg.text("");
		   isNickNameCheck = true;
	   }
	   
   });
   // 휴대폰 체
   function phoneCheck() {
	   
	   const pMid = $phoneMiddle.val().trim();
	   const pLast = $phoneLast.val().trim();
	   
	   if(pMid === "" && pLast === "") {
		   
		   $phoneMsg.text("");
		   isPhoneCheck = false;
		   return;
	   }
	   
	   if (pMid !== "" && pLast === "") {
	        $phoneMsg.text("");   
	        isPhoneCheck = false; 
	        return; 
	    }
	   
	   const midReg = /^[0-9]{3,4}$/;
	   const lastReg = /^[0-9]{4}$/;
	   
	   if(!midReg.test(pMid) || !lastReg.test(pLast)){
		   
		   $phoneMsg.text("휴대폰 번호를 확인해주세요");
		   isPhoneCheck = false;
		   		   
	   }
	   else{
		   
		   $phoneMsg.text("");
		   isPhoneCheck = true;
		   
	   }
   };
   
   $phoneMiddle.on('blur',function(){
	   
	   phoneCheck();
	   
   });
   
   $phoneLast.on('blur',function(){
	   
	   phoneCheck();
   });
   
   $joinBtn.on('click',function(e){
	  
	   e.preventDefault();
	   
	   if(isIdCheck && isPwdCheck && isNameCheck && isNickNameCheck && isPhoneCheck) {
		   
		   if(confirm("회원가입하시겠습니까?")) {
			   
			   const formElement = document.querySelector('#joinForm');
			   
			   const formData = new FormData(formElement);
			   
			   const data = Object.fromEntries(formData.entries());
			   
			   data.phone = $("#phoneFirst").val() + "-" + $("#phoneMiddle").val() + "-" + $("#phoneLast").val();
			   
			   $.ajax({
				   url: "/user/member",
				   type : "POST",
				   contentType : "application/json",
				   data : JSON.stringify(data),
				   success(result) {
					   
					   alert(result);
					   location.href = "/user/login";
				   },
				   
				   error: function(xhr) {
					   
					   alert(xhr.responseText); 
					   
				   }
			   
			   })
		   }
		   
	   }
	   else{
		   console.log(isIdCheck,isPwdCheck,isNameCheck,isNickNameCheck,isPhoneCheck);
		   alert("입력되지 않거나 올바르지않는 형식이 있습니다 ");
		   
		   if (!isIdCheck) { $('#userId').focus(); }
	       else if (!isPwdCheck) { $('#pwd').focus(); }
	       else if (!isNameCheck) { $('#userName').focus(); }
	       else if (!isNickNameCheck) { $('#nickName').focus(); }
	       else if (!isPhoneCheck) { $('#phoneMiddle').focus(); }
		   
	   }
	  
   });
   
</script>
</body>
</html>