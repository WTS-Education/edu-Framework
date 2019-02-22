<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="utf-8">
<title>カレンダー</title>
<link href="<c:url value='/static/css/calendar_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>

<body>

	<%
	ArrayList<ArrayList<Integer>> calendarDayDividedBy5or6weeks = new ArrayList<ArrayList<Integer>>();
	calendarDayDividedBy5or6weeks = (ArrayList<ArrayList<Integer>>) session.getAttribute("calendarDayDividedBy5or6");
	%>

	<f:form name="calender" method="post" action="calendar">
		<table border="1" class="calendar_titleAndBtn">
			<tr>
				<td><img alt="カレンダーアイコン"
					src="<c:url value='/static/images/header_schedule_01.gif'/>"><span
					class="title_string">スケジュール[月間]</span> <br></td>
			</tr>

			<tr>
				<td>
					<div class="btn">
						<input type="submit" value="&nbsp;" class="previous_btn" name="previous">
						<input type="submit" value="今月" class="thisMonth_btn" name ="thisMonth">
						<input type="submit" value="&nbsp;" class="next_btn" name="next">
					</div>
				</td>
			</tr>
		</table>
		<br>
	</f:form>

	<f:form name="calendar" method="post" action="scheduling">
		<table border="1">

			<colgroup span="1" class="sunday"></colgroup>
			<colgroup span="5"></colgroup>
			<colgroup span="1" class="saturday"></colgroup>

			<tr class="yearAndMonth">
				<td colspan="7" class="month"><c:out value="${yearAndMonth[0]}"></c:out>年<c:out
						value="${yearAndMonth[1] + 1}"></c:out>月</td>
			</tr>

			<tr class="dayOfTheWeek">
				<th style="color: red">日</th>
				<th>月</th>
				<th>火</th>
				<th>水</th>
				<th>木</th>
				<th>金</th>
				<th style="color: blue">土</th>
			</tr>

			<c:forEach var="week" items="${calendarDayDividedBy5or6weeks}">
				<tr align="right" valign="top">
					<c:forEach var="day" items="${week}">
						<td class="dayOfOtherMonth">
						<span class="btn">
						<input type="image" src="<c:url value='/static/images/scadd.gif'/>" alt="スケジュール登録" name="submit">
						</span>
						<c:out value="${day}" />
						</td>
					</c:forEach>
				</tr>
			</c:forEach>

		</table>
	</f:form>
</body>
</html>