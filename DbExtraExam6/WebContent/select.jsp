<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>
<body>
  <h3>検索したいデータ情報を入力してください</h3>

  <c:if test="${not empty msg}"><p>${msg}</p></c:if>

  <form action="search" method="post">
    書籍名 <input type="text" name="name" ><br><br>
    <button type="submit">検索</button>
  </form>
  <br>

  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>