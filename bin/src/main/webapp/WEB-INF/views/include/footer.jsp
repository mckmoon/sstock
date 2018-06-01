<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    

         <div class="footer">
            <div class="pull-right">
                서비스 <strong>30일</strong> 무료.
            </div>
            <div>
                <strong>Copyright</strong> SeoMoon Company &copy; 2017-2018
            </div>
        </div>

</div> <!-- page wrapper -->

<!-- Mainly scripts -->
<script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${contextPath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${contextPath}/resources/js/plugins/dataTables/datatables.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${contextPath}/resources/js/inspinia.js"></script>
<script src="${contextPath}/resources/js/plugins/pace/pace.min.js"></script>
<script src="${contextPath}/resources/js/common.js"></script>

</body>

</html>