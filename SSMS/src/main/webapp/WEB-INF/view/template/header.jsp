<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : CrossWalk 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140216

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
			
	});

</script>

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<c:set value="${sessionScope._MEMBER_}" var="member" />
<div id="wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">SSMS</a></h1>
		</div>
		<div id="menu">
			<ul id="ulMenu">
				<li ><a href="/SSMS/list" accesskey="1" title="">Homepage</a></li>
				<li ><a href="/SSMS/introduction" accesskey="2" title="">ABOUT US</a></li>
				<li ><a href="/SSMS/patientLoc" accesskey="3" title="">patient LOCATION</a></li>
				<li ><a href="/SSMS/mapGuide" accesskey="4" title="">MAP GUIDE</a></li>
				<c:if test="${ member.id eq null }">
					<li ><a href="/SSMS/login" accesskey="5" title="">Login</a></li>
				</c:if>
				<c:if test="${ member.id ne null }">
					<li ><a href="/SSMS/logout" accesskey="5" title="">Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<div id="banner" style="background-image: url(resources/img/banner.jpg);">&nbsp;</div>
	<div id="featured">
		<div class="container">
			<div class="title">
				<h2>Smart Sanatorium Management System</h2>
				<span class="byline">Smart Sanatorium Management System</span> 
			</div>
	
		</div>
	</div>
	
<div id="page" class="container">
		
	