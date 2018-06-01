<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>StockDB | Login </title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="loginColumns animated fadeInDown">
	    <div class="row">
	
	        <div class="col-md-6">
	            <h2 class="font-bold">Welcome to StockDB</h2>
	<br></br>
	            <p>
	                2000개가 넘는 종목 중에 당신이 원하는 종목을 찾을 수 있습니까? 그동안 증권방송, 찌라시에 혹하여 당신의 귀중한 시간과 돈을 낭비하지 않았나요?
	            </p>
	
	            <p>
	                               당신만이 가진 노하우로 직접 조건을 설정해서 당신의 포트폴리오를 구성하세요. <br></br>
	                               우량한 종목 중에 장기간 오르지 않는 종목을 찾아서 다른 사람보다 먼저 투자를 시작하시기 바랍니다.
	            </p>
	
	            <p>
	                StockDB는 당신의 능력이 빛이 될 수 있도록 도와드립니다.           
	            </p>
	
	            <p>
	                <small>.</small>
	            </p>
	
	        </div>
	        <div class="col-md-6">
	            <div class="ibox-content">
	                <form class="form-signin" role="form" action="${contextPath}/login" method="post">
	                
	                <div class="form-group ${error != null ? 'has-error' : ''}">
	                	<span>${message}</span>
	                    <input type="email" name="username" class="form-control" placeholder="Email" required="">
						<span>${error}</span>
	                </div>
	                <div class="form-group ${error != null ? 'has-error' : ''}">
	                	<span>${message}</span>
	                    <input type="password" name="password" class="form-control" placeholder="Password" required="">
	                    <span>${error}</span>
	                </div>
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
	
	                <a href="${contextPath}/recover">
	                    <small>Forgot password?</small>
	                </a>
	
	                <p class="text-muted text-center">
	                    <small>Do not have an account?</small>
	                </p>
	                <a class="btn btn-sm btn-white btn-block" href="${contextPath}/registration">Create an account</a>
	            </form>
	            <p class="m-t">
	                <small></small>
	            </p>
	        </div>
	    </div>
	</div>
	<hr/>            
	<div class="row">
	    <div class="col-md-6">
	        Copyright  EagleLeo Company
	    </div>
	    <div class="col-md-6 text-right">
	       <small>© 2017</small>
	    </div>
	</div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
