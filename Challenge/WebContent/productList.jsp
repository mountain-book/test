<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>チャレンジ[商品一覧]</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp"/>
<div id="main">
	<div id="contents"><h1>商品一覧画面</h1></div>
	<s:if test="productInfoDTOList == null">
		<h2>検索結果がありません。</h2>
	</s:if>
	<s:else>
		<s:iterator value="#session.productInfoDTOList">
		<ul>
			<li>
				<a href=
					'<s:url action="ProductDetailsAction">
						<s:param name="productId" value="%{productId}"/>
					</s:url>'>
					<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'/>
				</a><br>
				<s:property value="productName"/><br>
				<s:property value="productNameKana"/><br>
				<s:property value="price"/>円<br>
			</li>
		</ul>
		</s:iterator>
		<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
			<s:if test="#session.currentPageNo == #pageNo.count">
				<s:property value="%{#pageNo.count}"/>
			</s:if>
			<s:else>
				<a href=
					"<s:url action='SearchItemAction'>
						<s:param name='pageNo' value='%{#pageNo.count}'/>
						<s:param name='categoryId' value='%{categoryId}'/>
					</s:url>">
					<s:property value="%{#pageNo.count}"/>
				</a>
			</s:else>
		</s:iterator>
	</s:else>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>