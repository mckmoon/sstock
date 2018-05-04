
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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

    <title>권한체크</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">   

</head>
 
<sec:authentication property="principal.username"/> ${errMsg }

<p> 당신의 권한: <sec:authentication property="Authorities"/> </p>


<p> 추가 결제가 필요합니다. </p>
