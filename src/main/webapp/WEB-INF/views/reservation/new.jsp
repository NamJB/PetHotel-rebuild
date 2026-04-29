<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>


예약 게시판

<form id = "resForm">
   <div class="form-group">
       <label>예약 기간 선택:</label>
          <input type="text" name="reservationDates" id="reservationDates" class="form-control" />
   </div>
   <div>펫목록</div>
   <table>
       <tr>
          <td></td>
          <td>이름</td>
          <td>견종</td>
          <td>나이</td>
          <td>성별</td>
          <td>몸무게</td>
          <td>주의사항</td>
          <td>등록일</td>
       </tr>
    <c:forEach var = "p" items = "${petList}">
       <tr>
          <td><input type = "checkbox" name = "petId" value = "${p.petId }"></td>
          <td ><span class="pet-name">${p.name}</span></td>
          <td>${p.type}</td>
          <td>${p.age}</td>
          <td>${p.gender}</td>
          <td>${p.weight}kg</td>
          <td>${p.note }</td>
          <td>${p.createdAt }</td>
       </tr>    
    </c:forEach>       
   </table>
        <input type= "button" value = "예약하기" id = "confirm-btn">
</form>
   
   <div id = "confirmArea" style = "display : none">
      <h3>예약 정보를 확인해주세요!</h3>
      <p>예약 기간: <strong id="checkDate"></strong></p>
      <p>선택한 펫: <strong id="checkPet"></strong></p>
      <button type="button" id="btnSubmit">최종 확정</button>
      <button type="button" id="btnCancel">다시 수정하기</button>
   </div>

<script>
   $(function() {
	  $('#reservationDates').daterangepicker({
	    "locale": {
	        "format": "YYYY-MM-DD",
	        "separator": " ~ ",
	        "applyLabel": "확인",
	        "cancelLabel": "취소",
	        "fromLabel": "From",
	        "toLabel": "To",
	        "customRangeLabel": "Custom",
	        "weekLabel": "W",
	        "daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
	        "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
	        "firstDay": 1
	    },
	    "minDate": new Date(), // 오늘 이전 날짜는 선택 못 하게!
	    "opens": "center"      // 달력이 가운데서 열리게
	  });
	});
	
	$(function(){
		
		$("#confirm-btn").on('click',function(){
			
			const checkedPets = $("input[name='petId']:checked");
			
			
            if(checkedPets.length === 0 ){
				
				alert("예약할 펫을 최소 한마리 선택해주세요");
				return;
			}
            
            const petNames = [];
            
            checkedPets.each(function(){
						
			    const name = $(this).closest("tr").find(".pet-name").text();
	            petNames.push(name);
				
			});
				
			
			$("#checkDate").text($("#reservationDates").val());
	        $("#checkPet").text(petNames.join(", "));
	        
	        $("#resForm").hide();
	        $("#confirmArea").show();
		});
		
		$("#btnCancel").click(function() {
	        $("#confirmArea").hide();
	        $("#resForm").show(); 
	    });
		
		$("#btnSubmit").click(function() {
	        
			const selectDate = $("#reservationDates").val();
			const date = selectDate.split("~");
			
			const petIds = [];
	        $("input[name='petId']:checked").each(function(){
	            petIds.push($(this).val());
	        });
						
			const reservationData = {
				
				checkIn : date[0].trim(),
				checkOut : date[1].trim(),
				petIds : petIds
					
			};
			console.log(reservationData);
			$.ajax({
			   url :  "/api/reservation/save",
			   type : "POST",
			   contentType : "application/json",
			   data : JSON.stringify(reservationData),
			   success : function(resId) {
				   
				   //alert("예약이 성공적으로 완료되었습니다");
				   requestPay(resId);				   		   
			   },
			   error: function(xhr){
				   
				   alert("예약실패 :" + xhr.responseText);
				   
			   }
			});
	        
	    });
		
	});
	
	function requestPay(resId) {
		
		var IMP = window.IMP;
		IMP.init("imp36353532");
		
	    IMP.request_pay({
	    	
	    	pg : "kakaopay.TC0ONETIME",
	        pay_method : 'card',
	        merchant_uid: "order_no_" + new Date().getTime(), 
	        name : '펫 숙박 예약 (테스트)',
	        amount : 100, // 테스트용 100원
	        buyer_email : 'njb3430@naver.com',
	        buyer_name : '남정범',
	        buyer_tel : '010-3430-6138'
	    	
	    },function(rsp){
	    	
	    	if(rsp.success){
	    		
	    		console.log("결제성공" +rsp.imp_uid);
	    		
	    		$.ajax({    			
	    			url: "/payment/verify",
	    			type : "POST",
	    			contentType : "application/json",
	    			data : JSON.stringify({
	    				
	    				imp_uid : rsp.imp_uid, //결제 고유번
	    				merchant_uid : rsp.merchant_uid, //내가 생성한 주문번호
	    				amount : rsp.paid_amount //실제결제된 금액
	    			}),
	    			success : function(data){
	    			   alert("예약및 결제 완료");
	    			   location.href = "/main/home";
	    			},
	    			error: function(err) {
	    				
	    				alert("결제 실패");
	    			}    			
	    		});	    		
	    	}
	    	else {
	    		
	    		alert("결제 실패 " + rsp.error_msg);
	    	}	    	
	    });
    
	}
	
	
</script>
</body>
</html>