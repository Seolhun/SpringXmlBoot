<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/board/board.css'/>" rel="stylesheet"></link>
<title>게시판 글 보기</title>
</head>
<body>
	<div class="boardUI2 col-sm-12">
	 	<label class="baardName">게시판 글 보기</label>
	</div>
	<div class="boardDetailDiv col-sm-12" align="center">
		<div class="col-sm-12 boardInsertDiv">
			<label style="width:10%; float: left">번 호 </label>
			<input type="text" id="boardNo" style="width:10%; float: left; text-align: center" value="${bVo.boardno }" disabled>
			<label style="width:10%; float: left">아이디 </label>
			<input type="text" id="boardAccount" style="width:10%; float: left; text-align: center" value="${bVo.account }" disabled>
			<label style="width:10%; float: left">좋아요 </label>
			<input type="text" id="boardLike" style="width:10%; float: left; text-align: center" value="${bVo.blike }" disabled>
			<label style="width:10%; float: left">조회수 </label>
			<input type="text" id="boardHit" style="width:10%; float: left; text-align: center" value="${bVo.hit }" disabled>
			<br>
			<br>
			<label style="width:10%; float: left">제 목 </label>
			<input type="text" id="boardSubject" value="${bVo.subject }" style="width:55%; float: left" disabled>
			<div id="boardFunctionDiv">
				<c:if test="${logAccount ne null }">
					<button type="button" class="btn btn-info boardFunctionBtn" id="recoBtn" value="reco" data-href="boardLike.do?boardNo=${vo.boardno }&logAccount=${logAccount}">좋아요</button>
				</c:if>
				<c:if test="${logAccount eq bVo.account }">
					<a href="boardModify.do?boardNo=${bVo.boardno }"><button type="button" class="btn btn-info boardFunctionBtn" id="modifyBtn" value="reco">수정하기</button></a>
				</c:if>
				<button type="button" class="btn btn-info boardFunctionBtn" id="shareBtn" value="reco">공유하기</button>
			</div>
			<br>
		</div>
		<div class="col-sm-12" id="contentDiv">
			<label class="contentlabel" id="detailContent"> 내 용 </label>
			<div id="article">
				<div id="boardContent">${bVo.content }</div>
			</div>
		</div>
		<c:if test="${replyList ne '[]' }">
			<div class="col-sm-12" id="replyBorderDiv">
				<label style="width:10%; float: left">댓 글</label>
				<c:forEach var="brVo" items="${replyList }">
					<div id="replyListDiv">
						<div id="divideReply"></div>
						<!-- boardReplyNo,boardNo,account,replyContent,replyRegDate,boardLikeNum --> 
						<label style="width:10%; float: left">아이디</label>
						<input type="text" id="boardAccount" style="width:10%; float: left; text-align: center" value="${brVo.reAccount }" disabled>
						<label style="width:10%; float: left">날 짜</label>
						<input type="text" id="replyRegDate" style="width:10%; float: left; text-align: center" value="${brVo.replyRegDate }" disabled>
						<label style="width:10%; float: left">좋아요 </label>
						<input type="text" id="boardLikeNum" style="width:10%; float: left; text-align: center" value="${brVo.boardLikeNum }" disabled>
						<input type="hidden" id="forReplyDelete" value="${brVo.boardReplyNo }">
						<div id="replyFunctionDiv">
						<c:if test="${logAccount ne null }">
							<button type="button" class="btn btn-info boardFunctionBtn" id="recoBtn" value="reco">좋아요</button>
							<c:if test="${logAccount eq brVo.reAccount }">
								<button type="button" class="btn btn-danger" id="replyDeleteBtn" value="delete">삭  제</button>
							</c:if>	
						</c:if>
						</div>
						<div class="col-sm-12" id="replyContentDiv">
							<div id="article">
								<div id="replyContent">${brVo.replyContent }</div>
							</div>
						</div>
					</div>	
				</c:forEach>
			</div>
		</c:if>
		<div class="col-sm-12" id="replyDiv">
		<label class="contentlabel" class="contact" style="width:10%; float: left; text-align: center;"></label>
			<div id="replyInsertDiv">
				<textarea id="reTextarea" rows="5" cols="155" placeholder="저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는 게시물은 이용약관 및 관련 법률에 의해 제재를 받을 수 있습니다. 건전한 토론문화와 양질의 댓글 문화를 위해, 타인에게 불쾌감을 주는 욕설 또는 특정 계층/민족, 종교 등을 비하하는 단어들은 표시가 제한됩니다."></textarea>
				<label id="countReplyInput">0/300</label><button class="btn btn-success" id="replyBtn">등 록</button>
			</div>
		</div>
		<div class="col-sm-12" id="sendDiv">
			<c:if test="${logAccount eq bVo.account }">
				<button type="button" class="btn btn-danger" id="deleteBtn" value="delete">삭  제</button>
			</c:if>	
			<button type="button" class="btn btn-warning" id="cancelBtn" value="cancel" onclick="javascript:history.back()">취  소</button>
		</div>
	</div>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/board/board.js'/>"></script>
</html>