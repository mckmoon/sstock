<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>

    <title>EGLEO</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resources/egleo/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/egleo/css/style.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">
          <img src="${contextPath}/resources/egleo/images/logo.png" alt="EGLEO VISUAL LOGO"/>
        </a>
        <button class="navbar-toggler" type="button" id="menu">
          <img src="${contextPath}/resources/egleo/images/icon_menu.jpg" alt="메뉴"/>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#intro">회사소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#service">서비스소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#price">가격</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">연락처</a>
            </li>
          </ul>
        </div>
        <div class="sliding-menu flex-center-wrapper flex-column right-menu">
          <ul class="">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#intro">회사소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#service">서비스소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#price">가격</a>
            </li>
            <li class="nav-item mb-5">
              <a class="nav-link js-scroll-trigger" href="#contact">연락처</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${contextPath}/registration">회원가입</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${contextPath}/recover">비밀번호 찾기</a>
            </li>
          </ul>
          <span class="sliiider-exit exit right-exit">×</span>
        </div>
      </div>
    </nav>

    <header class="header text-egleo">
      <div class="container text-center">
        <h1>Specialized in Stock Analysis</h1>
        <p class="lead"><b>이글레오 StockDB</b>를 통해 당신만의 노하우를 활용하여 투자 종목을 쉽게 찾을 수 있습니다</p>
        <form class="form-inline" role="form" action="${contextPath}/login" method="post">
          <div class="form-group">
            <input type="email" class="form-control" name="username" size="25" placeholder="Email" required="">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-egleo">지금시작</button>
          </div>
        </form>
        <p class="link-area">
          <a class="link" href="${contextPath}/registration"><b>회원가입</b></a>
          <a class="link" href="${contextPath}/recover">비밀번호 찾기</a>
        </p>
      </div>
        <div class="bg-container">
            <div class="left"></div>
            <div class="right"></div>
        </div>
    </header>

    <section id="intro">
      <div class="container">
        <div class="row">
          <div class="col-12 mx-auto text-center">
            <div class="img-box">
              <img src="${contextPath}/resources/egleo/images/logo_content.jpg" alt="EGLEO VISUAL LOGO CONTENT"/>
            </div>
            <h2>회사 소개</h2>
            <ul class="intro-list">
              <li><b>EagleLeo Financial Technology</b>는 개인화된 투자전략 및 주식정보를 제공하는 금융기술 전문 회사입니다.</li>
              <li>Eagle Leo FT는 StockDB 서비스를 통해 맞춤형 종목 추출 서비스를 제공합니다.</li>
              <li>&nbsp;</li>
              <li><b>Eagle Leo FT</b>는 방대한 주식 데이타를 기반으로 개인이 가진 노하우를 접목하여 자신만의 투자 종목을 검색하도록 지원합니다.</li>
              <li>이를 통해 고객 개인의 자산 상승에 기여하고, 고객의 풍요로운 삶과 안정적인 삶을 지향합니다.</li>
            </ul>
            <!--  
            <button type="button" class="btn btn-default">Get In Touch</button>
            -->
          </div>
        </div>
      </div>
    </section>

    <section id="about">
      <div class="container">
        <div class="row">
          <div class="col-12 mx-auto text-center text-white">
            <h2>EAGLE LEO의 가치</h2>
            <ul class="about-list cf">
              <li class="t">MISSION</li>
              <li class="c text-left">대용량 주식 데이타 처리, AI 기반 주식 데이타 분석, 개인 맞춤형 종목 추출</li>
              <li class="t">VISON</li>
              <li class="c text-left">고객의 풍요로운 삶, 안정적인 삶을 지원하기 위한 금융공학기술 전문 회사</li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <section id="service">
      <div class="container">
        <div class="row">
          <div class="col-12 mx-auto text-center">
            <h2>SERVICES</h2>
            <p class="lead">What we offer</p>
            <ul class="service-list slideanim cf">
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services01.jpg"/></div>
                <strong><a href="${contextPath}/today/main">오늘의종목</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services02.jpg"/></div>
                <strong><a href="${contextPath}/upjong/rising_most">업종분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services03.jpg"/></div>
                <strong><a href="${contextPath}/basic/rising_falling">기본분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services04.jpg"/></div>
                <strong><a href="${contextPath}/finance/year">재무분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services05.jpg"/></div>
                <strong><a href="${contextPath}/sma/ma5_20">이동평균선분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services06.jpg"/></div>
                <strong><a href="${contextPath}/secondary/macd_plus">보조지표분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services07.jpg"/></div>
                <strong><a href="${contextPath}/advance/rising_ndays_min">고급분석</a></strong>
                <p class="text">Lorem iqsum dolor sit amet..</p>
              </li>
              <li>
                <div class="icon"><img src="${contextPath}/resources/egleo/images/icon_services08.jpg"/></div>
                <strong><a href="${contextPath}/simulation/basic/rising_falling">시뮬레이션</a></strong>
                <p class="text">시뮬레이션</p>
              </li>
            </ul>
          </div>
        </div>

        <div class="row" id="price">
          <div class="col-12 mx-auto text-center">
            <h2 class="sub-title">
              <span>가격체계</span>
              <hr class="line"/>
            </h2>
            <p class="sub-lead">Choose a payment plan that works for you</p>
            <ul class="price-list slideanim cf">
              <li class="blue">
                <div class="bar">BLUE</div>
                <ul class="price-item-list">
                  <li>오늘의 종목</li>
                  <li>업종 분석</li>
                  <li>기본 분석</li>
                  <li>&nbsp;</li>
                </ul>
                <div class="info-box">
                  <strong>50,000원</strong>
                  <p>per month</p>
                  <button class="btn btn-price-blue">Sign Up</button>
                </div>
              </li>
              <li class="silver">
                <div class="bar">SILVER</div>
                <ul class="price-item-list">
                  <li>BLUE 기능</li>
                  <li>재무 분석</li>
                  <li>이동평균성 분석</li>
                  <li>보조지표 분석</li>
                </ul>
                <div class="info-box">
                  <strong>100,000원</strong>
                  <p>per month</p>
                  <button class="btn btn-price-silver">Sign Up</button>
                </div>
              </li>
              <li class="gold">
                <div class="bar">GOLD</div>
                <ul class="price-item-list">
                  <li>SILVER 기능</li>
                  <li>고급 분석</li>
                  <li>시뮬레이션</li>
                  <li>&nbsp;</li>
                </ul>
                <div class="info-box">
                  <strong>150,000원</strong>
                  <p>per month</p>
                  <button class="btn btn-price-gold">Sign Up</button>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>

	<footer class="py-12 bg-dark" id="contact">
	<div class="container">
	  <h2 class="text-center">..</h2>
	  <div class="row">
	    <div class="col-sm-6 text-white">
	      <p>Contact us and we'll get back to you within 24 hours.</p>
	      <p><span class="glyphicon glyphicon-map-marker"></span> 서울시 강남구 ...</p>
	      <p><span class="glyphicon glyphicon-phone"></span> (02) 555 - 5555</p>
	      <p><span class="glyphicon glyphicon-envelope"></span> myemail@something.com</p>
	    </div>
	    <div class="col-sm-6 slideanim">
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
	</div><!-- /.contact -->
    </footer>

	<footer class="container-fluid text-center">
	  <a href="#page-top" title="To Top">
	    <span class="glyphicon glyphicon-chevron-up"></span>
	  </a>
	  <p class="m-t"> <small>EagleLeo Financial Technology &copy; 2018</small> </p>
	</footer>

    <!-- Bootstrap core JavaScript -->
    <script src="${contextPath}/resources/egleo/vendor/jquery/jquery.min.js"></script>
    <script src="${contextPath}/resources/egleo/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="${contextPath}/resources/egleo/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${contextPath}/resources/egleo/js/agency.min.js"></script>
    <script src="${contextPath}/resources/egleo/js/sliiide.min.js"></script>
  	<script src="${contextPath}/resources/js/common.js"></script>


    <script type="text/javascript">
        $(document).ready(function(){

            // Slide in elements on scroll
            $(window).scroll(function() {
                $(".slideanim").each(function(){
                    var pos = $(this).offset().top;

                    var winTop = $(window).scrollTop();
                    if (pos < winTop + 700) {
                        $(this).addClass("slide");
                    }
                });
            }).scroll();

            $(".sliding-menu").find("a").on("click", function(){
                $(this).closest("ul").siblings("span.right-exit").trigger("click");
            })


            var settings = {
                toggle: "#menu",
                exit_selector: ".right-exit",
                animation_duration: "0.5s",
                place: "right",
                animation_curve: "cubic-bezier(0.54, 0.01, 0.57, 1.03)",
                body_slide: true,
                no_scroll: true,
                auto_close: false
            };

            $('.right-menu').sliiide(settings);
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

