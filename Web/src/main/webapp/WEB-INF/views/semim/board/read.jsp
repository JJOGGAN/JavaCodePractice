<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semim/common_function.jsp"/>
<style type="text/css">
	.boardreply.grid{

}
	.boardreply.grid .replycontent.span{
		grid-column : 1/-1; /*한 줄 전부 차지*/
}
</style>
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
<div>
	<c:forEach items="${dto.replydtolist}" var="replydto">
		<div class="boardreply grid"> <!-- 강사님 css코드 참고 -->
			<div>${replydto.boardReplyId}</div> <!--replydto는 forEach에서만 적용되는 변수명  -->
			<div>${replydto.boardReplyContent}</div>
			<div>${replydto.boardReplyWriteTime}</div>
			<div>${replydto.boardReplyWriter}</div>
			<div ><button type="button">ㄷ댓글</button></div>
			<div class="replycontent span"><input type="text" name="content" class="btn rreply"> </div><!--grid의 영향을 받지 않는 div가 생성되길 원함 ㄷ댓글버튼을 누르면 생성  -->
		</div> 
	</c:forEach>

</div>
[[<div>${dto.replydtolist}</div>]]
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.replay").on("click", btnReplyClickHandler);
	$(".btn.rreplaycontent.show").on("click", btnRReplyContentClickHandler);
}
function btnReplyClickHandler(){
	//login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		return;
	}
	if$(".replayContent").val.trim().length ==0){
		alert("입력된 글이 없습니다. ");
		return;
	}
	console.log("${replydto.boardReplyId}"");
	$.ajax({
		url : "${pageContext.request.contextPath}/board/reply/write.ajax";
		,mehtod : "post"
		,data:{replayContent : }
		
	});
	
}
function btnRReplyContentClickHandler(){
/* 	$(".btn.rreplaycontent.show").each(function(){
		if($(this).text()=="취소"){
			$(this).text("대댓글");
		}
	}); */

	if($(this).text()=="대댓글"){ //text가 대댓글이라면
		$(this).text("취소"); //버튼에 취소로 보이기
	}else {
		$(this).text("대댓글"); //아니라면 대댓글로 보이기
	}
	
	//$(".boardreply.grid .rreplycontent.span").show();
	//$(this).parent().next().show();//내 부모의 형재를 보여줘
	$(this).parent().next().toggle(); // 한 번 누르면 보이고 한 번 더 누르면 사라짐
}
</script>
</body>
</html>