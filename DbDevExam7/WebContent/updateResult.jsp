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
  <h3>更新完了</h3>

  <p>
  	【更新前】<br>
  	product_id: ${fn:escapeXml(oldProduct.productId)}<br>
  	product_name: ${fn:escapeXml(oldProduct.productName)}<br>
  	price: ${fn:escapeXml(oldProduct.price)}<br>
  </p>

  <p>
  	【更新後】<br>
  	product_id: ${fn:escapeXml(newProduct.productId)}<br>
  	product_name: ${fn:escapeXml(newProduct.productName)}<br>
  	price: ${fn:escapeXml(newProduct.price)}<br>
  </p>

  <a href="update.jsp">戻る</a>
</body>
</html>