<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Edit Customer</h1>
<form:form commandName="customer" cssClass="form-horizontal registrationForm" autocomplete="off" action="${pageContext.request.contextPath}/index/edit.html">
	<div class="modal-body">

		<div class="form-group" hidden="true">
			<label for="id" class="col-sm-2 control-label">Name :</label>
			<div class="col-sm-10">
				<form:input path="id" cssClass="form-control" />
				<form:errors path="id" />
			</div>
		</div>
		<div class="form-group">
			<label for="customerName" class="col-sm-2 control-label">Name :</label>
			<div class="col-sm-10">
				<form:input path="customerName" cssClass="form-control" />
				<form:errors path="customerName" />
			</div>
		</div>
		<div class="form-group">
			<label for="customerDepartment" class="col-sm-2 control-label">Department:</label>
			<div class="col-sm-10">
				<form:select path="customerDepartment.id" cssClass="form-control">								
					<form:options itemLabel="departmentName" itemValue="id" items="${departments}" />
				</form:select>
				<form:errors path="customerDepartment" />						
			</div>
		</div>
		<input type="submit" class="btn btn-success" value="Update" />
	</div>
</form:form>