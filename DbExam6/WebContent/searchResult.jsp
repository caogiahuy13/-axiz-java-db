<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
  <h3>検索結果</h3>
  <p>データを習得しました</p>

  <p>
  	product_id:${product.productId}<br>
	product_name:${product.productName}<br>
	price:${product.price}<br>
  </p>

  <a href="top.jsp">戻る</a>
</body>
</html>