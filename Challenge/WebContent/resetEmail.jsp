<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[メールアドレス変更]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="contents"><h1>メールアドレス変更画面</h1></div>
	<s:if test="nullMessage != null">
		<h2 style="color:red;"><s:property value="nullMessage"/></h2>
	</s:if>
	<s:if test="differenceMessage != null">
		<h2 style="color:red;"><s:property value="differenceMessage"/></h2>
	</s:if>
	<h2>変更したいメールアドレスを入力して下さい。</h2>
	<s:form action="ResetEmailAction" theme="simple">
		<table style="text-align: center;">
		<tr><td>現在のメールアドレス</td></tr>
		<tr><td><s:property value="#session.Email"/></td></tr>
		<tr><td>新しいメールアドレス</td></tr>
		<tr><td><input type="text" name="newEmail"/></td></tr>
		<tr><td>確認のため、もう一度入力して下さい</td></tr>
		<tr><td><input type="text" name="checkEmail"/></td></tr>
		</table>
		<s:submit value="決定" id="reset_btn"/>
	</s:form>
	</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>