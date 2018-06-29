<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[パスワード変更]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="contents"><h1>パスワード変更画面</h1></div>
	<s:if test="nullMessage != null">
		<h2 style="color:red;"><s:property value="nullMessage"/></h2>
	</s:if>
	<s:if test="missMessage != null">
		<h2 style="color:red;"><s:property value="missMessage"/></h2>
	</s:if>
	<s:if test="differenceMessage != null">
		<h2 style="color:red;"><s:property value="differenceMessage"/></h2>
	</s:if>
	<h2>ご希望のパスワードを入力して下さい。</h2>
	<s:form action="ResetPasswordAction" theme="simple">
		<table>
		<tr><td>現在のパスワード</td></tr>
		<tr><td><input type="password" name="oldPassword"/></td></tr>
		<tr><td>新しいパスワード</td></tr>
		<tr><td><input type="password" name="newPassword"/></td></tr>
		<tr><td>確認のため、もう一度入力して下さい</td></tr>
		<tr><td><input type="password" name="checkPassword"/></td></tr>
		</table>
		<p><s:submit value="決定" id="reset_btn"/></p>
	</s:form>
	</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>