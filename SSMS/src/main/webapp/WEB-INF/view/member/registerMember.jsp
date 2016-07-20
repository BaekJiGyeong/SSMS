<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	$(document).ready(function () {
		
		var isCheckedId = false;
		
		$("#id").blur(function () {
			
			$.post("<c:url value="/checkValidationById" />", { "id" : $("#id").val() }, function(data) {
				if (!data) {
					alert("인터넷 연결이 끊겼습니다.");
				} else if (data == "OK") {
					$("#messageById").text("사용할 수 있는 아이디 입니다.").css("color", "green");
					isCheckedId = true;
				} else if (data == "NO") {
					$("#messageById").text("이미 사용중이거나 탈퇴한 회원입니다!").css("color", "red");
					isCheckedId = false;
				} 
			});
		});
		
		$("#addMember").click(function () {
			
			if ( isCheckedId ) {
				var form = $("#addMemberForm");
				form.attr("method", "post");
				form.attr("action", "/SSMS/doRegisterMemberAction");
				form.submit();
			}
			else {
				alert("ID를 확인하세요");
			}
		});
	});
</script>
<div style="margin-left:500px;">
<br/>
<br/>
<br/>
<form id="addMemberForm">
	아이디 : <input type="text" id="id" name="id" value="${ member.id }"><br/>
	<span class="deleteMessageId" id="messageById"></span> <br/>

	비밀번호 : <input type="password" id="password" name="password" value="${ member.password }"><br/><br/>

	이름 : <input type="text" id="name" name="name" value="${ member.name }"><br/><br/>

	생년월일 : 
	<input type="date" id="birthday" name="birthday" value="${ member.birthday }" maxlength="12"/><br/><br/>
	
	핸드폰 번호 : <input type="text" id="phoneNumber" name="phoneNumber" value="${ member.phoneNumber }"><br/><br/>
	
	<input type="button" id="addMember" value="가입"/>
</form>
</div>
