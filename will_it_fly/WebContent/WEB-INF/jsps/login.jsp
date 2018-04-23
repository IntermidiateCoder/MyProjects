<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="auth" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		document.f.j_username.focus();
	});
</script>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:directive.include file="/resources/script/toolbar.jsp" /><br><br><br>

<h3>Login with Username and Password</h3>

<c:if test="${param.error != null}">

	<p class="error">Login failed. Check that your username and
		password are correct.</p>

</c:if>

<form name='f' class='form-horizontal'
	action="<c:url value='/login' />"
	method='POST'>
	<table>
		<tr>
			<td>Username:</td>
			<td><input class='form-control' type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
				<input class='form-control' type='password' name='password' />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</td>
			
		</tr>
		<tr>
			<td>Remember me:</td>
			<td><input type='checkbox' name='_spring_security_remember_me'
				checked="checked" /></td>
		</tr>
		<tr><td><br></td></tr>
		<tr>
			<td colspan='2'><input class='btn btn-success' name="submit" type="submit" value="Login" /></td>
		</tr>
	</table>
</form>

<p>
	<a href="<c:url value="/newaccount"/>">Create new account</a>
</p>
</body>
</html>