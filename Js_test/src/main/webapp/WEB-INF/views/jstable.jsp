<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/resource/reset.css"
	rel="stylesheet">
<!-- jquery 연습용 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<h1>JS Table</h1>
	<table>
		<thead>
			<tr>
				<th>menu</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아메리카노</td>
				<td>2500</td>
			</tr>
			<tr>
				<td>아메리카노</td>
				<td>아메리카노</td>
			</tr>
			<tr>
				<td>아메리카노</td>
				<td>아메리카노</td>
			</tr>
			<tr>
				<td>아메리카노</td>
				<td>아메리카노</td>
			</tr>
			<tr></tr>
			<tr></tr>
		</tbody>

	</table>
</body>
</html>