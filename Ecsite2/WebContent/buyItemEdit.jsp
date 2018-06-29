<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>商品管理</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>BuyItemEdit</p></div>
	<s:if test="buyItemList == null">
		<h3>商品情報はありません。</h3>
	</s:if>
	<s:elseif test="message == null">
		<h3>商品情報は以下になります。</h3>
		<table border="1">
		<tr>
			<th>商品名</th>
			<th>値段</th>
			<th>在庫</th>
			<th>登録日</th>
			<th>更新日</th>
		</tr>
		<s:iterator value="buyItemList">
			<tr>
				<td><s:property value="itemName"/></td>
				<td><s:property value="itemPrice"/><span>円</span></td>
				<td><s:property value="itemStock"/><span>個</span></td>
				<td><s:property value="insert_date"/></td>
				<td><s:property value="update_date"/></td>
			</tr>
		</s:iterator>
		</table>
			<s:form action="BuyItemEditAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete"/>
			</s:form>
	</s:elseif>
	<s:if test="message != null">
		<h3><s:property value="message"/></h3>
	</s:if>
		<div id="text-right">
			<h3>商品を追加する場合は<a href='<s:url action="BuyItemAdditionAction"/>'>こちら</a></h3>
			<p>前画面に戻る場合は<a href='<s:url action="GoManagerAction"/>'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
		</div>
	</div>

<div id="footer"></div>
</body>
</html>