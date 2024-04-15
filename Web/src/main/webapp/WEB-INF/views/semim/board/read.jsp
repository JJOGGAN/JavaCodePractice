<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semim/common_function.jsp"/>
<title>Semim Board Write</title>
</head>
<body>
<h1>Semim Board Write</h1>
<div>
	<div>${dto.subject }</div>
	<div>${dto.content }</div>
	<div>${dto.readCount }</div>
</div>
<form id="frm-reply">
	<div><label>댓글</label><input type="text" name="content" required><button type="button" class="btn replay" >댓글달기</button></div>
</form>
[[<div>${dto.replydtolist}</div>]]
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.replay").on("click", btnReplyClickHandler);
}
function btnReplyClickHandler(){
	//Login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		return;
	}
}
</script>
</body>
</html>