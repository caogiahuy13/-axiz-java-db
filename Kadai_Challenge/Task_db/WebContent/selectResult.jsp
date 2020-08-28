<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <c:if test="${sessionScope.user.roleId == 1}">
  <p>
    編集する場合は、1つのみ対象を選択してください
  </p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form action="selectResultOption" method="post">
	  <table>
	    <caption>検索結果</caption>
	    <thead>
	      <tr>
	      	<th>選択</th>
	        <th>ID</th>
	        <th>名前</th>
	        <th>TEL</th>
	        <th>権限</th>
	        <th>登録日</th>
	        <th>更新日</th>
	      </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="user" items="${sessionScope.selectResult}">
				<tr>
					<td style="text-align: center; "><input type="checkbox" name="checkboxes" value="${user.loginId}"/></td>
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

    <button type="submit" name="btn" value="update">編集</button>
    <button type="submit" name="btn" value="delete">削除</button>
  </form>
  </c:if>

  <c:if test="${sessionScope.user.roleId != 1}">
	<table>
    <caption>検索結果</caption>
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
        <c:forEach var="user" items="${sessionScope.selectResult}">
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
  </table>
  </c:if>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
