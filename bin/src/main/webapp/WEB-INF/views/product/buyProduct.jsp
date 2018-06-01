<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<c:if test="${denied == 'yes'}">
<script>
	alert("서비스 권한이 없습니다. 해당 서비스가 포함된 가격 상품에 가입후 메뉴를 이용하시기 바랍니다.");
</script>
</c:if>


<!-- Menu Location -->
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-4">
        <!--<h2>Layouts</h2>  -->
        <br>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">고객 지원</a>
            </li>
            <li class="breadcrumb">
                <strong>상품 목록 </strong>
            </li>
            <li class="active">
                <strong>상품 구매 </strong>
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

                    <div class="ibox product-detail">
                        <div class="ibox-content">

                            <div class="row">
                                <div class="col-md-5">
                                     <div>
                                         <div class="image-imitation">
                                             [IMAGE 1]
                                         </div>
                                     </div>

                                </div>
                                <div class="col-md-7">

                                    <h2 class="font-bold m-b-xs">
                                        ${product.name}
                                    </h2>
                                    <small>Many desktop publishing packages and web page editors now.</small>
                                    <div class="m-t-md">
                                        <h2 class="product-main-price">${product.price} <small class="text-muted">Exclude Tax</small> 
                                        </h2>
                                    </div>
                                    <hr>

                                    <h4>Product description</h4>

                                    <div class="small text-muted">
                                        It is a long established fact that a reader will be distracted by the readable
                                        content of a page when looking at its layout. The point of using Lorem Ipsum is

                                        <br/>
                                        <br/>
                                        There are many variations of passages of Lorem Ipsum available, but the majority
                                        have suffered alteration in some form, by injected humour, or randomised words
                                        which don't look even slightly believable.
                                    </div>
                                    <dl class="small m-t-md">
                                        <dt>결제 방법</dt>
                                        <dd>신용카드</dd>
                                        <dd>실시간계좌이체</dd>
                                        <dd>가상계좌</dd>

                                    </dl>
                                    <hr>

                                    <div>
                                        <div class="btn-group">
                                            <button class="btn btn-primary btn-md" onClick="requestPay()"><i class="fa fa-cart-plus"></i> 결제</button>

                                        </div>
                                    </div>



                                </div>
                            </div>

                        </div>

                    </div>


</div> 
</div> 

<%@ include file="../include/footer.jsp" %>

<!-- iamport.payment.js -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script>
var IMP = window.IMP; // 생략해도 괜찮습니다.
IMP.init("imp27631769"); // "imp00000000" 대신 발급받은 "가맹점 식별코드"를 사용합니다.

function requestPay() {
	

	IMP.request_pay({ // param
	    pg: "inicis",
	    pay_method: "card",
	    merchant_uid: "ORD20180131-0000011",
	    name: "${product.name}",
	    amount: ${product.price},
	    buyer_email: "${user.username}",
	    buyer_name: "${user.name}",
	    buyer_tel: "${user.phone_no}",
	    buyer_addr: "${user.address}",
	    buyer_postcode: "01181"
	}, function (rsp) { // callback
		if ( rsp.success ) {
			//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			jQuery.ajax({
			url: "${contextPath}/product/paymentComplete", //cross-domain error가 발생하지 않도록 주의해주세요
			type: 'POST',
			dataType: 'json',
			data: {
				imp_uid : rsp.imp_uid
				//기타 필요한 데이터가 있으면 추가 전달
			}
			}).done(function(data) {
				//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
				if ( everythings_fine ) {
					var msg = '결제가 완료되었습니다.';
					msg += '\n고유ID : ' + rsp.imp_uid;
					msg += '\n상점 거래ID : ' + rsp.merchant_uid;
					msg += '\결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
	   			
					alert(msg);
				} else {
					//[3] 아직 제대로 결제가 되지 않았습니다.
					//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
				}
			});
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		      
			alert(msg);
		}
	});
}
</script>
