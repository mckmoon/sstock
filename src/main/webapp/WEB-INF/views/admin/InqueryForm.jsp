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
                <strong>고객문의 관리</strong>
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
                <h5>고객 문의  (ID: ${inquery.id}, 작성 일자: ${inquery.reg_date})</h5>
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
                    <input type="text" class="form-control" id="username" name="username" value="${inquery.email}" readOnly>
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-2 control-label">이름</label>
                    <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${inquery.name}" readOnly> 
                    </div>
                </div>

                <div class="form-group"><label class="col-sm-1 control-label">내용</label>
                    <div class="col-sm-11">
                    <textarea id="brdmemo" name="content" class="form-control" rows="4">${inquery.content}</textarea>
                    </div>
                </div>

                
			</div> <!-- ibox content -->
			<div class="ibox-footer">
              	<input type="hidden" name="id" value="<c:out value="${inquery.id}"/>"> 
				<div class="form-group">
                    <div class="col-sm-11 col-sm-offset-9">

                           <button type="button" class="btn btn-white" onclick="fn_cancel()">확인</button>

                	</div>
                </div>
			</div> <!-- ibox-footer -->
			</form>
		</div>
 
	</div>
</div>



<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->
<script>

function fn_cancel(){
	history.go(-1);
}
</script>

