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
	      	<div class="ibox-content">
			   <div class="form-group">
			     <label for="exampleInputEmail1">제 목</label>
			       <input type="text" name="title" class="form-control" value="${boardInfo.brdtitle}"
			       readonly='readonly'>
			   </div>
			   <div class="form-group">
			     <label for="exampleInputPassword1">내 용</label>
			     <textarea class="form-control" name="content" rows="7" 
			       readonly="readonly">${boardInfo.brdmemo}</textarea>
			   </div>
			   <div class="form-group">
			     <label for="exampleInputEmail1">작성자</label>
			     <input type="text"
			       name="writer" class="form-control" value="${boardInfo.brdwriter}" readonly="readonly">
			   </div>
			   <div class="form-group">

			     <c:forEach var="listview" items="${listview}" varStatus="status">
					    <span class="btn btn-default btn-file">
							<a href="${contextPath}/common/fileDownload?filename=${listview.filename}&downname=${listview.realname}"> 							 
						 		${listview.filename}</a> ${listview.size2String()}
					    </span>
				</c:forEach>
			   </div>
			</div> <!--  ibox-content --> 
			
			<div class="ibox-footer">
			   <div class="form-group">
						<a href="UserList?id=<c:out value="${user.id}"/>">
						<button type="button" class="btn btn-white">Cancel</button>
						</a>
						<a href="userDelete?id=<c:out value="${user.id}"/>">
						<button type="button" class="btn btn-primary"> 삭 제  </button>
						</a>
						<a href="boardForm?brdno=<c:out value="${boardInfo.brdno}"/>">
						<button type="button" class="btn btn-primary"> 수 정 </button>
						</a>
               </div>
			</div> <!-- ibox footer -->			 	
		</div> <!--  ibox -->
	</div> <!-- col -->
</div> <!-- row -->

<c:if test="${bgInfo.bgreply=='Y'}">
<div class="row">
  <div class="col-lg-12">	
    <div class="ibox float-e-margins">
  		<div class="ibox-header with-border">
			<h4 class="box-title">새 댓글</h4>
		</div>
		<form id="form1" name="form1">
      	<div class="ibox-content">	
			작성자: 
			<input type="hidden" id="brdno1" name="brdno" value="${boardInfo.brdno}"> 
			<input class="form-control" type="text" id="rewriter1" name="rewriter" > <br/>
			<textarea id="rememo1" class="form-control" name="rememo" rows="1" placeholder="댓글을 입력해 주세요."></textarea>
	  	</div>
 		<div class="ibox-footer">
		  	<button type="submit" class="btn btn-primary" id="replyAddBtn" onclick="fn_formSubmit()">댓글 달기</button>
		</div>
		</form>
	</div>
  </div>
 </div>
 
					
<div class="row">
  <div class="col-lg-12">	
    <div class="ibox float-e-margins">
      <div class="ibox-content">		
		<div id="replyList"> 
			<c:forEach var="replylist" items="${replylist}" varStatus="status">
				<div id="replyItem${replylist.reno}" style="margin-top: 5px; margin-left: ${20*replylist.redepth}px; display: inline-block">			

					<div id="reply${replylist.reno}">${replylist.rememo}</div>
					<strong>${replylist.rewriter}</strong> (${replylist.redate})
					<a href="#" onclick="fn_replyDelete('${replylist.reno}')">삭제</a>
					<a href="#" onclick="fn_replyUpdate('${replylist.reno}')">수정</a>
					<a href="#" onclick="fn_replyReply('${replylist.reno}')">댓글</a>
				</div>
				</br></br>
			</c:forEach>
		</div>

		<div id="replyDiv" style="width: 99%; display:none">
			<form id="form2" name="form2" action="boardReplySave" method="post">
				<input type="hidden" id="brdno2" name="brdno" value="<c:out value="${boardInfo.brdno}"/>"> 
				<input type="hidden" id="reno2" name="reno"> 
				<textarea class="form-control" id="rememo2" name="rememo" rows="2" maxlength="500"></textarea>
				<a href="#" onclick="fn_replyUpdateSave()">저장</a>
				<a href="#" onclick="fn_replyUpdateCancel()">취소</a>
			</form>
		</div>
		
		<div id="replyDialog" style="width: 99%; display:none">
			<form id="form3" name="form3" action="boardReplySave" method="post">
				<input type="hidden" id="brdno3" name="brdno" value="<c:out value="${boardInfo.brdno}"/>"> 
				<input type="hidden" id="reno3" name="reno"> 
				<input type="hidden" id="reparent3" name="reparent"> 
				작성자: <input type="text" id="rewriter3" name="rewriter" size="20" maxlength="20"> <br/>
				<textarea class="form-control" id="rememo3" name="rememo" rows="2" maxlength="500"></textarea>
				<a href="#" onclick="fn_replyReplySave()">저장</a>
				<a href="#" onclick="fn_replyReplyCancel()">취소</a>
			</form>
		</div>
	  </div>
	</div>							
  </div>
</div>
</c:if>

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
	if ( ! chkInputValue("#rewriter1", "작성자를")) return;
	if ( ! chkInputValue("#rememo1", "글 내용을")) return;
	
	var formData = $("#form1").serialize();
	$.ajax({
		url: "boardReplySave", 
		type:"post", 
		data : formData,
		success: function(result){ 
			if (result!=="") {
				$("#rewriter1").val("");
				$("#rememo1").val("");
				$("#replyList").append(result);
				alert("저장되었습니다.");
			} else{
				alert("서버에 오류가 있어서 저장되지 않았습니다.");
			}
		}
	})		
}

function fn_replyDelete(reno){
	if (!confirm("삭제하시겠습니까?")) {
		return;
	}
	$.ajax({
		url: "boardReplyDelete",
		type:"post", 
		data: {"reno": reno},
		success: function(result){
			if (result=="OK") {
				$("#replyItem"+reno).remove();
				alert("삭제되었습니다.");
			} else{
				alert("댓글이 있어서 삭제할 수 없습니다.");
			}
		}
	})
}

var updateReno = updateRememo = null;
function fn_replyUpdate(reno){
	hideDiv("replyDialog");
	
	$("#replyDiv").show();
	
	if (updateReno) {
		$("#replyDiv").appendTo(document.body);
		$("#reply"+updateReno).text(updateRememo);
	} 
	
	$("#reno2").val(reno);
	$("#rememo2").val($("#reply"+reno).text());
	$("#reply"+reno).text("");
	$("#replyDiv").appendTo($("#reply"+reno));
	$("#rememo2").focus();
	updateReno   = reno;
	updateRememo = $("#rememo2").val();
} 

function fn_replyUpdateSave(){
	if ( ! chkInputValue("#rememo2", "글 내용을")) return;
	
	var formData = $("#form2").serialize();
	$.ajax({
		url: "boardReplySave", 
		type:"post", 
		data : formData,
		success: function(result){
			if (result!=="") {
				$("#reply"+updateReno).text($("#rememo2").val());
				$("#replyDiv").hide();
				alert("저장되었습니다.");
			} else{
				alert("서버에 오류가 있어서 저장되지 않았습니다.");
			}
		}
	})
} 

function fn_replyUpdateCancel(){
	hideDiv("#replyDiv");
	
	$("#reply"+updateReno).text(updateRememo);
	updateReno = updateRememo = null;
} 

function hideDiv(id){
	$(id).hide();
	$(id).appendTo(document.body);
}

function fn_replyReply(reno){
	$("#replyDialog").show();
	
	if (updateReno) {
		fn_replyUpdateCancel();
	} 
	
	$("#reparent3").val(reno);
	$("#rememo3").val("");
	$("#replyDialog").appendTo($("#reply"+reno));
	$("#rewriter3").focus();
} 
function fn_replyReplyCancel(){
	hideDiv("#replyDialog");
} 

function fn_replyReplySave(){
	if ( ! chkInputValue("#rewriter3", "작성자를")) return;
	if ( ! chkInputValue("#rememo3", "글 내용을")) return;

	var formData = $("#form3").serialize();
	$.ajax({
		url: "boardReplySave",
		type:"post", 
		data : formData,
		success: function(result){
			if (result!=="") {
				var parent = $("#reparent3").val();
				$("#replyItem"+parent).after(result);
				hideDiv("#replyDialog");
				alert("저장되었습니다.");
				$("#rewriter3").val("");
				$("#rememo3").val("");
			} else{
				alert("서버에 오류가 있어서 저장되지 않았습니다.");
			}
		}
	})	
}
</script>
