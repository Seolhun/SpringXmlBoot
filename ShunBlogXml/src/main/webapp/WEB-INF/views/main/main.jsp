<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>iMediSyn</title>
</head>
<body>
	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('resources/img/home-bg.jpg');">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>iSyncBrain</h1>
						<hr class="large" >
						<span class="subheading">Welcome to iSyncBrain</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div id="naverMap">
					<div id="map" style="width:100%;height:400px;"></div>
				</div>
				<div class="post-preview">
					<a href="post.html">
						<h2 class="post-title">Man must explore, and this is
							exploration at its greatest</h2>
						<h3 class="post-subtitle">Problems look mighty small from 150
							miles up</h3>
					</a>
					<p class="post-meta">
						Posted by <a href="#">Start Bootstrap</a> on September 24, 2014
					</p>
				</div>
				
				<!-- Pager -->
				<ul class="pager">
					<li class="next"><a href="#">Older Posts &rarr;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<hr>
</body>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=PuLsUjuvj6Kfg0EQe7Jh"></script>
<script>
	var HOME_PATH = window.HOME_PATH || 'resources';
	var imedisyn = new naver.maps.LatLng(37.511795, 127.048245),
		map = new naver.maps.Map('map', {
			center: imedisyn.destinationPoint(0, 100),
			zoom : 11, //지도의 초기 줌 레벨
			minZoom : 6, //지도의 최소 줌 레벨
			zoomControl : true, //줌 컨트롤의 표시 여부
		}),
		/* 지도 옵션 */
		marker = new naver.maps.Marker({
			map : map,
			position : imedisyn
		});
	var contentString = [
		    '<div class="iw_inner" style="width : 330px;">',
		    '<h4 style="margin-left : 3px">(주)아이메디신</h4>',
		    '<p style="font-size : 14px; margin : 10px 10px">서울특별시 강남구 봉은사로 443 | 삼성2동 44-14',
		    '<br/>02-747-7422 | 웰니스 헬스케어 솔루션 기업',
		    '<br/><a href="http://imedisyn.com/" target="_blank">http://imedisyn.com/</a>',
		    '<img src="'+ HOME_PATH +'/img/imedisyn.png" width="55" height="55" style="margin-left : 35%"; alt="(주)아이메디신" class="thumb" /></p>',
		    '</div>'
		].join('');
	
	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});
	
	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, imedisyn.destinationPoint(0, 80));
	    }
	});
	infowindow.open(map, imedisyn.destinationPoint(0, 80));
</script>
</html>
