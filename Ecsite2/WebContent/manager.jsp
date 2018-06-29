<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>管理者画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>管理者画面</p></div>
	<h3>実行したい事項を選択してください。</h3>
	<div id="managerList">
		<a href='<s:url action="BuyItemEditAction"/>'>商品編集</a>
		<a href='<s:url action="UserEditAction"/>'>ユーザー編集</a><br>
		<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
	</div>

</div>

<div id="footer"></div>
</body>
</html>