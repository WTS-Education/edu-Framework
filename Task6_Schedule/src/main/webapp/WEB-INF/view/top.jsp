<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta charset="utf-8">
<title>カレンダー</title>
<link href="<c:url value='/static/css/calender_style.css'/>"
	type="text/css" rel="stylesheet" />
</head>

<body>
	<f:form name="calendar" method="post" action="scheduling">
		<table border="1" >

			<colgroup span="1" class="sunday"></colgroup>
			<colgroup span="5"></colgroup>
			<colgroup span="1" class="saturday"></colgroup>

			<tr class="yearAndMonth">
				<td colspan="7" class="month">2019年02月</td>
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
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
					alt="28日スケジュール登録"  name="submit" ></span>27</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
					 alt="28日スケジュール登録"  name="submit" ></span>28</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>29</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>30</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>31</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>1</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>2</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>3</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>4</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>5</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>6</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>7</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>8</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>9</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>10</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span><div style="color:red">11</div><div style="color:red; font-size:12px;">建国記念の日</div></td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>12</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>13</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>14</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>15</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>16</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>17</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>18</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>19</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>20</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>21</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>22</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>23</td>
			</tr>

			<tr align="right" valign="top">
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>24</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>25</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>26</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>27</td>
				<td class="dayOfThisMonth1"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>28</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>1</td>
				<td class="dayOfThisMonth2"><span class="btn"><input type="image" src="<c:url value='/static/images/scadd.gif'/>"
				 alt="28日スケジュール登録"  name="submit" ></span>2</td>
			</tr>
		</table>

	</f:form>
</body>

</html>