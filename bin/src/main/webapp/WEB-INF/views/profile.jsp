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
		<div id="modal-pwConf" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <h3 class="m-t-none m-b">기존 비밀번호 확인</h3>
                                	<input type="hidden" name="username" value="${userForm.username }"></input>
                                    <div class="form-group"><label class="col-lg-2 control-label">비밀번호</label>
                                    	<div class="col-lg-4"> 
                                    	<input type="password" name="password" placeholder="Password" class="form-control">
                                    	</div>
                                    </div>
                                    <div class="form-group">
                                    	<div class="col-lg-4">
                                    	<input class="btn btn-sm btn-primary pull-right m-t-n-xs" type="button" id="confirmPw" value="확인">
                                    	</div>                                       
                                        
                                    </div>
                                                        
                    </div>
                </div>
                </div>
            </div>
		</div>

		<div id="modal-pwChange" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <h3 class="m-t-none m-b">비밀번호 변경</h3>
                                	<input type="hidden" name="username1" value="${userForm.username }"></input>
                                    <div class="form-group"><label class="col-lg-2 control-label">비밀번호</label>
                                    	<div class="col-lg-4"> 
                                    	<input type="password" name="password1" placeholder="Password" class="form-control">
                                    	</div>
                                    </div>
                                    <div class="form-group"><label class="col-lg-2 control-label">비밀번호 재확인</label>
                                    	<div class="col-lg-4"> 
                                    	<input type="password" name="password2" placeholder="Password" class="form-control">
                                    	</div>
                                    </div>
                                    <div class="form-group">
                                    	<div class="col-lg-4">
                                    	<input class="btn btn-sm btn-primary pull-right m-t-n-xs" type="button" id="changePw" value="확인">
                                    	</div>                                       
                                        
                                    </div>
                                                        
                    </div>
                </div>
                </div>
            </div>
		</div>
		
<div >
  <div>
	<div>
    <p class="logo-name text-center"><a href="${contextPath}/">SDB</a></p>
	</div>

    <p class="text-center">고객 정보를 항상 최신 정보로 유지바랍니다.</p>

	<div class="row middle-box">
    <form:form method="POST" modelAttribute="userForm" action="profile" class="m-t" role="form">

        <div class="form-group"><label class="col-lg-4 control-label">이메일</label>
        	<div class="col-lg-12">
                <form:input type="email" path="username" class="form-control" placeholder="*이메일 (필수)"
                            value="${userForm.username }" readOnly="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </div>
        <div class="form-group"><label class="col-lg-4 control-label">비밀번호</label>
            <div class="col-lg-12">
            	<a data-toggle="modal" class="btn btn-lg btn-warning btn-block" href="#modal-pwChange">비밀번호 수정</a>
            </div>
        </div>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label class="col-lg-4 control-label">이름</label>
            	<div class="col-lg-12">
                <form:input type="text" path="name" class="form-control" placeholder="이름"
                            value="${userForm.name }" autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
                </div>
            </div>
        </spring:bind>
                
        <spring:bind path="birth_date">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label class="col-lg-4 control-label">생년월일 (YYYYMMDD)</label>
            	<div class="col-lg-12">
                <form:input type="text" path="birth_date" class="form-control" placeholder="*생년월일(필수: 8자리)"
                            value="${userForm.birth_date }" autofocus="true"></form:input>
                <form:errors path="birth_date"></form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="nickname">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label class="col-lg-4 control-label">별명</label>
            	<div class="col-lg-12">
                <form:input type="text" path="nickname" class="form-control" placeholder="별명"
                            value="${userForm.nickname }" autofocus="true"></form:input>
                <form:errors path="nickname"></form:errors>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="phone_no">
            <div class="form-group ${status.error ? 'has-error' : ''}"><label class="col-lg-4 control-label">전화번호 (숫자만)</label>
            	<div class="col-lg-12">
                <form:input type="text" path="phone_no" class="form-control" placeholder="전화번호(숫자만)"
                            value="${userForm.phone_no }" autofocus="true"></form:input>
                <form:errors path="phone_no"></form:errors>
                </div>
            </div>
        </spring:bind>
        
        <div class="form-group">
            <div class="col-lg-12">
				<button class="btn btn-lg btn-primary " type="submit">회원정보 수정</button>
            	<input class="btn btn-lg btn-warning pull-right m-t-n-xs" type="button" id="cancel" value="취소">
                
            </div>
        </div>
    </form:form>


	<c:if test="${update == 'ok'}">
	<script>
		alert("회원 정보가 수정 되었습니다.");
	</script>
 	<p class="m-t text-center"><a href="${contextPath}/today/summary">서비스 들어가기 </a></p> 
	</c:if>
	</div>
	
	
    <p class="m-t text-center"> <small>EagleLoe Company &copy; 2017</small> </p>
    
  </div>
</div>

    <!-- Mainly scripts -->
    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<script>
	$("#cancel").click(function(){
		history.go(-1);
	});
	
	$("#confirmPw").click(function(){
		var username = $("input[name=username]");
		var pwd = $("input[name=password]");
		
		if (pwd.val() == "") {
			return;
		}
		
			$.ajax({
				url: '${contextPath}/confirmPassword',
				type: 'POST',
				data: {
					"username" : $(username).val(),
					"pwd" : $(pwd).val()
				},
				success: function(data) {
					if (data == '1') {
						$("#modal-pwConf").modal('hide');	
						//$("#modal-pwChange").modal('show');
					} else {
						alert("기존 비밀번호와 일치하지 않습니다.");
					}

				},
				error: function(data) {
					alert("error"+data);
				}
			});
			
	});
	
	$("#changePw").click(function(){
		var username = $("input[name=username1]");
		var pwd = $("input[name=password1]");
		var pwd1 = $("input[name=password2]");
		if (pwd.val() != pwd1.val()) {
			alert("비밀번호와 재확인 비밀번호가 일치하지 않습니다.");
			return;
		}
		
			$.ajax({
				url: '${contextPath}/changePassword',
				type: 'POST',
				data: {
					"username" : $(username).val(),
					"pwd" : $(pwd).val()
				},
				success: function(data) {
					if (data == '1') {
						alert("비밀번호가 성공적으로 변경되었습니다.");
						$("#modal-pwChange").modal('hide');	

					} else {
						alert("암호가 일치하지 않습니다.");
					}

				},
				error: function(data) {
					alert("error"+data);
				}
			});
			
	});
	</script>
	    
</body>
</html>
