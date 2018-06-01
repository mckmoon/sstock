<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>StockDB | Registration</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<!-- Modal -->
<div id="dialog_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">               
            </div>            	
        </div>
    </div>
</div>

<div class="middle-box text-center loginscreen   animated fadeInDown">
  <div>
	<div>
    <h4 class="logo-name"><a href="${contextPath}/">SDB</a></h4>
	</div>
	<h3>Register to StockDB</h3>
    <p>서비스를 이용하기 위해서는 가입이 필요합니다</p>
 
    <form:form method="POST" modelAttribute="userForm" class="m-t" role="form" >
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" path="username" class="form-control" placeholder="*이메일 (필수)"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="*암호 (필수: 8자리 이상)"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="*암호 재확인 (필수)"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="birth_date">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="birth_date" class="form-control" placeholder="*생년월일(필수: YYYYMMDD 8자리)"
                            autofocus="true"></form:input>
                <form:errors path="birth_date"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="이름"
                            autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="nickname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="nickname" class="form-control" placeholder="별명"
                            autofocus="true"></form:input>
                <form:errors path="nickname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone_no">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="phone_no" class="form-control" placeholder="전화번호(숫자만)"
                            autofocus="true"></form:input>
                <form:errors path="phone_no"></form:errors>
            </div>
        </spring:bind>

		<spring:bind path="contractAgreement">
			<div class="form-group ${status.error ? 'has-error' : ''}">
                <div class="checkbox i-checks">
                	<form:checkbox path="contractAgreement" label="약관에 동의합니다" autofocus="true"></form:checkbox>
                	<a data-toggle="modal" href="${contextPath}/terms" data-target="#dialog_modal">약관상세</a>
                </div> 
                
					<form:errors path="contractAgreement"></form:errors>                              	
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
        <p class="text-muted text-center"><small>이미 회원이십니까?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="${contextPath}/login">로그인</a>
    </form:form>
    <p class="m-t"> <small>EagleLeo Financial Technology &copy; 2018</small> </p>
  </div>
</div>

    <!-- Mainly scripts -->
    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
        
    	$("#dialog_modal").on("shown.bs.modal",function(){
 		   //will be executed everytime #item_modal is shown
 		   $(this).hide().show(); //hide first and then show here
	 	});
	 		
	 	$("body").on('hidden.bs.modal', '.modal', function () {
	 		  $(this).removeData('bs.modal');
	 	});
    </script>
    
</body>
</html>

