<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/board/board.css'/>" rel="stylesheet"></link>
<title>Board List</title>
</head>
<body>
<!-- y1RJtkVStGr566tHhms6 : 네이버 에이피아이  -->
	<div class="boardUI2 col-lg-12">
	 	<label class="baardName">게시판 리스트</label>
	 	<div>
			<button type="button" class="btn btn-info" id="writeBtn">글쓰기</button>
		</div>
	</div>
	<div class="container col-lg-12">
		<table class="table table-condensed">
			<thead>
				<tr class="info boardtable">
					<td class="boardTh" style="width: 10%">번호</td>
					<td class="boardTh" style="width: 45%">제목</td>
					<td class="boardTh" style="width: 15%">작성자</td>
					<td class="boardTh" style="width: 10%">날 짜</td>
					<td class="boardTh" style="width: 10%">좋아요</td>
					<td class="boardTh" style="width: 10%">조회수</td>
				</tr>
			</tdead>
			<tbody>
				<c:forEach var="sVO" items="${searchList }">
					<tr class="boardtable boardTd" data-href="boardDetail?boardNo=${sVO.boardno }">
					<!-- boardno, userno, subject,content,regdate,hit,blike,depth -->
						<td id="boardNo" class="boardList" style="width: 10%">${sVO.boardno }</td>
						<td class="boardList2" style="width: 45%">${sVO.subject }  [${sVO.depth }]</td>
						<td class="boardList" style="width: 15%">${sVO.account }</td>
						<td class="boardList" style="width: 10%">
							<fmt:formatDate value="${sVO.regdate }" pattern="yyyy-MM-dd"/>
						</td>
						<td class="boardList" style="width: 10%">${sVO.blike }</td>
						<td class="boardList" style="width: 10%">${sVO.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-lg-12">
		<div id="functionBoard">
		<form id="searchForm" action="boardSearch" method="GET" enctype="multipart/form-data">
			<select id="searchType" name="searchType">
				<option value="subject" selected="selected">제목</option>
				<option value="content">제목/본문</option>
				<option value="account">작성자</option>
			</select>
			<input id="searchCurPage" name="searchCurPage" type="hidden" value="1"/>
			<input id="searchBlock" name="searchBlock" type="hidden" value="1"/>
			<input id="searchContent" name="searchContent" type="text" class="box"/>
			<button type="button" class="btn btn-success" id="searchBtn">검색</button>
		</form>	
		</div>
	</div>
	<!-- searchType=subject & searchsearchCurPage=1 & searchBlock=1 & searchContent=너는 -->
	<div class="boardUI col-lg-12">
	<c:if test="${searchCurrentBlock ne 1 }">
		<a href="boardSearch?searchCurPage=${searchCurrentBlock>=searchBlockNum?searchStartPage-5:searchStartPage }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock>=searchBlockNum?searchCurrentBlock-1:searchCurrentBlock }">이 전</a>
	</c:if>		
		<c:if test="${searchCurrentBlock eq searchBlockNum }">
			<c:forEach var="searchMoveBlock" begin="${searchMoveBlock }" end="${searchMoveBlock+searchLastPage }">
				<c:if test="${searchStartPage eq searchMoveBlock}">
					<a href="boardSearch?searchCurPage=${searchMoveBlock }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock }"><label class="boardNum" style="color:red">${searchMoveBlock }</label></a>
				</c:if>
				<c:if test="${searchStartPage ne searchMoveBlock}">
					<a href="boardSearch?searchCurPage=${searchMoveBlock }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock }"><label class="boardNum">${searchMoveBlock }</label></a>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${searchCurrentBlock ne searchBlockNum }">
			<c:forEach var="searchMoveBlock" begin="${searchMoveBlock }" end="${searchMoveBlock+searchLastPage }">
				<c:if test="${searchStartPage eq searchMoveBlock}">
					<a href="boardSearch?searchCurPage=${searchMoveBlock }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock }"><label class="boardNum" style="color:red">${searchMoveBlock }</label></a>
				</c:if>
				<c:if test="${searchStartPage ne searchMoveBlock}">
					<a href="boardSearch?searchCurPage=${searchMoveBlock }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock }"><label class="boardNum">${searchMoveBlock }</label></a>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${searchCurrentBlock ne searchBlockNum }">
			<a href="boardSearch?searchCurPage=${searchCurrentBlock<searchBlockNum?searchCurrentBlock+5:searchCurrentBlock }&searchContent=${searchContent}&searchType=${searchType}&searchBlock=${searchCurrentBlock<searchBlockNum?searchCurrentBlock+1:searchCurrentBlock }">다 음</a>
		</c:if>	
		<br>  ${searchStartPage } page / ${searchTotalPage } pages
	</div>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/board/board.js'/>"></script>
</html>