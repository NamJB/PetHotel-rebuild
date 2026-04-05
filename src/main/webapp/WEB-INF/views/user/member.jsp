<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 화면


<form method = "post" action = "/user/member">
   <div>아이디<input type = "text" name = userid  maxlength="10" pattern="[a-z0-9]{5,20}" required></div>
   <div>비밀번호<input type = "password" name = "pwd" required maxlength = "20"></div>
   <div>성함<input type = "text" name = "username"required></div>
   <div>닉네임<input type = "text" name = "nickname" maxlength="10" ></div>
   <div>휴대폰
      <select name = "p1">
         <option value = "010">010</option>
         <option value = "011">011</option>
      </select>
     -<input type = "text" name = "p2" size= "4" maxlength = "4" required>
     -<input type = "text" name = "p3" size = "4" maxlength = "4" required>
   </div>
   <div><input type = "submit" value = "회원가입"></div>
</form>

</body>
</html>