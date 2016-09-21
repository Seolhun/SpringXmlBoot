<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<!-- Login Design CSS -->
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="main">iSyncBrain</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="main">iMediSyn</a></li>
					<li><a href="portfolio">Solution</a></li>
					<li><a href="board">Notice</a></li>
					<li><a href="contact">Contact</a></li>
				<c:if test="${param.logout == null}">
					<li><a href="login" id="loginBtn">Login</a></li>
					<li><a href="sign" id="signBtn">SignUp</a></li>
				</c:if>
				<c:if test="${param.logout != null}">
					<li><a href="detailUser">${pageContext.request.userPrincipal.name}</a></li>
					<li><a href="<c:url value="/logout" />">Logout</a></li>
				</c:if>
				<li><a href="#" class="facebook" onclick="signOut();">Sign out</a></li>
			</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
</body>
</html>