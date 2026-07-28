<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 관리자페이지 
 
<div>오늘 예약 </div>
<div id = "todayDashboard"></div>

<h3>체크인리스트 </h3>
<div id = "checkInList"></div>

<h3>체크아웃리스트</h3>
<div id ="checkOutList"></div>


<script>
  $(document).ready(function() {
	 
	  todayReservation();
	  todayDashboard();
	  
  });
 /* 
  const today = new Date();
  
  const year = today.getFullYear();
  const month = today.getMonth();
  */
  function todayReservation() {
	  
	  $.ajax({
		  
		  url : "/api/admin/reservation/today",
		  type : "GET",		  
		  success : function(data){
			  //console.log(data);
			  
			  let checkInHtml = "";
			  let checkOutHtml = "";
			  
			  //체크인 출력 
			  if(data.checkIns.length == 0) {
				  
				  checkInHtml = "<div>오늘은 예약이 없습니다 </div>";
				     
			  }
			  else{
				  
				  data.checkIns.forEach(function(item){
						
					  checkInHtml += `
					     <div>${item.nickname}</div>
					     `;
				  });
			  }
			  //체크아웃 출력
			  if(data.checkOuts.length == 0){
				  
				  checkOutHtml = "<div>오늘 체크아웃 없음 </div>";
			  }
			  else{				  
				  data.checkOuts.forEach(function(item){
					  
					  checkOutHtml += `
					     <div>${item.nickname}</div>
					     `;
				  });
			  }
			   		  
			  $("#checkInList").html(checkInHtml);
			  $("#checkOutList").html(checkOutHtml);			
			  todayDashboard();
		  },
		  error : function(xhr) {
			  
			  alert(xhr.responseText);
		  }
	  });
  }
  function todayDashboard() {
	  	  	  
	  $.ajax({
		  
		  url:"/api/admin/reservation/dashboard",
		  type: "GET",
		  success: function(data){
			  
			  let dashboardHtml = `
			     <div>오늘 체크인: \${data.checkInCnt}건</div>
			     <div>오늘 체크아웃: \${data.checkOutCnt}건</div>
			     <div>예약건수 :</div>
			     <div>투숙중? : </div>
			  `;
			  $("#todayDashboard").html(dashboardHtml);
			  //console.log(dashboardHtml);
			  //console.log(data.checkInCnt);
			  //console.log(data.checkOutCnt);
		  },
		  error : function(xhr){
			  
			  alert(xhr.responseText);
			  
		  }		  
	  });
  }
</script>
</body>
</html>