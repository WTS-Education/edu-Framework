<!DOCTYPE html>

<%@page import="java.sql.Timestamp"%>
<%@page import="jp.co.wintechservice.webScheduler.model.TSchedule"%>
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

<!-- // 	ArrayList<ArrayList<Integer>> calendarDayDividedBy5or6weeks = new ArrayList<ArrayList<Integer>>(); -->
<!-- // 	calendarDayDividedBy5or6weeks = (ArrayList<ArrayList<Integer>>) session.getAttribute("calendarDayDividedBy5or6"); -->

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
						<td class="dayOfMonth">
							<span class="btn">
							<button type="submit" name="selectedDay" value="${day}" class="schedule_btn">
								<img alt="スケジュール登録" src="<c:url value='/static/images/scadd.gif'/>">
							</button>
							</span>
							<c:out value="${day}" /><br><br>
							<!-- 登録済みのスケジュール表示 -->
							<%
								List<TSchedule> scheduleList =(List<TSchedule>)session.getAttribute("scheduleList");
								Calendar calendar = Calendar.getInstance();
								for(TSchedule tSchedule : scheduleList){
								    String[] minute = new String[2];
								    calendar.setTimeInMillis(tSchedule.getStartTimestamp().getTime());
								    int startTime[] = {calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
								            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)};
									if(calendar.get(Calendar.MINUTE) == 0){minute[0] = "00";}else{minute[0] = String.valueOf(calendar.get(Calendar.MINUTE));};
								    session.setAttribute("startTime", startTime);
								    calendar.setTimeInMillis(tSchedule.getEndTimestamp().getTime());
								    int endTime[] = {calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
								            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)};
								    if(calendar.get(Calendar.MINUTE) == 0){minute[1] = "00";}else{minute[1] = String.valueOf(calendar.get(Calendar.MINUTE));}
								    session.setAttribute("endTime", endTime);
								    session.setAttribute("minute", minute);
								    session.setAttribute("titleColor", tSchedule.getTitleColor());
							%>
								<c:choose>
									<c:when test="${yearAndMonth[0] == startTime[0] && yearAndMonth[1] == startTime[1] && day == startTime[2]}">
									<c:choose>
										<c:when test="${titleColor == 0}">
										<div class="link">
											<a href="scheduling?id=<%= tSchedule.getScheduleId() %>" class="blueLink">
													<c:out value="${startTime[3]}:${minute[0]}-${endTime[3]}:${minute[1]}"/><br>
												<%= tSchedule.getTitle() %>
											</a>
										</div>
										</c:when>
										<c:when test="${titleColor == 1}">
										<div class="link">
											<a href="scheduling?id=<%= tSchedule.getScheduleId() %>" class="redLink">
													<c:out value="${startTime[3]}:${minute[0]}-${endTime[3]}:${minute[1]}"/><br>
												<%= tSchedule.getTitle() %>
											</a>
										</div>
										</c:when>
										<c:when test="${titleColor == 2}">
										<div class="link">
											<a href="scheduling?id=<%= tSchedule.getScheduleId() %>" class="greenLink">
													<c:out value="${startTime[3]}:${minute[0]}-${endTime[3]}:${minute[1]}"/><br>
												<%= tSchedule.getTitle() %>
											</a>
										</div>
										</c:when>
										<c:when test="${titleColor == 3}">
										<div class="link">
											<a href="scheduling?id=<%= tSchedule.getScheduleId() %>" class="orangeLink">
													<c:out value="${startTime[3]}:${minute[0]}-${endTime[3]}:${minute[1]}"/><br>
												<%= tSchedule.getTitle() %>
											</a>
										</div>
										</c:when>
										<c:when test="${titleColor == 4}">
										<div class="link">
											<a href="scheduling?id=<%= tSchedule.getScheduleId() %>">
													<c:out value="${startTime[3]}:${minute[0]}-${endTime[3]}:${minute[1]}"/><br>
												<%= tSchedule.getTitle() %>
											</a>
										</div>
										</c:when>
									</c:choose>
									</c:when>
								</c:choose>
							<% 	} %>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>

		</table>
	</f:form>
</body>
</html>