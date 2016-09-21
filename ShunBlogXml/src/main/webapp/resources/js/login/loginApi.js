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
	console.log('Email: ' + profile.getEmail());
}

function onLogin(googleUser) {
	var google_id_token = googleUser.getAuthResponse().id_token;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'https://www.googleapis.com/oauth2/v3/tokeninfo?id_token='
			+ google_id_token);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('idtoken=' + google_id_token);
	xhr.onload = function() {
		console.log('Signed in responseText: ' + xhr.responseText);
		var data = xhr.responseText;
		var jsonResponse = JSON.parse(data);
		var checkVerify = jsonResponse["email_verified"];
		var verifyEmail = jsonResponse["email"];
		if (checkVerify) { //우리 회사 디비와 비교하여 로그인을 시도한다.
			$.ajax({
				type : 'POST',
				url : 'ownUserCheck',
				//timeout : 20000,//20초 //milliseconds : 1000분의 1
				data : {
					'signEmail' : verifyEmail
				},
				success : function(data) {
					if (data == "needSign") {
						$('#signEmail').attr("value", verifyEmail);
						$('#signEmail').attr("disabled", true);
					} else { //
						location.reload();
					}
				},
				error : function(e) {
					console.log("ERROR : ", e);
					display(e);
				}
			}); // end ajax
		} else {
			alert("Google Login Fail")
		}
	}
}

function google_login() {

}

//구글 로그아웃 기능 구현
function signOut() {
	var auth2 = gapi.auth2.getAuthInstance();
	auth2.signOut().then(function() {
		console.log('User signed Out.');
	});
	location.reload();
}

function onLoad() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
	});
}

