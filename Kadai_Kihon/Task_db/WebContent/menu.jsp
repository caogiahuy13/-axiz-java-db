<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.user}">
　  	<c:redirect url="index.jsp" />
    </c:if>

  <p>${sessionScope.user.userName}さん、こんにちは</p>

  <p>
    <a href="select.jsp">検索</a>
  </p>
  <c:if test="${sessionScope.user.roleId == 1}">
	<p>
    	<a href="insert.jsp">登録</a>
  	</p>
  </c:if>
  <!-- 発展課題
    <p>
      <a href="update.html">更新</a>
    </p>
    <p>
      <a href="delete.html">削除</a>
    </p>
-->
  <form action="logout" method="post">
    <button type="submit">ログアウト</button>
  </form>
</body>
</html>
