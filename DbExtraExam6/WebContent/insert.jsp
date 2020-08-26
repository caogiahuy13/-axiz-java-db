<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
  <h3>登録情報を入力してください </h3>

  <form action="insert" method="post">
    書籍名： <input type="text" name="name" >
    <c:if test="${not empty errName}">${errName}</c:if><br><br>

	出版社ID： <input type="number" name="publisher" >
    <c:if test="${not empty errPublisher}">${errPublisher}</c:if><br><br>

	定価： <input type="number" name="price" >
	<c:if test="${not empty errPrice}">${errPrice}</c:if><br><br>

    <button type="submit">確認</button>
  </form>
  <br>

  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>