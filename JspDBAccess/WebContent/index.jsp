<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>検索したいID</h3>
	<c:if test = "${not empty msg}">
		<p style="color: red">
			<c:out value = "${msg}"/>
		</p>
	</c:if>
	<form action="indexServlet">
		<input type="number" name="id" required>
		<button class="btn" type="submit">検索</button>
    </form>
</body>
</html>