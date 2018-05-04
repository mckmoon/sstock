<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>StockDB</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">   
    <link href="${contextPath}/resources/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">

</head>

<body >

<div id="wrapper" class="gray-bg">
 <div class="row">
 	 <div class="col-lg-2">
 	 </div>
     <div class="col-lg-10">
     	<div class="ibox">
         <h2 class="font-bold">Welcome to StockDB !!</h2>
         <br></br>
         <p>
             2000개가 넘는 종목 중에 당신이 원하는 종목을 찾을 수 있습니까? 그동안 증권방송, 찌라시에 혹하여 당신의 귀중한 시간과 돈을 낭비하지 않았나요?
         </p>

         <p>
                            당신만이 가진 노하우로 직접 조건을 설정해서 당신의 포트폴리오를 구성하세요. <br></br>
                            우량한 종목 중에 장기간 오르지 않는 종목을 찾아서 다른 사람보다 먼저 투자를 시작하시기 바랍니다.
         </p>

         <p>
             SmartDB은 당신의 능력이 빛이 될 수 있도록 도와드립니다.   
			<ul class="nav navbar-top-links navbar-right">
            	<li>
				<sec:authorize access="!hasRole('ROLE_USER')">
                   <a href="${contextPath}/login">
                       <i class="fa fa-sign-in"></i> 로그인
                   </a>              
				</sec:authorize>
				</li>
            	<li>
                   <a href="${contextPath}/registration">
                       <i class="fa fa-sign-in"></i> 회원가입
                   </a>              
				</li>
            	<li>
                   <a href="${contextPath}/today/main">
                       <i class="fa fa-sign-in"></i> 서비스미리보기
                   </a>              
				</li>
			</ul>                     
         </p>

		</div>
     </div>
  </div>
  <div class="row">
    <div class="col-lg-12">

		<div class="col-lg-6">
		    <div class="ibox float-e-margins">
		        <div class="ibox-title">
		            <h5>단기 골든 크로스 MA(5,20)</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		                <a class="close-link">
		                    <i class="fa fa-times"></i>
		                </a>
		            </div>
		        </div>
		        <div class="ibox-content">
		            <table class="table table-hover no-margins">
		                <thead>
		                <tr>
		                    <th>날짜</th>
		                    <th>종목명</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma520}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> (${stockVO.shcode})</td>
						<td>${stockVO.price}</td>
						<td>${stockVO.volume}</td>
						</tr>
						</c:forEach>
	
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div>
		<div class="col-lg-6">
		    <div class="ibox float-e-margins">
		        <div class="ibox-title">
		            <h5>중기 골든 크로스 MA(20,60)</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		                <a class="close-link">
		                    <i class="fa fa-times"></i>
		                </a>
		            </div>
		        </div>
		        <div class="ibox-content">
		            <table class="table table-hover no-margins">
		                <thead>
		                <tr>
		                    <th>날짜</th>
		                    <th>종목명</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma2060}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> (${stockVO.shcode})</td>
						<td>${stockVO.price}</td>
						<td>${stockVO.volume}</td>
						</tr>
						</c:forEach>
	
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div>  
    </div>
  </div><!-- row --> 

  <div class="row">
    <div class="col-lg-12">

		<div class="col-lg-6">
		    <div class="ibox float-e-margins">
		        <div class="ibox-title">
		            <h5>장기 골든 크로스 MA(60,180)</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		                <a class="close-link">
		                    <i class="fa fa-times"></i>
		                </a>
		            </div>
		        </div>
		        <div class="ibox-content">
		            <table class="table table-hover no-margins">
		                <thead>
		                <tr>
		                    <th>날짜</th>
		                    <th>종목명</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma60120}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> (${stockVO.shcode})</td>
						<td>${stockVO.price}</td>
						<td>${stockVO.volume}</td>
						</tr>
						</c:forEach>
	
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div> 
		<div class="col-lg-6">
		    <div class="ibox float-e-margins">
		        <div class="ibox-title">
		            <h5>거래량 급증 (10일 평균 대비)</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		                <a class="close-link">
		                    <i class="fa fa-times"></i>
		                </a>
		            </div>
		        </div>
		        <div class="ibox-content">
		            <table class="table table-hover no-margins">
		                <thead>
		                <tr>
		                    <th>날짜</th>
		                    <th>종목명</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${volume}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> (${stockVO.shcode})</td>
						<td>${stockVO.price}</td>
						<td>${stockVO.volume}</td>
						</tr>
						</c:forEach>
	
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div> 
    </div>
  </div><!-- row --> 
       
  <div class="row">
	    <div class="col-md-6">
	        <strong>Copyright</strong> SeoMoon Company &copy; 2017-2018
	    </div>
	    <div class="col-md-6 text-right">
	       	서비스 <strong>30일</strong> 무료.
	    </div>
  </div>

</div> <!-- page wrapper -->

<!-- Mainly scripts -->
<script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${contextPath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${contextPath}/resources/js/plugins/dataTables/datatables.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${contextPath}/resources/js/inspinia.js"></script>
<script src="${contextPath}/resources/js/plugins/pace/pace.min.js"></script>

<script src="${contextPath}/resources/js/common.js"></script>
 

</body>

</html>

