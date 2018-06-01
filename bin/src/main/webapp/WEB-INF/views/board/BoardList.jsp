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
                	게시판
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
                <h5>${bgInfo.bgname}</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>

                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div> <!-- ibox title -->
            <div class="ibox-content">
            <form id="form1" name="form1"  method="post">
                <div class="row">
                    <div class="col-sm-5 m-b-xs">
					<c:if test="${bgInfo.bgreadonly=='N'}">
						<a href="boardForm?bgno=<c:out value="${searchVO.bgno}"/>">
						<button type="button" class="btn btn-primary btn-default">새글 작성</button>
						</a>
					</c:if>
                    </div>
                    
                    <div class="col-sm-3 m-b-xs">
                        <div class="btn-group">
 						<input type="checkbox" name="searchType" value="brdtitle" <c:if test="${fn:indexOf(searchVO.searchType, 'brdtitle')!=-1}">checked="checked"</c:if>/>
						<label class="chkselect" for="searchType1">제목</label>
						<input type="checkbox" name="searchType" value="brdmemo" <c:if test="${fn:indexOf(searchVO.searchType, 'brdmemo')!=-1}">checked="checked"</c:if>/>
						<label class="chkselect" for="searchType2">내용</label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                    	<div class="input-group">
                        <input type="text" name="searchKeyword" placeholder="Search" class="input-sm form-control" value="${searchVO.searchKeyword}"
                        onkeydown="if(event.keyCode == 13) { fn_formSubmit();}" />                        
                        <span class="input-group-btn"><button type="button" class="btn btn-sm btn-primary" onclick="fn_formSubmit()"> 검색!</button> </span>
                        </div>
                    </div>
                    
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>

                            <th>번호</th>
                            <th>제목 </th>
                            <th>작성자 </th>
                            <th>작성일</th>
                            <th>조회수</th>
                            <th>첨부</th>
                        </tr>
                        </thead>
                        <tbody>
                        
			<c:forEach var="listview" items="${listview}" varStatus="status">	
				<c:url var="link" value="boardRead">
					<c:param name="brdno" value="${listview.brdno}" />
				</c:url>		
										  				
				<tr>
					<td><c:out value="${searchVO.totRow-((searchVO.page-1)*searchVO.displayRowCount + status.index)}"/></td>
					<td >
						<a href="${link}"><c:out value="${listview.brdtitle}"/></a>
						<c:if test="${listview.replycnt>0}">
							(<c:out value="${listview.replycnt}"/>)
						</c:if>						
					</td>
					<td><c:out value="${listview.brdwriter}"/></td>
					<td><c:out value="${listview.brddate}"/></td>
					<td><c:out value="${listview.brdhit}"/></td>
					<td><c:out value="${listview.filecnt}"/></td>
				</tr>
			</c:forEach>

                        </tbody>
                    </table>

	    			<jsp:include page="../common/pagingforSubmit.jsp" />
	    
                </div> <!-- row -->
			</form>
            </div> <!-- ibox content -->
        </div>
    </div>
</div>

	


<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->
<script>
function fn_formSubmit(){ 
	document.form1.submit();	
}
</script>
