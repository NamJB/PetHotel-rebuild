<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
펫수정
<form method = "post" action = "/pet/${pdto.petId}/update">
   <div>이름:<input type = "text" name = "name" value = "${pdto.name}"></div>
   <div>견종:<input type = "text" name = "type" value = "${pdto.type}"></div>
   <div>나이:<input type = "number" name = "age" value = "${pdto.age}"></div>
   <div>몸무게: <input type = "number" name = "weight" value = "${pdto.weight}"></div>
   <div>
      성별 : 
      남<input type = "radio" name = "gender" value = "M" ${pdto.gender eq 'M' ? 'checked' : ''}>
      여<input type = "radio" name = "gender" value = "F" ${pdto.gender eq 'F' ? 'checked' : ''}>
   </div>
   <div>메모<textarea name = "note">${pdto.note }</textarea></div>
   <div><input type = "submit" value = "수정하기"></div>
</form>
</body>
</html>