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
	<s:if test="errorMessage != null">
	<h2 style="color:red;"><s:property value="errorMessage"/></h2>
	</s:if>
	<h2>ご登録内容を入力して下さい。</h2>
	<div id="LoginForm">
	<s:form action="UserCreateAction">
		<table>
			<tr>
				<td>お名前</td>
				<td>
					<input type="text" name="familyName" placeholder="姓"/>
					<input type="text" name="firstName" placeholder="名"/>
				</td>
			</tr>
			<tr>
				<td>ふりがな</td>
				<td>
					<input type="text" name="familyName_kana" placeholder="せい"/>
					<input type="text" name="firstName_kana" placeholder="めい"/>
				</td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<input type="radio" name="sex" value="男" checked="checked" id="man"><label for="man">男</label>
					<input type="radio" name="sex" value="女" id="woman"><label for="woman">女</label>
				</td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="Email" size="48"/></td>
			</tr>
			<tr>
				<td>ユーザーID</td>
				<td><input type="text" name="userId" size="48"/></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password" size="49"/></td>
			</tr>
			<tr>
				<td><s:submit value="決定" id="submit_btn"/></td>
			</tr>
		</table>
	</s:form>
</div>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>