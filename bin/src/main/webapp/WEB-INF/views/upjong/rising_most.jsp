<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  
<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li>
                <a href="">업종 분석</a>
            </li>
            <li class="active">
                <strong>요약</strong>
            </li>
        </ol>
    </div>
	<div class="col-lg-2">
	
	</div>
</div>
<br>
<!-- Main content -->
   <div class="row">
     <div class="col-lg-12">
		<div class="col-lg-12">
		    <div class="ibox float-e-margins">

		        <div class="ibox-title">
		        <form role="form" class="form-inline" action="rising_most" method="post">
		            <table>
		                <tr>
		                	<td> 기준 일자 : </td>
		                	<td> <div class="col-lg-1"></div> </td>
		                    <td>                   
		                    <div id="data_1">
		                    <div class="input-group date">
		                      <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                      <input type="text" class="form-control" name="basedate" value='${vo.basedate}'>
		                    </div>
		                    </div>
		                    </td>
							<td> <div class="col-lg-1"></div> </td>
		                    <td><div><button class="btn btn-primary " type="submit">Get Results</button></div></td>					
		                </tr>
		            </table>
		        </form>
		        
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
		            <h5>코스피 최근 5거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kospi5}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kospi?duration=5&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스닥 최근 5거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kosdaq5}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kosdaq?duration=5&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스피 최근 20거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kospi20}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kospi?duration=20&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스닥 최근 20거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>

		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kosdaq20}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kosdaq?duration=20&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스피 최근 60거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kospi60}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kospi?duration=60&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스닥 최근 60거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kosdaq60}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kosdaq?duration=60&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*5}%;"></div>
                        </div>
						</td>
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
		            <h5>코스피 최근 120거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kospi120}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kospi?duration=120&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*3}%;"></div>
                        </div>
						</td>
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
		            <h5>코스닥 최근 120거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kosdaq120}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kosdaq?duration=120&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*3}%;"></div>
                        </div>
						</td>
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
		            <h5>코스피 최근 250거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kospi250}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kospi?duration=250&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*3}%;"></div>
                        </div>
						</td>
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
		            <h5>코스닥 최근 250거래일</h5>
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
		                    <th>업종</th>
		                    <th>지수</th>
		                    <th>기간변동률</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${kosdaq250}" var="upjongVO">
						<tr>
						<td><a href='${contextPath}/upjong/rising_falling_kosdaq?duration=250&basedate=${upjongVO.date}&upcode=${upjongVO.upcode}';">
							${upjongVO.upname}</a></td>
						<td>${upjongVO.close}</td>
						<td>${upjongVO.du_diff_rate}
						<div class="progress progress-mini">
                            <div class="progress-bar" style="width: ${upjongVO.du_diff_rate*3}%;"></div>
                        </div>
						</td>
						</tr>
						</c:forEach>
	
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div>  
    </div>
  </div><!-- row --> 
    
<%@ include file="../include/footer.jsp" %>

<!-- Data picker -->
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