<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:directive.include file="/resources/script/toolbar.jsp" /><br><br><br>
	
	<table class="formtable">
		<tr>
			<td>The Idea:</td>
			<td>${idea.subject }</td>
		</tr>
				<tr>
			<td>Description:</td>
			<td>${idea.content }</td>
		</tr>
		<tr>
			<td>
				<label id="score">Score:</label>
				 ${idea.score }
			</td>
		</tr>
		<tr>
			<td><br />
			<br />
			<h3>
					Elements: Element are rated with numbers between -10 to 10<br />
					based on how well your idea performs.
				</h3></td>
		</tr>
		<tr>
			<td>Element 1- :</td>
			<td> ${idea.element1 }</td>
		</tr>
		<tr>
			<td>Element 2- :</td>
			<td> ${idea.element2 }</td>
		</tr>
		<tr>
			<td>Element 3- :</td>
			<td>  ${idea.element3 }</td>
		</tr>
		<tr>
			<td>Element 4- :</td>
			<td>  ${idea.element4 }</td>
		</tr>
		<tr>
			<td>Element 5- :</td>
			<td> ${idea.element5 }</td>
		</tr>
		<tr>
			<td>Element 6- :</td>
			<td>${idea.element6 }</td>
		</tr>
		<tr>
			<td>Element 7- :</td>
			<td>${idea.element7 }</td>
		</tr>
		<tr>
			<td>Element 8- :</td>
			<td>${idea.element8 }</td>
		</tr>
		<tr>
			<td>Element 9- :</td>
			<td>${idea.element9 }</td>
		</tr>
		<tr>
			<td>Element 10- :</td>
			<td>${idea.element10 }</td>
		</tr>
		<tr>
			<td>Element 11- :</td>
			<td>${idea.element11 }</td>
		</tr>
		<tr>
			<td>Element 12- :</td>
			<td>${idea.element10 }</td>
		</tr>
		<tr>
			<td>Element 13- :</td>
			<td> ${idea.element13 }</td>
		</tr>
		<tr>
			<td>Element 14- :</td>
			<td>${idea.element14 }</td>
		</tr>
		<tr>
			<td>Element 15- :</td>
			<td>${idea.element15 }</td>
		</tr>
		<tr>
			<td>Element 16- :</td>
			<td>${idea.element16}</td>
		</tr>
		<tr>
			<td>Element 17- :</td>
			<td>${idea.element17 }</td>
		</tr>
		<tr>
			<td>Element 18- :</td>
			<td>${idea.element18 }</td>
		</tr>
		<tr>
			<td>Element 19- :</td>
			<td> ${idea.element19 }</td>
		</tr>
		<tr>
			<td>Element 20- :</td>
			<td>${idea.element20 }</td>
		</tr>
		<tr>
			<td>Element 21- :</td>
			<td>${idea.element21 }</td>
		</tr>
		<tr>
			<td>Element 22- :</td>
			<td> ${idea.element22 }</td>
		</tr>
		<tr>
			<td>Element 23- :</td>
			<td> ${idea.element23 }</td>
		</tr>
		<tr>
			<td>Element 24- :</td>
			<td> ${idea.element24 }</td>
		</tr>
		<tr>
			<td>Element 25- :</td>
			<td> ${idea.element25 }</td>
		</tr>
		<tr>
			<td>Element 26- :</td>
			<td> ${idea.element26 }</td>
		</tr>
		<tr>
			<td>Element 27- :</td>
			<td> ${idea.element27 }</td>
		</tr>
		<tr>
			<td>Element 28- :</td>
			<td>${idea.element28 }</td>
		</tr>
		<tr>
			<td>Element 29- :</td>
			<td> ${idea.element29 }</td>
		</tr>
		<tr>
			<td>Element 30- :</td>
			<td>${idea.element30 }</td>
		</tr>
		<tr>
			<td>Element 31- :</td>
			<td>${idea.element31 }</td>
		</tr>
		<tr>
			<td>Element 32- :</td>
			<td> ${idea.element32 }</td>
		</tr>
		<tr>
			<td>Element 33- :</td>
			<td> ${idea.element33 }</td>
		</tr>
		<tr>
			<td>Element 34- :</td>
			<td> ${idea.element34 }</td>
		</tr>
		<tr>
			<td>Element 35- :</td>
			<td>${idea.element35 }</td>
		</tr>
		<tr>
			<td>Element 36- :</td>
			<td>${idea.element36 }</td>
		</tr>
		<tr>
			<td>Element 37- :</td>
			<td>${idea.element37 }</td>
		</tr>
		<tr>
			<td>Element 38- :</td>
			<td>${idea.element38 }</td>
		</tr>
		<tr>
			<td>Element 39- :</td>
			<td>${idea.element39 }</td>
		</tr>
		<tr>
			<td>Element 40- :</td>
			<td>${idea.element40}</td>
		</tr>
		<tr>
			<td>Element 41- :</td>
			<td>${idea.element41 }</td>
		</tr>
		<tr>
			<td>Element 42- :</td>
			<td>${idea.element42 }</td>
		</tr>
		<tr>
			<td>Element 43- :</td> 
			<td>${idea.element43 }</td>
		</tr>
		<tr>
			<td>Element 44- :</td>
			<td>${idea.element44 }</td>
		</tr>

		<tr>
			<td colspan='2'><input name="submit" type="submit" value="Save" /></td>
		</tr>
	</table>
</body>
</html>