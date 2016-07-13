<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript">

$(document).ready(function () {
	
	$(".message").css("color", "red");
	
	var isCheckedId = false;
	var isCheckedName = false;
	var isCheckedBirthday = false;
	var isCheckedPhoneNumber = false;
	var isCheckedPassword = false;
	
	$("#id").blur(function () {
		if($("#id").val()=="") {
			$("#messageById").text("");
			return;
		}
		$.post("<c:url value='/checkValidationById' />", { "id" : $("#id").val() }, function(data) {
			if (!data) {
				alert("인터넷 연결이 끊겼습니다.");
			} else if (data == "OK") {
				$("#messageById").text("사용할 수 있는 아이디 입니다.").css("color", "green");
				isCheckedId = true;
			} else if (data == "NO") {
				$("#messageById").text("영문, 숫자 조합의 5~20 글자이어야 합니다!").css("color", "red");
				isCheckedId = false;
			}
		});
	});
	
		$("#id").focus(function () {
			$(".deleteMessageId").text("");
		});
		
		$("#password").blur(function () {
			$.post("<c:url value='/checkValidationByPassword' />", { "password" : $("#password").val() }, function(data) {
				if($("#password").val()=="") {
					$("#messageByPassword").text("");
					return;
				}
				
				if (!data) {
					alert("인터넷 연결이 끊겼습니다.");
				} else if (data == "OK") {
					$("#messageByPassword").text("안전한 비밀번호 입니다.").css("color", "green");
				} else if (data == "NO") {
					$("#messageByPassword").text("영문, 숫자, 특수문자 조합의 10~16 글자이어야 합니다!").css("color", "red");
				}
			});
			
			$("#repeatPassword").val("");
		});
			$("#password").focus(function () {
				$(".deleteMessagePassword").text("");
			});
			
			$("#repeatPassword").blur(function () {
				$.post("<c:url value='/checkValidationByRepeatPassword' />", { "password" : $("#password").val(), "repeatPassword" : $("#repeatPassword").val() }, function(data) {
					if($("#repeatPassword").val()=="") {
						$("#messageByRepeatPassword").text("");
						return;
					}
					
					if (!data) {
						alert("인터넷 연결이 끊겼습니다.");
					} else if (data == "OK") {
						$("#messageByRepeatPassword").text("일치합니다.").css("color", "green");
					} else if (data == "NO") {
						$("#messageByRepeatPassword").text("비밀번호가 일치하지 않습니다.").css("color", "red");
					}
				});
			});
			
			$("#repeatPassword").focus(function () {
				$(".deleteMessageRepeatPassword").text("");
			});
			
			$("#name").blur(function () {
				if($("#name").val()=="") {
					$("#messageByName").text("");
					return;
				}
				
				$.post("<c:url value="/checkValidationByName" />", { "name" : $("#name").val() }, function(data) {
					if (!data) {
						alert("인터넷 연결이 끊겼습니다.");
					} else if (data == "OK") {
						isCheckedName = true;
					} else if (data == "NO") {
						$("#messageByName").text("이름은 한글만 입력해주세요.").css("color", "red");
						isCheckedName = false;
					}
				});
			});
			
			$("#name").focus(function () {
				$(".deleteMessageName").text("");
			});
			
			$("#phoneNumber").blur(function () {
				$.post("<c:url value="/checkValidationByPhoneNumber" />", { "phoneNumber" : $("#phoneNumber").val() }, function(data) {
					if (!data) {
						isCheckedPhoneNumber = false;
						alert("인터넷 연결이 끊겼습니다.");
					} else if (data == "OK") {
						isCheckedPhoneNumber = true;
						$("#messageByPhoneNumber").text("사용할 수 있는 전화번호 입니다.").css("color", "green");
					} else if (data == "NO") {
						isCheckedPhoneNumber = false;
						$("#messageByPhoneNumber").text("정확한 전화번호를 입력하세요!").css("color", "red");
					}
				});
			});
			
			$("#phoneNumber").focus(function () {
				$(".deleteMessagePhoneNumber").text("");
			});
			

				$("#registerButton").click( function () {
					
					if(isCheckedId == false) {
						alert("아이디를 확인해주세요.");
						return;
					}
					
					if(isCheckedName == false) {
						alert("이름을 확인해주세요.");
						return;
					}
					
					if(isCheckedPhoneNumber == false) {
						alert("전화번호를 확인해주세요.");
						return;
					}
					
					var form = $("#registerForm");
					form.attr("action", "<c:url value="/doRegisterMemberAction" />");
					form.submit();
					
					$.post("<c:url value="/doRegisterMemberAction"/>", $("#registerForm").serialize(), function(data) {
						if(data == "OK") {
							alert("축하합니다^^ 회원가입 되셨습니다.");
							location.href="<c:url value='/login'/>";
						} else if (data == "NO") {
							alert("회원가입에 실패하셨습니다. 다시 시도해주세요.");
						} 
					});
					
				});
				
				$('#years, #months, #days').change(function () {
					$("#birthDate").val();
					
					$(".deleteMessageBirthDate").text("");
					
					var target = document.getElementById("years");
					var date = "";
					var year = target.options[target.selectedIndex].text;
					date += year + "-";
					
					target = document.getElementById("months");
					var month = target.options[target.selectedIndex].text;
					if ( month.length == 1) {
						month = "0" + month;
					}
					date += month + "-";
					
					target = document.getElementById("days");
					var day = target.options[target.selectedIndex].text;
					if ( day.length == 1) {
						day = "0" + day;
					}
					date += day;
					
					$("#birthDate").val(date);
				});
				
				var id = $("#id").val();
				if (id != null && id != "") {
					$("#id").blur();
				}
				
				var name = $("#name").val();
				if (name != null && name != "") {
					$("#name").blur();
				}
				
				var phoneNumber = $("#phoneNumber").val();
				if (phoneNumber != null && phoneNumber != "") {
					$("#phoneNumber").blur();
				}
			});

</script>

 <script type="text/javascript">
	$(function () {
		for (i = new Date().getFullYear() ; i > 1900; i--) {
			$('#years').append($('<option />').val(i).html(i));
		}

		for (i = 1; i < 13; i++) {
			$('#months').append($('<option />').val(i).html(i));
		}
		updateNumberOfDays();
		
		var birthDate;
		<c:if test="${member.birthDate ne null}">
			birthDate = "${member.birthDate}";
		</c:if>
		var yyyy;
		var mm;
		var dd;
		
		if (birthDate != null && birthDate != "" ) {
			var splitBirthDate = birthDate.split("-");
			yyyy = splitBirthDate[0];
			mm = splitBirthDate[1];
			dd = splitBirthDate[2];
			
			try{
				yyyy = parseInt(yyyy);
				mm = parseInt(mm);
				dd = parseInt(dd);
			} catch (NumberFormatException) {
				yyyy = 2016;
				mm = 1;
				dd = 1;
			}
		}
		else {
			yyyy = 2016;
			mm = 1;
			dd = 1;
		}
		
		$("#years").val(yyyy).attr("selected", "selected");
		$("#months").val(mm).attr("selected", "selected");
		$("#days").val(dd).attr("selected", "selected");
		
		if ( mm < 10 ) {
			mm = "0" + mm;
		}
		
		if ( dd < 10 ) {
			dd = "0" + dd;
		}
		
		$("#birthDate").val(yyyy + "-" + mm + "-" + dd);
		
		$('#years, #months').change(function () {
			updateNumberOfDays();
		});
	});

	function updateNumberOfDays() {
		$('#days').html('');
		month = $('#months').val();
		year = $('#years').val();
		days = daysInMonth(month, year);

		for (i = 1; i < days + 1 ; i++) {
			$('#days').append($('<option />').val(i).html(i));
		}
	}

	function daysInMonth(month, year) {
		return new Date(year, month, 0).getDate();
	}
</script>
<title>Insert title here</title>

<form id="registerForm" name="registerForm">
	<div style="text-align: center;">
		아이디 : <input type="text" id="id" name="id" tabindex="1" maxlength="20"/>
		<br/><span class="deleteMessageId" id="messageById"></span>
		<form:errors class="deleteMessageId message" path="id"/><br/>
		
		비밀번호 : <input type="password" id="password" name="password" tabindex="2" maxlength="16"/>
		<br/><span class="deleteMessagePassword" id="messageByPassword"></span>
		<form:errors class="deleteMessagePassword message" path="password" /><br/>
		
		비밀번호 재확인: <input type="password" id="repeatPassword" name="repeatPassword" tabindex="3" maxlength="16"/>
		<br/><span class="deleteMessageRepeatPassword" id="messageByRepeatPassword"></span>
		<c:if test="${isEmptyRepeatPassword eq 'true'}">
			<span class="deleteMessageRepeatPassword" style="color: red;">비밀번호를 확인해주세요.</span>
		</c:if>
		<c:if test="${isEqualsPassword eq 'true'}">
			<span class="deleteMessageRepeatPassword" style="color: red;">비밀번호가 일치하지 않습니다.</span>
		</c:if>
		<br/>
		
		이름(실명) : <input type="text" id="name" name="name" tabindex="4" maxlength="10"/>
		<br/><span class="deleteMessageName" id="messageByName"></span>
		<form:errors class="deleteMessageName message" path="name"/><br/>
		
		생년월일 : 
		<select id="years" name="years" tabindex="6"></select>&nbsp;년
		<select id="months" name="months" tabindex="7"></select>&nbsp;월
		<select id="days" name="days" tabindex="8"></select>&nbsp;일
		<input type="hidden" id="birthDate" name="birthDate" maxlength="12"/>
		<br/><form:errors class="deleteMessageBirthDate message" path="birthDate" /><br/>
		
		전화 번호 : <input type="text" id="phoneNumber" name="phoneNumber" tabindex="20" maxlength="13"/>
		<br/><span class="deleteMessagePhoneNumber" id="messageByPhoneNumber"></span>
		<form:errors class="deleteMessagePhoneNumber message" path="phoneNumber" /><br/>

		<input id="registerButton" class="inputButton" type="button" value="가입"/>
	</div>
	</form>
