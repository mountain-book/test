<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/styleLogin.css">
<title>Login画面</title>
</head>
<body>
	<div id="header"></div>

	<div id="main">
		<div id="top"> <p>Login</p> </div>
		<h3>商品を購入する際にはログインをお願いします。</h3>
		<s:form action="LoginAction">
			<s:textfield name="userId"/>
			<s:password name="password"/>
			<s:submit value="ログイン"/>
		</s:form>
			<br>
		<span>新規ユーザー登録は
			<a href='<s:url action="UserCreateAction"/>'>こちら</a>
		</span>
	</div>

	<div id="footer"></div>

</body>
</html>