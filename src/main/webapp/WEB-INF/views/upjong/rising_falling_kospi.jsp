<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- Modal -->
<div id="dialog_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">               
            </div>            	
        </div>
    </div>
</div>

<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li>업종분석</li>
            <li class="active">
                <strong>KOSPI 업종별 주가 변동률</strong>
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
                  <h5>기준일 D, 업종별 U, N 거래일 주가 변동률
                  
				  </h5>
              </div>
              <form role="form" class="form-inline" action="rising_falling_kospi" method="post">
              <div class="ibox-content">                 
						<div class="col-md-2 input-group">
                			<label class="font-normal">기준일(D)</label>
                			<div id="data_1">
		                    <div class="input-group date">		                    
		                      <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                      <input type="text" class="form-control" name="basedate" value='${vo.basedate}'>
		                    </div>
		                    </div>
		                </div>
                      	<div class="col-md-2 input-group">
                			<label class="font-normal">업종 (U)</label>           	
		                    <div>
	                          <select class="select2_demo_1 form-control" name="upcode" id="upcode">
	                              <option value="005" <c:out value="${vo.upcode eq '005'?'selected':''}"/>>음식료업</option>
	                              <option value="006" <c:out value="${vo.upcode eq '006'?'selected':''}"/>>섬유의복</option>
	                              <option value="007" <c:out value="${vo.upcode eq '007'?'selected':''}"/>>종이목재</option>
	                              <option value="008" <c:out value="${vo.upcode eq '008'?'selected':''}"/>>화학</option>
	                              <option value="009" <c:out value="${vo.upcode eq '009'?'selected':''}"/>>의약품</option>	                              		                              	
	                              <option value="010" <c:out value="${vo.upcode eq '010'?'selected':''}"/>>비금속광물</option>
	                              <option value="011" <c:out value="${vo.upcode eq '011'?'selected':''}"/>>철강금속</option>
	                              <option value="012" <c:out value="${vo.upcode eq '012'?'selected':''}"/>>기계</option>
	                              <option value="013" <c:out value="${vo.upcode eq '013'?'selected':''}"/>>전기전자</option>
	                              <option value="014" <c:out value="${vo.upcode eq '014'?'selected':''}"/>>의료정밀</option>
	                              <option value="015" <c:out value="${vo.upcode eq '015'?'selected':''}"/>>운수장비</option>
	                              <option value="016" <c:out value="${vo.upcode eq '016'?'selected':''}"/>>유통업</option>
	                              <option value="017" <c:out value="${vo.upcode eq '017'?'selected':''}"/>>전기가스</option>
	                              <option value="018" <c:out value="${vo.upcode eq '018'?'selected':''}"/>>건설업</option>
	                              <option value="019" <c:out value="${vo.upcode eq '019'?'selected':''}"/>>운수창고</option>
	                              <option value="020" <c:out value="${vo.upcode eq '020'?'selected':''}"/>>통신업</option>
	                              <option value="021" <c:out value="${vo.upcode eq '021'?'selected':''}"/>>금융업</option>
	                              <option value="022" <c:out value="${vo.upcode eq '022'?'selected':''}"/>>은행</option>

	                              <option value="024" <c:out value="${vo.upcode eq '024'?'selected':''}"/>>증권</option>
	                              <option value="025" <c:out value="${vo.upcode eq '025'?'selected':''}"/>>보험업</option>
	                              <option value="026" <c:out value="${vo.upcode eq '026'?'selected':''}"/>>서비스업</option>
	                              <option value="027" <c:out value="${vo.upcode eq '027'?'selected':''}"/>>제조업</option>

	                          </select>
                      		</div>
						</div>
		                <div class="col-md-1 input-group">
		                    <label class="font-normal">기간(N) </label> 
		                    <div>
	                          <select class="select2_demo_1 form-control" name="duration" id="duration">
	                              <option value="5" 
	                              	<c:out value="${vo.duration eq '5'?'selected':''}"/>>
	                              	최근5일 </option>	                              
	                              <option value="20" 
	                              	<c:out value="${vo.duration eq '20'?'selected':''}"/>>
	                              	최근20일 </option>	                                                      
	                              <option value="60" 
	                              	<c:out value="${vo.duration eq '60'?'selected':''}"/>>
	                              	최근60일 </option>                              
	                              <option value="120" 
	                              	<c:out value="${vo.duration eq '120'?'selected':''}"/>>
	                              	최근120일 </option>	                              
	                              <option value="180" 
	                              	<c:out value="${vo.duration eq '180'?'selected':''}"/>>
	                              	최근180일 </option>
	                              <option value="250" 
	                              	<c:out value="${vo.duration eq '250'?'selected':''}"/>>
	                              	최근250일 </option>
                          
	                           </select>
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
              <th>날짜</th>
              <th>종목</th>
              <th>종가</th>
              <th>전일가대비</th>
              <th>전일거래량대비</th>
              <th>시가총액(억)</th>
              <th>년매출액(억)</th>
              <th>영업이익률</th>
              <th>시가배당률</th>
			  <th>기간변동률</th>
          </tr>
          </thead>
          <tbody>

<c:forEach items="${list}" var="stockVO">
<tr>
<td>${stockVO.date}</td>
<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a>
<c:if test="${stockVO.notice > 0}">
 <a data-toggle="modal" href="${contextPath}/simulation/modal_notice?basedate=${stockVO.date}&shcode=${stockVO.shcode}" data-target="#dialog_modal"><i class="fa fa-bomb"></i></a> 
</c:if>
</td>
<td>${stockVO.price}</td>
<td>${stockVO.diff_rate > 0.0 ? "<span style='color:red'>" : "<span style='color:blue'>"} ${stockVO.diff_rate }</span> </td>
<td>${stockVO.vol_diff_rate}</td>
<td>${stockVO.total}</td>
<td>${stockVO.sales}</td>
<td>${stockVO.ic_rate}</td>
<td>${stockVO.dy_rate}</td>
<td>${stockVO.du_diff_rate > 0.0 ? "<span style='color:red'>" : "<span style='color:blue'>"} ${stockVO.du_diff_rate }</span> </td>
</tr>
</c:forEach>

          </tbody>
          <tfoot>
          <tr>
              <th>날짜</th>
              <th>종목</th>
              <th>종가</th>
              <th>전일가대비</th>
              <th>전일거래량대비</th>
              <th>시가총액(억)</th>
              <th>년매출액(억)</th>
              <th>영업이익률</th>
              <th>시가배당률</th>
			  <th>기간변동률</th>

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
  
	$("#dialog_modal").on("shown.bs.modal",function(){
		   //will be executed everytime #item_modal is shown
		   $(this).hide().show(); //hide first and then show here
	});
		
	$("body").on('hidden.bs.modal', '.modal', function () {
		  $(this).removeData('bs.modal');
	});
</script>