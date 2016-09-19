<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('resources/img/boardList.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading" style="color: black;">
						<h1>iSyncBrain</h1>
						<hr class="large" 	style="border-color: black;">
						<span class="subheading">iSyncBrain에 오신것을 환영합니다.</span>
					</div>
				</div>
			</div>
		</div>
	</header>
</head>
<body>
	<!-- 로그인 Modal  -->
	<!-- Modal -->
	<div id="loginModal">
		<div class="modal-header">
			<h4>
				<span class="glyphicon glyphicon-lock"></span> Login
			</h4>
		</div>
		<form action="loginDo" method="post" name="loginFrm" class="form-horizontal">
			<div class="modal-body">
				<div class="form-group">
					<label for="usrname"><span class="glyphicon glyphicon-user"></span> Account</label> 
					<input type="text" class="form-control" name="logEmail" placeholder="이메일을 입력하세요." id="logAccount" width="200px">
				</div>
				<div class="form-group">
					<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> 
					<input type="password" class="form-control" name="logPwd" placeholder="4자리 이상 입력하세요." id="logPwd">
				</div>
				<div class="form-group">
					<label><input type="checkbox" value="1" id="logSave" name="logSave">Account Save</label>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="right">
					<a href="" class="facebook" >
						<span class="fontawesome-facebook"></span>
					</a> 
					<a href="" class="twitter"><span class="fontawesome-twitter"></span></a> 
					<a href="" class="google-plus"><span class="fontawesome-google-plus"></span></a>
				</div>
			</div>
			<div class="modal-footer">
				<div class="footerDiv">
					<button type="submit" id="logYes" name="logYes" class="btn btn-success btn-default pull-left" value="Send">
						<span class="glyphicon glyphicon-plus"></span>Submit
					</button>
					<button type="button" class="btn btn-danger btn-default pull-left" onclick="javascript:history.back();">
						<span class="glyphicon glyphicon-remove"></span>Cancel
					</button>
				</div>
				<div class="footerDiv">
					<a href="#">Password</a><span class="glyphicon glyphicon-search"></span>
				</div>
			</div>
		</form>
	</div>
</body>
</html>