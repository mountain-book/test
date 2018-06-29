<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>追加確認画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>BuyItemAdditionConfirm</p></div>
		<s:form>
			<tr>
				<td>商品名</td>
				<td><s:property value="#session.buyItemName"/></td>
			</tr>
			<tr>
				<td>値段</td>
				<td><s:property value="#session.buyItemPrice"/><span>円</span></td>
			</tr>
			<tr>
				<td>在庫</td>
				<td><s:property value="#session.buyItemStock"/><span>個</span></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><input type="button" value="戻る"
					onclick="submitAction('BuyItemAdditionAction')"/></td>
				<td><input type="button" value="完了"
					onclick="submitAction('BuyItemAdditionCompleteAction')"/></td>
			</tr>
		</s:form>
	</div>

<div id="footer"></div>
<script type="text/javascript" src="./script/script.js"></script>
</body>
</html>