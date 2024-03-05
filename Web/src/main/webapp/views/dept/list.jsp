<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept List</title>
</head>
<body>
<h1>Dept List</h1>
<c:choose>
	<c:when test="${empty volist} ">
	dept cannot read
	</c:when>
	<c:when test="${volist.size()==0} ">
	not dept
	</c:when>
	<c:otherwise>
		<c:forEach items="${volist }" var="vo" varStatus="vs">
			${vs.count}||${vo.deptno}|${vo.dname}|${vo.loc}<br>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>