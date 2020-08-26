<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除</title>
</head>
<body>
  <h3>削除する書籍IDを入力してください </h3>

  <c:if test="${not empty msg}"><p>${msg}</p></c:if>

  <form action="delete" method="post">
    書籍ID： <input type="text" name="id" >
    <c:if test="${not empty errId}">${errId}</c:if><br><br>

    <button type="submit">確認</button>
  </form>
  <br>

  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>