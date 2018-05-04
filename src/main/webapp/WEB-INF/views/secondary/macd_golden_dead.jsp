<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
            <li>
                	보조지표
            </li>
            <li>
                <strong>MACD</strong>
            </li>
            <li class="active">
                <strong> 골든크로스/데드크로스</strong>
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
                  <h5>기준일 D, MACD 골든크로스/데드크로스
                  
				  </h5>
              </div>
              <form role="form" class="form-inline" action="macd_golden_dead" method="post">
              <div class="ibox-content">                 
						<div class="col-md-3 input-group">
                			<label class="font-normal">기준 일(D)</label>
                			<div id="data_1">
		                    <div class="input-group date">		                    
		                      <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                      <input type="text" class="form-control" name="basedate" value='${vo.basedate}'>
		                    </div>
		                    </div>
		                </div>
                      	<div class="col-md-2 input-group">
                			<label class="font-normal">골드/데드</label>           	
		                    <div>
		            	      <select class="select2_demo_1 form-control" name="sign" id="sign">
	                              <option value="1" 
	                              	<c:out value="${vo.sign eq '1'?'selected':''}"/>>
	                              	골든크로스</option>
	                              <option value="2" 
	                              <c:out value="${vo.sign eq '2'?'selected':''}"/>>
	                              	데드크로스</option>
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
             <h5>추출결과 </h5>
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
              <th>MACD</th>
              <th>시가총액(억)</th>
              <th>년매출액(억)</th>
              <th>영업이익률</th>
              <th>시가배당률</th>

          </tr>
          </thead>
          <tbody>

<c:forEach items="${list}" var="stockVO">
<tr>
<td>${stockVO.date}</td>
<td><a href="#" onClick="javascript:openNaver('${stockVO.shcode}')">${stockVO.hname}</a>
<c:if test="${stockVO.notice > 0}">
 <a data-toggle="modal" href="${contextPath}/basic/modal_notice?basedate=${stockVO.date}&shcode=${stockVO.shcode}" data-target="#dialog_modal"><i class="fa fa-bomb"></i></a> 
</c:if>
</td>
<td>${stockVO.price}</td>
<td>${stockVO.diff_rate > 0.0 ? "<span style='color:red'>" : "<span style='color:blue'>"} ${stockVO.diff_rate }</span> </td>
<td>${stockVO.vol_diff_rate}</td>
<td>${stockVO.macd}</td>
<td>${stockVO.total}</td>
<td>${stockVO.sales}</td>
<td>${stockVO.ic_rate}</td>
<td>${stockVO.dy_rate}</td>

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
              <th>MACD</th>
              <th>시가총액(억)</th>
              <th>년매출액(억)</th>
              <th>영업이익률</th>
              <th>시가배당률</th>
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