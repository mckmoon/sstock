<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<%@ include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
    
         <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2017
            </div>
        </div>

    </div>
</div>

<!-- Mainly scripts -->
<script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${contextPath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${contextPath}/resources/js/plugins/dataTables/datatables.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${contextPath}/resources/js/inspinia.js"></script>
<script src="${contextPath}/resources/js/plugins/pace/pace.min.js"></script>


</body>

</html>