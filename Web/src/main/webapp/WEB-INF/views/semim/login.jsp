<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Semim Login </title>
</head>
<body>
<h1>로그인 창에 오신 것을 환영합니다</h1>
<form action ="${pageContaxt.request.contextPath}/login " method="post">
	<div>id : <input type="text" name="id"></div>
	<div>pwd : <input type="password" name="pwd"></div>
	<div><button type="submit">로그인</button></div>
</form>

<script >
//존 래식이 형님과 함께하는 코딩생활




</script>
</body>
</html>