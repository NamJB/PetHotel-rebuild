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
   <div>예약한 날짜 ${detail.createdAt}</div>  
   
   
   <c:forEach var = "p" items = "${detail.pets}">
      <div>펫이름:${p.name}</div>
      <div>나이:${p.age}</div>
      <div>성별:${p.gender}</div>
      <div>견종:${p.type}</div>
      <div>사이즈:${p.weight}</div>
      <div>주의사항:${p.note}</div>
      <hr>
   </c:forEach>
     
   
   
   <div>
    <c:if test = "${detail.status != '예약 취소'}">
       <input type = "button" class = "btn-cancel" onclick = "cancelReservation(${detail.resId})" value = "예약 취소">
    </c:if>
   </div>
   
   
<script>
function cancelReservation(resId) {
    
	if(!confirm("정말 취소가하시겠습니까")){
		
		return;
	}
	
	$.ajax({
		url : '/reservation/' + resId + '/cancel',
		method : 'PATCH',
		success :function(data) {
			if(data.trim() === "success") {
				alert("취소 완료!");
				
				$(".res-status").text("예약 취소");
				$(".btn-cancel").hide();
			}
			else if(data.trim()=== "fail"){
				
				alert("서버오류 다시시도");
			}
		},
		error:function(xhr) {
			
			alert("에러발생:" + xhr.status);
		}
		
		
	});
}

</script>   
</body>
</html>