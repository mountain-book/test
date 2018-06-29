<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Vidaloka" >
<title>ヘッダー</title>
</head>
<body>
<div id="header">
	<h1>
		<a href='<s:url action="HomeAction"/>'>
			<span id="mainLogo">上の段</span>
			<span id="descriptionLogo">下の段</span>
		</a>
	</h1>
	<div id="header-menu">
		<ul>
			<li><a href='<s:url action="GoCartAction"/>'>カート</a></li>
			<li><a href='<s:url action="GoProductListAction"/>'>商品一覧</a></li>
		<s:if test="#session.userId != null">
			<li><a href='<s:url action="GoMyPageAction"/>'>マイページ</a></li>
		</s:if>
		<s:if test="#session.userId != null">
			<li><a href='<s:url action="GoLogoutAction"/>'>ログアウト</a></li>
		</s:if>
		<s:else>
			<li><a href='<s:url action="GoLoginAction"/>'>ログイン</a></li>
		</s:else>
		</ul>
	</div>
	<s:if test='#session.containsKey("mCategoryDTOList")'>
	<li><s:select name="categoryId" list="#session.mCategoryDTOList" listValue="categoryName" listKey="categoryId"/></li>
	</s:if>
	<s:form action="SearchItemAction">
		<s:textfield name="keywords" placeholder="検索ワード"/>
		<s:submit value="商品検索"/>
	</s:form>
</div>
</body>
</html>