<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録完了</title>
<link href="<c:url value='/static/css/schedulingIsOk_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>
<div class="information" align="center">
<f:form name="ok"  method="post" action="top">
インフォメーション<br>
[スケジュール]の登録が完了しました<br>
<input type="submit" value="ok">
</f:form>
</div>
</body>
</html>