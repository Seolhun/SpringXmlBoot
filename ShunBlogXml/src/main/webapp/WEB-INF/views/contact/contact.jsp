<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/contact/contact.css'/>" rel="stylesheet"></link>
	<title>Contact Me</title>
</head>
<body>
	<div class="container contact">
		<div class="col-sm-12">
			<label class="accountlabel"> 아이디 </label>
			<input class="account" type="text" readonly="readonly" id="account" value=${logAccount }>
		</div>
		<div class="col-sm-12">
			<label class="subjectlabel"> 제목  </label>
			<input class="subject" type="text" id="subject" placeholder="제목을 입력하세요(6자 이상)">
		</div>
		<div id="contentDiv" class="col-sm-12">
			<label class="contentlabel" class="contact"> 내 용 </label>
			<textarea name="smartEditor" id="smartEditor" rows="20" cols="123" placeholder="내용을 입력하세요(6자 이상)" style="float : right"></textarea>
		</div>
		<div id="functionContact" class="col-sm-12">
			<label class="contentlabel"> 사용자 이메일 </label>
			<input class="" id="email1" type="text" class="box"> @ 
			<input class="" id="email2" type="text" class="box">
				<select id="emailSelection" name="emailSelection">
					<option value="1" selected="selected">직접입력</option>
					<option value="gmail.com">gmail.com</option>
					<option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
			<button type="button" class="btn btn-success" id="sendContact">완료</button>
			<button type="button" class="btn btn-warning" id="cancelContact" onclick="javascript:history.back()">취소</button>
		</div>
	</div>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/contact/contact.js'/>"></script>
</html>