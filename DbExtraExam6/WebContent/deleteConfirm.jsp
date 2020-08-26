<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
</head>
<body>
  <h3>これでよろしいですか？ </h3>

	<table border="1">
		<tr>
      		<th>書籍ID</th>
      		<th>書籍名</th>
      		<th>定価</th>
    	</tr>
		<tr>
			<td>${fn:escapeXml(book.bookId)}</td>
        	<td>${fn:escapeXml(book.bookName)}</td>
        	<td>${fn:escapeXml(book.price)}</td>
     	 </tr>
 	 </table>
 	 <br>

  <form action="deleteConfirm" method="post">
	<input type=hidden name="id" value="${book.bookId}" >

	<button type="submit" name="btn" value="delete">削除</button>
	<button type="submit" name="btn" value="return">戻る</button>

  </form>
  <br>

  <a href="menu.jsp">メニューに戻る</a>
</body>
</html>