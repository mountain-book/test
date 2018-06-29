<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[マイページ]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="contents"><h1>マイページ画面</h1></div>
	<h2>お客様情報</h2>
	<table class="mypageList">
		<tr>
			<th>お名前</th>
			<td>
			<div>
				<s:property value="#session.familyName"/>
				<s:property value="#session.firstName"/>
			</div>
			</td>
		</tr>
		<tr>
			<th>性別</th>
			<td><s:property value="#session.sex"/></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td><s:property value="#session.Email"/></td>
		</tr>
	</table>
	<s:form action="PurchaseHistoryAction">
		<p><s:submit value="購入履歴" /></p>
	</s:form>
	<s:form action="GoResetPasswordAction">
		<p><s:submit value="パスワード変更"/></p>
	</s:form>
	<s:form action="GoResetEmailAction">
		<p><s:submit value="メールアドレス変更"/></p>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>