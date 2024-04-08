<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Semim main</title>
</head>
<body>
<!--값 확인 하는 방법 두 가지  -->
[[$(ssslogin)]]
[<%=session.getAttribute("ssslogin") %>]] <!--session이 ajax에선 반응을 못해요 ajax에선 반드시 url의 변화가 있을 때만 다음 페이지를 인식하 수 있다.  -->
<h1>Semim Main</h1>
<c:choose>
	<c:when test="${empty ssslogin}">
		<div><button class="btn join">회원가입</button></div>
		<div><button class="btn login">로그인</button></div>
	</c:when>
	<c:otherwise>
		<form id="frm-logout">
			<div><button class="btn logout">로그아웃</button></div>
		</form>
		<div><button class="btn mypage">마이페이지</button></div>
	</c:otherwise>
</c:choose><!--choose else 개념  -->
<!-- 
<div><button class="btn join">회원가입</button></div>
<div><button class="btn login">로그인</button></div>
 -->
<!--단지 post로 가기 위한 방법 중 하나  -->
<!-- 
<form id="frm-logout">
<div><button class="btn logout">로그아웃</button></div>
</form>


<div><button class="btn mypage">마이페이지</button></div>
-->
<div><button class="btn board">게시판</button></div>
<script>
	$(loadedHandler)
	function loadedHandler(){
		//event 등록
		$(".btn.join").on("click",btnJoinClickHandler);
		$(".btn.login").on("click",btnLoginClickHandler);
		$(".btn.mypage").on("click",btnMypageClickHandler);
		$(".btn.board").on("click",btnBoardClickHandler);
		$(".btn.logout").on("click",btnLogoutClickHandler);
	}
 	function btnJoinClickHandler(){
 		 location.href="${pageContext.request.contextPath}/join"; //location 이동하고 싶은 위치
		
	}
	function btnLoginClickHandler(){
		location.href="${pageContext.request.contextPath}/login";
		
	}
	function btnMypageClickHandler(){
		location.href="${pageContext.request.contextPath}/mypage";
		
	}
	function btnBoardClickHandler(){
		location.href="${pageContext.request.contextPath}/board";
		
	} 
	
	function btnLogoutClickHandler(){
		//get방식으로 가는 방법이기 때문에 logout에는 활용하지 않음
		 /* form, ajax로만 doPost를 활용할 수 있다 결국 form태그로 submit으로 보내야한다.*/
		//location.href="${pageContext.request.contextPath}/logout";
		//js형식으로 가능얘가 코드가 간결하기 때문에 jquery 대신 js방식 활용
		var frmlogout=document.getElementById("frm-logout");
		frmlogout.action="${pageContext.request.contextPath}/logout";
		frmlogout.method="post";
		frmlogout.submit();
		
		alert("로그아웃되었습니다.");
		
	}
</script>
</body>
</html>