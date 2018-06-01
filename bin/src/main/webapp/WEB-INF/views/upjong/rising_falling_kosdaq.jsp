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
                <strong>KOSDAQ 업종별 주가 변동률</strong>
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
              <form role="form" class="form-inline" action="rising_falling_kosdaq" method="post">
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
	                              <option value="303" <c:out value="${vo.upcode eq '303'?'selected':''}"/>>기타서비스</option>
	                              <option value="304" <c:out value="${vo.upcode eq '304'?'selected':''}"/>>IT 종합</option>
	                              <option value="306" <c:out value="${vo.upcode eq '306'?'selected':''}"/>>제조</option>
	                              <option value="307" <c:out value="${vo.upcode eq '307'?'selected':''}"/>>건설</option>
	                              <option value="308" <c:out value="${vo.upcode eq '308'?'selected':''}"/>>유통</option>
	                              <option value="309" <c:out value="${vo.upcode eq '309'?'selected':''}"/>>숙박음식</option>	                              		                              	
	                              <option value="310" <c:out value="${vo.upcode eq '310'?'selected':''}"/>>운송</option>
	                              <option value="311" <c:out value="${vo.upcode eq '311'?'selected':''}"/>>금융</option>
	                              <option value="312" <c:out value="${vo.upcode eq '312'?'selected':''}"/>>통신 방송</option>
	                              <option value="313" <c:out value="${vo.upcode eq '313'?'selected':''}"/>>IT S/W</option>
	                              <option value="314" <c:out value="${vo.upcode eq '314'?'selected':''}"/>>IT H/W</option>
	                              <option value="315" <c:out value="${vo.upcode eq '315'?'selected':''}"/>>음식료담배</option>
	                              <option value="316" <c:out value="${vo.upcode eq '316'?'selected':''}"/>>섬유의류</option>
	                              <option value="317" <c:out value="${vo.upcode eq '317'?'selected':''}"/>>종이목재</option>
	                              <option value="318" <c:out value="${vo.upcode eq '318'?'selected':''}"/>>출판매체</option>
	                              <option value="319" <c:out value="${vo.upcode eq '319'?'selected':''}"/>>화학</option>
	                              <option value="320" <c:out value="${vo.upcode eq '320'?'selected':''}"/>>제약</option>
	                              <option value="321" <c:out value="${vo.upcode eq '321'?'selected':''}"/>>비금속</option>
	                              <option value="322" <c:out value="${vo.upcode eq '322'?'selected':''}"/>>금속</option>
								  <option value="323" <c:out value="${vo.upcode eq '323'?'selected':''}"/>>기계장비</option>
	                              <option value="324" <c:out value="${vo.upcode eq '324'?'selected':''}"/>>전기전자</option>
	                              <option value="325" <c:out value="${vo.upcode eq '325'?'selected':''}"/>>의료정밀</option>
	                              <option value="326" <c:out value="${vo.upcode eq '326'?'selected':''}"/>>운송부품</option>
	                              <option value="327" <c:out value="${vo.upcode eq '327'?'selected':''}"/>>기타제조</option>
	                              <option value="328" <c:out value="${vo.upcode eq '328'?'selected':''}"/>>통신서비스</option>
	                              <option value="329" <c:out value="${vo.upcode eq '329'?'selected':''}"/>>방송서비스</option>
	                              <option value="330" <c:out value="${vo.upcode eq '330'?'selected':''}"/>>인터넷</option>
	                              <option value="331" <c:out value="${vo.upcode eq '331'?'selected':''}"/>>디지털</option>
	                              <option value="332" <c:out value="${vo.upcode eq '332'?'selected':''}"/>>소프트웨어</option>
	                              
	                              <option value="333" <c:out value="${vo.upcode eq '333'?'selected':''}"/>>컴퓨터서비스</option>
	                              <option value="334" <c:out value="${vo.upcode eq '334'?'selected':''}"/>>통신장비</option>
	                              <option value="335" <c:out value="${vo.upcode eq '335'?'selected':''}"/>>정보기기</option>
	                              <option value="336" <c:out value="${vo.upcode eq '336'?'selected':''}"/>>반도체</option>
	                              <option value="337" <c:out value="${vo.upcode eq '337'?'selected':''}"/>>IT 부품</option>
	                              <option value="338" <c:out value="${vo.upcode eq '338'?'selected':''}"/>>오락문화</option>

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