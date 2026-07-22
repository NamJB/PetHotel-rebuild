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


<script>
  $(document).ready(function() {
	 
	  todayReservation();
	  
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
			  console.log(data);
		  },
		  error : function(xhr) {
			  
			  alert(xhr.responseText);
		  }
	  });
  }
</script>
</body>
</html>