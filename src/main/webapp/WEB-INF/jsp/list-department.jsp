<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Departments</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Department Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${departments}" var="item">
			<tr>
				<td><c:out value="${item.id}"></c:out></td>
				<td> <c:out value="${item.departmentName}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>