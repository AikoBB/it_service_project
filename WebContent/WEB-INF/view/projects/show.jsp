<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Project Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID:</label>
		<div class="col-sm-10">${project.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Title:</label>
		<div class="col-sm-10">${project.title}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Start Date:</label>
		<div class="col-sm-10">${project.startDate}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">End Date</label>
		<div class="col-sm-10">${project.endDate}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Priority</label>
		<div class="col-sm-10">${project.priority}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Comment</label>
		<div class="col-sm-10">${project.comment}</div>
	</div>
	
	<h3>Project Staff</h3>
	<h4>Company:</h4>
	<table>
		<thead>
			<tr>
				<th>ROLE</th>
				<th>Title</th>
			</tr>
		</thead>

		<c:forEach var="obj" items="${companies}">
			<tr>
				<td>${obj.role}</td>
				<td>${obj.company.title}</td>
			</tr>
		</c:forEach>
						
	</table>
	
	<h4>Employees:</h4>
	<table>
		<thead>
			<tr>
				<th>ROLE</th>
				<th>Name Surname</th>
			</tr>
		</thead>

		<c:forEach var="obj" items="${employees}">
			<tr>
				<td>${obj.role}</td>
				<td>${obj.person.name} ${obj.person.surname}</td>
			</tr>
		</c:forEach>
						
	</table>
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>