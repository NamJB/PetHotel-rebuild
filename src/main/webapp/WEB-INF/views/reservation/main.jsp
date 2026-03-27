<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>



예약 게시판

<form method = "post" action = "/reservation/postConfirm">
   <div>체크인 날짜 <input type = "date" name = "check_in" id = "check_in"></div>
   <div>체크아웃 날짜 <input type = "date" name = "check_out" id = "check_out"></div>
   
   <div>소형견
       <input type = "button" value = "-" onclick = "changeCnt('small',-1)">
       <input type = "text" name = "small_cnt" value = "0" id = "small_cnt" readonly>
       <input type = "button" value = "+" onclick = "changeCnt('small',1)">
   </div>
   
   <div>중형견
       <input type = "button" value = "-" onclick = "changeCnt('medium',-1)">
       <input type = "text" name = "medium_cnt" value = "0" id = "medium_cnt">
       <input type = "button" value = "+" onclick = "changeCnt('medium',1)">
   </div>
   
   <div>대형견
       <input type = "button" value = "-" onclick = "changeCnt('large',-1)">
       <input type = "text" name = "large_cnt" value = "0" id = "large_cnt">
       <input type = "button" value = "+" onclick = "changeCnt('large',1)">
   </div>
   
   <div><input type = "button" value = "예약가능 여부" id = check></div>
   <div id = "result"></div>
   <div>
      <input type = "submit" value = "예약하기">
   </div>
</form>

<script>
function changeCnt(type, number) {
    let input = document.getElementById(type +"_cnt");
    let value = parseInt(input.value);

    value += number;

    if (value < 0) {
        value = 0;
    }

    input.value = value;
}

document.getElementById("check").addEventListener("click", function() {
    let check_in = document.getElementById("check_in").value;
    let check_out = document.getElementById("check_out").value;
    let small_cnt = document.getElementById("small_cnt").value;
    let medium_cnt = document.getElementById("medium_cnt").value;
    let large_cnt = document.getElementById("large_cnt").value;

    $.ajax({
        url: "/reservation/check",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            check_in: check_in,
            check_out: check_out,
            small_cnt: small_cnt,
            medium_cnt: medium_cnt,
            large_cnt: large_cnt
        }),
        success: function(res) {
            if (res.state) {
                document.getElementById("result").innerHTML =
                    "<p style='color:green;'>" + res.message + "</p>";
            } else {
                document.getElementById("result").innerHTML =
                    "<p style='color:red;'>" + res.message + "</p>";
            }
        },
        error: function() {
            alert("오류 발생");
        }
    });
});
</script>

</body>
</html>