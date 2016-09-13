<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value='/resources/css/portfolio/portfolio.css'/>" rel="stylesheet"></link>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="pf-main">
    <div class="pf-header">
        <label class="pf-name">Project Portfolio List</label>
    </div>
    <div class="container pf-content pf-boardDiv">
        <div class="row pfList-list">
            <ul class="pfList-ul">
                <li class="pfList-li1 list-group-item col-md-1">번호</li>
                <li class="pfList-li1 list-group-item col-md-2">작성자</li>
                <li class="pfList-li1 list-group-item col-md-6">프로젝트 내용</li>
                <li class="pfList-li1 list-group-item col-md-2">등록</li>
                <li class="pfList-li1 list-group-item col-md-1">조회수</li>
            </ul>
        </div>
        <div class="row pfList-list">
            <ul class="pfList-ul">
                <li class="pfList-li2 list-group-item col-md-1"></li>
                <li class="pfList-li2 list-group-item col-md-2"></li>
                <li class="pfList-li2 list-group-item col-md-6"></li>
                <li class="pfList-li2 list-group-item col-md-2"></li>
                <li class="pfList-li2 list-group-item col-md-1"></li>
            </ul>
        </div>
    </div>
</div>
</body>

</html>