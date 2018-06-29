<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>Home画面</title>
</head>
<body>
<div id="header"></div>
<div id="main">
	<div id="top"><p>Home</p></div>

	<div id="text-center">
		<s:form action="HomeAction">
			<s:submit value="商品購入"/>
		</s:form>
	<!-- ↓ログイン時のみ表示する -->
		<s:if test="#session.id != null">
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
		</s:if>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>