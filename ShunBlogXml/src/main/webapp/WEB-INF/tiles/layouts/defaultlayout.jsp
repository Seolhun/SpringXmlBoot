<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="Chrome">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Google API Element -->
<meta name="google-signin-client_id" content="264714905099-kta7i5n1lrmlrfbsmp7vi5g6or0e3n3d.apps.googleusercontent.com">
<title>iSyncBrain</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Font CSS -->
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href="${css}/font/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- Tiles JSP CSS -->
<link href="${css}/main/clean-blog.min.css" rel="stylesheet"></link>
<link href="${css}/login/login.css" rel="stylesheet"></link>
<link href="${css}/board/board.css" rel="stylesheet"></link>
<link href="${css}/contact/contact.css" rel="stylesheet"></link>
<link href="${css}/portfolio/portfolio.css" rel="stylesheet"></link>
</head>

<body>
	<header id="header">
	    <tiles:insertAttribute name="header" />
	</header>
	
	<section id="body">
	    <tiles:insertAttribute name="body" />
	</section>
	
	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>      

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<!-- Ties JSP JavaScript -->
	<script src="${js}/contact/contact.js"></script>
	<script src="${js}/board/board.js"></script>
	<script src="${js}/login/login.js"></script>
	<script src="${js}/login/loginApi.js"></script>
	
	<!-- Theme JavaScript -->
	<script src="${js}/main/clean-blog.min.js"></script>
	<script src="${js}/main/jqBootstrapValidation.js"></script>
	
	<!-- 구글 로그인 JS -->
	<script src="https://apis.google.com/js/client:platform.js?onload=renderButton" async defer></script>
</html>