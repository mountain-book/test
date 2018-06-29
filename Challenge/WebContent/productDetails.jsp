<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[商品詳細]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="contents"><h1>商品詳細画面</h1></div>
	<s:form action="AddCartAction">
	<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>'/><br>
	<table>
		<tr>
			<th>商品名</th>
			<td><s:property value="%{#session.productName}"/></td>
		</tr>
		<tr>
			<th>商品名かな</th>
			<td><s:property value="%{#session.productNameKana}"/></td>
		</tr>
		<tr>
			<th>値段</th>
			<td><s:property value="%{#session.price}"/></td>
		</tr>
		<tr>
			<th>購入個数</th>
			<td><s:select name="productCount" list="%{#session.productCountList}"/>個</td>
		</tr>
		<tr>
			<th>発売会社名</th>
			<td><s:property value="%{#session.releaseCompany}"/></td>
		</tr>
		<tr>
			<th>発売年月日</th>
			<td><s:property value="%{#session.releaseDate}"/></td>
		</tr>
		<tr>
			<th>商品詳細情報</th>
			<td><s:property value="%{#session.productDescription}"/></td>
		</tr>
	</table>
	<s:hidden name="productId" value="%{#session.productId}"/>
	<s:hidden name="productName" value="%{#session.productName}"/>
	<s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
	<s:hidden name="imageFilePath" value="%{#session.imageFilePath}"/>
	<s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
	<s:hidden name="price" value="%{#session.price}"/>
	<s:hidden name="releaseCompany" value="%{#session.releaseCompany}"/>
	<s:hidden name="releaseDate" value="%{#session.releaseDate}"/>
	<s:hidden name="productDescription" value="%{#session.productDescription}"/>

	<s:submit value="カートに追加"/>
	</s:form>

	<s:iterator value="#session.productInfoDTOList">
		<a href=
			'<s:url action="ProductDetailsAction">
				<s:param name="productId" value="%{productId}"/>
			</s:url>'>
		<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'/>
		</a>
		<s:property value="productName"/><br>
	</s:iterator>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>