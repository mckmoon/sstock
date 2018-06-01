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
                  <h5>Screen 5 conditions</h5>
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
                              <input type="text" class="form-control" name="basedate">
                          </div>
                      </div>
                      <div class="col-md-2">
                          <label for="duration">DURATION</label>
                          <input type="text" name="duration" placeholder="DURATION" id="duration" 
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="total">TOTAL AMOUNT</label>
                          <input type="text" name="total" placeholder="TOTAL AMOUNT" id="total" 
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="ic_rate">IC_RATE</label>
                          <input type="text" name="ic_rate" placeholder="IC_RATE" id="ic_rate" 
                                 class="form-control">
                      </div>
                      <div class="col-md-2">
                          <label for="dy_rate">DY_RATE</label>
                          <input type="text" name="dy_rate" placeholder="DY_RATE" id="dy_rate" 
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

<%@ include file="../include/footer.jsp" %>

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
        