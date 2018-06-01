<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SmartStock</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">   
    <link href="${contextPath}/resources/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">


</head>

<body>

<div id="wrapper">

<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
            	<sec:authorize access="hasRole('ROLE_USER')">
                <div class="dropdown profile-element"> <span>
                            <strong>Welcome!!</strong>
                             </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear">
                             <span class="block m-t-xs"> 
                             	<strong class="font-bold"><sec:authentication property="principal.username"/></strong>
                             </span> 
                             <span class="text-muted text-xs block"><sec:authentication property="principal.nickname"/><b class="caret"></b>
                             </span> 
                            </span>                           
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="${contextPath}/profile?">Profile</a></li>

                        <li class="divider"></li>
                        <li><a href="${contextPath}/logout">Logout</a></li>
                    </ul>
                </div>
                </sec:authorize> 
                <div class="logo-element">
                    S+                </div>
            </li>
            <li>
                <a href=""><i class="fa fa-th-large"></i> <span class="nav-label">오늘의 종목</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/today/summary">Summary</a></li>                   
                       <li><a href="${contextPath}/today/rising_falling_most">상승/하락</a></li>
                       <li><a href="${contextPath}/today/open_gap">시초가 갭 상승/하락</a></li>
                       <li><a href="${contextPath}/today/renew_low_high">최고가/최저가 갱신</a></li>
                       <li><a href="${contextPath}/today/volume_rising_falling">거래량 급증/급감</a></li>
                </ul>
            </li>
             <li>
                <a href=""><i class="fa fa-th-large"></i> <span class="nav-label">업종 분석</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/upjong/rising_most">요약</a></li>                   
					   <li><a href="${contextPath}/upjong/rising_falling_kospi">KOSPI 업종별 주가변동</a></li>
					   <li><a href="${contextPath}/upjong/rising_falling_kosdaq">KOSDAQ 업종별 주가변동</a></li> 
                </ul>
            </li>
            <li>
                <a href=""><i class="fa fa-th-large"></i> <span class="nav-label">기본분석</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/basic/rising_falling">기간 상승률/하락률</a></li>
                       <li><a href="${contextPath}/basic/fluctuation">기간 주가 변동률</a></li>
                       <li><a href="${contextPath}/basic/cont_rising_falling">연속 상승/하락</a></li>
                       <li><a href="${contextPath}/basic/gongsin">공매도/신용 증가</a></li> 
                       <li><a href="${contextPath}/basic/holder">기관투자자 보유</a></li>
                       <li><a href="${contextPath}/basic/foreign_rate">외인 지분율 변동</a></li>                     
                       <li><a href="${contextPath}/basic/foreign_buying_selling">외국인 연속 매수/매도</a></li>
                       <li><a href="${contextPath}/basic/company_buying_selling">기관 연속 매수/매도</a></li>
                       <li><a href="${contextPath}/basic/view_stock">종목 정보</a></li>
                </ul>
            </li> 
            <li>
                <a href=""><i class="fa fa-th-large"></i> <span class="nav-label">재무분석</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/finance/year">연 재무지표</a></li>
                       <li><a href="${contextPath}/finance/quarter">분기 재무지표</a></li>
                       <li><a href="${contextPath}/finance/year_improve">연 재무지표 연속상승</a></li>
                       <li><a href="${contextPath}/finance/quarter_improve">분기 재무지표 연속상승</a></li>
                </ul>
            </li> 
            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">이동평균선</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/sma/ma5_20">MA(5,20) 돌파</a></li>
                       <li><a href="${contextPath}/sma/ma20_60">MA(20,60) 돌파</a></li>
                       <li><a href="${contextPath}/sma/ma5_20_upward_more_m">MA(5,20) 강한 상향 돌파</a></li>
                       <li><a href="${contextPath}/sma/ma5_20_downward_more_m">MA(5,20) 강한 하향 돌파</a></li>
                       <li><a href="${contextPath}/sma/ma_arrange">MA 정/역배열</a></li>
					   <li><a href="${contextPath}/sma/convergent_ma5_20">수렴상태에서 MA(5,20) 돌파</a></li>
					   <li><a href="${contextPath}/sma/week_ma5_20">주봉 MA(5,20) 돌파</a></li>
                       <li><a href="${contextPath}/sma/week_ma20_60">주봉 MA(20,60) 돌파</a></li>
                       <li><a href="${contextPath}/sma/ma5_20_more_k">기간내 MA(5,20) 복수번 돌파</a></li>
                </ul>
            </li>
            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">보조지표</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="#">MACD(12,26,9) <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/secondary/macd_plus"> + 전환</a></li>
	                       <li><a href="${contextPath}/secondary/macd_rising_falling"> 상승/하락 추세</a></li>
	                       <li><a href="${contextPath}/secondary/macd_golden_dead">골든/데드크로스</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">RSI(14,9) <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/secondary/rsi">RSI M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/secondary/rsi_updown">RSI M% 돌파</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Stochastic slow(10,5,5) <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/secondary/stocastic_slow">slowD M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/secondary/stocastic_updown">slowD M% 돌파</a></li>
	                       <li><a href="${contextPath}/secondary/stocastic_golden_dead">골든/데드크로스</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">체결강도 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/secondary/deal_strength">체결강도 M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/secondary/deal_strength_rising_falling">체결강도 M% 상승/하락</a></li>
                        </ul>
                    </li>
                     <li>
                        <a href="#">투자심리선 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/secondary/psychology_line10">심리선 M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/secondary/psychology_line10_updown">심리선  전환</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="${contextPath}/secondary/seperation_rate">이평선 이격률 <span class="fa arrow"></span></a>
                    </li>
	
                </ul>
            </li>
            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">고급 분석</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/advance/pattern_analysis">패턴 분석</a></li> 
                       <li><a href="${contextPath}/advance/rising_ndays_min">기간 최저가 대비 상승</a></li>
                       <li><a href="${contextPath}/advance/falling_ndays_max">기간 최고가 대비 하락</a></li>
                       <li><a href="${contextPath}/advance/rising_ndays_min_negative_pole">기간 최저가 대비 상승후 음봉</a></li>
                       <li><a href="${contextPath}/advance/falling_ndays_max_positive_pole">기간 최고가 대비 하락후 양봉</a></li> 
                       <li><a href="${contextPath}/advance/volume_rate_ndays_avg">기간 평균거래량 대비율</a></li> 
      
                </ul>
            </li>

            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">시뮬레이션</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="#">기본분석 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/simulation/basic/rising_falling">기간 상승률/하락률</a></li>
	                       <li><a href="${contextPath}/simulation/basic/fluctuation">기간 주가 변동률</a></li>
	                       <li><a href="${contextPath}/simulation/basic/cont_rising_falling">연속 상승/하락</a></li>
	                       <li><a href="${contextPath}/simulation/basic/gongsin">공매도/신용 증가</a></li> 
	                       <li><a href="${contextPath}/simulation/basic/holder">기관투자자 보유</a></li>
	                       <li><a href="${contextPath}/simulation/basic/foreign_rate">외인 지분율 변동</a></li>                     
	                       <li><a href="${contextPath}/simulation/basic/foreign_buying_selling">외국인 연속 매수/매도</a></li>
	                       <li><a href="${contextPath}/simulation/basic/company_buying_selling">기관 연속 매수/매도</a></li>							
                        </ul>
                    </li>
 
                    <li>
                        <a href="#">이동평균선 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/simulation/sma/ma5_20">MA(5,20) 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/ma20_60">MA(20,60) 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/ma5_20_upward_more_m">MA(5,20) 강한 상향 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/ma5_20_downward_more_m">MA(5,20) 강한 하향 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/ma_arrange">MA 정/역배열</a></li>
						   <li><a href="${contextPath}/simulation/sma/convergent_ma5_20">수렴상태에서 MA(5,20) 돌파</a></li>
						   <li><a href="${contextPath}/simulation/sma/week_ma5_20">주봉 MA(5,20) 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/week_ma20_60">주봉 MA(20,60) 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/sma/ma5_20_more_k">기간내 MA(5,20) 복수번 돌파</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">보조지표 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/simulation/secondary/macd_plus"> MACD + 전환</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/macd_rising_falling">MACD 상승/하락 추세</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/macd_golden_dead">MACD 골든/데드크로스</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/rsi">RSI M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/rsi_updown">RSI M% 돌파</a></li>
 	                       <li><a href="${contextPath}/simulation/secondary/stocastic_slow">slowD M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/stocastic_updown">slowD M% 돌파</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/stocastic_golden_dead">Stocastic 골든/데드크로스</a></li>
 	                       <li><a href="${contextPath}/simulation/secondary/deal_strength">체결강도 M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/deal_strength_rising_falling">체결강도 M% 상승/하락</a></li>
 	                       <li><a href="${contextPath}/simulation/secondary/psychology_line10">심리선 M% 이상/이하</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/psychology_line10_updown">심리선  전환</a></li>
	                       <li><a href="${contextPath}/simulation/secondary/seperation_rate">이평선 이격률 <span class="fa arrow"></span></a></li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="#">고급분석 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
	                       <li><a href="${contextPath}/simulation/advance/rising_ndays_min">기간 최저가 대비 상승</a></li>
	                       <li><a href="${contextPath}/simulation/advance/falling_ndays_max">기간 최고가 대비 하락</a></li>
	                       <li><a href="${contextPath}/simulation/advance/rising_ndays_min_negative_pole">기간 최저가 대비 상승후 음봉</a></li>
	                       <li><a href="${contextPath}/simulation/advance/falling_ndays_max_positive_pole">기간 최고가 대비 하락후 양봉</a></li> 
	                       <li><a href="${contextPath}/simulation/advance/volume_rate_ndays_avg">기간 평균거래량 대비율</a></li>
                        </ul>
                    </li>
	
                </ul>
            </li>
            
            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">고객 지원</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/board/boardList?bgno=1">공지사항</a></li>
                       <li><a href="${contextPath}/board/boardList?bgno=2">질문/응답</a></li>
                       <li><a href="${contextPath}/product/productList?denied=no">상품 구매</a></li>
                       <li><a href="">Menu item</a></li>
                </ul>
            </li>
            <li>
                <a href=""><i class="fa fa-diamond"></i> <span class="nav-label">관리자</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                       <li><a href="${contextPath}/admin/boardGroupList">게시판 관리</a></li>
                       <li><a href="${contextPath}/admin/UserList">회원 관리</a></li>
                       <li><a href="${contextPath}/admin/ProductList">상품 관리</a></li>
                       <li><a href="${contextPath}/admin/InqueryList">고객문의 관리</a></li>
                       <li><a href="">Menu item</a></li>
                </ul>
            </li>            
        </ul>

    </div>
</nav>

<div id="page-wrapper" class="gray-bg">

   <div class="row border-bottom" class="breadcrumb">
   <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
        </div>
		<div class="navbar-collapse collapse" id="navbar">

           <ul class="nav navbar-top-links navbar-right">
            	<li>
				<sec:authorize access="hasRole('ROLE_USER')">             
                   <a href="${contextPath}/logout">
                       <i class="fa fa-sign-out"></i> Log out
                   </a>
				</sec:authorize>
				<sec:authorize access="!hasRole('ROLE_USER')">
                   <a href="${contextPath}/login">
                       <i class="fa fa-sign-in"></i> Login
                   </a>              
				</sec:authorize>
				</li>
           </ul>
		</div>
   </nav>
   </div>   

