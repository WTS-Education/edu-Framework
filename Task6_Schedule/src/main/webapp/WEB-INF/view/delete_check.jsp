<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認</title>
</head>
<body>

	<f:form name="deleteOk" method="post" action="deletingIsOk">
		<div>Imformation</div>
		<br>
		<div>スケジュールを削除しますか？</div>
		<br>
		<div>
			<input type="submit" value="はい" name="yes">
		</div>
		<div>
			<input type="submit" value="いいえ" name="no">
		</div>
	</f:form>

</body>
</html>