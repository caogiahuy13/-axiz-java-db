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
  <h3>検索要件を入力してください。</h3>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="search" method="post">
    product_name
    <input type="text" name="name" >
    <c:if test="${not empty nameErr}">
    	${nameErr}
  	</c:if>
    <br>
    price
    <input type="text" name="price" >
    <c:if test="${not empty priceErr}">
    	${priceErr}
  	</c:if>
    <br>
    <button type="submit" name="btn" value="search">検索</button>
    <button type="submit" name="btn" value="register">登録</button>

  </form>
</body>
</html>