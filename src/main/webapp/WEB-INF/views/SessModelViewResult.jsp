<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

		model add 정보 <br>
		ID : ${ user.id } <br>
		PW : ${ user.pw } <br>
		name : ${ user.name } <br><br>

		세션 정보 <br>
		ID : ${ sessionScope.user.id } <br>
		PW :${ sessionScope.user.pw } <br>
		name :${ sessionScope.user.name } <br><br>
		
		세션 클리어<br>
		<form action="<c:url value="/sessmodelAttr/sessClear" />">
				ID : <input type="text" name="id"> <br>
			  name : <input type="text" name="name"> <br>
			 <input type="submit" value="클리어">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

		
	</body>
</html>