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
                <a href="index.html">재무 분석</a>
            </li>
            <li class="active">
                <strong>분기 재무지표 </strong>
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
          <div class="ibox float-e-margins">
              <div class="ibox-title">
                  <h5>분기 재무지표 기준 종목 추출
                  
				  </h5>
              </div>
              <form role="form" class="form-inline" action="quarter" method="post">
              <div class="ibox-content">                 
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">기준분기</label> 
		                    <div>
	                          <select class="select2_demo_1 form-control" name="basedate" id="basedate">
	                              <option value="20160301" 
	                              	<c:out value="${vo.basedate eq '20160301'?'selected':''}"/>>
	                              	2016년 1분기</option>
	                              <option value="20160601" 
	                              	<c:out value="${vo.basedate eq '20160601'?'selected':''}"/>>
	                              	2016년 2분기</option>
	                              <option value="20160901" 
	                              	<c:out value="${vo.basedate eq '20160901'?'selected':''}"/>>
	                              	2016년 3분기</option>
	                              <option value="20161201" 
	                              	<c:out value="${vo.basedate eq '20161201'?'selected':''}"/>>
	                              	2016년 4분기</option>
	                              <option value="20170301" 
	                              	<c:out value="${vo.basedate eq '20170301'?'selected':''}"/>>
	                              	2017년 1분기</option>
	                              <option value="20170601" 
	                              	<c:out value="${vo.basedate eq '20170601'?'selected':''}"/>>
	                              	2017년 2분기</option>
	                              <option value="20170901" 
	                              	<c:out value="${vo.basedate eq '20170901'?'selected':''}"/>>
	                              	2017년 3분기</option>
	                              <option value="20171201" 
	                              	<c:out value="${vo.basedate eq '20171201'?'selected':''}"/>>
	                              	2017년 4분기</option>
	                              <option value="20180301" 
	                              	<c:out value="${vo.basedate eq '20180301'?'selected':''}"/>>
	                              	2018년 1분기</option>
	                              <option value="20180601" 
	                              	<c:out value="${vo.basedate eq '20180601'?'selected':''}"/>>
	                              	2018년 2분기</option>
	                              <option value="20180901" 
	                              	<c:out value="${vo.basedate eq '20180901'?'selected':''}"/>>
	                              	2018년 3분기</option>
	                              <option value="20181201" 
	                              	<c:out value="${vo.basedate eq '20181201'?'selected':''}"/>>
	                              	2018년 4분기</option>

	                          </select>
                      		</div>
                      	</div>
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">매출액(억) 이상</label> 
		                    <div>
                          	<input type="text" name="sales" placeholder="SALES" id="sales" value='${vo.sales}'
                                 class="form-control">
                      		</div>
                      	</div>
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">영업이익률(%) 이상</label> 
		                    <div>
                          	<input type="text" name="op_profit_rate" placeholder="op_profit_rate" id="op_profit_rate" value='${vo.op_profit_rate}'
                                 class="form-control">
                      		</div>
                      	</div>
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">부채비율(%) 이하</label> 
		                    <div>
                          	<input type="text" name="debt_rate" placeholder="debt_rate" id="debt_rate" value='${vo.debt_rate}'
                                 class="form-control">
                      		</div>
                      	</div>
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">ROE(%) 이상</label> 
		                    <div>
                          	<input type="text" name="roe" placeholder="roe" id="roe" value='${vo.roe}'
                                 class="form-control">
                      		</div>
                      	</div>

						<div class="col-md-2 input-group">
                			<label class="font-normal"><a href="#" class="text-white">..</a></label>
                			<div>  
							<button class="btn btn-primary " type="submit">종목 추출</button>
							</div>
						</div>		                        
              </div>
              </form>
          </div>
      </div>
  </div> <!-- row -->

  
  <div class="row">
     <div class="col-lg-12">
     <div class="ibox float-e-margins">
         <div class="ibox-title">
             <h5>추출 결과 </h5>
             <div class="ibox-tools">
                 <a class="collapse-link">
                     <i class="fa fa-chevron-up"></i>
                 </a>
                 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                     <i class="fa fa-wrench"></i>
                 </a>
                 <ul class="dropdown-menu dropdown-user">
                     <li><a href="#">Config option 1</a>
                     </li>
                     <li><a href="#">Config option 2</a>
                     </li>
                 </ul>
                 <a class="close-link">
                     <i class="fa fa-times"></i>
                 </a>
             </div>
         </div>
         <div class="ibox-content">

           <div class="table-responsive">
          <table class="table table-striped table-bordered table-hover dataTables-example" >
          <thead>
          <tr>
              <th>기준분기</th>
              <th>종목</th>
              <th>매출액(억)</th>
              <th>영업이익(억)</th>
              <th>영업이익률(%)</th>
              <th>부채비율(%)</th>
              <th>ROE(%)</th>
              <th>배당수익률(%)</th>
          </tr>
          </thead>
          <tbody>

<c:forEach items="${list}" var="financeVO">
<tr>
<td>${financeVO.date}</td>
<td><a href="#" onClick="javascript:openNaver('${financeVO.shcode}')">${financeVO.hname}</a> (${financeVO.shcode})</td>
<td>${financeVO.sales}</td>
<td>${financeVO.op_profit}</td>
<td>${financeVO.op_profit_rate}</td>
<td>${financeVO.debt_rate}</td>
<td>${financeVO.roe}</td>
<td>${financeVO.cash_divided_yield_rate}</td>
</tr>
</c:forEach>

          </tbody>
          <tfoot>
          <tr>
              <th>기준분기</th>
              <th>종목</th>
              <th>매출액(억)</th>
              <th>영업이익(억)</th>
              <th>영업이익률(%)</th>
              <th>부채비율(%)</th>
              <th>ROE(%)</th>
              <th>배당수익률(%)</th>
          </tr>
          </tfoot>
          </table>
           </div><!-- table respective -->

            </div>
        </div>
    </div>
</div>



<%@ include file="../include/footer.jsp" %>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function(){
        $('.dataTables-example').DataTable({
            pageLength: 25,
            responsive: true,
            dom: '<"html5buttons"B>lTfgitp',
            buttons: [
                {extend: 'copy'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'print',
                 customize: function (win){
                        $(win.document.body).addClass('white-bg');
                        $(win.document.body).css('font-size', '10px');

                        $(win.document.body).find('table')
                                .addClass('compact')
                                .css('font-size', 'inherit');
                }
                }
            ]

        });

    });

</script>
