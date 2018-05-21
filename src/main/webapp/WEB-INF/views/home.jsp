<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="kr">
<head>

  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <!-- Mainly scripts --> 
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">


  <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>


  <!-- Custom and plugin javascript -->
  <script src="${contextPath}/resources/js/inspinia.js"></script>
  <script src="${contextPath}/resources/js/common.js"></script>


  <style>
  body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
  h2 {
      font-size: 24px;
      text-transform: uppercase;
      color: #303030;
      font-weight: 600;
      margin-bottom: 30px;
  }
  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }  
  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 100px 25px;
      font-family: Montserrat, sans-serif;
  }
  .jumbotron .link {

      background-color: #f4511e;
      color: #fff;
      font-size: 13px
  }
  .container-fluid {
      padding: 60px 50px;
  }
  .bg-grey {
      background-color: #f6f6f6;
  }
  .logo-small {
      color: #f4511e;
      font-size: 50px;
  }
  .logo {
      color: #f4511e;
      font-size: 200px;
  }

  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail img {
      width: 100%;
      height: 100%;
      margin-bottom: 10px;
  }
  .carousel-control.right, .carousel-control.left {
      background-image: none;
      color: #f4511e;
  }
  .carousel-indicators li {
      border-color: #f4511e;
  }
  .carousel-indicators li.active {
      background-color: #f4511e;
  }
  .item h4 {
      font-size: 19px;
      line-height: 1.375em;
      font-weight: 400;
      font-style: italic;
      margin: 70px 0;
  }
  .item span {
      font-style: normal;
  }
  .panel {
      border: 1px solid #f4511e; 
      border-radius:0 !important;
      transition: box-shadow 0.5s;
  }
  .panel:hover {
      box-shadow: 5px 0px 40px rgba(0,0,0, .2);
  }
  .panel-footer .btn:hover {
      border: 1px solid #f4511e;
      background-color: #fff !important;
      color: #f4511e;
  }
  .panel-heading {
      color: #fff !important;
      background-color: #f4511e !important;
      padding: 25px;
      border-bottom: 1px solid transparent;
      border-top-left-radius: 0px;
      border-top-right-radius: 0px;
      border-bottom-left-radius: 0px;
      border-bottom-right-radius: 0px;
  }
  .panel-footer {
      background-color: white !important;
  }
  .panel-footer h3 {
      font-size: 32px;
  }
  .panel-footer h4 {
      color: #aaa;
      font-size: 14px;
  }
  .panel-footer .btn {
      margin: 15px 0;
      background-color: #f4511e;
      color: #fff;
  }
  .navbar {
      margin-bottom: 0;
      background-color: #f4511e;
      z-index: 9999;
      border: 0;
      font-size: 12px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
      font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
      color: #f4511e !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      color: #fff !important;
  }
  footer .glyphicon {
      font-size: 20px;
      margin-bottom: 20px;
      color: #f4511e;
  }
  .slideanim {visibility:hidden;}
  .slide {
      animation-name: slide;
      -webkit-animation-name: slide;
      animation-duration: 1s;
      -webkit-animation-duration: 1s;
      visibility: visible;
  }
  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
        width: 100%;
        margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">StockDB</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">회사소개</a></li>
        <li><a href="#services">서비스소개</a></li>
        <li><a href="#pricing">가격</a></li>
        <li><a href="#contact">연락처</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>Specialized in Stock Analysis</h1> 
  <p>StockDB를 통해 당신만의 노하우를 활용하여 투자 종목을 쉽게 찾을수 있습니다.</p> 
  <form class="form-inline" role="form" action="${contextPath}/login" method="post">
    <div class="form-group">
      <input type="email" class="form-control" name="username" size="25" placeholder="Email" required=>
    </div>
    <div class="form-group">
      <input type="password" class="form-control" name="password" placeholder="Password">
	</div>
    <div class="form-group">
        <button type="submit" class="btn btn-danger">지금시작</button>
    </div>
  </form>
  <p>
	<a class="link" href='${contextPath}/registration'><b>회원가입</b></a>
	<a class="link" href='${contextPath}/recover'>비밀번호 찾기</a>
  </p>

</div>


<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row">
    <div class="col-sm-8">
      <h2>회사 소개</h2><br>
      <h4>EagleLeo Financial Technology는 개인화된 투자전략 및 주식정보를 제공하는 금융기술 전문 회사입니다. EegleLeo FT는 StockDB 서비스를 통해 개인 맞춤형 종목 추출 서비스를 제공합니다.</h4><br>
      <p>EagleLeo FT는 방대한 주식 데이타를 기반으로 개인이 가진 노하우를 접목하여 자신만의 투자 종목을 검색하도록 지원합니다. 이를 통해 고객 개인의 자산 상승에 기여하고, 고객의 풍요로운 삶과 안정적인 삶을 지향합니다.</p>
      <br><a href="${contextPath}/today/main"><button class="btn btn-default btn-lg">Get in Touch</button></a>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-signal logo"></span>
    </div>
  </div>
</div>

<div class="container-fluid bg-grey">
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-globe logo slideanim"></span>
    </div>
    <div class="col-sm-8">
      <h2>EagleLeo의 가치</h2><br>
      <h4><strong>MISSION:</strong> 대용량 주식 데이타 처리, AI 기반 주식 데이타 분석, 개인 맞춤형 종목 추출 </h4><br>
      <p><strong>VISION:</strong> 고객의 풍요로운 삶, 안정적인 삶을 지원하기 위한 금융공학기술 전문 회사 </p>
    </div>
  </div>
</div>

<!-- Container (Services Section) -->
<div id="services" class="container-fluid text-center">
  <h2>SERVICES</h2>
  <h4>What we offer</h4>
  <br>
  <div class="row slideanim">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-heart logo-small"></span>
      <h4><a href="${contextPath}/today/main">오늘의종목</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-heart logo-small"></span>
      <h4><a href="${contextPath}/upjong/rising_most">업종분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-off logo-small"></span>
      <h4><a href="${contextPath}/basic/rising_falling">기본분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
  </div>
  <br><br>    
 
  <div class="row slideanim">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-off logo-small"></span>
      <h4><a href="${contextPath}/finance/year">재무분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>

    <div class="col-sm-4">
      <span class="glyphicon glyphicon-lock logo-small"></span>
      <h4><a href="${contextPath}/sma/ma5_20">이동평균선분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-leaf logo-small"></span>
      <h4><a href="${contextPath}/secondary/macd_plus">보조지표분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
  </div>
  <br><br>

  <div class="row slideanim">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-certificate logo-small"></span>
      <h4><a href="${contextPath}/advance/rising_ndays_min">고급분석</a></h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-wrench logo-small"></span>
      <h4 style="color:#303030;"><a href="${contextPath}/simulation/basic/rising_falling">시뮬레이션</a></h4>
      <p>시뮬레이션</p>
    </div>
  </div>
</div>


<!-- Container (Pricing Section) -->
<div id="pricing" class="container-fluid">
  <div class="text-center">
    <h2>가격체계</h2>
    <h4>Choose a payment plan that works for you</h4>
  </div>
  <div class="row slideanim">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>BLUE</h1>
        </div>
        <div class="panel-body">
          <p><strong>오늘의 종목</strong></p>
          <p><strong>업종 분석</strong></p>
          <p><strong>기본 분석</strong></p>
        </div>
        <div class="panel-footer">
          <h3>50,000원</h3>
          <h4>per month</h4>
          <button class="btn btn-lg">Sign Up</button>
        </div>
      </div>      
    </div>     
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>SILVER</h1>
        </div>
        <div class="panel-body">
          <p><strong>BLUE 기능</strong></p>
          <p><strong>재무 분석</strong></p>
          <p><strong>이동평균선 분석</strong></p>
          <p><strong>보조지표 분석</strong></p>
          <p><strong></strong></p>
        </div>
        <div class="panel-footer">
          <h3>100,000원</h3>
          <h4>per month</h4>
          <button class="btn btn-lg">Sign Up</button>
        </div>
      </div>      
    </div>       
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>GOLD</h1>
        </div>
        <div class="panel-body">
          <p><strong>SILVER 기능</strong></p>
          <p><strong>고급 분석</strong></p>
          <p><strong>시뮬레이션</strong></p>
        </div>
        <div class="panel-footer">
          <h3>150,000원</h3>
          <h4>per month</h4>
          <button class="btn btn-lg">Sign Up</button>
        </div>
      </div>      
    </div>    
  </div>
</div>

<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">CONTACT</h2>
  <div class="row">
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> 서울시 강남구 ...</p>
      <p><span class="glyphicon glyphicon-phone"></span> (02) 555 - 5555</p>
      <p><span class="glyphicon glyphicon-envelope"></span> myemail@something.com</p>
    </div>
    <div class="col-sm-7 slideanim">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="cust_name" name="cust_name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="cust_email" name="cust_email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="cust_content" name="cust_content" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <input class="btn btn-default pull-right" type="button" id="contact_submit" value="Send">
        </div>
      </div>
    </div>
  </div>
</div>



<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p class="m-t"> <small>EagleLeo Company &copy; 2017</small> </p>
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Prevent default anchor click behavior
    event.preventDefault();

    // Store hash
    var hash = this.hash;

    // Using jQuery's animate() method to add smooth page scroll
    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 900, function(){
   
      // Add hash (#) to URL when done scrolling (default click behavior)
      window.location.hash = hash;
    });
  });
  
  // Slide in elements on scroll
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

<script>
	var cust_name = $("input[name=cust_name]");
	var cust_email = $("input[name=cust_email]");
	var cust_content = $("#cust_content");
	
	$("#contact_submit").click(function(){
		alert(cust_content.val());
		
		$.ajax({
			type: 'POST',
			url: '${contextPath}/contact',
			data: {
				"name" : $(cust_name).val(),
				"email" : $(cust_email).val(),
				"content" : $(cust_content).val()
			},
			success: function(data){
				if(data=='0'){
					alert("내용이 관리자에게 전달되었습니다. 연락드리겠습니다. 감사합니다.");
				}
			}
		});//end ajax 
	});
	
</script>
</body>

</html>

