<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    登録情報を入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form action="insertConfirm" method="post">
    <fieldset class="label-60">
      <div>
        <label class="required">ID</label>
        <input type="text" name="loginId" value="${fn:escapeXml(param.loginId)}" >
        <c:if test="${not empty errId}">
			<span class="error">${errId}</span>
		</c:if>
      </div>
      <div>
        <label class="required">名前</label>
        <input type="text" name="userName" value="${fn:escapeXml(param.userName)}" >
        <c:if test="${not empty errUserName}">
			<span class="error">${errUserName}</span>
		</c:if>
      </div>
      <div>
        <label class="required">TEL</label>
        <input type="text" name="tel" value="${fn:escapeXml(param.tel)}" >
        <c:if test="${not empty errTel}">
			<span class="error">${errTel}</span>
		</c:if>
      </div>
      <div>
        <label class="required">権限</label> <select name="roleId">
          <c:forEach var="role" items="${sessionScope.roles}">
			<option value="${role.roleId}" <c:if test="${param.roleId == role.roleId}">selected</c:if>>
				${role.roleName}
			</option>
    	  </c:forEach>
        </select>
      </div>
      <div>
        <label class="required">PASS</label>
        <input type="password" name="pass" value="${fn:escapeXml(param.pass)}" >
        <c:if test="${not empty errPass}">
			<span class="error">${errPass}</span>
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
