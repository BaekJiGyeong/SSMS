<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js"'/>"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#id").focus();
	
	if ( $("#loginFail").val() == "Y") {
		alert("로그인이 실패했습니다");
	}
	
	$("#id, #password").keypress(function (e) {
        if (e.keyCode === 13) {
            $(".login .loginButton").click();
        }
    });
	
	$(".login .loginButton").click(function() {
		if( $("#id").val() == "" ) {
			alert("ID를 입력하세요!");
			$("#id").focus();
			return;
		}
		if( $("#password").val() == "" ) {
			alert("Password를 입력하세요!");
			$("#password").focus();
			return;
		}
		
		var form = $("#loginForm");
		form.attr("method","post");
		form.attr("action","<c:url value="/doLogin"/>");
		form.submit();
	});
	
	$(".login .registButton").click(function() {
		location.href = "<c:url value="/register" />";
	});
	
});
</script>

<div class="login">
	<div class="wrapper">
		<form id="loginForm" name="loginForm">
			<input type="text" name="id" id="id" placeholder="ID" tabindex="1" />
			<input type="password" name="password" id="password" placeholder="Password" tabindex="2" />
			<span class="button loginButton" style="cursor: pointer;" tabindex="3" >Login</span>
			<span class="button registButton" style="cursor: pointer;" tabindex="4" >Sign Up</span>
		</form>
		
		<input type="hidden" id="loginFail" value="${param.loginFail}" />
	</div>
</div>
