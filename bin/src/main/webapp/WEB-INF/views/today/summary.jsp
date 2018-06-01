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
                <a href="index.html">오늘의 종목</a>
            </li>
            <li class="active">
                <strong>Summary</strong>
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
		        <form role="form" class="form-inline" action="summary" method="post">
		            <table>
		                <tr>
		                	<td> 기준 일자 : </td>
		                	<td> <div class="col-lg-1"></div> </td>
		                    <td>                   
		                    <div id="data_1">
		                    <div class="input-group date">
		                      <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                      <input type="text" class="form-control" name="basedate" value='${basedate}'>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma520}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> 
						
						</td>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma2060}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ma60120}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>일목균형표(9,26) 전환선이 기준선 상향 돌파</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${ilmok}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>MACD(12,26,9) 지표가 시그널선 상향 돌파</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${macd}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>Stochastic slow(10,5,5) %K가 %D 상향 돌파 (그리고, %D가 20% 이하에서 20% 이상으로 전환)</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${slow}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>Sonar(10,5) 지표가 시그널선 상향 돌파</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${sonar}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>CCI(9) 0선 상향 돌파</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${cci}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		            <h5>RSI(14,9) 지표가 시그널선 상향 돌파</h5>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${rsi}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
		                    <th>종목</th>
		                    <th>종가</th>
		                    <th>거래량</th>
		                </tr>
		                </thead>
		                <tbody>
		                
						<c:forEach items="${volume}" var="stockVO">
						<tr>
						<td>${stockVO.date}</td>
						<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a> </td>
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
  
							<div class="modal inmodal" id="myModal4" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content animated fadeIn">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <i class="fa fa-clock-o modal-icon"></i>
                                            <h4 class="modal-title">Modal title</h4>
                                            <small>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</small>
                                        </div>
                                        <div class="modal-body">
                                            <p><strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown
                                                printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,
                                                remaining essentially unchanged.</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>



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