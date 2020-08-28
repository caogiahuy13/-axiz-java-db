<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    １箇所以上の項目を変更してください
  </p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form action="updateConfirm" method="post">
    <fieldset>
      <div>
        <input type="hidden" name="userId" value="${sessionScope.curUpdateUser.userId}" >
      </div>
      <div>
        <label>ID</label>
        <input type="text" name="loginId" value="${sessionScope.curUpdateUser.loginId}" >
         <c:if test="${not empty errId}">
			<span class="error">${errID}</span>
		</c:if>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName" value="${sessionScope.curUpdateUser.userName}">
         <c:if test="${not empty errUserName}">
			<span class="error">${errUserName}</span>
		</c:if>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel" value="${sessionScope.curUpdateUser.tel}">
         <c:if test="${not empty errTel}">
			<span class="error">${errTel}</span>
		</c:if>
      </div>
      <div>
        <label>権限</label> <select name="roleId">
          <c:forEach var="role" items="${sessionScope.roles}">
			<option value="${role.roleId}"  <c:if test="${role.roleId == sessionScope.curUpdateUser.roleId}">selected</c:if>>
				${role.roleName}
			</option>
    	  </c:forEach>
        </select>
      </div>
      <div>
        <label>PASS</label>
        <input type="password" name="pass" value="${sessionScope.curUpdateUser.password}">
         <c:if test="${not empty errPass}">
			<span class="error">${errPass}</span>
		</c:if>
      </div>
    </fieldset>
    <div>
      <button type="submit" name="btn" value="update">確認</button>
      <button type="submit" name="btn" value="return">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
