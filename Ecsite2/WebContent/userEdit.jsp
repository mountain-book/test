<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>ユーザー編集画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>ユーザー編集</p></div>
	<s:if test="userList == null">
		<h3>ご登録情報はありません。</h3>
	</s:if>
	<s:elseif test="message == null">
		<h3>ご登録情報は以下になります。</h3>
		<table border="1">
		<tr>
			<th>ID</th>
			<th>ログインID</th>
			<th>ログインPASS</th>
			<th>ユーザー名</th>
			<th>登録日</th>
			<th>更新日</th>
		</tr>
		<s:iterator value="userList">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="loginId"/></td>
				<td><s:property value="loginPass"/></td>
				<td><s:property value="userName"/></td>
				<td><s:property value="insert_date"/></td>
				<td><s:property value="updated_date"/></td>
			</tr>
	</s:iterator>
	</table>
	<s:form action="UserEditAction">
		<input type="hidden" name="deleteFlg" value="1">
		<s:submit value="削除" method="delete"/>
	</s:form>
	</s:elseif>
	<s:if test="message != null">
		<h3><s:property value="message"/></h3>
	</s:if>
	<div id="text-right">
		<p>前画面に戻る場合は<a href='<s:url action="GoManagerAction"/>'>こちら</a></p>
		<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
	</div>
</div>

<div id="footer"></div>
</body>
</html>