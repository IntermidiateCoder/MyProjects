function onLoad() {
	document.getElementById("score").innerHTML = "Score: " + 0;
	$("#elem1").keyup(recalculteScore);
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
	$("#elem44").keyup(alert("I am an alert box!"));
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
	}
	
	document.getElementById("score").innerHTML = "Score: " + 0;
}

$(document).ready(onLoad);