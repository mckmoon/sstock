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

<div class="middle-box text-center loginscreen   animated fadeInDown">
  <div>
	<div>
    <h4 class="logo-name"><a href="${contextPath}/">SDB</a></h4>
	</div>
	<h3>고객 정보</h3>
    <p>고객 정보를 항상 최신 정보로 유지해 주세요.</p>
 
    <form:form method="POST" modelAttribute="userForm" action="profile" class="m-t" role="form" >
            <div class="form-group" >
                <form:input type="email" path="username" class="form-control" placeholder="*이메일 (필수)"
                            value="${userForm.username }" readOnly="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>

		<!-- 
        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="*암호 (필수: 8자리 이상)"
                		value="${userForm.password }"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="*암호 재확인 (필수)" value="${userForm.passwordConfirm }"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
         -->
         
        <spring:bind path="birth_date">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="birth_date" class="form-control" placeholder="*생년월일(필수: 8자리)"
                            value="${userForm.birth_date }" autofocus="true"></form:input>
                <form:errors path="birth_date"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="이름"
                            value="${userForm.name }" autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="nickname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="nickname" class="form-control" placeholder="별명"
                            value="${userForm.nickname }" autofocus="true"></form:input>
                <form:errors path="nickname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone_no">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="phone_no" class="form-control" placeholder="전화번호(숫자만)"
                            value="${userForm.phone_no }" autofocus="true"></form:input>
                <form:errors path="phone_no"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">회원정보 수정</button>

    </form:form>
<c:if test="${update == 'ok'}">
	<script>
		alert("회원 정보가 수정 되었습니다.");
	</script>
 	<a href="${contextPath}/today/summary">Today > 요약</a> 
</c:if>
    <p class="m-t"> <small>EagleLoe Company &copy; 2017</small> </p>
  </div>
</div>

    <!-- Mainly scripts -->
    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    
</body>
</html>
