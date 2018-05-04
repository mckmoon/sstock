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
                <a href="index.html">게시판</a>
            </li>
            <li class="active">
                <strong>${bgInfo.bgname}</strong>
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
                <h5>새글 작성하기</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <form id="form1" name="form1" action="boardSave" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="ibox-content">
                <div class="form-group"><label class="col-sm-1 control-label">작성자</label>
                    <div class="col-sm-11">
                    <input type="text" class="form-control" id="brdwriter" name="brdwriter" value="${boardInfo.brdwriter}">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group"><label class="col-sm-1 control-label">제목</label>
                    <div class="col-sm-11">
                    <input type="text" class="form-control" id="brdtitle" name="brdtitle" value="${boardInfo.brdtitle}"> 
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group"><label class="col-sm-1 control-label">내용</label>
                    <div class="col-sm-11">
                    <textarea id="brdmemo" name="brdmemo" class="form-control" rows="4">${boardInfo.brdmemo}</textarea>
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="form-group"><label class="col-sm-1 control-label">첨부</label>
                    <div class="col-sm-11">
                    <c:forEach var="listview" items="${listview}" varStatus="status">
					<input type="checkbox" name="fileno" value="${listview.fileno}">	
        				<a href="/common/fileDownload?filename=<c:out value="${listview.filename}"/>&downname=<c:out value="${listview.realname }"/>"> 							 
						<c:out value="${listview.filename}"/></a> <c:out value="${listview.size2String()}"/><br/>
					</c:forEach>					
	
					<input type="file" name="uploadfile" multiple="" />						
                    </div>
                </div>
			</div> <!-- ibox content -->
			<div class="ibox-footer">
              	<input type="hidden" name="bgno" value="<c:out value="${bgno}"/>"> 
				<input type="hidden" name="brdno" value="<c:out value="${boardInfo.brdno}"/>">
				<div class="form-group">
                    <div class="col-sm-11 col-sm-offset-1">

                           <button type="button" class="btn btn-white" onclick="fn_cancel()">Cancel</button>
                           <button type="button" class="btn btn-primary"  onclick="fn_formSubmit()">저 장</button>

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
function chkInputValue(id, msg){
	if ( $.trim($(id).val()) == "") {
		alert(msg+" 입력해주세요.");
		$(id).focus();
		return false;
	} 
	return true;
}

function fn_formSubmit(){
	if ( ! chkInputValue("#brdwriter", "작성자를")) return;
	if ( ! chkInputValue("#brdtitle", "글 제목을")) return;
	if ( ! chkInputValue("#brdmemo", "글 내용을")) return;
	
	$("#form1").submit();
}

function fn_cancel(){
	history.go(-1);
}
</script>
