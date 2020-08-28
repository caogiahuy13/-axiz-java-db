<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <form action="delete" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginId" value="${user.loginId}" readonly>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName" value="${user.userName}" readonly>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel" value="${user.tel}" readonly>
      </div>
      <div>
        <label>権限</label>
        <input type="text" name="roleName" value="${user.roleName}" readonly>
      </div>
      <input type="hidden" name="userId" value="${user.userId}" />
    </fieldset>
    <div>
      <button type="submit" name="btn" value="delete">削除</button>
      <button type="submit" name="btn" value="return">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
