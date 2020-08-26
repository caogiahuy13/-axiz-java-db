<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
  <h3>検索結果</h3>
    <table border="1">
    	<tr>
      		<th>書籍ID</th>
      		<th>書籍名</th>
      		<th>定価</th>
    	</tr>
    	<c:forEach var="book" items="${books}">
			<tr>
			<td>${fn:escapeXml(book.bookId)}</td>
        	<td>${fn:escapeXml(book.bookName)}</td>
        	<td>${fn:escapeXml(book.price)}</td>
     	 </tr>
    	</c:forEach>
 	 </table>
	<br>
  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>