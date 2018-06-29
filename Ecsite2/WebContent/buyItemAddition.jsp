<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>追加画面</title>
</head>
<body>
<div id="header"></div>
<div id="main">
	<div id="top"><p>BuyItemAddition</p></div>
	<s:form action="BuyItemAdditionConfirmAction">
		<table>
			<tr>
				<td><span>商品名</span></td>
				<td><s:textfield name="buyItemName"/><br></td>
			</tr>
			<tr>
				<td><span>値段</span></td>
				<td><s:textfield name="buyItemPrice" placeholder="円"/></td>
			</tr>
			<tr>
				<td><span>在庫</span></td>
				<td><s:textfield name="buyItemStock" placeholder="個"/></td>
			</tr>
			<tr>
				<td><s:submit value="追加"/></td>
			</tr>
		</table>
	</s:form>
		<p>前画面に戻る場合は<a href='<s:url action="GoManagerAction"/>'>こちら</a></p>
</div>
<div id="footer"></div>
</body>
</html>