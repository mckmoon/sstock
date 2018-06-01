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
                <strong>상품 관리</strong>
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
                <h5>상품 정보 수정  (ID: ${product.id}, 등록일자: ${product.reg_date})</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div> <!-- ibox title -->

            <form id="form1" name="form1"  method="post" class="form-horizontal">
            <div class="ibox-content">
                <div class="form-group"><label class="col-sm-2 control-label">상품명</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${product.name}" >
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">가격</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="price" name="price" value="${product.price}" > 
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">개월수</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="months" name="months" value="${product.months}"> 
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">권한ID</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="role_id" name="role_id" value="${product.role_id}"> 
                    </div>
                </div>                

                <div class="form-group"><label class="col-sm-2 control-label">권한명</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="role_name" name="role_name" value="${product.role_name}"> 
                    </div>
                </div>  
            
			</div> <!-- ibox content -->

			<div class="ibox-footer">
              	<input type="hidden" name="id" value="<c:out value="${product.id}"/>"> 
 				<div class="col-sm-11 input-group col-sm-offset-9">
 					<c:if test="${id != '0'}">

                	<button type="button" class="btn btn-warning"  onclick="fn_deleteSubmit()">삭제</button>
					</c:if>
                    <button type="button" class="btn btn-white" onclick="fn_cancel()">Cancel</button>
                    <button type="button" class="btn btn-primary"  onclick="fn_saveSubmit()">저 장</button>
                </div>
			</div> <!-- ibox-footer -->
			</form>    
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->
<script>
function fn_deleteSubmit(){
    if (!confirm("삭제 하시겠습니까?")) return;
	var theForm = document.form1;
	theForm.action = 'ProductDelete';
	
	theForm.submit();
}

function fn_saveSubmit(){
    if (!confirm("저장하시겠습니까?")) return;
	var theForm = document.form1;
	theForm.action = 'ProductSave';
	
	theForm.submit();
}


function fn_cancel(){
	history.go(-1);
}
</script>

