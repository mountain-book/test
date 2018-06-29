<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[ログイン]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>

<div id="main">
<div id="contents"><h1>ログイン画面</h1></div>
<s:if test="errorMessage != null">
	<h2 style="color:red;"><s:property value="errorMessage"/></h2>
</s:if>
<h2>ログイン情報を入力してください。</h2>
	<div id="LoginForm">
	<s:form action="LoginAction">
		<table>
		<tr>
			<td>ユーザーID:</td>
			<td><input type="text" name="UserId"/></td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td><input type="password" name="Password"/></td>
		</tr>
		<tr>
			<td><s:submit value="決定" id="login_btn"/></td>
		</tr>
		</table>
	</s:form>
	</div>
	<script type="text/javascript">
		document.LoginAction.UserId.focus();
	</script>
	<p>新規ユーザー登録は<a href='<s:url action="GoUserCreateAction"/>'>こちら</a></p>
</div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>