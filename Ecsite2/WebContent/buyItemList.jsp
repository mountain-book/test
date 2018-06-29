<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>BuyItemList画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>BuyItemList</p></div>
	<h3>購入する商品を選択してください。</h3>
	<table border="1">
	<tr>
		<th>商品名</th>
		<th>値段</th>
		<th>在庫</th>
		<th>選択</th>
	</tr>
	<s:iterator value="buyItemList">
	<tr>
		<td><s:property value="itemName"/></td>
		<td><s:property value="itemPrice"/><span>円</span></td>
		<td><s:property value="itemStock"/><span>個</span></td>
		<td><a href='<s:url action="BuyItemChoiceAction"/>'>購入</a></td>
	</tr>
	</s:iterator>
	</table>
	<div id="text-right">
		<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
	</div>
</div>

<div id="footer"></div>
</body>
</html>