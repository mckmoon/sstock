<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li>
                	관리자
            </li>
            <li class="active">
                <strong>회원관리</strong>
            </li>
        </ol>
    </div>
	<div class="col-lg-2">
	
	</div>
</div>
<br>

<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">

            <div class="ibox-title">
                <h5>회원 정보 수정  (ID: ${user.id}, 가입일자: ${user.reg_date})</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div> <!-- ibox title -->

            <form id="form1" name="form1" action="userSave" method="post" class="form-horizontal">
            <div class="ibox-content">
                <div class="form-group"><label class="col-sm-2 control-label">이메일</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" value="${user.username}" readOnly>
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">이름</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}" readOnly> 
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">별명</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname}"> 
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">생년월일</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="birth_date" name="birth_date" value="${user.birth_date}"> 
                    </div>
                </div>                

                <div class="form-group"><label class="col-sm-2 control-label">휴대폰번호</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone_no" name="phone_no" value="${user.phone_no}"> 
                    </div>
                </div>  

                <div class="form-group"><label class="col-sm-2 control-label">주소</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address" value="${user.address}"> 
                    </div>
                </div>
                
			</div> <!-- ibox content -->
			<div class="ibox-footer">
              	<input type="hidden" name="id" value="<c:out value="${user.id}"/>"> 
				<div class="form-group">
                    <div class="col-sm-11 col-sm-offset-9">

                           <button type="button" class="btn btn-white" onclick="fn_cancel()">Cancel</button>
                           <button type="button" class="btn btn-primary"  onclick="fn_formSubmit()">저 장</button>

                	</div>
                </div>
			</div> <!-- ibox-footer -->
			</form>
		</div>
 
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>가격상품 </th>
                            <th>유효일자</th>
                        </tr>
                        </thead>
                        <tbody>                       
						<c:forEach var="list" items="${roles}" varStatus="status">											  				
						<tr>
							<td><c:out value="${status.index+1}"/></td>
							<td><c:out value="${list.role_name}"/></td>
							<td><c:out value="${list.expire_date}"/></td>
						</tr>
						</c:forEach>
                        </tbody>
                    </table>	    
                </div>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="ibox float-e-margins">

			<div class="ibox-content">
			<form id="form2" name="form2" method="post" class="form-horizontal">
              	<input type="hidden" name="user_id" value="<c:out value="${user.id}"/>"> 
                <div class="col-sm-3 form-group">
                    <label class="font-normal">가격상품: </label> 
                    <div>
                         <select class="select2_demo_1 form-control" name="role_id" id="role_id">
                             <option value="2"> BLUE </option>
                             <option value="3"> SILVER </option>
                             <option value="4"> GOLD </option>
                         </select>
                  	</div>
                </div>

				<div class="col-sm-3 form-group">
              		<label class="font-normal">유효일자:</label>
              		<div id="data_1">
                    <div class="input-group date">		                    
                      <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                      <input type="text" class="form-control" name="expire_date" >
                    </div>
                    </div>
                </div>
		                
				<div class="col-sm-6 input-group">
              			<label class="font-normal"><a href="#" class="text-white">..</a></label>
              			<div>  
					<button type="button" class="btn btn-primary"  onclick="fn_formSubmit2()">상품변경</button>
					</div>
				</div>
			</form>
			</div> <!-- ibox-footer -->

			

		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->
<script>
function chkInputValue(id, msg){
	if ( $.trim($(id).val()) == "") {
		alert(msg+" 입력해주세요.");
		$(id).focus();
		return false;
	} 
	return true;
}

function fn_formSubmit(){
	
	$("#form1").submit();
}

function fn_formSubmit2(){
	var theForm = document.form2;
	theForm.action = 'roleSave?id=' + ${user.id};
	
	theForm.submit();
}

function fn_cancel(){
	history.go(-1);
}
</script>

<!-- Date picker -->
<script src="${contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>

<script>
  	$(document).ready(function(){
      $('#data_1 .input-group.date').datepicker({
          todayBtn: "linked",
          keyboardNavigation: false,
          forceParse: false,
          calendarWeeks: true,
          autoclose: true,
          format: "yyyy-mm-dd"
      });
  	});
</script>