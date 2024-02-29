<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeptList</title>
</head>
<body>
	Dept List
	<br> ${data1 }
	<br> =====
	<br> ${data2 }
	<br>
	<%=request.getAttribute("volist")%>
	<br>
	<%=request.getAttribute("data2")%>
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
<%-- 	
	<br>
	<h1>EL (Expression Language 표현언어로 표현만가능. for,if,변수선언..등제어문없음.)</h1>
	${volist.get(0).deptno } | ${volist.get(0).dname } | ${volist.get(0).loc }
	<br> ==============
	<br> 
--%>
</body>
</html>



















