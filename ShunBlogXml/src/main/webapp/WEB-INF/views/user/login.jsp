<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<!-- 로그인 Modal  -->
	<!-- Modal -->
	<div class="modal fade" id="loginModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4>
						<span class="glyphicon glyphicon-lock"></span> Login
					</h4>
				</div>
				<c:url var="loginUrl" value="login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<div class="modal-body">
						<div class="form-group">
							<label for="usrname"><span class="glyphicon glyphicon-user"></span> Account</label> 
							<input type="text" class="form-control" name="logAccount" placeholder="2자리 이상 입력하세요." id="logAccount" width="200px">
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
							<a href="" class="facebook"><span class="fontawesome-facebook"></span></a> 
							<a href="" class="twitter"><span class="fontawesome-twitter"></span></a> 
							<a href="" class="google-plus"><span class="fontawesome-google-plus"></span></a>
						</div>
					</div>
					<div class="modal-footer">
						<div class="footerDiv">
							<button type="submit" id="logYes" name="logYes" class="btn btn-success btn-default pull-left" value="Send">
								<span class="glyphicon glyphicon-plus"></span>Submit
							</button>
							<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span>Cancel
							</button>
						</div>
						<div class="footerDiv">
							<a href="#">Password</a><span class="glyphicon glyphicon-search"></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>