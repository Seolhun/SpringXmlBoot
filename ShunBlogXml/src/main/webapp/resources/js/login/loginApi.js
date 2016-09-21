//Google Login JS

//구글 회원가입 버튼 구성
function renderButton() {
	gapi.signin2.render('my-signin2', {
		'scope' : 'profile email',
		'width' : 240,
		'height' : 50,
		'longtitle' : true,
		'theme' : 'dark',
		'onsuccess' : onSuccess,
		'onfailure' : onFailure
	});
}

//실패시에 에러를 출력한다.
function onFailure(error) {
	console.log(error);
}

//성공시에 콘솔 로그에 Token 값을 불러온다.
function onSuccess(googleUser) {
	var profile = googleUser.getBasicProfile();
	console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	console.log('Name: ' + profile.getName());
	console.log('Image URL: ' + profile.getImageUrl());
	console.log('Email: ' + profile.getEmail());
	//성공 시 구글에서버에서 토큰값을 반환받는다.
	var google_id_token = googleUser.getAuthResponse().id_token;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'https://www.googleapis.com/oauth2/v3/tokeninfo?id_token='+google_id_token);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('idtoken=' + google_id_token);
	xhr.onload = function() {
	  console.log('Signed in as: ' + xhr.responseText);
//		var data=xhr.responseText;
//		var jsonResponse = JSON.parse(data);
//		var checkVerify=jsonResponse["email_verified"];
//		var verifyEmail=jsonResponse["email"];
//		if(jsonResponse["email_verified"]){
//			$.ajax({
//				type : 'POST',
//				url : 'checkEmail',
//				data : {
//					'signEmail' : verifyEmail
//				},
//				success : function(data) {
//					if (data == "emailOK") {
//						$('#signYes').attr("disabled", false);
//					} else {
//						$('#signYes').attr("disabled", true);
//					}
//				}
//			}); // end ajax
//		} else {
//			alert("Google Login Fail")
//		}
	}


}

//로그아웃 기능 구현
function signOut() {
	var auth2 = gapi.auth2.getAuthInstance();
	auth2.signOut().then(function() {
		console.log('User signed Out.');
	});
}