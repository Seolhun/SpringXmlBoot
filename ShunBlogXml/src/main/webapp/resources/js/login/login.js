//로그인 모달
$(function() {
	$('#emailCheck').click(function() {
		var signEmail = $('#signEmail').val();
		var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		if (signEmail.match(regExp)){
			$.ajax({
				type : 'POST',
				url : 'checkEmail',
				data : {
					'signEmail' : signEmail
				},
				success : function(data) {
					if (data == "emailOK") {
						$('#signYes').attr("disabled", false);
					} else {
						$('#signYes').attr("disabled", true);
					}
				}
			}); // end ajax
		} else {
			alert("올바른 이메일이 아닙니다.")
		}
});
	
	//로그인 
	$("#logYes").click(function() {
		var logPwd = $('#logPwd').val();
		var logAccount = $('#logAccount').val();
		if (logAccount.trim() == "" || logAccount.length < 2) {
			$('#logAccount').focus();
		} else if (logPwd.trim() == "" || logPwd.length < 4) {
			$('#logPwd').focus();
		} else {
//			$.ajax({
//				url : 'userLogin.do',
//				type : 'post',
//				datatype : 'json',
//				data : {
//					"logAccount" : logAccount,
//					"logPwd" : logPwd
//				},
//				success : function(data) {
//					if (data == "noid") {
//						alert("아이디가 없습니다.")
//						var logAccount = $('#logAccount').val("");
//						$('#logAccount').focus();
//					} else if (data == "nopwd") {
//						alert("비밀번호가 틀립니다.");
//						var logPwd = $('#logPwd').val("");
//						$('#logPwd').focus();
//					} else {
//						alert("성공");
//						location.reload();
//					}
//				}
//			});
		}
	});

	// 아이디 중복체크 
//	$(document).ready(function() {
//		$('#signAccount').keyup(function() {
//			if ($('#signAccount').val().length > 1) {
//				var signAccount = $('#signAccount').val();
//				// ajax 실행
//				$.ajax({
//					type : 'POST',
//					url : 'accountCheck.do',
//					data : {
//						'signAccount' : signAccount
//					},
//					success : function(data) {
//						if (data == "ok") {
//							$('#result_id_msg').html('사용 가능한 아이디 입니다.');
//							$('#signYes').attr("disabled", false);
//						} else {
//							$('#result_id_msg').html('사용 불가능한 아이디 입니다.');
//							$('#signYes').attr("disabled", true);
//						}
//					}
//				}); // end ajax
//			}
//		}); // end keyup
//	});

	//회원가입 완료 
	$("#signYes").click(function() {
		var signAccount = $('#signEmail').val();
		var signPwd = $('#signPwd').val();
		var signPwd2 = $('#signPwd2').val();
		if (signAccount.trim() == "" || signAccount.length < 2) {
			$('#signEmail').focus();
			$('#signEmail').val("");
			return;
		} else if (signPwd.trim() == "" || signPwd.length < 4) {
			$('#signPwd').focus();
			$('#signPwd').val("");
			return;
		} else if (signPwd2.trim() != signPwd.trim()) {
			$('#signPwd2').focus();
			$('#signPwd2').val("");
			return;
		} else {
			jQuery('#signFrm').submit();
		}
	});
	
	
});

//슬라이드 스크립
var slideIndex = 1;
showSlides(slideIndex);
carousel(); //시간에 따른 이미지 넘기기 효과 

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	if (n > slides.length) {
		slideIndex = 1
	}
	if (n < 1) {
		slideIndex = slides.length
	}
	for (i = 0; i < slides.length; i++) { //같이 존재 
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
}

////슬라이드 스크립트 시간에 따른 자동효과 
function carousel() {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	for (i = 0; i < slides.length; i++) { //같이 존재 
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slideIndex++; //위에거와 차이점 
	if (slideIndex > slides.length) {
		slideIndex = 1
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	setTimeout(carousel, 7000); // Change image every 7 seconds
}
