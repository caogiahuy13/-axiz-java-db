<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form action="insert" method="post">
    <fieldset class="label-130">
      <div>
        <label>ID</label>
        <input type="text" name="loginId" value="${loginId}" readonly>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName" value="${userName}" readonly>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel" value="${tel}" readonly>
      </div>
      <div>
        <label>権限</label>
        <input type="text" name="roleName" value="${roleName}" readonly>
      </div>
      <div>
        <label>PASS（再入力）</label>
        <input type="password" name="rePass">
      </div>
      <div>
        <input type="hidden" name="pass" value="${pass}">
      </div>
      <div>
        <input type="hidden" name="roleId" value="${roleId}">
      </div>
    </fieldset>
    <div>
      <button type="submit" name="btn" value="register">登録</button>
      <button type="submit" name="btn" value="return">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
