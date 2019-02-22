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
	<div class="block_parent">
	<div class="block_child">
	<div class="block_grandchild">
		<f:form name="ok"  method="post" action="calender">
			<div>
				Imformation
			</div>
			<br>
			<div>
				[スケジュール]の登録が完了しました
			</div>
			<br>
			<div>
				<input type="submit" value="OK">
			</div>
		</f:form>
	</div>
	</div>
	</div>
</body>
</html>