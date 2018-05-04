<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Main content -->


     <div class="ibox float-e-margins">
        <div class="ibox-content">
            <table class="table table-stripped small m-t-md">
                <thead>
                <tr>
	              <th>일자</th>
	              <th>공시</th>
                </tr>
                </thead>
                <tbody>
                
				<c:forEach items="${list}" var="noticeVO">
				<tr>
				<td>${noticeVO.date}</td>
				<td>${noticeVO.title}</td>
				</tr>
				</c:forEach>	

				</tbody>
            </table>
      		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 	
        </div> 
                      
    </div>



