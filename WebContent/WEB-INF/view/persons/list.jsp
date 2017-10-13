<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
	<body>
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
	
			<h1>All Employees</h1>
			
			<spring:url value="/employees/new" var="urlAddPerson" />
			
			<div id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${urlAddPerson}">Add User</a></li>
				</ul>
			</div>
	
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#ID</th>
						<th>Name</th>
						<th>Email</th>
						<!-- <th>framework</th> -->
						<th>Action</th>
					</tr>
				</thead>
	
				<c:forEach var="person" items="${persons}">
					<tr>
						<td>${person.id}</td>
						<td>${person.name}</td>
						<td>${person.email}</td>
						<%-- <td><c:forEach var="framework" items="${user.framework}"
								varStatus="loop">
						${framework}
	    				        <c:if test="${not loop.last}">,</c:if>
							</c:forEach></td> --%>
						<td class="inlinetd">
						<spring:url value="/employees/${person.id}" var="personUrl" /> 
						<spring:url value="/employees/${person.id}/delete" var="deleteUrl" /> 
						<spring:url value="/employees/${person.id}/update" var="updateUrl" />
							
							<button class="btn btn-info" onclick="location.href='${personUrl}'">Show</button>
							<button class="btn btn-primary"
								onclick="location.href='${updateUrl}'">Update</button>
							<form class="inlinetd" method="post" action="${deleteUrl}">
							  <button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
	
		</div>
	
		<jsp:include page="../fragments/footer.jsp" />
	
	</body>
</html>