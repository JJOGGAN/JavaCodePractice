<%@page import="kh.mclass.jdbc.model.vo.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP LIST</title>
</head>
<body>
Emp List
<br>
${volist }
<br>
<%=request.getAttribute("volist")%>
	<%
	List<Emp> volist = (List<Emp>) request.getAttribute("volist"); 
	String data2 = (String) request.getAttribute("data2");
	Integer data3 = (Integer) request.getAttribute("data3");

	for (Emp vo : volist) {
	%>
	<%=vo.getDeptno()%>
	|
	<%=vo.getEname()%>
	|
	<%=vo.getJob()%>
	<br>
	<%
	}
	%>
</body>
</html>