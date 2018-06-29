<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<title>Error画面</title>
</head>
<body>
<div id="header"></div>

<div id="main">
	<div id="top"><p>Error</p></div>
	<h3>エラーが発生しました。</h3>
	<a href='<s:url action="GoHomeAction"/>'>ホームへ</a>
</div>

<div id="footer"></div>
</body>
</html>