<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Projects</title>

<spring:url value="/assets/core/css/hello.css" var="coreCss" />
<spring:url value="/assets/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/employees" var="urlEmployees" />
<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Projects Database</a>
			<a class="navbar-brand" href="${urlEmployees}">Employees Database</a>
		</div>
		
	</div>
</nav>


