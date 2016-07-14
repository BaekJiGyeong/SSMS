<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<body>
	<form:form commandName="member" method="post" action="/SSMS/doRegisterMemberAction">
		아이디 : <input type="text" id="id" name="id" value="${ member.id }"><br/>
		<form:errors path="id"/><br/>
		비밀번호 : <input type="password" id="password" name="password" value="${ member.password }"><br/>
		<form:errors path="password"/><br/>
		이름 : <input type="text" id="name" name="name" value="${ member.name }"><br/>
		<form:errors path="name"/><br/>
		생년월일 : 
		<input type="date" id="birthday" name="birthday" value="${ member.birthday }" maxlength="12"/>
		<br/><form:errors path="birthday" /><br/>
		
		핸드폰 번호 : <input type="text" id="phoneNumber" name="phoneNumber" value="${ member.phoneNumber }"><br/>
		<form:errors path="phoneNumber"/><br/>
		
		<input type="submit" value="가입"/>
	</form:form>
</body>

