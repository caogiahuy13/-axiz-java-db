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
  <h3>更新する情報を入力してください</h3>

  <c:if test="${not empty msg}"><p>${msg}</p></c:if>

  <form action="update" method="post">
 	product_id: <input type="text" name="id" >
    <c:if test="${not empty idErr}">${idErr}</c:if><br>

    product_name: <input type="text" name="name" >
    <c:if test="${not empty nameErr}">${nameErr}</c:if><br>

    price: <input type="text" name="price" >
    <c:if test="${not empty priceErr}">${priceErr}</c:if><br>

	<button type="submit">更新</button>
  </form>
</body>
</html>