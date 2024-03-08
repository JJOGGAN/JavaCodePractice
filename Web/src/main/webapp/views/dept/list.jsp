<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>부서추가</h1>
	<div>
		<form method="get" action="<%=request.getContextPath()%>/dept/insert"
			target="_self">

			<div>
				부서번호<input type="text" name="deptno">
			</div>
			<div>
				부서명 &nbsp;&nbsp;<input type="text" name="dname">
			</div>
			<div>
				지역 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="loc"
					value="seoul">
			</div>
			<input type="submit" value="get등록"> <input type="reset"
				value="취소">

		</form>
	</div>
		<div>
		<form method="post" action="<%=request.getContextPath()%>/dept/insert"
			target="_self">

			<div>
				부서번호<input type="text" name="deptno" placeholder="부서번호 2자리">
			</div>
			<div>
				부서명 &nbsp;&nbsp;<input type="text" name="dname">
			</div>
			<div>
				지역 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="loc"
					value="seoul">
			</div>
			<input type="submit" value="post등록"> <input type="reset"
				value="취소">

		</form>
	</div>
	<h1>부서삭제</h1>
	<div>
		<div>
			<form method="post"
				action="<%=request.getContextPath()%>/dept/delete" target="_self">

				<div>
					부서번호<input type="text" name="deptno" placeholder="부서번호 2자리">
					 <input type="submit"
						value="삭제">
				</div>
			</form>
		</div>
	</div>
</body>
</html>