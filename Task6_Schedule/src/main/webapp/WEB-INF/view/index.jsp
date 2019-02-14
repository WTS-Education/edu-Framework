<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>ログイン</title>
</head>
<body>

	<f:form modelAttribute="loginForm" action="calender" method="post">
		<div>
			ログインID：<input type="text" name="loginId">
		</div>
		<br>
		<div>
			パスワード：<input type="text" name="password">
		</div>
		<br>
		<div>
			<input type="submit" value="ログイン">
		</div>
	</f:form>
</body>
</html>