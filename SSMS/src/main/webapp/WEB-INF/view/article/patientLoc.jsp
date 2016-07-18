<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#searchNameBtn").click( function () {		
		var name = $("#name").val();

		$("#nameForm").attr("action", "<c:url value='/patientLoc'/>");
		$("#nameForm").attr("method", "POST");
		$("#nameForm").submit();
		
	});
	$(".paintBtn").click(function(){
		var w = $(this).parent().children(":eq(2)").children(":eq(0)").val()+"px";	
		var h = $(this).parent().children(":eq(3)").children(":eq(0)").val()+"px";
		
		canvas = document.getElementById("square");
		context = canvas.getContext("2d");
		
		context.fillStyle="#FF0000";
		context.fillRect(27, 27, 80, 113); // 속이 꽉찬 사각형
		context.clearRect(32, 32, 69, 102); // 지정한 영역을 투명하게 만들어준다.
	
		canvas.style.marginLeft = w;
		canvas.style.marginTop = h;
		
	});
});
</script>
<script>
	var canvas, context;
	function InitEvent() {
		var w = document.getElementById("w").value+"px";
		var h = document.getElementById("h").value+"px";
		canvas = document.getElementById("square");
		context = canvas.getContext("2d");
		
		context.fillStyle="#FF0000";
		context.fillRect(27, 27, 80, 113); // 속이 꽉찬 사각형
		context.clearRect(32, 32, 69, 102); // 지정한 영역을 투명하게 만들어준다.
	
		canvas.style.marginLeft = w;
		canvas.style.marginTop = h;
		
	}
</script>
<style>
	#square{
		margin-left:100px;
		margin-top:100px;
	}
</style>
</head>
<body class="w3-container">

<div id="page" class="container" >
	<div class="title" style="text-align: center;">
		<h2>환자 위치 안내</h2><br/><br/>
		<form id="nameForm">
		환자 성명 : <input type="text" id="name" name="name" value="${name}"/>
		<input type="button" id="searchNameBtn" value="검색"/>
		</form>
		
		<div  style="text-align: left; float:left; width:70%;
					 height:500px;
							background-image: url('resources/img/map.jpg'); background-repeat: no-repeat; background-position: center;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <img src="resources/img/map.jpg" style="width:800px;height:500px;"> -->
			<canvas id="square" width="110" height="200" >
			</canvas>
		</div >
		<div style="float:left; width:30%;">
			<table class="w3-table w3-striped w3-bordered w3-card-4">
				<c:forEach items="${patientVOList}" var="patient">
				<thead>
					<tr class="w3-green">
						<th style="width:150px;">이름/생년 월일</th>
						<th colspan="3">입실 시간</th>
						
					</tr>
				</thead>
					<tr>
						<td class="paintBtn" style="cursor:pointer;">${patient.name}<br/> ${patient.birthday}</td>
						<td><span style="font-size: 11px;">${patient.time}</span></td>
						<td><input type="hidden" id="w" value="${patient.marginLeft}"></td>
						<td><input type="hidden" id="h" value="${patient.marginTop}"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>