<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>下記のデータを削除します。</p>
  <p>よろしいですか？</p>

  <table>
    <caption>削除対象</caption>
    <thead>
      <tr>
        <th>ID</th>
        <th>名前</th>
        <th>TEL</th>
        <th>権限</th>
        <th>登録日</th>
        <th>更新日</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${sessionScope.usersToDelete}">
			<tr>
				<td>${fn:escapeXml(user.loginId)}</td>
	        	<td>${fn:escapeXml(user.userName)}</td>
	        	<td>${fn:escapeXml(user.tel)}</td>
	        	<td>${fn:escapeXml(user.roleName)}</td>
				<td><fmt:formatDate value="${user.createDateTime}" pattern="yyyy/MM/dd"/></td>
	        	<td><fmt:formatDate value="${user.updateDateTime}" pattern="yyyy/MM/dd"/></td>
     	 	</tr>
    	</c:forEach>
    </tbody>
  </table><br>

  <form action="selectResultDelete" method="post">
    <button type="submit" name="btn" value="delete">削除</button>
    <button type="submit" name="btn" value="return">戻る</button>
  </form>

  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
