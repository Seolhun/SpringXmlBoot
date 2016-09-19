<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shun Blog</title>
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
	<!-- 회원가입  -->
	<!-- Modal -->
	<div id="SignUpModal">
		<div class="modal-header">
			<h4>
				<span class="glyphicon glyphicon-user"></span> Sign Up
			</h4>					
		</div>		
		<form action="signDo" method="post" class="form-horizontal" id="signFrm" name="signFrm">	
			<div class="modal-body">
				<div class="form-group" id="divAccount">
					<label for="email"><span class="glyphicon glyphicon-user"></span> 이메일</label><br>
					<input type="text" class="form-control" id="signEmail" name="signEmail" placeholder="이메일을 입력하세요.">
					<button class="btn btn-success" type="button" id="emailCheck">인증번호 전송</button>
				</div>
				<div class="form-group" id="divPwd">
					<label for="psw">
					<span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
					<input type="password" class="pwd form-control" id="signPwd" name="signPwd" placeholder="4자리 이상 입력하세요.">
				</div>
				
				<div class="form-group" id="divPwd2">
					<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호 확인</label> 
					<input	type="password" class="form-control" id="signPwd2" name="signPwd2" placeholder="4자리 이상 입력하세요.">
				</div>
				<div class="right">
					<a href="" class="facebook"> <span class="fontawesome-facebook"></span></a>
					<a href="" class="twitter"> <span class="fontawesome-twitter"></span></a> 
					<a href="" class="google-plus"> <span class="fontawesome-google-plus"></span></a>
				</div>
			</div>
		</form>
		<div class="modal-footer">
			<div class="footerDiv">
				<button type="button" id="signYes" name="signYes" class="btn btn-success btn-default pull-left"  value="Send" disabled="disabled">
					<span class="glyphicon glyphicon-plus"></span>Submit
				</button>
			<button type="button" class="btn btn-danger btn-default pull-left" onclick="javascript:history.back();">
					<span class="glyphicon glyphicon-remove"></span>Cancel
				</button>
				</div>
			<div class="footerDiv">
				<a href="#">Account</a><span class="glyphicon glyphicon-search"></span>
				<a href="#">Password</a><span class="glyphicon glyphicon-search"></span>	
			</div>
		</div>
	</div>
</body>
</html>