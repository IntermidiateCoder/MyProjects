<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<nav class="navbar navbar-expand-sm bg-light navbar-light">
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="<c:url value='/'/>">New Idea</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="<c:url value='/myideas'/>">My Ideas</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="<c:url value='/allideas'/>">All Ideas</a></li>

		<sec:authorize access="!isAuthenticated()">
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="<c:url value='/login'/>">Login</a></li>
		</sec:authorize>

		<sec:authorize access="isAuthenticated()">
			<c:url var='logoutUrl' value="/logout" />
			<li class="nav-item">
				<form id='my_form' action='${logoutUrl }' method='post'>
					<a class="nav-link" data-toggle="tab" href="javascript:{}"
						onclick="document.getElementById('my_form').submit(); return false;">Logout</a>
					<input type='hidden' name='${_csrf.parameterName}'
						value='${_csrf.token }' />
				</form>
			</li>
			<%-- 			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="<c:url value="/logout" />"> <input
					type='hidden' name='${_csrf.parameterName}' value='${_csrf.token }' />
					Logout
			</a></li> --%>
		</sec:authorize>
		<li class="nav-item"> <p>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
		&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Created by Tamir Larizki in 2018</p></li>
	</ul>
</nav>