<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[新規ユーザー登録]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>

<div id="main">
	<div id="contents"><h1>新規ユーザー登録</h1></div>
	<h2>ご登録内容は以下でよろしいですか？</h2>
	<div id="LoginForm">
	<s:form action="UserCreateConfirmAction">
		<table>
			<tr>
				<td>お名前</td>
				<td>
					<s:property value="familyName" escape="false"/>
					<s:property value="firstName" escape="false"/>
				</td>
			</tr>
			<tr>
				<td>ふりがな</td>
				<td>
					<s:property value="familyName_kana" escape="false"/>
					<s:property value="firstName_kana" escape="false"/>
				</td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<s:property value="sex" escape="false"/>
				</td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><s:property value="Email" escape="false"/></td>
			</tr>
			<tr>
				<td>ユーザーID</td>
				<td><s:property value="userId" escape="false"/></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><s:property value="password" escape="false"/></td>
			</tr>
			<tr>
				<td><s:submit value="決定" id="confirm_btn"/></td>
			</tr>
		</table>
	</s:form>
</div>
</div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>