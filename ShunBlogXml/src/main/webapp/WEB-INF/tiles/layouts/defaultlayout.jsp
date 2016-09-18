<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="Chrome">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shun Blog</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Font CSS -->
<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href="/resources/css/font/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Main Design CSS -->
<link href="${css}/main/clean-blog.min.css" rel="stylesheet"></link>
<link href="${css}/login/login.css" rel="stylesheet"></link>
</head>

<body>
	<header id="header">
	    <tiles:insertAttribute name="header" />
	</header>
	
	<section id="body">
	    <tiles:insertAttribute name="body" />
	</section>
	
	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>      

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<!-- Contact Form JavaScript -->
	<script src="<c:url value='/resources/js/main/jqBootstrapValidation.js'/>"></script>
	<script src="${js}/main/jqBootstrapValidation.js'"></script>
	<script src="${js}/main/contact_me.js"></script>
	<script src="${js}/board/board.js"></script>
	<script src="${js}/login/login.js"></script>
	
	<!-- Theme JavaScript -->
	<script src="${js}/main/clean-blog.min.js"></script>
	
	<!-- 네이버 글쓰기 자바스크립 -->
	<script src="<c:url value='/WEB-INF/views/SE2/js/HuskyEZCreator.js'/>"></script>
	<script type="text/javascript" src="/WEB-INF/views/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "smartEditor",
		//SmartEditor2Skin.html 파일이 존재하는 경로
		sSkinURI: "/SE2/SmartEditor2Skin.html",	
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,				
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			
			fOnBeforeUnload : function(){
			}
		},
		fOnAppLoad : function(){
			//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
			oEditors.getById["smartEditor"].exec("PASTE_HTML", [""]);
		},
		fCreator: "createSEditor2"
	});
	
	//네이버 에디터 작성 데이터 전송하기 
	$("#submitBoardBtn").click(function(){
		oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
	})
	
	$("#submitModifyBoardBtn").click(function(){
		oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
	})
</script>
</html>