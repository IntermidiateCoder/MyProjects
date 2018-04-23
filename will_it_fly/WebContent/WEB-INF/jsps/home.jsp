<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script> --%>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js?ver=1.4.2'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<jsp:directive.include file="/resources/script/toolbar.jsp" /><br><br><br>
	
	<sf:form id='f' action='${pageContext.request.contextPath}/saveidea'
		method='POST' modelAttribute='idea'>
		<table>
			<tr>
				<td>The Idea:</td>
				<td><sf:input type='text' class='form-control' id='idea' path='subject' value='' /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><sf:textarea  class='form-control' id="content" path='content'
						rows="5" cols="10"></sf:textarea></td>
			</tr>
			<tr>
				<td><label id="score">Score:</label> <sf:input type='hidden'
						path='score' id='scoreval' /></td>
			</tr>
			<tr>
				<td><br /> <br />
					<h3>
						Elements: Write near each element a number between -10 to 10<br />
						based on how well your idea performs.
					</h3></td>
			</tr>
			<tr>
				<td>Element 1- :</td>
				<td><sf:input type='text' class='form-control' id='elem1' path='element1' value='' /></td>
			</tr>
			<tr>
				<td>Element 2- :</td>
				<td><sf:input type='text' class='form-control' id='elem2' path='element2' value='' /></td>
			</tr>
			<tr>
				<td>Element 3- :</td>
				<td><sf:input type='text' class='form-control' id='elem3' path='element3' value='' /></td>
			</tr>
			<tr>
				<td>Element 4- :</td>
				<td><sf:input type='text' class='form-control' id='elem4' path='element4' value='' /></td>
			</tr>
			<tr>
				<td>Element 5- :</td>
				<td><sf:input type='text' class='form-control' id='elem5' path='element5' value='' /></td>
			</tr>
			<tr>
				<td>Element 6- :</td>
				<td><sf:input type='text' class='form-control' id='elem6' path='element6' value='' /></td>
			</tr>
			<tr>
				<td>Element 7- :</td>
				<td><sf:input type='text' class='form-control' id='elem7' path='element7' value='' /></td>
			</tr>
			<tr>
				<td>Element 8- :</td>
				<td><sf:input type='text' class='form-control' id='elem8' path='element8' value='' /></td>
			</tr>
			<tr>
				<td>Element 9- :</td>
				<td><sf:input type='text' class='form-control' id='elem9' path='element9' value='' /></td>
			</tr>
			<tr>
				<td>Element 10- :</td>
				<td><sf:input type='text' class='form-control' id='elem10' path='element10' value='' /></td>
			</tr>
			<tr>
				<td>Element 11- :</td>
				<td><sf:input type='text' class='form-control' id='elem11' path='element11' value='' /></td>
			</tr>
			<tr>
				<td>Element 12- :</td>
				<td><sf:input type='text' class='form-control' id='elem12' path='element12' value='' /></td>
			</tr>
			<tr>
				<td>Element 13- :</td>
				<td><sf:input type='text' class='form-control' id='elem13' path='element13' value='' /></td>
			</tr>
			<tr>
				<td>Element 14- :</td>
				<td><sf:input type='text' class='form-control' id='elem14' path='element14' value='' /></td>
			</tr>
			<tr>
				<td>Element 15- :</td>
				<td><sf:input type='text' class='form-control' id='elem15' path='element15' value='' /></td>
			</tr>
			<tr>
				<td>Element 16- :</td>
				<td><sf:input type='text' class='form-control' id='elem16' path='element16' value='' /></td>
			</tr>
			<tr>
				<td>Element 17- :</td>
				<td><sf:input type='text' class='form-control' id='elem17' path='element17' value='' /></td>
			</tr>
			<tr>
				<td>Element 18- :</td>
				<td><sf:input type='text' class='form-control' id='elem18' path='element18' value='' /></td>
			</tr>
			<tr>
				<td>Element 19- :</td>
				<td><sf:input type='text' class='form-control' id='elem19' path='element19' value='' /></td>
			</tr>
			<tr>
				<td>Element 20- :</td>
				<td><sf:input type='text' class='form-control' id='elem20' path='element20' value='' /></td>
			</tr>
			<tr>
				<td>Element 21- :</td>
				<td><sf:input type='text' class='form-control' id='elem21' path='element21' value='' /></td>
			</tr>
			<tr>
				<td>Element 22- :</td>
				<td><sf:input type='text' class='form-control' id='elem22' path='element22' value='' /></td>
			</tr>
			<tr>
				<td>Element 23- :</td>
				<td><sf:input type='text' class='form-control' id='elem23' path='element23' value='' /></td>
			</tr>
			<tr>
				<td>Element 24- :</td>
				<td><sf:input type='text' class='form-control' id='elem24' path='element24' value='' /></td>
			</tr>
			<tr>
				<td>Element 25- :</td>
				<td><sf:input type='text' class='form-control' id='elem25' path='element25' value='' /></td>
			</tr>
			<tr>
				<td>Element 26- :</td>
				<td><sf:input type='text' class='form-control' id='elem26' path='element26' value='' /></td>
			</tr>
			<tr>
				<td>Element 27- :</td>
				<td><sf:input type='text' class='form-control' id='elem27' path='element27' value='' /></td>
			</tr>
			<tr>
				<td>Element 28- :</td>
				<td><sf:input type='text' class='form-control' id='elem28' path='element28' value='' /></td>
			</tr>
			<tr>
				<td>Element 29- :</td>
				<td><sf:input type='text' class='form-control' id='elem29' path='element29' value='' /></td>
			</tr>
			<tr>
				<td>Element 30- :</td>
				<td><sf:input type='text' class='form-control' id='elem30' path='element30' value='' /></td>
			</tr>
			<tr>
				<td>Element 31- :</td>
				<td><sf:input type='text' class='form-control' id='elem31' path='element31' value='' /></td>
			</tr>
			<tr>
				<td>Element 32- :</td>
				<td><sf:input type='text' class='form-control' id='elem32' path='element32' value='' /></td>
			</tr>
			<tr>
				<td>Element 33- :</td>
				<td><sf:input type='text' class='form-control' id='elem33' path='element33' value='' /></td>
			</tr>
			<tr>
				<td>Element 34- :</td>
				<td><sf:input type='text' class='form-control' id='elem34' path='element34' value='' /></td>
			</tr>
			<tr>
				<td>Element 35- :</td>
				<td><sf:input type='text' class='form-control' id='elem35' path='element35' value='' /></td>
			</tr>
			<tr>
				<td>Element 36- :</td>
				<td><sf:input type='text' class='form-control' id='elem36' path='element36' value='' /></td>
			</tr>
			<tr>
				<td>Element 37- :</td>
				<td><sf:input type='text' class='form-control' id='elem37' path='element37' value='' /></td>
			</tr>
			<tr>
				<td>Element 38- :</td>
				<td><sf:input type='text' class='form-control' id='elem38' path='element38' value='' /></td>
			</tr>
			<tr>
				<td>Element 39- :</td>
				<td><sf:input type='text' class='form-control' id='elem39' path='element39' value='' /></td>
			</tr>
			<tr>
				<td>Element 40- :</td>
				<td><sf:input type='text' class='form-control' id='elem40' path='element40' value='' /></td>
			</tr>
			<tr>
				<td>Element 41- :</td>
				<td><sf:input type='text' class='form-control' id='elem41' path='element41' value='' /></td>
			</tr>
			<tr>
				<td>Element 42- :</td>
				<td><sf:input type='text' class='form-control' id='elem42' path='element42' value='' /></td>
			</tr>
			<tr>
				<td>Element 43- :</td>
				<td><sf:input type='text' class='form-control' id='elem43' path='element43' value='' /></td>
			</tr>
			<tr>
				<td>Element 44- :</td>
				<td><sf:input type='text' class='form-control' id='elem44' path='element44' value='' /></td>
			</tr>

			<tr>
				<td colspan='2'><input name="submit" class='btn btn-success' type="submit" value="Save" /></td>
			</tr>
		</table>
	</sf:form>
	<script type='text/javascript'>
	function onLoad() {
		$("#elem1").keyup(recalculateScore);
		$("#elem2").keyup(recalculateScore);
		$("#elem3").keyup(recalculateScore);
		$("#elem4").keyup(recalculateScore);
		$("#elem5").keyup(recalculateScore);
		$("#elem6").keyup(recalculateScore);
		$("#elem7").keyup(recalculateScore);
		$("#elem8").keyup(recalculateScore);
		$("#elem9").keyup(recalculateScore);
		$("#elem10").keyup(recalculateScore);
		$("#elem11").keyup(recalculateScore);
		$("#elem12").keyup(recalculateScore);
		$("#elem13").keyup(recalculateScore);
		$("#elem14").keyup(recalculateScore);
		$("#elem15").keyup(recalculateScore);
		$("#elem16").keyup(recalculateScore);
		$("#elem17").keyup(recalculateScore);
		$("#elem18").keyup(recalculateScore);
		$("#elem19").keyup(recalculateScore);
		$("#elem20").keyup(recalculateScore);
		$("#elem21").keyup(recalculateScore);
		$("#elem22").keyup(recalculateScore);
		$("#elem23").keyup(recalculateScore);
		$("#elem24").keyup(recalculateScore);
		$("#elem25").keyup(recalculateScore);
		$("#elem26").keyup(recalculateScore);
		$("#elem27").keyup(recalculateScore);
		$("#elem28").keyup(recalculateScore);
		$("#elem29").keyup(recalculateScore);
		$("#elem30").keyup(recalculateScore);
		$("#elem31").keyup(recalculateScore);
		$("#elem32").keyup(recalculateScore);
		$("#elem33").keyup(recalculateScore);
		$("#elem34").keyup(recalculateScore);
		$("#elem35").keyup(recalculateScore);
		$("#elem36").keyup(recalculateScore);
		$("#elem37").keyup(recalculateScore);
		$("#elem38").keyup(recalculateScore);
		$("#elem39").keyup(recalculateScore);
		$("#elem40").keyup(recalculateScore);
		$("#elem41").keyup(recalculateScore);
		$("#elem42").keyup(recalculateScore);
		$("#elem43").keyup(recalculateScore);
		$("#elem44").keyup(recalculateScore);
	}
	
	function validate() {
		try {
			var val1 = $("#elem1").val();
			var val2 = $("#elem2").val();
			var val3 = $("#elem3").val();
			var val4 = $("#elem4").val();
			var val5 = $("#elem5").val();
			var val6 = $("#elem6").val();
			var val7 = $("#elem7").val();
			var val8 = $("#elem8").val();
			var val9 = $("#elem9").val();
			var val10 = $("#elem10").val();
			var val11 = $("#elem11").val();
			var val12 = $("#elem12").val();
			var val13 = $("#elem13").val();
			var val14 = $("#elem14").val();
			var val15 = $("#elem15").val();
			var val16 = $("#elem16").val();
			var val17 = $("#elem17").val();
			var val18 = $("#elem18").val();
			var val19 = $("#elem19").val();
			var val20 = $("#elem20").val();
			var val21 = $("#elem21").val();
			var val22 = $("#elem22").val();
			var val23 = $("#elem23").val();
			var val24 = $("#elem24").val();
			var val25 = $("#elem25").val();
			var val26 = $("#elem26").val();
			var val27 = $("#elem27").val();
			var val28 = $("#elem28").val();
			var val29 = $("#elem29").val();
			var val30 = $("#elem30").val();
			var val31 = $("#elem31").val();
			var val32 = $("#elem32").val();
			var val33 = $("#elem33").val();
			var val34 = $("#elem34").val();
			var val35 = $("#elem35").val();
			var val36 = $("#elem36").val();
			var val37 = $("#elem37").val();
			var val38 = $("#elem38").val();
			var val39 = $("#elem39").val();
			var val40 = $("#elem40").val();
			var val41 = $("#elem41").val();
			var val42 = $("#elem42").val();
			var val43 = $("#elem43").val();
			var val44 = $("#elem44").val();
		 	if(val1 > 10 || val1 < -10 || val2 > 10 || val2 < -10 ||
					val3 > 10 || val3 < -10 || val4 > 10 || val4 < -10 ||
					val5 > 10 || val5 < -10 || val6 > 10 || val6 < -10 ||
					val7 > 10 || val8 < -10 || val9 > 10 || val10 < -10 ||
					val11 > 10 || val1 < -10 || val12 > 10 || val12 < -10 ||
					val13 > 10 || val13 < -10 || val14 > 10 || val14 < -10 ||
					val15 > 10 || val15 < -10 || val16 > 10 || val16 < -10 ||
					val17 > 10 || val17 < -10 || val18 > 10 || val18 < -10 ||
					val19 > 10 || val19 < -10 || val20 > 10 || val20 < -10 ||
					val21 > 10 || val21 < -10 || val22 > 10 || val22 < -10 ||
					val23 > 10 || val23 < -10 || val24 > 10 || val24 < -10 ||
					val25 > 10 || val25 < -10 || val26 > 10 || val26 < -10 ||
					val27 > 10 || val27 < -10 || val28 > 10 || val28 < -10 ||
					val29 > 10 || val29 < -10 || val30 > 10 || val30 < -10 ||
					val31 > 10 || val31 < -10 || val32 > 10 || val32 < -10 ||
					val33 > 10 || val33 < -10 || val34 > 10 || val34 < -10 ||
					val35 > 10 || val35 < -10 || val36 > 10 || val36 < -10 ||
					val37 > 10 || val37 < -10 || val38 > 10 || val38 < -10 ||
					val39 > 10 || val39 < -10 || val40 > 10 || val40 < -10 ||
					val41 > 10 || val41 < -10 || val42 > 10 || val42 < -10 ||
					val43 > 10 || val43 < -10 || val44 > 10 || val44 < -10 ) {
				return false;
			} 
		} catch(err) {
			return false;
		}
		
		return true;
	}

	function recalculateScore() {
		var score = 0;
		if(validate()) {
			score += ($("#elem1").val() * 3);
			score += ($("#elem2").val() * 3);
			score += ($("#elem3").val() * 1);
			score += ($("#elem4").val() * 1);
			score += ($("#elem5").val() * 2);
			score += ($("#elem6").val() * 3);
			score += ($("#elem7").val() * 1);
			score += ($("#elem8").val() * 2);
			score += ($("#elem9").val() * 2);
			score += ($("#elem10").val() * 2);
			score += ($("#elem11").val() * 3);
			score += ($("#elem12").val() * 1);
			score += ($("#elem13").val() * 2);
			score += ($("#elem14").val() * 3);
			score += ($("#elem15").val() * 2);
			score += ($("#elem16").val() * 1);
			score += ($("#elem17").val() * 3);
			score += ($("#elem18").val() * 3);
			score += ($("#elem19").val() * 2);
			score += ($("#elem20").val() * 1);
			score += ($("#elem21").val() * 2);
			score += ($("#elem22").val() * 1);
			score += ($("#elem23").val() * 1);
			score += ($("#elem24").val() * 3);
			score += ($("#elem25").val() * 1);
			score += ($("#elem26").val() * 2);
			score += ($("#elem27").val() * 1);
			score += ($("#elem28").val() * 3);
			score += ($("#elem29").val() * 1);
			score += ($("#elem30").val() * 2);
			score += ($("#elem31").val() * 1);
			score += ($("#elem32").val() * 3);
			score += ($("#elem33").val() * 3);
			score += ($("#elem34").val() * 2);
			score += ($("#elem35").val() * 1);
			score += ($("#elem36").val() * 3);
			score += ($("#elem37").val() * 1);
			score += ($("#elem38").val() * 2);
			score += ($("#elem39").val() * 3);
			score += ($("#elem40").val() * 1);
			score += ($("#elem41").val() * 2);
			score += ($("#elem42").val() * 3);
			score += ($("#elem43").val() * 2);
			score += ($("#elem44").val() * 1);	
			
			document.getElementById("score").innerHTML = "Score: "  + score;
			document.getElementById("scoreval").setAttribute("value", score);
		}
		
	}

	$(document).ready(onLoad);
	</script>
</body>
</html>