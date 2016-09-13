<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Board List</title>
<!-- Board CSS -->
<link href="<c:url value='/resources/css/board/board.css'/>" rel="stylesheet"></link>
</head>
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('resources/img/boardList2.jpg');">
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
	<div class="boardUI col-lg-12">
	 	<div>
			<a href="boardInsert"><button type="button" class="btn btn-info" id="writeBtn">글쓰기</button></a>
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
				<c:forEach var="vo" items="${list }">
					<tr class="boardtable boardTd" data-href="boardDetail?boardNo=${vo.boardno }">
					<!-- boardno, userno, subject,content,regdate,hit,blike,depth -->
						<td id="boardNo" class="boardList" style="width: 10%">${vo.boardno }</td>
						<td class="boardList2" style="width: 45%">${vo.subject }  [${vo.depth }]</td>
						<td class="boardList" style="width: 15%">${vo.account }</td>
						<td class="boardList" style="width: 10%">
							<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
						</td>
						<td class="boardList" style="width: 10%">${vo.blike }</td>
						<td class="boardList" style="width: 10%">${vo.hit }</td>
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

	<div class="boardUI col-lg-12">
	<c:if test="${currentBlock ne 1 }">
		<a href="board?curPage=${currentBlock>=blockNum?startPage-5:startPage }&block=${currentBlock>=blockNum?currentBlock-1:currentBlock }">이 전</a>
	</c:if>		
		<c:if test="${currentBlock eq blockNum }">
			<c:forEach var="moveBlock" begin="${moveBlock }" end="${moveBlock+lastPage }">
				<c:if test="${startPage eq moveBlock}">
					<a href="board?curPage=${moveBlock }&block=${currentBlock }"><label class="boardNum" style="color:red">${moveBlock }</label></a>
				</c:if>
				<c:if test="${startPage ne moveBlock}">
					<a href="board?curPage=${moveBlock }&block=${currentBlock }"><label class="boardNum">${moveBlock }</label></a>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${currentBlock ne blockNum }">
			<c:forEach var="moveBlock" begin="${moveBlock }" end="${moveBlock+4 }">
				<c:if test="${startPage eq moveBlock}">
					<a href="board?curPage=${moveBlock }&block=${currentBlock }"><label class="boardNum" style="color:red">${moveBlock }</label></a>
				</c:if>
				<c:if test="${startPage ne moveBlock}">
					<a href="board?curPage=${moveBlock }&block=${currentBlock }"><label class="boardNum">${moveBlock }</label></a>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${currentBlock ne blockNum }">
			<a href="board?curPage=${currentBlock<blockNum?currentBlock+5:currentBlock }&block=${currentBlock<blockNum?currentBlock+1:currentBlock }">다 음</a>
		</c:if>	
		<br>  ${startPage } page / ${totalPage } pages
	</div>
</body>
	<!-- Custom JavaScript -->
	<script src="<c:url value='/resources/js/board/board.js'/>"></script>
</html>