<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">Screen Stock</a>
            </li>
            <li class="active">
                <strong>Screen1</strong>
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
                  <h5>Screen${dto.sno } conditions</h5>
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
                  <form role="form" class="form-inline" action="/screen/result" method="post">
                    <input type="hidden" name="sno" value='${dto.sno }'>
                    <div class="row">
                    <div class="col-md-3" id="data_1">
                          <label class="font-normal">BASE DATE</label>
                          <div class="input-group date">
                              <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                              <input type="text" class="form-control" name="basedate" value='${dto.basedate}'>
                          </div>
                      </div>

                      <div class="col-md-2">
                          <label for="duration">DURATION</label>
                          <input type="text" name="duration" placeholder="DURATION" id="duration" value='${dto.duration}'
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="total">TOTAL AMOUNT</label>
                          <input type="text" name="total" placeholder="TOTAL AMOUNT" id="total" value='${dto.total}'
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="ic_rate">IC_RATE</label>
                          <input type="text" name="ic_rate" placeholder="IC_RATE" id="ic_rate" value='${dto.ic_rate}'
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="dy_rate">DY_RATE</label>
                          <input type="text" name="dy_rate" placeholder="DY_RATE" id="dy_rate" value='${dto.dy_rate}'
                                 class="form-control">
                      </div>
					</div>
					<br>
					<div class="row">
					  <div class="col-md-2">
                      	<button class="btn btn-primary " type="submit">Get Results</button>
                      </div>
                    </div> 
                  </form>
              </div>
          </div>
      </div>
  </div> <!-- row -->

  
  <div class="row">
     <div class="col-lg-12">
     <div class="ibox float-e-margins">
         <div class="ibox-title">
             <h5>Screen${dto.sno } Results </h5>
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
              <th>Date</th>
              <th>shcode</th>
              <th>hname</th>
              <th>total</th>
              <th>price</th>
              <th>ic_rate</th>
              <th>dy_rate</th>
              <th>ict_rate</th>
              <th>uprate</th>
              <th>down_rate</th>
              <th>avg_price</th>
          </tr>
          </thead>
          <tbody>

<c:forEach items="${list}" var="stockVO">
<tr>
  <td>${vo.basedate}</td>
<td>${stockVO.shcode} </td>
<td>${stockVO.hname}</td>
<td>${stockVO.total}</td>
<td>${stockVO.price}</td>
<td>${stockVO.ic_rate}</td>
<td>${stockVO.dy_rate} </td>
<td>${stockVO.ict_rate}</td>
<td>${stockVO.uprate}</td>
<td>${stockVO.downrate}</td>
<td>${stockVO.avg_price}</td>
</tr>
</c:forEach>

          </tbody>
          <tfoot>
          <tr>
              <th>Date</th>
              <th>shcode</th>
              <th>hname</th>
              <th>total</th>
              <th>price</th>
              <th>ic_rate</th>
              <th>dy_rate</th>
              <th>ict_rate</th>
              <th>uprate</th>
              <th>down_rate</th>
              <th>avg_price</th>
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
                { extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'pdf', title: 'ExampleFile'},

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
<script src="/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>

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