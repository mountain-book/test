<!-- すべてのページにsmoothscrollを導入するために、フッターにスクリプトを記載 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<title>フッター</title>
<script>
$(function() {
	//頭文字#のアンカーをクリックしたとき発動
	$('a[href^="#"]').click(function() {
		//スクロール速度(ミリ秒)
		var speed = 500;
		//アンカーの値を取得
		var href = $(this).attr("href");
		//移動先を取得
		var target = $(href == "#" || href == "" ? 'html' : href);
		//移動先の数値を取得
		var position = target.offset().top;
		//スムーススクロール
		$("html, body").animate({scrollTop : position}, speed, "swing");
		return false;
	});
});
</script>
</head>
<body>
<div id="footer">
頑張ってjavaを覚える
</div>
</body>
</html>