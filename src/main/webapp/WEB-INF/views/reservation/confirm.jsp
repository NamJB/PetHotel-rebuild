<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
예약확인페이지

 <div>체크인:${dto.check_in}</div>
 <div>체크아웃:${dto.check_out}</div>
 <div>소형견 ${dto.small_cnt}마리</div>
 <div>중현견 ${dto.medium_cnt}마리</div>
 <div>대형견 ${dto.large_cnt}마리</div>
 
 <form method = "post" action = "/reservation/save">
    <input type = "hidden" name = "check_in" value = "${dto.check_in}">
    <input type = "hidden" name = "check_out" value = "${dto.check_out}">
    <input type = "hidden" name = "small_cnt" value = "${dto.small_cnt}">
    <input type = "hidden" name = "medium_cnt" value = "${dto.medium_cnt}">
    <input type = "hidden" name = "large_cnt" value = "${dto.large_cnt}">
    <input type = "submit" value = "예약 확정하기">
 </form>

</body>
</html>