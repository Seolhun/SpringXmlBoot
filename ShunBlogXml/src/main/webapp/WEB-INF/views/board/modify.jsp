<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/board/board.css'/>" rel="stylesheet"></link>
<title>글쓰기</title>
</head>
<body>
	<div class="boardUI2">
	 	<label class="baardName">게시판 수정하기</label>
	</div>
	<div class="boardDiv" align="center">
		<div class="col-sm-12 boardInsertDiv">
			<label style="width:10%; float: left">아이디 </label>
			<input type="text" id="boardModifyAccount" style="width:20%; float: left" value="${bVO.account }" readonly="readonly">
			<input type="hidden" id="boardModifyNo" value="${bVO.boardno }">
			<label style="width:10%; float: left">제목 </label>
			<input type="text" id="boardModifySubject" style="width:58%; float: left" value=${bVO.subject }>
		</div>
		<div class="col-sm-12" id="contentDiv">
			<label class="contentlabel contact" style="width:10%; float: left; text-align: center;"> 내 용 </label>
			<textarea name="smartEditor" id="smartEditor" rows="35" cols="170" placeholder="내용을 입력하세요(4자 이상)">${bVO.content }</textarea>
		</div>
		<div class="col-sm-12" id="sendDiv">
			<button type="button" class="btn btn-info" id="submitModifyBoardBtn" value="Send">저  장</button>
			<button type="button" class="btn btn-warning" id="cancelBtn" value="cancel" onclick="javascript:history.back()">취  소</button>
		</div>
	</div>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/board/board.js'/>"></script>
</html>