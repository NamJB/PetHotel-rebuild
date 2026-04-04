<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



예약 게시판
<!--  
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
-->

   <form method = "post" action ="postConfirm" onsubmit = "return resCheck()">
      <div>체크인:<input type = "date" name = "check_in"></div>
      <div>체크아웃:<input type = "date" name ="check_out"></div>
      
      <div id = "pet_area">     
      </div>
         
         <div>
            <input type = "button"  onclick = "addPet()" value = "펫 추가"></input>                  
         </div>
         
         <div><input type = "submit" value = "예약하기" ></div>    
   </form>
<script>
   window.onload=function() {
	   
	   addPet();
	   
	   let today = new Date().toISOString().split('T')[0];
	    
	   
	   document.querySelector('input[name="check_in"]').min = today;
	   document.querySelector('input[name="check_out"]').min = today;
	   
   }
   
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
	   //펫 정보칸 삭제
	   let pet_boxes = document.querySelectorAll(".pet_box");
	   
	   if(pet_boxes.length == 1 ) {
		   
		   alert("펫 한마리 이상");
		   return;
		   
	   }
	   btn.parentElement.remove();
	   index_pets();
   }
   
   function index_pets() {
	    //재정렬
	   let pet_boxes = document.querySelectorAll(".pet_box");

	   for (let i = 0; i < pet_boxes.length; i++) {
	        let pet_box = pet_boxes[i];

	        let titleSpan = pet_box.querySelector(".pet_number");
	        titleSpan.textContent = i + 1;

	        let nameInput = pet_box.querySelector('input[type="text"]');
	        nameInput.name = 'pets[' + i + '].name';

	        let ageSelect = pet_box.querySelector('select[name*=".age"]');
	        ageSelect.name = 'pets[' + i + '].age';

	        let sizeSelect = pet_box.querySelector('select[name*=".size"]');
	        sizeSelect.name = 'pets[' + i + '].size';

	        let noteTextarea = pet_box.querySelector('textarea');
	        noteTextarea.name = 'pets[' + i + '].content';
	    }
	}
   
   function resCheck() {
	   //체크인,체크아웃 날짜 확인
	   let check_in = document.querySelector('input[name="check_in"]').value;
	   let check_out = document.querySelector('input[name="check_out"]').value;
	   
	   if(!check_in || !check_out){
		  
		  alert("날짜 선택해주세요") 
		  return false;
	   }
	   
	   let today = new Date().toISOString().split('T')[0];
	   
	   if(check_in < today){
		   
		   alert("오늘 이전 날짜는 예약할수없습니다")
		   return false;
	   }
	   if(check_in > check_out) {
		   
		   alert("날짜를 다시 확인해주세요")
		   return false;
	   }
	   
	   //펫이름 체크
	   let petnames = document.querySelectorAll('input[name*=".name"]');
	   
	   for(let i = 0; i < petnames.length; i++) {
		   
		   let names = petnames[i].value.trim();
		   
		   if(names === "") {
			   
			   alert((i+1)+"번째 펫의 이름을 입력해주세요");
			   petnames[i].focus();
			   return false;
		   }
	   }
	   
	   return true;
   }
   
</script>
</body>
</html>