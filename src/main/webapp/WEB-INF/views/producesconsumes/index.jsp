<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ProducesConsumes Index</title>
</head>
<body>
ProducesConsumes Index<br>
<br>
<a class="" href="<c:url value="/producesconsumesControl" />">home</a><br>
<a class="textLink1" href="<c:url value="/producesconsumesControl" />">application/json</a><br>
<a class="textLink2" href="<c:url value="/producesconsumesControl" />">text/plain</a><br>

<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("a.textLink1").click(function(){
		var link = $(this);
		$.ajax(
			{ 
				url: link.attr("href"), 
				dataType: "text", 
				beforeSend: function(req) { 
					req.setRequestHeader("Accept", "application/json");
				},
				success: function(text) { console.log(text) }, 
				error: function(xhr) { console.log(xhr.responseText); }
			});
		return false;
	});
	
	$("a.textLink2").click(function(){
		var link = $(this);
		$.ajax(
			{ 
				url: link.attr("href"), 
				dataType: "text", 
				beforeSend: function(req) { 
					req.setRequestHeader("Accept", "text/plain");
				},
				success: function(text) { console.log(text) }, 
				error: function(xhr) { console.log(xhr.responseText); }
			});
		return false;
	});
	
});
</script>
</body>
</html>