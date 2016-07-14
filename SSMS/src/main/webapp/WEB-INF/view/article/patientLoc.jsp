<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
var canvas, context;
	function InitEvent() {
		var w = document.getElementById("w").value+"px";
		var h = document.getElementById("h").value+"px";
		canvas = document.getElementById("square");
		context = canvas.getContext("2d");
		
		context.fillStyle="#FF0000";
		context.fillRect(25, 25, 100, 100); // 속이 꽉찬 사각형
		context.clearRect(30, 30, 75, 90); // 지정한 영역을 투명하게 만들어준다.
	
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
<body>

<div id="page" class="container" >
	<div class="title" style="text-align: center;">
		<h2>환자 위치 안내</h2><br/><br/>
		<div  style="text-align: left; 
					 height:500px;
							background-image: url('resources/img/map.jpg'); background-repeat: no-repeat; background-position: center;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <img src="resources/img/map.jpg" style="width:800px;height:500px;"> -->
			<canvas id="square" width="110" height="200" >
			</canvas>
		</div >
		
		w : <input type="number" id="w" value="339">
		h : <input type="number" id="h" value="100">
		<input type="button" onclick="InitEvent()" value="입력"></input>
	</div>

</body>
</html>