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

    <title>StockDB | Password Recovery</title>

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
	<h3>암호 재설정</h3>
    <p>고객님의 가입 계정 이메일로 임시 암호를 보내 드립니다.</p>
 
    <form method="POST" action="recover" >
        <div class="form-group ">
            <input type="email" name="username" class="form-control" placeholder="이메일 " autofocus="true">
        </div>
        <div id="notice"></div>

        <input type="button" class="btn btn-lg btn-primary btn-block" value="임시 암호 요청">      
    </form>
    <br>
        <div>
        <h4 class="text-muted text-center"><a href="${contextPath}/">메인페이지</a></h4>
		</div>

    <p class="m-t"> <small>EagleLeo Financial Technology &copy; 2017</small> </p>
  </div>
</div>

    <!-- Mainly scripts -->
    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<script>
	var em_frm = $("input[name=username]");
	var em_ck = 0;
	var _authCode;
	
	$(".btn").click(function(){

		$.ajax({
			type: 'POST',
			url: 'recover',
			data: {
				"email" : $(em_frm).val()
			},
			success: function(data){
				if(data=='0'){
					$('#notice').html(
	'<font size="2" color="red">해당 계정이 없습니다. 다시 입력해주세요.</font>');
					$(em_frm).val("");
					$(em_frm).focus();
				}else if(data=='1'){
					$('#notice').html(
	'<font size="2" color="red">이메일 전송에 에러가 발생했습니다. 다시 시도해주세요.</font>');
					$(em_frm).val("");
					$(em_frm).focus();

				}else {
					_authCode = data;
					$("#_time").html("");
					$('#notice').html(
	'<font size="2" color="green">임시 암호가 메일로 전송되었습니다.</font><br/>');
					countDown();
				}
			}
		});//end ajax 
	});
	
	</script>
	   
</body>
</html>
