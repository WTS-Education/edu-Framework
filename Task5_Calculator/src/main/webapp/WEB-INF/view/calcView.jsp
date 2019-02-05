<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WTS電卓課題</title>
</head>
<body>
    <%= new java.util.Date() %>


<fieldset style="width:450px"><br>
	<form:form modelAttribute="Calculator"  method="POST">

	<table>
	<tr style="background:#CEE3F6">
		<td colspan="4" style="width:400px; height:50px; font-size:20px;" align="right">式${calcBean.expression}</td>
		<td colspan="4" style="width:400px; height:50px; font-size:20px;" align="right">input${calcBean.input}</td>
		<td colspan="4" style="width:400px; height:50px; font-size:20px;" align="right">演${calcBean.operator}</td>
		<td colspan="4" style="width:400px; height:50px; font-size:20px;" align="right">x${calcBean.x}</td>


	</tr>

	<tr style="background:#A9F5D0">
		<td colspan="4" style="width:400px; height:50px; font-size:50px;" align="right">${calcBean.output}</td>
	</tr>

	<tr>
		<td><input type=submit name="plusAlpha" value="%" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="plusAlpha" value="√" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="plusAlpha" value="x²" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="plusAlpha" value="1/x" style="width:100px; height:100px; font-size:50px"></td>
	</tr>
	<tr>
		<td><input type=submit name="del" value="CE" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="del" value="C" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="del" value="◀" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="operator" value="÷" style="width:100px; height:100px; font-size:50px"></td>
	</tr>

	<tr>
		<td><input type=submit name="num" value="7" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="8" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="9" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="operator" value="×" style="width:100px; height:100px; font-size:50px"></td>
	</tr>

	<tr>
		<td><input type=submit name="num" value="4" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="5" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="6" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="operator" value="-" style="width:100px; height:100px; font-size:50px"></td>
	</tr>

	<tr>
		<td><input type=submit name="num" value="1" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="2" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="3" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="operator" value="+" style="width:100px; height:100px; font-size:50px"></td>
	</tr>

	<tr>
		<td><input type=submit name="plusAlpha" value="±" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="0" style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="num" value="." style="width:100px; height:100px; font-size:50px"></td>
		<td><input type=submit name="operator" value="=" style="width:100px; height:100px; font-size:50px"></td>
	</tr>
	</table>
	</form:form>
</fieldset>
</body>
</html>