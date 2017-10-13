<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${projectForm.created > 0}">
			<h1>Add Project</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Project</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/projects/new" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="projectForm" action="${userActionUrl}">

		<spring:bind path="project.title">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Title</label>
				<div class="col-sm-10">
					<form:input path="project.title" type="text" class="form-control" id="title"
						placeholder="Project Title" />
					<form:errors path="project.title" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="project.startDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Start Date</label>
				<div class="col-sm-10">
					<form:input path="project.startDate" class="date" id="startDate" type="date"
						placeholder="Start Date" />
					<form:errors path="project.startDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="project.endDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">End Date</label>
				<div class="col-sm-10">
					<form:input path="project.endDate" class="date" id="endDate" type="date"
						placeholder="End Date" />
					<form:errors path="project.endDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
			<spring:bind path="executer">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Select Executer Company:</label>
				<div class="col-sm-2">
					<form:select path="executer">
					   <form:option value="0" label="--- Select ---"/> 
					   <c:forEach items="${companies}" var="company">
					        <option value="${company.id}" ${projectForm.executer == company.id ? 'selected="selected"' : ''}><c:out value="${company.title}" /></option>
					    </c:forEach>
					   <%-- <option value="${companies}">${companies}</option> --%>
					</form:select>
				</div>
				<label class="col-sm-2 control-label">Or Add New Executer Company:</label>
				<div class="col-sm-5">
					<form:input path="newExecuter" type="text" class="form-control" id="newExecuter"
						placeholder="New Executer Company" />
					<form:errors path="newExecuter" class="control-label" />
				</div>
			  </div>
			</spring:bind>
		
		<spring:bind path="customer">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Select Customer Company:</label>
			<div class="col-sm-2">
				<form:select path="customer">
				   <form:option value="0" label="--- Select ---"/>
				   <c:forEach items="${companies}" var="company">
				        <option value="${company.id}" ${projectForm.customer == company.id ? 'selected="selected"' : ''}><c:out value="${company.title}" /></option>
				    </c:forEach>
				</form:select>
			</div>
			<label class="col-sm-2 control-label">Or Add New Customer Company:</label>
				<div class="col-sm-5">
					<form:input path="newCustomer" type="text" class="form-control" id="newCustomer"
						placeholder="New Customer Company" />
					<form:errors path="newCustomer" class="control-label" />
				</div>
		  </div>
		</spring:bind>

		<spring:bind path="project.priority">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Priority</label>
				<div class="col-sm-10">
					<form:input path="project.priority" class="form-control" id="priority" type="number"
						placeholder="Priority" />
					<form:errors path="project.priority" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="leader">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Select Project Leader:</label>
			<div class="col-sm-5">
				<form:select path="leader">
				   <form:option value="0" label="--- Select ---"/>
				   <c:forEach items="${persons}" var="person">
				        <option value="${person.id}" ${projectForm.leader == person.id ? 'selected="selected"' : ''}><c:out value="${person.name} ${person.surname}" /></option>
				    </c:forEach>
				</form:select>
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="performers">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Select Employees</label>
			<div class="col-sm-5">
                <form:select multiple="true" path="performers" items="${persons}" itemLabel="name" itemValue="id" />
				<form:errors path="performers" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>

		<spring:bind path="project.comment">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Comment</label>
				<div class="col-sm-10">
					<form:textarea  path="project.comment" class="form-control" rows="5" cols="30"
						id="comment" placeholder="comment" />
					<form:errors path="project.comment" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="created">
			<form:hidden  path="created" class="form-control" />
		</spring:bind>
		
		<spring:bind path="project.id">
			<form:hidden  path="project.id" class="form-control" />
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${projectForm.created > 0}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add
						</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>