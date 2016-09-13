<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shun Blog</title>
</head>
<body>
	<!-- 회원가입  -->
	<!-- Modal -->
	<div class="modal fade" id="SignUpModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4>
						<span class="glyphicon glyphicon-user"></span> Sign Up
					</h4>					
				</div>		
				<c:url var="signUrl" value="/sign" />
				<form action="${signUrl}" method="post" class="form-horizontal">	
					<div class="modal-body">
						<div class="form-group" id="#divAccount">
							<label for="email"><span class="glyphicon glyphicon-user"></span> Account</label><br>
							<input type="text" class="form-control" id="signAccount" placeholder="2자리 이상 입력하세요.(10자리 이하)">
							<span id="result_id_msg"></span>
						</div>
						<div class="form-group" id="divPwd">
							<label for="psw">
							<span class="glyphicon glyphicon-eye-open"></span> Password</label>
							<input type="password" class="pwd form-control" id="signPwd" name="pwd" placeholder="4자리 이상 입력하세요.">
						</div>
						
						<div class="form-group" id="divPwd2">
							<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Check Password</label> 
							<input	type="password" class="form-control" id="signPwd2" name="pwd2" placeholder="4자리 이상 입력하세요.">
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
						<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal" value="Input Button">
							<span class="glyphicon glyphicon-remove"></span>Cancel
						</button>
						</div>
					<div class="footerDiv">
						<a href="#">Account</a><span class="glyphicon glyphicon-search"></span>
						<a href="#">Password</a><span class="glyphicon glyphicon-search"></span>	
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="<c:url value='/resources/js/login/login.js' />"></script>
</body>
</html>