<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{width: 600px; margin: auto;}
	table, th, td {
		border: 1px solid darkgray;
		text-align: center;
		border-collapse: collapse;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   $(function() {
	 	
	 	
	 	$("#btn2").click(function() {
			$("#table").empty();
			$.ajax({
				url : "/MyController02",
				methode : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<thead>";
					table += "<tr><th>stn_id</th><th>icon</th><th>desc</th><th>ta</th><th>지역</th><tr>";
					table += "</thead><tbody>";
					$(data).find("local").each(function(){
						table +="<tr>";
						table +="<td>" + $(this).attr("stn_id")+"</td>";
						table +="<td>" + $(this).attr("icon")+"</td>";
						table +="<td>" + $(this).attr("desc")+"</td>";
						table +="<td>" + $(this).attr("ta")+"</td>";
						table +="<td>" + $(this).text()+"</td>";
						table +="</tr>";
					});
					
					table +="</tbody>";
					$("#table").append(table);
					
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
	 	$("#btn3").click(function() {
			$("#table").empty();
			$.ajax({
				url : "/MyController03",
				methode : "post",
				dataType : "json",
				success : function(data) {
					var table = "<thead>";
					table += "<tr><th>LBRRY_NAME</th><th>CODE_VALUE</th><th>ADRES</th><th>FDRM_CLOSE_DATE</th><th>TEL_NO</th><th>XCNTS</th><th>YDNTS</th><tr>";
					table += "</thead><tbody>";
					$.each(data, function(k,v) {
						table += "<tr><td>"+ v["LBRRY_NAME"]+"</td><td>"+v["CODE_VALUE"]+"</td><td>"+ v["ADRES"]+"</td><td>"+ v["FDRM_CLOSE_DATE"]+"</td><td>"+ v["TEL_NO"]+"</td><td>"+ v["XCNTS"]+"</td><td>"+ v["YDNTS"]+"</td></tr>";
					});
					
					table +="</tbody>";
					$("#table").append(table);
					
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
   });
</script>
<script type="text/javascript"></script>
</head>
<body>
	<div>
		<button id="btn2">XML 태그/속성 정보가져오기</button>
		<button id="btn3">JSON 정보가져오기</button>
	</div>
	<hr>
	<div>
		<table id="table"></table>
	</div>
</body>
</html>