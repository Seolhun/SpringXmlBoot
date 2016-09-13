<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/board/board.css'/>" rel="stylesheet"></link>
<title>글쓰기</title>
</head>
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('resources/img/boardList2.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading" style="color: black;">
						<h1>Board</h1>
						<hr class="small" 	style="border-color: black;">
						<span class="subheading">Welcome Hooney's Blog</span>
					</div>
				</div>
			</div>
		</div>
	</header>
<body>
	<div class="boardUI2">
	 	<label class="baardName">게시판 글쓰기</label>
	</div>
	<form id="boardFileFrm" action="boardInsert.do" name="boardFileFrm" enctype="multipart/form-data" method="POST">
		<div class="boardDiv" align="center">
			<div class="col-sm-12 boardInsertDiv">
				<label style="width:10%; float: left">아이디 </label>
				<input name="boardAccount" type="text" id="boardAccount" style="width:20%; float: left" value="${logAccount }" readonly="readonly">
				<label style="width:10%; float: left">제목 </label>
				<input name="boardSubject" type="text" id="boardSubject" placeholder="4글자 이상 입력하세요." style="width:30%; float: left">			
			</div>
			<div class="col-sm-12 fileInsertDiv">
				<label style="width:10%; float: left">파일첨부 </label>
				<input class="fileInput" id="file" type="file" name="file">
			</div>
			<div class="col-sm-12" id="contentDiv">
				<label class="contentlabel contact" style="width:10%;  height : auto; float: left; text-align: center;"> 내 용 </label>
				<textarea name="smartEditor" id="smartEditor" rows="35" cols="170" placeholder="내용을 입력하세요(4자 이상)"></textarea>
			</div>
			<div class="col-sm-12" id="sendDiv">
				<button type="button" class="btn btn-info" id="submitBoardBtn" value="Send">저  장</button>
				<button type="button" class="btn btn-warning" id="cancelBtn" value="cancel" onclick="javascript:history.back()">취  소</button>
			</div>
		</div>
	</form>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/board/board.js'/>"></script>
</html>
