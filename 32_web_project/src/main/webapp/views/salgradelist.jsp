<%@page import="kh.mclass.jdbc.model.vo.Dept"%>
<%@page import="kh.mclass.jdbc.model.vo.Salgrade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salgrade List</title>
</head>
<body>
	Salgrade SelectList

	<br>${volist}
	<br> ********************
	<br>
<% 	
	List<Salgrade> volist = (List<Salgrade>)request.getAttribute("volist");
	if(volist!=null){
		if(volist.size() == 0){
%>
DEPT 데이터가 없습니다. 추가해주세요.
<% 
		}else {
			for(Salgrade vo : volist){
%>
<%=vo.getGrade() %> | <%=vo.getLosal() %>  | <%=vo.getHisal() %> <br>
<%
			}
		}
	} else {
	 %>
잠시 시스템이 불안정하여 잠시후 다시 확인해 주세요.
<%

	}
 %>
	
</body>
</html>