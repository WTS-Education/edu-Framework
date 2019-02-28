<!DOCTYPE html>

<%@page import="java.util.Calendar"%>
<%@page import="jp.co.wintechservice.webScheduler.model.TSchedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<meta charset="utf-8">
<title>スケジュール登録</title>
<link href="<c:url value='/static/css/scheduling_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<f:form name="scheduling" method="post" action="schedulingIsOk" modelAttribute="scheduleForm">
	<div align="center">
		<table border="1" class="calender_config_title">
		<tr>
		<td>
			<img alt="カレンダーアイコン"
				src="<c:url value='/static/images/header_schedule_01.gif'/>"><span class="title_string">スケジュール[スケジュール登録]</span>
			<br>
		</td>
		</tr>

		<tr>
		<td>
			<div class="btn">
			<c:choose>
				<c:when test="${updateAndDelete != null}">
					<input type="submit" value="変更" name="update" class="update_btn">
					<input type="submit" value="削除" name="delete" class="delete_btn">
				</c:when>
				<c:otherwise>
					<input type="submit" value="登録" name="plan" class="config_btn">
				</c:otherwise>
			</c:choose>
					<input type="submit" value="戻る" name="return" class="return_btn">
			</div>
		</td>
		</tr>
		</table><br>


		<table border="1">
			<colgroup span="1" class="tableHeading"></colgroup>
			<colgroup span="1" class="tableContent"></colgroup>
			<tr>
				<th class="heading">名前</th>
				<td class="content"><c:out value = "${userName}"/></td>
			</tr>

			<tr>
				<th class="key">開始</th>
				<td class="value">
				<!-- 開始年 -->
				<select name="startYear">
				<c:forEach var="year" begin="2018" end="2022">
					<c:choose>
						<c:when test="${year == yearAndMonth[0]}">
							<option value="${year}" selected><c:out value = "${year}"/>年</option>
						</c:when>
						<c:otherwise>
							<option value="${year}"><c:out value = "${year}"/>年</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 開始月 -->
				<select name="startMonth">
				<c:forEach var="month" begin="1" end="12">
					<c:choose>
						<c:when test="${month == yearAndMonth[1] + 1}">
							<option value="${month}" selected><c:out value = "${month}"/>月</option>
						</c:when>
						<c:otherwise>
							<option value="${month}"><c:out value = "${month}"/>月</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 開始日 -->
				<select name="startDay">
				<c:forEach var="day" begin="1" end="${yearAndMonth[2]}">
					<c:choose>
						<c:when test="${selectedDay != null && day == selectedDay}">
							<option value="${day}" selected><c:out value = "${day}"/>日</option>
						</c:when>
						<c:when test="${updateAndDelete != null && day == scheduleDay[0]}">
							<option value="${day}" selected><c:out value = "${day}"/>日</option>
						</c:when>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 開始時 -->
				<select name="startOclock" class="timeSelectBox">
						<option value="未設定">未設定</option>
						<c:forEach var="time" begin="0" end="23">
							<c:choose>
								<c:when test="${selectedDay != null && time == 9}">
									<option value="${time}" selected><c:out value = "${time}"/></option>
								</c:when>
								<c:when test="${updateAndDelete != null && time == scheduleDay[1]}">
									<option value="${time}" selected><c:out value = "${time}"/></option>
								</c:when>
								<c:otherwise>
										<option value="${time}"><c:out value = "${time}"/></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select> 時
				<!-- 開始分 -->
				<select name="startMinute">
						<option value="未設定">未設定</option>
					<c:forEach var="minute" begin="0" end="45" step="15">
					<c:choose>
							<c:when test="${selectedDay != null}">
								<option value="${minute}" selected>00</option>
							</c:when>
							<c:when test="${updateAndDelete != null && scheduleDay[2] == 0}">
								<option value="0">00</option>
							</c:when>
					</c:choose>
					<c:choose>
							<c:when test="${updateAndDelete != null && minute == scheduleDay[2]}">
								<c:choose>
									<c:when test="${minute == 0}">
										<option value="${minute}" selected>00</option>
									</c:when>
									<c:otherwise>
										<option value="${minute}" selected><c:out value="${minute}"/></option>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
							<c:choose>
								<c:when test="${minute == 0}">
									<option value="${minute}" selected>00</option>
								</c:when>
								<c:otherwise>
									<option value="${minute}"><c:out value="${minute}"/></option>
								</c:otherwise>
							</c:choose>
							</c:otherwise>
					</c:choose>
					</c:forEach>
				</select> 分
			</tr>

			<tr>
				<th>終了</th>
				<td>
				<!-- 終了年 -->
				<select name="endYear">
				<c:forEach var="year" begin="2018" end="2022">
					<c:choose>
						<c:when test="${year == yearAndMonth[0]}">
							<option value="${year}" selected><c:out value = "${year}"/>年</option>
						</c:when>
						<c:otherwise>
							<option value="${year}"><c:out value = "${year}"/>年</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 終了月 -->
				<select name="endMonth">
				<c:forEach var="month" begin="1" end="12">
					<c:choose>
						<c:when test="${month == yearAndMonth[1] + 1}">
							<option value="${month}" selected><c:out value = "${month}"/>月</option>
						</c:when>
						<c:otherwise>
							<option value="${month}"><c:out value = "${month}"/>月</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 終了日 -->
				<select name="endDay">
				<c:forEach var="day" begin="1" end="${yearAndMonth[2]}">
					<c:choose>
						<c:when test="${day == selectedDay}">
							<option value="${day}" selected><c:out value = "${day}"/>日</option>
						</c:when>
						<c:when test="${updateAndDelete != null && day == scheduleDay[0]}">
							<option value="${day}" selected><c:out value = "${day}"/>日</option>
						</c:when>
						<c:otherwise>
							<option value="${day}"><c:out value = "${day}"/>日</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<!-- 終了時 -->
				<select name="endOclock" class="timeSelectBox">
				<c:forEach var="time" begin="0" end="23">
					<c:choose>
						<c:when test="${time == 18}">
							<option value="${time}" selected><c:out value = "${time}"/></option>
						</c:when>
						<c:when test="${updateAndDelete != null && time == endTime[3]}">
							<option value="${time}" selected><c:out value = "${time}"/></option>
						</c:when>
						<c:otherwise>
								<option value="${time}"><c:out value = "${time}"/></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select> 時
				<!-- 終了分 -->
				<select name="endMinute">
						<option value="未設定">未設定</option>
						<option value="00" selected="selected">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
				</select> 分<span style="float: right">期間:一日間</span>
				</td>
			</tr>

			<tr>
				<th>タイトル</th>
				<td>
					<c:choose>
						<c:when test="${updateAndDelete != null}">
							<input type="text" name="title" value="${schedule.getTitle()}" maxlength="300" class="title_textbox">
						</c:when>
						<c:otherwise>
							<input type="text" name="title" maxlength="300" class="title_textbox">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>

			<tr>
				<th>タイトル色</th>
				<td>
					<c:choose>
						<c:when test="${titleColor == 0}">
							<span class="radio_01"> <input type="radio"
										name="titleColor" checked="checked" value="0">
							</span> <label for="titleColor_01" class="titleColor_text">訪問</label>
						</c:when>
						<c:otherwise>
							<span class="radio_01"> <input type="radio"
										name="titleColor"  value="0">
							</span> <label for="titleColor_01" class="titleColor_text">訪問</label>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${titleColor == 1}">
							<span class="radio_02"> <input type="radio"
										name="titleColor" checked="checked" value="1">
							</span> <label for="titleColor_02" class="titleColor_text">勤怠</label>
						</c:when>
						<c:otherwise>
							<span class="radio_02"> <input type="radio"
										name="titleColor"  value="1">
							</span> <label for="titleColor_02" class="titleColor_text">勤怠</label>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${titleColor == 2}">
							<span class="radio_03"> <input type="radio"
										name="titleColor" checked="checked" value="2">
							</span> <label for="titleColor_03" class="titleColor_text">来客</label>
						</c:when>
						<c:otherwise>
							<span class="radio_03"> <input type="radio"
										name="titleColor"  value="2">
							</span> <label for="titleColor_03" class="titleColor_text">来客</label>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${titleColor == 3}">
							<span class="radio_04"> <input type="radio"
										name="titleColor" checked="checked" value="3">
							</span> <label for="titleColor_04" class="titleColor_text">面談・面接</label>
						</c:when>
						<c:otherwise>
							<span class="radio_04"> <input type="radio"
										name="titleColor"  value="3">
							</span> <label for="titleColor_04" class="titleColor_text">面談・面接</label>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${titleColor == 4}">
							<span class="radio_05"> <input type="radio"
										name="titleColor" checked="checked" value="4">
							</span> <label for="titleColor_05" class="titleColor_text">私用</label>
						</c:when>
						<c:otherwise>
							<span class="radio_05"> <input type="radio"
										name="titleColor"  value="4">
							</span> <label for="titleColor_05" class="titleColor_text">私用</label>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>

			<tr>
				<th>内容</th>
				<td><textarea name="description" rows="10" cols="50" maxlength="1000"><c:if test="${updateAndDelete != null}"><c:out value="${schedule.getDescription()}"></c:out></c:if></textarea><br>
					MAX1000文字</td>
			</tr>

			<tr>
				<th>備考</th>
				<td><textarea name="note" rows="5" cols="50" maxlength="1000"><c:if test="${updateAndDelete != null}"><c:out value="${schedule.getNote()}"></c:out></c:if></textarea><br>
					MAX1000文字</td>
			</tr>

			<tr>
				<th>登録者</th>
				<td><c:out value = "${userName}"/></td>
			</tr>

		</table>
	</div>
	</f:form>

</body>
</html>
