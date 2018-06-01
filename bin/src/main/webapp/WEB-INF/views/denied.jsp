<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="./include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<script>
	alert("서비스 권한이 없습니다. 해당 서비스가 포함된 가격 상품에 가입후 메뉴를 이용하시기 바랍니다.");
</script>

<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li class="active">
                <strong>가격 상품</strong>
            </li>
        </ol>
    </div>
	<div class="col-lg-2">
	
	</div>
</div>
<br>

<!-- Container (Pricing Section) -->

<div class="row">
<div class="col-lg-12">

	<div class="panel">
		 <div class="panel-heading">
		    <h4>아래에서 당신에게 맞는 가격 플랜을 구입해 주세요.</h4>
		 </div>
		  
		 <div class="panel-body"> 
			<c:forEach var="list" items="${product_blue}" varStatus="status">	
		    <div class="col-sm-4 col-xs-12">
		      <div class="panel panel-info text-center">
		        <div class="panel-heading">
		          <h1>${list.name}</h1>
		        </div>
		        <div class="panel-body">
		          <p><strong>오늘의 종목</strong></p>
		          <p><strong>업종 분석</strong></p>
		          <p><strong>기본 분석</strong></p>
		        </div>
		        <div class="panel-footer">
		          <h3>&#8361;${list.price}</h3>
		          <h4>per ${list.months} month</h4>
		          <button class="btn btn-lg">Sign Up</button>
		        </div>
		      </div>      
		    </div>     
		    </c:forEach>
		    
		    <c:forEach var="list" items="${product_silver}" varStatus="status">	
		    <div class="col-sm-4 col-xs-12">
		      <div class="panel panel-success text-center">
		        <div class="panel-heading">
		          <h1>${list.name}</h1>
		        </div>
		        <div class="panel-body">
		          <p><strong>BLUE 기능</strong></p>
		          <p><strong>재무 분석</strong></p>
		          <p><strong>이동평균선 분석</strong></p>
		          <p><strong>보조지표 분석</strong></p>
		          <p><strong></strong></p>
		        </div>
		        <div class="panel-footer">
		          <h3>&#8361;${list.price}</h3>
		          <h4>per ${list.months} month</h4>
		          <button class="btn btn-lg">Sign Up</button>
		        </div>
		      </div>      
		    </div>     
		    </c:forEach>
		      
		    <c:forEach var="list" items="${product_gold}" varStatus="status">	
		    <div class="col-sm-4 col-xs-12">
		      <div class="panel panel-danger text-center">
		        <div class="panel-heading">
		          <h1>${list.name}</h1>
		        </div>
		        <div class="panel-body">
		          <p><strong>SILVER 기능</strong></p>
		          <p><strong>고급 분석</strong></p>
		          <p><strong>시뮬레이션</strong></p>
		          <P></P>
		        </div>
		        <div class="panel-footer">
		          <h3>&#8361;${list.price}</h3>
		          <h4>per ${list.months} month</h4>
		          <button class="btn btn-lg">Sign Up</button>
		        </div>
		      </div>      
		    </div>    
			</c:forEach>
			
		  </div> <!-- ibox content -->
  
	</div> <!-- ibox -->
</div> 
</div> 

<%@ include file="./include/footer.jsp" %>


