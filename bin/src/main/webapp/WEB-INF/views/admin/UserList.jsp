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
                <h5>회원 목록</h5>
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
						<!--  
						<a href="userForm">
						<button type="button" class="btn btn-primary btn-default">회원 추가</button>
						</a>
						-->
                    </div>
                    
                    <div class="col-sm-3 m-b-xs">
                        <div class="btn-group">
 						<input type="checkbox" name="searchType" value="username" <c:if test="${fn:indexOf(searchVO.searchType, 'username')!=-1}">checked="checked"</c:if>/>
						<label class="chkselect" for="searchType1">이메일</label>
						<input type="checkbox" name="searchType" value="name" <c:if test="${fn:indexOf(searchVO.searchType, 'name')!=-1}">checked="checked"</c:if>/>
						<label class="chkselect" for="searchType2">이름</label>
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

                            <th>No</th>
                            <th>이메일 </th>
                            <th>이름 </th>
                            <th>별명</th>
                            <th>생년월일</th>
                            <th>전화번호</th>
                            <th>이메일인증</th>
                            <th>가입일자</th>
                        </tr>
                        </thead>
                        <tbody>
                        
			<c:forEach var="list" items="${list}" varStatus="status">	
				<c:url var="link" value="userForm">
					<c:param name="id" value="${list.id}" />
				</c:url>		
										  				
				<tr>
					<td><c:out value="${searchVO.totRow-((searchVO.page-1)*searchVO.displayRowCount + status.index)}"/></td>
					<td >
						<a href="${link}"><c:out value="${list.username}"/></a>					
					</td>
					<td><c:out value="${list.name}"/></td>
					<td><c:out value="${list.nickname}"/></td>
					<td><c:out value="${list.birth_date}"/></td>
					<td><c:out value="${list.phone_no}"/></td>
					<td><c:out value="${list.email_conf}"/></td>
					<td><c:out value="${list.reg_date}"/></td>
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
