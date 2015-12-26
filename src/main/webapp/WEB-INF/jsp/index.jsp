<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Customers</h1>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add New Customer</button>
<br/><br/>

<form:form commandName="customer" cssClass="form-horizontal registrationForm" autocomplete="off">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Customer Add Sucsessfully</div>
	</c:if>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Customer</h4>
				</div>
				<div class="modal-body">

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

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-success" value="Save" />
				</div>
			</div>
		</div>
	</div>

</form:form>

<script type="text/javascript">
$(document).ready(
	    function() {
	    	$('.registrationForm').validate(
	    			{
	    			    rules : {
		    			    customerName : {
		    				    required : true,
		    				    minlength : 1,
		    				    maxlength: 150
		    				},
	    			    },
	    			    highlight : function(element) {
	    				$(element).closest('.form-group').removeClass(
	    					'has-success').addClass('has-error');
	    			    },
	    			    unhighlight : function(element) {
	    				$(element).closest('.form-group').removeClass(
	    					'has-error').addClass('has-success');
	    			    }
	    			});	
	    	
	    	$('.triggerRemove').click(
	    			function(e) {
	    			    e.preventDefault();
	    			    $('#modalRemove .removeBtn').attr("href",
	    				    $(this).attr("href"));
	    			    $('#modalRemove').modal();
	    			});
	    });
</script>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<!-- <th>Id</th> -->
			<th>Customer Name</th>
			<th>Customer Department</th>
			<th>Options</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${fn:length(users) eq 0}">
		   <tr>
		   		<td>Add Customers</td>
		   </tr>
		</c:if>
		<c:forEach items="${users}" var="item">
			<tr>
				<%-- <td><c:out value="${item.id}"></c:out></td> --%>
				<td> <c:out value="${item.customerName}"></c:out></td>
				<td> <c:out value="${item.customerDepartment.departmentName}"></c:out></td>
				<td>
					<div align="center">
						<a href='<spring:url value="/index/edit/${item.id}.html"/>'
							class="btn btn-warning">Edit</a>
						<!-- <button type="button" class="btn btn-danger">Delete</button> -->
						<a href='<spring:url value="/index/delete/${item.id}.html"/>'
						class="btn btn-danger triggerRemove">Delete</a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Delete Customer</h4>
			</div>
			<div class="modal-body">Are You Sure ?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Delete</a>
			</div>
		</div>
	</div>
</div>