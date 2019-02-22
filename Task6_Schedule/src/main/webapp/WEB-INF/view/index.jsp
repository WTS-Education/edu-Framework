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
<link href="<c:url value='/static/css/index_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="form_block_parent">
	<div class="form_block_child">
	<div class="form_block_grandchild">
	<f:form modelAttribute="loginForm" action="calender" method="post">
		<div class="loginId">
			Login_ID<input type="text" name="loginId">
		</div>
		<br>
		<div class="password">
			Password<input type="password" name="password">
		</div>
		<br>
		<div class="loginBtn">
			<input type="submit" value="login">
		</div>
	</f:form>
	</div>
	</div>
	</div>
</body>
</html>