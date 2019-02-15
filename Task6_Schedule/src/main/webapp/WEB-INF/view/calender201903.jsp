<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="utf-8">
<title>カレンダー201903</title>
<link href="<c:url value='/static/css/calender_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>

<body>

	<f:form name="calendar" method="post" action="calender">
		<table border="1" class="calender_titleAndBtn">
			<tr>
			<td>
				<img alt="カレンダーアイコン"
					src="<c:url value='/static/images/header_schedule_01.gif'/>"><span class="title_string">スケジュール[月間]</span>
				<br>
			</td>
			</tr>

			<tr>
			<td>
				<div class="btn">
					<input type="submit" value="&nbsp;" class="previous_btn">
					<input type="submit" value="今月" class="thisMonth_btn">
				</div>
			</td>
			</tr>
		</table><br>
	</f:form>

	<f:form name="calendar" method="post" action="scheduling">
		<table border="1" >

			<colgroup span="1" class="sunday"></colgroup>
			<colgroup span="5"></colgroup>
			<colgroup span="1" class="saturday"></colgroup>

			<tr class="yearAndMonth">
				<td colspan="7" class="month">2019年03月</td>
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

			<tr align="right" valign="top">
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
					alt="28日スケジュール登録"  name="submit" ></span>27</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
					 alt="28日スケジュール登録"  name="submit" ></span>28</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>29</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>30</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>31</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>1</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>2</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>3</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>4</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>5</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>6</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>7</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>8</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>9</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>10</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>11</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>12</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>13</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>14</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>15</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>16</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>17</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>18</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>19</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>20</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>21</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>22</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>23</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>24</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>25</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>26</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>27</td>
				<td class="dayOfThisMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>28</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>1</td>
				<td class="dayOfOtherMonth"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>2</td>
			</tr>
		</table>

	</f:form>
</body>

</html>