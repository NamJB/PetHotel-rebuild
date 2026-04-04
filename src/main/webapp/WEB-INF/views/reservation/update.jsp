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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
예약 수정게시판


<!--  
<form method = "post" action = "/reservation/update">
   <div><input type = "hidden" value = "${res.id}" name = "id"></div>
   <div>체크인 날짜 <input type = "date" name = "check_in" id = "check_in" value = "${res.check_in }"></div>
   <div>체크아웃 날짜 <input type = "date" name = "check_out" id = "check_out" value = "${res.check_out }"></div>
   
   <div>소형견
       <input type = "button" value = "-" onclick = "changeCnt('small',-1)">
       <input type = "text" name = "small_cnt" value = "${res.small_cnt }" id = "small_cnt" readonly>
       <input type = "button" value = "+" onclick = "changeCnt('small',1)">
   </div>
   
   <div>중형견
       <input type = "button" value = "-" onclick = "changeCnt('medium',-1)">
       <input type = "text" name = "medium_cnt" value = "${res.medium_cnt}" id = "medium_cnt">
       <input type = "button" value = "+" onclick = "changeCnt('medium',1)">
   </div>
   
   <div>대형견
       <input type = "button" value = "-" onclick = "changeCnt('large',-1)">
       <input type = "text" name = "large_cnt" value = "${res.large_cnt}" id = "large_cnt">
       <input type = "button" value = "+" onclick = "changeCnt('large',1)">
   </div>
   
   <div><input type = "button" value = "예약가능 여부" id = check></div>
   <div id = "result"></div>
   <div>
      <input type = "submit" value = "수정하기">
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
-->

<form method = "post" action = "">
   <div>체크인:<input type = "date" name = "check_in" value = "${rdto.check_in }"></div>
   <div>체크아웃:<input type = "date" name = "check_in" value = "${rdto.check_out }"></div>
  
   <div  id = "pet_area">
   <c:forEach var = "p" items = "${rdto.pets }" varStatus = "status">
      <div class="pet_box">
      <div class="pet_number">${status.count}</div>
      <div>펫이름:<input type = "text" value = "${p.name}" name = "pets[${status.index}].name"></div>
      
      <div>나이:
         <select name = "pets[${status.index}].age">
           <c:forEach var = "i" begin = "1" end = "15">
             <option value="${i}" ${i == p.age ? 'selected="selected"' : ''}>
                 ${i}
             </option>
           </c:forEach>
        </select>
      </div>
      <div>사이즈
         <select name = "pets[${status.index}].size">
            <option value = "small" ${'small' == p.size ? 'selected = "selected"' : '' }>소형견</option>
            <option value = "medium" ${'medium' == p.size ? 'selected = "selected"' : '' }>중형견</option>
            <option value = "large" ${'large' == p.size ? 'selected = "selected"' : '' }>대형견</option>
         </select>
      </div>
              
      <button type="button" onclick="removePet(this)">삭제</button>
       <hr>
       </div>     
   </c:forEach>
       </div>
      <div><input type = "button" onclick = "addPet()" value = "펫추가"></div>
      <div><input type = "submit" value = "예약 수정하기"></div> 
      
   <script>
   
   function ageOption(selectedValue) {
	    let options = '';

	    for (let i = 1; i <= 15; i++) {
	        if (i == selectedValue) {
	            options += '<option value="' + i + '" selected>' + i + '</option>';
	        } else {
	            options += '<option value="' + i + '">' + i + '</option>';
	        }
	    }

	    return options;
	}
   
   
function addPet() {
	   
	   let pet_area = document.getElementById("pet_area");
	   let pet_count = document.querySelectorAll(".pet_box").length;
	   
	   let html = ''
	       + '<div class = "pet_box">'
	       +   '<div class = "pet_number">' + ( pet_count + 1) + '</div>'
	       +   '<div>펫 이름 <input type = "text" name = "pets['+ pet_count +'].name"></div>'
	       +   '<div>펫나이' 
	       +      '<select name = "pets[' + pet_count+ '].age">' 
	       +          ageOption(1)
	       +      '</select>'
	       +   '</div>'
	       +   '<div>'
	       +      '펫사이즈'
	       +      '<select name="pets[' + pet_count + '].size">'
	       +         '<option value="small">소형견</option>'
	       +         '<option value="medium">중형견</option>'
	       +         '<option value="large">대형견</option>'
	       +      '</select>'
	       +   '</div>'
	       +   '<div>'
	       +      '주의사항'
	       +         '<textarea name="pets[' + pet_count + '].content"></textarea>'
	       +   '</div>'
	       +      '<button type="button" onclick="removePet(this)">삭제</button>'
	       +      '<hr>'
	       +   '</div>';

	    pet_area.insertAdjacentHTML("beforeend", html);
   }

	function removePet(btn) {
	    let pet_boxes = document.querySelectorAll(".pet_box");
	    if(pet_boxes.length === 1) {
	        alert("최소 한 마리는 있어야 합니다.");
	        return;
	    }
	    btn.parentElement.remove(); // 버튼의 부모인 .pet_box 삭제
	    index_pets(); // 삭제 후 인덱스 재정렬
	}

	function index_pets() {
	    let pet_boxes = document.querySelectorAll(".pet_box");
	    pet_boxes.forEach((box, i) => {
	        // 번호 업데이트
	        box.querySelector(".pet_number").textContent = i + 1;
	        // name 속성 업데이트 (서버 전송용 인덱스 0, 1, 2...)
	        box.querySelector('input[name*=".name"]').name = `pets[${i}].name`;
	        box.querySelector('select[name*=".age"]').name = `pets[${i}].age`;
	        box.querySelector('select[name*=".size"]').name = `pets[${i}].size`;
	    });
	}
	
   </script>   
      
</form>   
</body>
</html>