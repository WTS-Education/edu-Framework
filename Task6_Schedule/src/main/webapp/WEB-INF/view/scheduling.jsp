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
	<f:form name="scheduling" method="post" action="schedulingIsOk">
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
				<input type="submit" value="登録" class="config_btn">
				 <input type="submit" value="戻る" class="return_btn">
			</div>
		</td>
		</tr>
		</table><br>


		<table border="1">
			<colgroup span="1" class="tableHeading"></colgroup>
			<colgroup span="1" class="tableContent"></colgroup>
			<tr>
				<th class="heading">名前</th>
				<td class="content">小針隼一郎(テスト)</td>
			</tr>

			<tr>
				<th class="key">開始</th>
				<td class="value"><select name="year">
						<option value="2018">2018年</option>
						<option value="2019">2019年</option>
						<option value="2020">2020年</option>
						<option value="2021">2021年</option>
						<option value="2022">2022年</option>
				</select> <select name="month">
						<option value="jan">1月</option>
						<option value="feb">2月</option>
						<option value="mar">3月</option>
						<option value="apr">4月</option>
						<option value="may">5月</option>
						<option value="jun">6月</option>
						<option value="jul">7月</option>
						<option value="aug">8月</option>
						<option value="sep">9月</option>
						<option value="oct">10月</option>
						<option value="nov">11月</option>
						<option value="dec">12月</option>
				</select> <select name="day">
						<option value="1">1日</option>
						<option value="2">2日</option>
						<option value="3">3日</option>
						<option value="4">4日</option>
						<option value="5">5日</option>
						<option value="6">6日</option>
						<option value="7">7日</option>
						<option value="8">8日</option>
						<option value="9">9日</option>
						<option value="10">10日</option>
						<option value="11">11日</option>
						<option value="12">12日</option>
						<option value="13">13日</option>
						<option value="14">14日</option>
						<option value="15">15日</option>
						<option value="16">16日</option>
						<option value="17">17日</option>
						<option value="18">18日</option>
						<option value="19">19日</option>
						<option value="20">20日</option>
						<option value="21">21日</option>
						<option value="22">22日</option>
						<option value="23">23日</option>
						<option value="24">24日</option>
						<option value="25">25日</option>
						<option value="26">26日</option>
						<option value="27">27日</option>
						<option value="28">28日</option>
						<option value="29">29日</option>
						<option value="30">30日</option>
						<option value="31">31日</option>
				</select> <select name="oclock">
						<option value="未設定">未設定</option>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
				</select> 時 <select name="minute">
						<option value="未設定">未設定</option>
						<option value="00">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
				</select> 分 <input type="checkbox" name="assignTime">時間指定無し</td>
			</tr>

			<tr>
				<th>終了</th>
				<td><select name="year">
						<option value="2018">2018年</option>
						<option value="2019">2019年</option>
						<option value="2020">2020年</option>
						<option value="2021">2021年</option>
						<option value="2022">2022年</option>
				</select> <select name="month">
						<option value="jan">1月</option>
						<option value="feb">2月</option>
						<option value="mar">3月</option>
						<option value="apr">4月</option>
						<option value="may">5月</option>
						<option value="jun">6月</option>
						<option value="jul">7月</option>
						<option value="aug">8月</option>
						<option value="sep">9月</option>
						<option value="oct">10月</option>
						<option value="nov">11月</option>
						<option value="dec">12月</option>
				</select> <select name="day">
						<option value="1">1日</option>
						<option value="2">2日</option>
						<option value="3">3日</option>
						<option value="4">4日</option>
						<option value="5">5日</option>
						<option value="6">6日</option>
						<option value="7">7日</option>
						<option value="8">8日</option>
						<option value="9">9日</option>
						<option value="10">10日</option>
						<option value="11">11日</option>
						<option value="12">12日</option>
						<option value="13">13日</option>
						<option value="14">14日</option>
						<option value="15">15日</option>
						<option value="16">16日</option>
						<option value="17">17日</option>
						<option value="18">18日</option>
						<option value="19">19日</option>
						<option value="20">20日</option>
						<option value="21">21日</option>
						<option value="22">22日</option>
						<option value="23">23日</option>
						<option value="24">24日</option>
						<option value="25">25日</option>
						<option value="26">26日</option>
						<option value="27">27日</option>
						<option value="28">28日</option>
						<option value="29">29日</option>
						<option value="30">30日</option>
						<option value="31">31日</option>
				</select> <select name="oclock">
						<option value="未設定">未設定</option>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
				</select> 時 <select name="minute">
						<option value="未設定">未設定</option>
						<option value="00">00</option>
						<option value="15">15</option>
						<option value="30">30</option>
						<option value="45">45</option>
				</select> 分 期間:一日間</td>
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
					MAX1000文字(テスト)</td>
			</tr>

			<tr>
				<th>登録者</th>
				<td>小針隼一郎(テスト)</td>
			</tr>

		</table>
	</div>
	</f:form>

</body>
</html>
