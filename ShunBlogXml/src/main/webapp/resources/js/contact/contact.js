//$(document).ready(function(){

$(function(){	
	$(document).ready(function(){
		$('select[name=emailSelection]').change(function() {
			if($(this).val()=="1"){
				$('#email2').val("");
			} else {
				$('#email2').val($(this).val());
				$("#email2").attr("readonly", true);
			}
		});
	});
	
	//sendContact
	$("#sendContact").click(function(){
		var account = $("#account").val();
		var subject = $("#subject").val();
		var ir1 = $("#ir1").val();
		var email1 = $("#email1").val();
		var email2 = $("#email2").val();
		if(subject.length < 6 || subject.trim()==""){
			$('#subject').focus();
		} else if(ir1.length < 6 || content.trim()=="") {
			$('#ir1').focus();
		} else if(email1.length <= 4 || email1.trim()=="") {
			$('#email1').focus();
		} else if(email2.length <= 4 || email2.trim()=="") {
			$('#email2').focus();
		} else {
			$.ajax({
				url : 'contactMail.do',
				type : 'post',
				datatype : 'json',
				data : {
					'account' : account,
					'subject' : subject,
					'ir1' : ir1,
					'email1' : email1,
					'email2' : email2	
				}, success : function(data){ 
					if(data=="ok"){
						location.href("main.do");
					} else {
						alert("Email 주소가 아닙니다.");
					}
				}
			});
		}
	});
	
	// 네이버 TextArea기능 
	// ‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
	function submitContents(elClickedObj) {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

		// 에디터의 내용에 대한 값 검증은 이곳에서
		// document.getElementById("ir1").value를 이용해서 처리한다.
		try {
			elClickedObj.form.submit();
		} catch (e) {
		}
	}
	
});