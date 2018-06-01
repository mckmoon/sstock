<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<%@ include file="../include/header.jsp" %>

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

<body class="top-navigation">


<div id="page-wrapper" class="gray-bg">
   <div class="row border-bottom white-bg" class="breadcrumb">
   <nav class="navbar navbar-static-top" role="navigation">
       <div class="navbar-header">
           <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
               <i class="fa fa-reorder"></i>
           </button>
           <a href="#" class="navbar-brand">SmartStock</a>
       </div>
       <div class="navbar-collapse collapse" id="navbar">
           <ul class="nav navbar-nav">
               <li class="active">
                   <a aria-expanded="false" role="button" href="/user/profile.jsp"> Welcome 
                   <sec:authorize access="hasRole('ROLE_USER')">
                   <sec:authentication property="principal.nickname"/>
                   </sec:authorize>
                   </a>
               </li>
               <li class="dropdown">
                   <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Today's Stock <span class="caret"></span></a>
                   <ul role="menu" class="dropdown-menu">
                       <li><a href="${contextPath}/today/main">Summary</a></li>
                       <li><a href="${contextPath}/today/rising_falling">기간 상승률/하락률</a></li>
                       <li><a href="${contextPath}/today/fluctuation">기간 주가 변동률</a></li>
                       <li><a href="${contextPath}/today/rising_ndays_min">기간 최저가 대비 상승률</a></li>
                       <li><a href="${contextPath}/today/falling_ndays_max">기간 최고가 대비 하락률</a></li>
                       <li><a href="${contextPath}/today/rising_ndays_min_negative_pole">기간 최저가 대비 상승후 음봉</a></li>
                       <li><a href="${contextPath}/today/falling_ndays_max_positive_pole">기간 최고가 대비 하락후 양봉</a></li>                      
                       <li><a href="${contextPath}/today/most_rising_falling">가장 많이 상승/하락</a></li>
                       <li><a href="${contextPath}/today/open_gap">시초가 갭 상승/하락</a></li>
                       <li><a href="${contextPath}/today/cont_rising_falling">연속 상승/하락</a></li>
                       <li><a href="${contextPath}/today/renew_low_high">최고가/최저가 갱신</a></li>
                       <li><a href="${contextPath}/today/gongsin">공매도/신용 증가</a></li> 
                       <li><a href="${contextPath}/today/holder">기관투자자 보유</a></li>
                       <li><a href="${contextPath}/today/foreign_rate">외인 지분율 변동</a></li>                     
                       <li><a href="${contextPath}/today/foreign_buying_selling">외국인 연속 매수/매도</a></li>
                       <li><a href="${contextPath}/today/company_buying_selling">기관 연속 매수/매도</a></li>

                   </ul>
               </li>
               <li class="dropdown">
                   <a aria-expanded="false" role="button" href="" class="dropdown-toggle" data-toggle="dropdown"> Screen Stock <span class="caret"></span></a>
                   <ul role="menu" class="dropdown-menu">
                       <li><a href="${contextPath}/screen/screen1">Screen1</a></li>
                       <li><a href="${contextPath}/screen/screen2">Screen2</a></li>

                   </ul>
               </li>
               <li class="dropdown">
                   <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> CustomerSupport <span class="caret"></span></a>
                   <ul role="menu" class="dropdown-menu">
                       <li><a href="${contextPath}/board/boardList?bgno=1">공지사항</a></li>
                       <li><a href="${contextPath}/board/boardList?bgno=2">질문/응답</a></li>
                       <li><a href="">Menu item</a></li>
                       <li><a href="">Menu item</a></li>
                   </ul>
               </li>
               <li class="dropdown">
                   <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Admin <span class="caret"></span></a>
                   <ul role="menu" class="dropdown-menu">
                       <li><a href="${contextPath}/admin/boardGroupList">게시판 관리</a></li>
                       <li><a href="">회원 관리</a></li>
                       <li><a href="">Menu item</a></li>
                       <li><a href="">Menu item</a></li>
                   </ul>
               </li>
           </ul>
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
