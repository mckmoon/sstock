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
	<h3>StockDB 회원 가입 완료</h3>
    <p>서비스를 이용하기 위해서는 이메일 인증이 필요합니다</p>

	<div class="form-group">
		<input class="form-conrol" type="text" name="email" value="${email}" readOnly>
		<span style="font-size:4pt;color:red" id="_time"></span>
	</div>
	<div class="form-group">
		<span style="display:block" id="first">
		<input class="form-conrol" id="authEmail" type="button"  value="이메일 인증">
		<strong><a href='${contextPath}/today/summary'>차후에 인증받기</a></strong>
		</span>
	</div>
	<span style="display:none" id="again">
		<input type="button" class="auth_again" value="다시 요청하기">
	</span>
	<br/>

	<div id="notice">
	</div>
	<div id="auth" class="form-group" style="display:none">
	   <input class="form-conrol" type="text" name="auth_code" id="auth_code" placeholder="인증번호를입력하세요.">
	   <input class="form-conrol" type="button" id="codeAuth" value="인증하기">
	</div>
	<div id="notice1">
	</div>




    <p class="m-t"> <small>EagleLoe Company &copy; 2017</small> </p>
  </div>
</div>

    <!-- Mainly scripts -->
    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<script>
	var em_frm = $("input[name=email]");
	var em_ck = 0;
	var _authCode;
	
	$("#authEmail").click(function(){
		$("#_time").html("전송중 ...");
		$.ajax({
			type: 'POST',
			url: '${contextPath}/authEmail',
			data: {
				"email" : $(em_frm).val()
			},
			success: function(data){
				if(data=='0'){
					$('#notice').html(
	'<font size="2" color="red">이메일 전송에 실패했습니다. 다시 입력해주세요.</font>');
					$(em_frm).val("");
					$(em_frm).focus();

				}else {
					_authCode = data;
					$("#_time").html("");
					$("#first").attr("style","display:none");
					$("#again").attr("style","display:none");
					$('#auth').attr("style", "display:block");
					$('#notice').html(
	'<font size="2" color="green">메일이 전송되었습니다.</font><br/>');
				}
			}
		});//end ajax 
	});
	
	</script>

	<script>
	$("#codeAuth").click(function(){
		auth_code = $("input[name=auth_code]").val();
		//alert(auth_code);
		if(_authCode == auth_code ){
			$.ajax({
				url: '${contextPath}/confEmail',
				type: 'GET',
				success: function(data) {
					alert(data);
					if (data == '1') {
					$("#notice1").html(
					"<font size='2' color='green'>이메일 인증이 완료되었습니다.</font><p><a href='${contextPath}/today/summary'>서비스 들어가기</a> </p>");	
					} else {
						alert("이미 인증이 완료된 계정입니다.");
						$("#notice1").html(
						"<p><a href='${contextPath}/today/summary'>서비스 들어가기</a> </p>");	
					}
				},
				error: function(data) {
					alert("error"+data);
				}
			});

		}
			
	});
	</script>
			    
</body>
</html>

