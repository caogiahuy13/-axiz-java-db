<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    削除するIDを入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form action="deleteConfirm" method="post">
    <fieldset>
      <div>
        <label class="required">ID</label>
        <input type="text" name="loginId" value="${fn:escapeXml(param.loginId)}">
        <c:if test="${not empty errId}">
			<span class="error">${errId}</span>
		</c:if>
      </div>
    </fieldset>
    <button type="submit">確認</button>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
