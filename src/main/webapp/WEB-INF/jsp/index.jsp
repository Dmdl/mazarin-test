<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1>Customers</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Customer Name</th>
			<th>Customer Department</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="item">
			<tr>
				<td><c:out value="${item.id}"></c:out></td>
				<td> ${item.customerName}</td>
				<td> ${item.customerDepartment.departmentName}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>