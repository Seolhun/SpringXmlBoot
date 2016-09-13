$(function(){
	// 로그인이 되어있지 않을 때, 게시판 작성에 로그인 모달 띄우기
	$('#boardSubject').keyup(function(){
		var boardAccount = $('#boardAccount').val();
		if(boardAccount.trim() =="" || boardAccount.length<2){
			$("#LoginModal").modal();
		}
	});
	
	// 로그인이 되어있지 않을 때, 게시판 작성에 로그인 모달 띄우기
	$('#smartEditor').keyup(function(){
		var boardAccount = $('#boardAccount').val();
		if(boardAccount.trim() =="" || boardAccount.length<2){
			$("#LoginModal").modal();
		}
	});
	
	//게시판 글쓰기버튼 클릭시
	$('#writeBtn').click(function(){
		var logAccountLabel=$('#logAccountLabel').html();
		if(logAccountLabel==undefined){
			alert("회원이 아니라서 글쓰기 불가능합니다.");
		} else {
			location.href="/insert";
		}
	});
	
	//게시판 글쓰기 완성 후 저장 버튼 
	$("#submitBoardBtn").click(function(){
		var boardAccount = $('#boardAccount').val();
		var boardSubject= $('#boardSubject').val();
		var smartEditor= $('#smartEditor').val();
		if(boardSubject.trim().length < 4){
			alert("4글자 이상 입력하세요.");
			$('#boardSubject').focus();
		} else{
//			$.ajax({
//				url : '/boardInsert',
//				type : 'post',
//				datatype : 'json',
//				data : {
//					"boardAccount" : boardAccount,
//					"boardSubject" : boardSubject,
//					"smartEditor" : smartEditor
//				},
//				success : function(data){
//					if(data=="ok"){
//						location.href="/boardList";
//					}
//				}
//			});
			jQuery('#boardFileFrm').submit();
		}
	});
	
	// 게시판 Row클릭 시 게시판 이동 제이쿼리 *********
	jQuery(document).ready(function($) {
	    $(".boardTd").click(function() {
	        window.document.location = $(this).data("href");
	    });
	});
	
	//댓글 글자수 확인하기 이벤트 
	$('#reTextarea').keyup(function() {
		var reTextarea=$('#reTextarea').val();
		var reLength=reTextarea.length;
		if(reLength>300){
			$('#reTextarea').val(reTextarea.substring(0, 300));
		}
		$('#countReplyInput').html(reLength+'/300');
	});
	
	//댓글달기 이벤트 
	$('#replyBtn').click(function(){
		var reTextarea=$('#reTextarea').val();
		var boardNo=$('#boardNo').val();
		// var reLength=reTextarea.length;
			$.ajax({
				url : '/boardReplyInsert',
				type : 'post',
				datatype : 'json',
				data : {
					'boardNo' : boardNo,
					'reTextarea' : reTextarea
				},
				success : function(data){
					if(data=="ok"){
						location.reload();
					} else {
						alert("회원이 아니면 댓글 작성이 불가능 합니다.");
					}
				}
			})
	});
	
	//게시물 삭제하기 이벤트 
	$('#deleteBtn').click(function(){
		var boardNo=$('#boardNo').val();
	    var deleteYes=confirm("게시물을 정말로 삭제하시겠습니까?");
	    if(deleteYes==true){
			$.ajax({
				url : '/boardDelete',
				type : 'post',
				datatype : 'json',
				data : {
					'boardNo' : boardNo
				},
				success : function(data){
					if(data=="fail"){
						alert("댓글이 존재하여 게시글 삭제가 불가능합니다.");
					} else {
						location.href="/board";
					}
				}
			})
	    }
	});
	
	//댓글 삭제하기 이벤트 
	$('.replyDeleteBtn').click(function(){
		var boardReplyNo=$(this).attr("boardReplyNo");
		var reBoardNo=$('#boardNo').val();
		var deleteYes=confirm("댓글을 정말로 삭제하시겠습니까?");
		if(deleteYes==true){
			$.ajax({
				url : '/boardReplyDelete',
				type : 'post',
				datatype : 'json',
				data : {
					'boardReplyNo' : boardReplyNo,
					'reBoardNo' : reBoardNo
				},
				success : function(data){
					if(data=="success"){
						location.href="/boardDetail?boardNo="+reBoardNo;
					}
				}
			})
		}
	});
	
	// 게시물 수정하기 이벤트 처리 
	$("#submitModifyBoardBtn").click(function(){
		var boardModifyNo =$('#boardModifyNo').val();
		var boardModifyAccount = $('#boardModifyAccount').val();
		var boardModifySubject= $('#boardModifySubject').val();
		var smartEditor= $('#smartEditor').val();
		$.ajax({
			url : '/boardModifyInsert',
			type : 'post',
			datatype : 'json',
			data : {
				"boardModifyNo" : boardModifyNo,
				"boardModifyAccount" : boardModifyAccount,
				"boardModifySubject" : boardModifySubject,
				"smartEditor" : smartEditor
			},
			success : function(data){
				if(data=="ok"){
					location.href="/boardList";
				}
			}
		});
	});
	
//	//검색 옵션 바꿀시 자동으로 입력값 넣기(히든처리하여서 보이지 않음)
//	$(document).ready(function(){
//		$('select[name=searchTypeSelection]').change(function() {
//			$('#searchType').val($(this).val());
//			$("#searchType").attr("readonly", true);
//		});
//	});

	
	//검색하기 버튼 클릭시 
	$("#searchBtn").click(function(){
		var searchContent = jQuery('#searchForm #searchContent').val();
		var searchType = jQuery('#searchForm #searchType').val();
        if (searchContent == '') { 
        	alert('검색어를 입력하세요.');
	    } else {
	    	jQuery('#searchForm').submit();
//	  		$.ajax({
//				url : "/boardSearch",
//				type : "GET",
//				datatype : "json",
//				data : {
//					"searchType" : searchType,
//					"searchContent" : searchContent
//				}, 
//				success : function(data){
//					location.href="/boardSearch";
//				}
//	  		})
	    }
	});
});
