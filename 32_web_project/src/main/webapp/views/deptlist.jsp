<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
</head>
<body>
	Dept List
	<br> ${data1 }
	<br>
	<br> ${data2 }
	<br>
		<%=request.getAttribute("volist")%>
	<br>
	<%=request.getAttribute("data2")%><!-- DeptController의 data2 옆 text내용  -->
	<br> =====
	<br> ==============
	<br>
	<%
	List<Dept> volist = (List<Dept>) request.getAttribute("volist");
	String data2 = (String) request.getAttribute("data2");
	Integer data3 = (Integer) request.getAttribute("data3");

	for (Dept vo : volist) {
	%>
	<%=vo.getDeptno()%>
	|
	<%=vo.getDname()%>
	|
	<%=vo.getLoc()%>
	<br>
	<%
	}
	%>
	<br>
</body>
</html>