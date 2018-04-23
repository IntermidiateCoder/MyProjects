<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:directive.include file="/resources/script/toolbar.jsp" /><br><br><br>
	
	<table class="formtable">
		<tr>
			<td>Idea Of</td>
			<td>Idea</td>
			<td>Score</td>
		</tr>

		<c:forEach var="idea" items="${ideas}">
		
			<tr>
				<td><c:out value="${idea.username}"></c:out></td>
				<td><c:out value="${idea.subject}"></c:out></td>
				<td><c:out value="${idea.score}"></c:out></td>
				<td><sf:form action='${pageContext.request.contextPath}/viewidea' method='POST' modelAttribute='idea'>
				<sf:input type='hidden' path='id' value='${idea.id}'/>
				<input name="submit" class='btn btn-info' type="submit" value="View" />
				</sf:form>
				</td>
				<td><sf:form action='${pageContext.request.contextPath}/editidea' method='POST' modelAttribute='idea'>
				<sf:input type='hidden' path='id' value='${idea.id}'/>
				<input name="submit" class='btn btn-info' type="submit" value="Edit" />
				</sf:form>
				</td>
				<td><sf:form action='${pageContext.request.contextPath}/deleteidea' method='POST' modelAttribute='idea'>
				<sf:input type='hidden' path='id' value='${idea.id}'/>
				<input name="submit" class='btn btn-info' type="submit" value="Delete" />
				</sf:form>
				</td>
			</tr>
			
		</c:forEach>

	</table>
</body>
</html>