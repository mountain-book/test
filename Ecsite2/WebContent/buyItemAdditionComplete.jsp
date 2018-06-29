<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>商品追加完了画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>BuyItemAdditionComplete</p></div>
	<h3>商品の登録が完了致しました。</h3>
	<p>引き続き商品を追加する場合は<a href='<s:url action="BuyItemAdditionAction"/>'>こちら</a></p>
	<p>管理者画面へ戻る場合は<a href='<s:url action="GoManagerAction"/>'>こちら</a></p>
	<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
</div>

<div id="footer"></div>
</body>
</html>