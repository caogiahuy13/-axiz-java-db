<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
  <h3>削除対象のproduct_idを入力してください</h3>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="delete" method="post">
    product_id
    <input type="text" name="id" >
    <c:if test="${not empty idErr}">
    	${idErr}
  	</c:if>
    <br>
    <button type="submit">削除</button>
  </form>
</body>
</html>