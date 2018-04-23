<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js?ver=1.4.2'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath}/resources/script/newaccountscript.js'></script>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:directive.include file="/resources/script/toolbar.jsp" /><br><br><br>

	<h2>Create New Account</h2>

	<sf:form id="details" method="post" class='form-horizontal'
		action="${pageContext.request.contextPath}/createaccount"
		modelAttribute="user">

		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><sf:input class='form-control' path="username" name="username"
						type="text" />
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><sf:input class='form-control' path="name" name="name"
						type="text" />
					<div class="error">
						<sf:errors path="name"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input class='form-control' path="email" name="email"
						type="text" />
					<div class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><sf:input id="password" class='form-control' path="password"
						name="password" type="password" />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmpass" class='form-control' name="confirmpass"
					type="password" />
					<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><input class='btn btn-info' value="Create account" type="submit" /></td>
			</tr>
		</table>

	</sf:form>
 	<script type="text/javascript">
		function onLoad() {

			$("#password").keyup(checkPasswordsMatch);
			$("#confirmpass").keyup(checkPasswordsMatch);

			$("#details").submit(canSubmit);
		}

		function canSubmit() {
			var password = $("#password").val();
			var confirmpass = $("#confirmpass").val();

			if (password != confirmpass) {
				alert("<fmt:message key='Passwords Do Not Match' />")
				return false;
			} else {
				return true;
			}
		}

		function checkPasswordsMatch() {
			var password = $("#password").val();
			var confirmpass = $("#confirmpass").val();

			if (password.length > 3 || confirmpass.length > 3) {

				if (password == confirmpass) {
					$("#matchpass")
							.text("Passwords Match");
					$("#matchpass").addClass("valid");
					$("#matchpass").removeClass("error");
				} else {
					$("#matchpass")
							.text(
									"<fmt:message key='Passwords Do Not Match' />");
					$("#matchpass").addClass("error");
					$("#matchpass").removeClass("valid");
				}
			}
		}

		$(document).ready(onLoad);
	</script> 
</body>
</html>