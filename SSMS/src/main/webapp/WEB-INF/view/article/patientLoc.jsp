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
		
		var l1 = $(this).parent().children(":eq(3)").children(":eq(1)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(11)").val();
		var l2 = $(this).parent().children(":eq(3)").children(":eq(2)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(12)").val();
		var l3 = $(this).parent().children(":eq(3)").children(":eq(3)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(13)").val();
		var l4 = $(this).parent().children(":eq(3)").children(":eq(4)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(14)").val();
		var l5 = $(this).parent().children(":eq(3)").children(":eq(5)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(15)").val();
		var l6 = $(this).parent().children(":eq(3)").children(":eq(6)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(16)").val();
		var l7 = $(this).parent().children(":eq(3)").children(":eq(7)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(17)").val();
		var l8 = $(this).parent().children(":eq(3)").children(":eq(8)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(18)").val();
		var l9 = $(this).parent().children(":eq(3)").children(":eq(9)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(19)").val();
		var l10 = $(this).parent().children(":eq(3)").children(":eq(10)").val() +"호실  "+ $(this).parent().children(":eq(3)").children(":eq(20)").val();
		
		var patientName = $(this).children(":eq(0)").text()+ " 님 위치";
		

		canvas = document.getElementById("square");
		context = canvas.getContext("2d");
		
		context.fillStyle="#FF0000";
		context.fillRect(27, 27, 80, 113); // 속이 꽉찬 사각형
		context.clearRect(32, 32, 69, 102); // 지정한 영역을 투명하게 만들어준다.
	
		canvas.style.marginLeft = w;
		canvas.style.marginTop = h;

		$("#p1").text(l1);
		$("#p2").text(l2);
		$("#p3").text(l3);
		$("#p4").text(l4);
		$("#p5").text(l5);
		$("#p6").text(l6);
		$("#p7").text(l7);
		$("#p8").text(l8);
		$("#p9").text(l9);
		$("#p10").text(l10);
		
		$("#patientName").text(patientName);
		
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

<div id="page" class="container" style="background-color:white;">
	<div class="title" style="text-align: center;">
		<h2>환자 위치 안내</h2><br/><br/>
		<form id="nameForm">
		환자 성명 : <input type="text" id="name" name="name" value="${name}"/>
		 <button type="button" class="btn btn-success" id="searchNameBtn">검색</button>
		</form>
		
		<div  style="text-align: left; float:left; width:70%; height:500px;
							background-image: url('resources/img/map.jpg'); background-repeat: no-repeat; background-position: center;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<canvas id="square" width="110" height="200" >
			</canvas>
		</div >
		<div style="float:left; width:30%;">
		
			<table class="w3-table w3-striped w3-bordered w3-card-4">
				<thead>
					<tr class="w3-" style="background-color:#79C255; ">
						<th style="width:150px; text-align:center; color:white;">이름/생년 월일</th>
						<th colspan="3" style="text-align:center; color:white;">입실 시간</th>
						
					</tr>
				</thead>
				<c:forEach items="${patientVOList}" var="patient">
					<tr style="margin:0px;">
						<td class="paintBtn" style="cursor:pointer;"><p>${patient.name}</p>${patient.birthday}</td>
						<td><span style="font-size: 11px;">${patient.time}</span></td>
						<td><input type="hidden" id="w" value="${patient.marginLeft}"></td>
						<td><input type="hidden" id="h" value="${patient.marginTop}">
						<input type="hidden" id="l1" style="width:1px;" value="${patient.locationList[0].locationId}">
						<input type="hidden" id="l2" style="width:1px;" value="${patient.locationList[1].locationId}">
						<input type="hidden" id="l3" style="width:1px;" value="${patient.locationList[2].locationId}">
						<input type="hidden" id="l4" style="width:1px;" value="${patient.locationList[3].locationId}">
						<input type="hidden" id="l5" style="width:1px;" value="${patient.locationList[4].locationId}">
						<input type="hidden" id="l6" style="width:1px;" value="${patient.locationList[5].locationId}">
						<input type="hidden" id="l7" style="width:1px;" value="${patient.locationList[6].locationId}">
						<input type="hidden" id="l8" style="width:1px;" value="${patient.locationList[7].locationId}">
						<input type="hidden" id="l9" style="width:1px;" value="${patient.locationList[8].locationId}">
						<input type="hidden" id="l10" style="width:1px;" value="${patient.locationList[9].locationId}">
						
						<input type="hidden" id="t1" style="width:1px;" value="${patient.locationList[0].time}">
						<input type="hidden" id="t2" style="width:1px;" value="${patient.locationList[1].time}">
						<input type="hidden" id="t3" style="width:1px;" value="${patient.locationList[2].time}">
						<input type="hidden" id="t4" style="width:1px;" value="${patient.locationList[3].time}">
						<input type="hidden" id="t5" style="width:1px;" value="${patient.locationList[4].time}">
						<input type="hidden" id="t6" style="width:1px;" value="${patient.locationList[5].time}">
						<input type="hidden" id="t7" style="width:1px;" value="${patient.locationList[6].time}">
						<input type="hidden" id="t8" style="width:1px;" value="${patient.locationList[7].time}">
						<input type="hidden" id="t9" style="width:1px;" value="${patient.locationList[8].time}">
						<input type="hidden" id="t10" style="width:1px;" value="${patient.locationList[9].time}">
						</td>																	
					</tr>
					
				</c:forEach>
			</table>
			
			<br/><br/>
			
			<div>
		<p id="patientName"></p>
				<p id="p1" ></p>
				<p id="p2" ></p>
				<p id="p3" ></p>
				<p id="p4" ></p>
				<p id="p5" ></p>
				<p id="p6" ></p>
				<p id="p7" ></p>
				<p id="p8" ></p>
				<p id="p9" ></p>
				<p id="p10" ></p>
				
			</div>
			
		</div>
	</div>

</body>
</html>