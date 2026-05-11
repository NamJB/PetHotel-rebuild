<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<body>
예약글 상세보기 입니다
  <!--   
   <div>체크인:${res.check_in}</div>
   <div>체크아웃 ${res.check_out }</div>
   <div>상태:${res.status}</div>
   <div>예약한 날짜 ${res.created_at}</div>
  
  
   <c:forEach var="p" items="${plist}">
       <c:choose>
          <c:when test="${p.dog_type == 'small'}">소형견</c:when>
          <c:when test="${p.dog_type == 'medium'}">중형견</c:when>
          <c:when test="${p.dog_type == 'large'}">대형견</c:when>
      </c:choose>
    : ${p.count}마리 <br>
   </c:forEach>
      -->
   <div>${detail.nickName}님!</div>
   <div>체크인:${detail.checkIn}</div>
   <div>체크아웃${detail.checkOut}</div>
   <div>에약상태:<span class = "res-status">${detail.status}</span></div>
   <div>예약한 날짜 ${detail.reservationCreatedAt}</div>  
   
   
   <c:forEach var = "p" items = "${detail.pets}">
      <div>펫이름:${p.name}</div>
      <div>나이:${p.age}</div>
      <div>성별:${p.gender}</div>
      <div>견종:${p.type}</div>
      <div>사이즈:${p.weight}</div>
      <div>주의사항:${p.note}</div>
      <hr>
   </c:forEach>
     
   
   
   <c:if test = "${not empty detail.payId}">
      <div>결제 금액:${detail.paymentAmount}원</div>
      <div>결제 수단 : ${detail.payMethod}</div>
      <div>결제 상태 : ${detail.payStatus}</div>
      <div>결제된 날짜 : ${detail.paidAt}</div>
   </c:if>
   
   
   <c:if test = "${empty detail.payId and detail.status != 'CANCEL' }">
      <div><input type = "button" value = "결제하기" id = "pay-btn" data-resid = "${detail.resId}" > </div>
   </c:if>
   
   <div>
    <c:if test = "${detail.status != 'CANCEL'}">
       <input type = "button" class = "btn-cancel" onclick = "cancelReservation(${detail.resId})" value = "예약 취소">
    </c:if>
   </div>
   
   
<script>
function cancelReservation(resId) {
    
	if(!confirm("정말 취소가하시겠습니까")){
		
		return;
	}
	
	$.ajax({
		url : '/api/reservation/' + resId + '/cancel',
		method : 'POST',
		success :function(data) {
			
				alert("취소 완료!");				
				$(".res-status").text("예약 취소");
				$(".btn-cancel").hide();		
		},
		error:function(xhr) {
			
			alert("에러발생:" + xhr.responseText);
		}				
	});
}

$("#pay-btn").click(function(){
	
	let resId = $(this).data("resid");
	
	$.ajax({
	   url : "/api/reservation/"+resId +"/ready",	
	   type:"POST",
	   success :function(data) {
		   
		   resquestPayment(resId);
	   },
	   error : function(xhr){
		   alert("예약확인중 오류" + xhr.responseText);
		   
	   }
	});
	
	
});

function resquestPayment(resId){
	
	var IMP = window.IMP;
    IMP.init("imp36353532");
    
    IMP.request_pay({
    	
    	pg: "uplus",
        pay_method : 'card',
        merchant_uid: "RES_" + resId + "_" + Date.now(), 
        name : '펫 숙박 예약 (테스트)',
        amount : 101, // 테스트용 100원
        buyer_email : 'njb3430@naver.com',
        buyer_name : '남정범',
        buyer_tel : '010-3430-6138'
    },function(rsp) {
    	
    	if(rsp.success) {
    		
    		$.ajax({
    			   url : '/payment/verify',
    			   type:'POST',
    			   contentType : "application/json",
    			   data : JSON.stringify({
    				   
    				   impUid : rsp.imp_uid, //결제 고유번호
	    			   merchantUid : rsp.merchant_uid, //내가 생성한 주문번호
	    			   amount : rsp.paid_amount, //실제결제된 금액
	    			   resId : resId
    			   }),
    			   success : function(data) {		   
    				   		
    				   alert("결제완료");
    				   location.href = "/board/mypage?tab=reservation"
    			   },
    			   error : function(xhr){		   
    				   alert("예약확인중 오류"+ xhr.responseText);
    			   }
    			
    		});
    	}else{
    		
    		alert("결제 실패 " + rsp.error_msg);
    	}
    });
  	
}


</script>   
</body>
</html>