<!DOCTYPE html>

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
				<input type="submit" value="登録" name="plan" class="config_btn">
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
				<select name="year">
				<c:forEach var="year" begin="2018" end="2022">
					<c:choose>
						<c:when test="${year == yearAndMonth[0]}">
							<option value="${year}年" selected><c:out value = "${year}"/>年</option>
						</c:when>
						<c:otherwise>
							<option value="${year}年"><c:out value = "${year}"/>年</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="month">
				<c:forEach var="month" begin="1" end="12">
					<c:choose>
						<c:when test="${month == yearAndMonth[1] + 1}">
							<option value="${month}月" selected><c:out value = "${month}"/>月</option>
						</c:when>
						<c:otherwise>
							<option value="${month}月"><c:out value = "${month}"/>月</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="day">
				<c:forEach var="day" begin="1" end="${yearAndMonth[2]}">
					<c:choose>
						<c:when test="${day == selectedDay}">
							<option value="${day}日" selected><c:out value = "${day}"/>日</option>
						</c:when>
						<c:otherwise>
							<option value="${day}日"><c:out value = "${day}"/>日</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="oclock">
						<option value="未設定">未設定</option>
						<c:forEach var="time" begin="0" end="23">
							<c:choose>
								<c:when test="${time == 9}">
									<option value="${time}" selected><c:out value = "${time}"/></option>
								</c:when>
								<c:otherwise>
										<option value="${time}"><c:out value = "${time}"/></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select> 時
				<select name="minute">
						<option value="未設定">未設定</option>
						<option value="00" selected="selected">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
				</select> 分
				<input type="checkbox" name="assignTime">時間指定無し</td>
			</tr>

			<tr>
				<th>終了</th>
				<td>
				<select name="year">
				<c:forEach var="year" begin="2018" end="2022">
					<c:choose>
						<c:when test="${year == yearAndMonth[0]}">
							<option value="${year}年" selected><c:out value = "${year}"/>年</option>
						</c:when>
						<c:otherwise>
							<option value="${year}年"><c:out value = "${year}"/>年</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="month">
				<c:forEach var="month" begin="1" end="12">
					<c:choose>
						<c:when test="${month == yearAndMonth[1] + 1}">
							<option value="${month}月" selected><c:out value = "${month}"/>月</option>
						</c:when>
						<c:otherwise>
							<option value="${month}月"><c:out value = "${month}"/>月</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="day">
				<c:forEach var="day" begin="1" end="${yearAndMonth[2]}">
					<c:choose>
						<c:when test="${day == selectedDay}">
							<option value="${day}日" selected><c:out value = "${day}"/>日</option>
						</c:when>
						<c:otherwise>
							<option value="${day}日"><c:out value = "${day}"/>日</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
				<select name="oclock">
				<c:forEach var="time" begin="0" end="23">
					<c:choose>
						<c:when test="${time == 18}">
							<option value="${time}" selected><c:out value = "${time}"/></option>
						</c:when>
						<c:otherwise>
								<option value="${time}"><c:out value = "${time}"/></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select> 時
				<select name="minute">
						<option value="未設定">未設定</option>
						<option value="00" selected="selected">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
				</select> 分 期間:一日間
				</td>
			</tr>

			<tr>
				<th>タイトル</th>
				<td><input type="text" name="title" maxlength="300" class="title_textbox"></td>
			</tr>

			<tr>
				<th>タイトル色</th>
				<td><span class="radio_01"> <input type="radio"
						name="title_color" checked="checked" id="title_color_01">
				</span> <label for="title_color_01" class="title_color_text">訪問</label> <span
					class="radio_02"> <input type="radio" name="title_color"
						id="title_color_02">
				</span> <label for="title_color_02" class="title_color_text">勤怠</label> <span
					class="radio_03"> <input type="radio" name="title_color"
						id="title_color_03">
				</span> <label for="title_color_03" class="title_color_text">来客</label> <span
					class="radio_04"> <input type="radio" name="title_color"
						id="title_color_04">
				</span> <label for="title_color_04" class="title_color_text">面談・面接</label>
					<span class="radio_05"> <input type="radio"
						name="title_color" id="title_color_05">
				</span> <label for="title_color_05" class="title_color_text">私用</label></td>
			</tr>

			<tr>
				<th>内容</th>
				<td><textarea name="content" rows="10" cols="50" maxlength="1000"></textarea><br>
					MAX1000文字</td>
			</tr>

			<tr>
				<th>備考</th>
				<td><textarea name="note" rows="5" cols="50" maxlength="1000"></textarea><br>
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
