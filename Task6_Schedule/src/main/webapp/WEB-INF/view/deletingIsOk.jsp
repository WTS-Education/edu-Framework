<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除完了</title>
</head>
<body>

<div class="block_parent">
	<div class="block_child">
	<div class="block_grandchild">
		<f:form name="ok"  method="post" action="calendar">
			<div>
				Imformation
			</div>
			<br>
			<div>
				[スケジュール]の削除が完了しました
			</div>
			<br>
			<div>
				<input type="submit" value="OK" name="ok">
			</div>
		</f:form>
	</div>
	</div>
	</div>

</body>
</html>