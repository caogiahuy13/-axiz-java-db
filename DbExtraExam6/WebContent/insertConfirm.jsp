<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
  <h3>これでよろしいですか？ </h3>

  <form action="insertConfirm" method="post">
    書籍名： <input value="${book.bookName}" disabled>
    <c:if test="${not empty errName}">${errName}</c:if><br><br>

	出版社ID： <input value="${book.publisher}" disabled>
    <c:if test="${not empty errPublisher}">${errPublisher}</c:if><br><br>

	定価： <input value="${book.price}" disabled>
	<c:if test="${not empty errPrice}">${errPrice}</c:if><br><br>

	<input type=hidden name="name" value="${book.bookName}" >
	<input type=hidden name="publisher" value="${book.publisher}">
	<input type=hidden name="price"  value="${book.price}">

	<button type="submit" name="btn" value="return">戻る</button>
    <button type="submit" name="btn" value="insert">登録</button>
  </form>
  <br>

  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>