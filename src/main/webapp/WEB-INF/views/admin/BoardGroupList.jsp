<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="${contextPath}/resources/js/dynatree/ui.dynatree.css" id="skinSheet"/>

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
                <strong>게시판 관리</strong>
            </li>
        </ol>
    </div>
	<div class="col-lg-2">
	
	</div>
</div>
<br>

<div class="row">
    <div class="col-lg-12">

    	<div id="tree">
			<ul id="treeData" style="display: none;">
				
			</ul>
		</div>
	</div>

	<br>
	<div class="col-lg-12">

		<div ><a onclick="fn_groupNew()" href="#">새게시판</a></div>
		<input name="bgno" id="bgno" type="hidden" value=""> 
		<table  class="table">
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
 	 		<tbody>
			<tr>
	 			<th>게시판명</th>
	 			<td> 
	 				<input name="bgname" id="bgname" style="width: 200px;" type="text" maxlength="100" value="">
	 			</td>
 			</tr>
 			<tr>
				<th>사용여부</th>
				<td>
					<input name="bgused" id="bgusedY" type="radio" checked="checked" value="Y"><label for="bgusedY">사용</label>
					<input name="bgused" id="bgusedN" type="radio" value="N"><label for="bgusedN">사용중지</label>
				</td>
			</tr>
 			<tr>
	 			<th>등록가능</th>
	 			<td>
					<input name="bgreadonly" id="bgreadonlyN" type="radio" checked="checked" value="N"><label for="bgreadonlyN">사용</label>
					<input name="bgreadonly" id="bgreadonlyY" type="radio" value="Y"><label for="bgreadonlyY">사용안함</label>
				</td>
 			</tr>
 			<tr>
	 			<th>댓글</th>
	 			<td>
					<input name="bgreply" id="bgreplyY" type="radio" checked="checked" value="Y"><label for="bgreplyY">사용</label>
					<input name="bgreply" id="bgreplyN" type="radio" value="N"><label for="bgreplyN">사용안함</label>
				</td>
 			</tr>
		 </tbody>
		 </table>

		<div class="ibox-footer">
			<div class="col-sm-11 input-group col-sm-offset-9">
              		<button type="button" class="btn btn-primary"  onclick="fn_groupSave()">저 장</button>
                  <button type="button" class="btn btn-warning"  onclick="fn_groupDelete()">삭제</button>
              </div>
		</div> <!-- ibox-footer -->
			
	</div>
</div>

<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->

<script src="${contextPath}/resources/js/jquery-ui.js"></script>
<script src="${contextPath}/resources/js/dynatree/jquery.dynatree.js"></script>
<script type="text/javascript"> 
var selectedNode = null;

$(function(){
	$("#tree").dynatree({
		children: <c:out value="${treeStr}" escapeXml="false"/>,
		onActivate: TreenodeActivate
	});
	fn_groupNew();
});
function TreenodeActivate(node) {
	selectedNode = node;
	
    if (selectedNode==null || selectedNode.data.key==0) return;
    $.ajax({
    	url: "boardGroupRead", 
    	cache: false,
    	data: { bgno : selectedNode.data.key }    	
    }).done(receiveData);
}

function receiveData(data){
    $("#bgno").val(data.bgno);
    $("#bgname").val(data.bgname);
	$('input:radio[name="bgused"][value="' + data.bgused + '"]').prop('checked', true);
	$('input:radio[name="bgreadonly"][value="' + data.bgreadonly + '"]').prop('checked', true);
	$('input:radio[name="bgreply"][value="' + data.bgreply + '"]').prop('checked', true);
}

function fn_groupNew(){
    $("#bgno").val("");
    $("#bgname").val("");
	$('input:radio[name="bgused"][value="Y"]').prop('checked', true);
	$('input:radio[name="bgreadonly"][value="N"]').prop('checked', true);
	$('input:radio[name="bgreply"][value="Y"]').prop('checked', true);
}

function fn_groupDelete(value){
    if (selectedNode==null){
    	alert("삭제할 게시판을 선택해 주세요!");
    	return;
    }
    if (selectedNode.childList){
    	alert("하위 게시판이 있는 게시판은 삭제 할 수 없습니다.");
    	return;
    }
    
    if(!confirm("삭제하시겠습니까?")) return;
    $.ajax({
    	url: "boardGroupDelete",
    	cache: false,
    	data: { bgno : selectedNode.data.key }    	
    }).done(receiveData4Delete);
}

function receiveData4Delete(data){
	alert("삭제되었습니다!");
	selectedNode.remove();		
	selectedNode = null;
	fn_groupNew();
}

function fn_groupSave(){
	if($("#bgname").val() == ""){
		alert("게시판 이름을 입력해주세요.");
		return;
	}
	var pid=null;
    if (selectedNode!=null) pid=selectedNode.data.key;

    if (!confirm("저장하시겠습니까?")) return;

    $.ajax({
    	url: "boardGroupSave",
    	cache: false,
    	type: "POST",
    	data: { bgno:$("#bgno").val(), bgname:$("#bgname").val(), bgparent: pid,
    			bgused : $("input:radio[name=bgused]:checked").val(), 
    			bgreadonly : $("input:radio[name=bgreadonly]:checked").val(), 
    			bgreply : $("input:radio[name=bgreply]:checked").val()}    	
    }).done(receiveData4Save);
}

function receiveData4Save(data){
	if (selectedNode!==null && selectedNode.data.key===data.bgno) {
		selectedNode.data.title=data.bgname;
		selectedNode.render();
	} else {
		addNode(data.bgno, data.bgname);
	}
	
	alert("저장되었습니다.");
}

function addNode(nodeNo, nodeTitle){
	var node = $("#tree").dynatree("getActiveNode");
	if (!node) node = $("#tree").dynatree("getRoot");
	var childNode = node.addChild({key: nodeNo, title: nodeTitle});
	node.expand() ;
	node.data.isFolder=true;
	node.tree.redraw();
}
</script>

