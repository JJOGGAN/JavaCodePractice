<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semim/common_function.jsp"/>
<style>
.boardreply.grid{
	display:grid;
	grid-template-columns: 1fr 5fr 2fr 1fr 1fr;
	max-width: 800px;
}
.boardreply.grid .rreplycontent.span{
	grid-column : 1/-1;
	display : none;
}
.board.grid{
	display:grid;
	grid-template-columns: 1fr;
	max-width: 800px;
}
.board.grid > div{
	border: 1px solid black;
	padding : 10px;
}
.flex{
	display: flex;
	justify-content: space-between;
}
.flex > div{
	border: 1px solid black;
	padding : 10px;
}
.flex > div:nth-child(1), .flex > div:nth-child(4){
	width:50px;
	flex-shrink: 0;
}
.board > .subject{
	text-align: center;
	font-weight: 800;
}
.board > .subject{
	text-align: center;
	font-weight: 800;
}
.board [name=boardReplyContent] {
	width:500px;
}
</style>
<!--게시글 읽기  -->
<title>Semim Board Read</title>
</head>
<body>
<h1>Semim Board Read</h1>

	<div>${dto.subject }</div>
<div class="board grid">
	<div class="flex">
		<div>${dto.boardId }</div>
		<div>${dto.boardWriter }</div>
		<%-- <div>${dto.writeTime }</div> --%>
		
		<div>${dto.readCount }</div>
	</div>
	<div class="subject">${dto.subject }</div>
	<div>${dto.content }</div>
	<div>
		<c:if test="${not empty dto.filedtolist}">
		<!--파일 다운로드하기  -->
			<c:forEach items="${dto.filedtolist}" var="filedto">
		<div><a href="${pageContext.request.contextPath }/files/${filedto.savedFilePathName}" download="${filedto.orginalFileName }">${filedto.orginalFileName }</a></div>
		</c:forEach>
		</c:if>
	</div>
	<div>${dto.readCount }</div>
	<div>
		<form id="frm-reply">
		<input type="hidden" name="boardId" value="${dto.boardId }">
		<div class="flex">
			<div>댓글</div>
			<div><input type="text" name="boardReplyContent" required></div>
			<div><button type="button" class="btn replay" >댓글달기</button></div>
		</div>
		</form>
	</div>
	<div class="reply-wrap">
<%-- 	
	
		<c:forEach items="${dto.replydtolist }" var="replydto">
		<!--result에 담겨온 것을 여기서 뿌려줘  -->
			<form class="frm-rreply">
			<input type="hidden" name="boardId" value="${dto.boardId }">
			<input type="hidden" name="boardReplyId" value="${replydto.boardReplyId }"> <!--replydto는 forEach에서만 적용되는 변수명  -->
			<input type="hidden" name="boardReplyLevel" value="${replydto.boardReplyLevel }">
			<input type="hidden" name="boardReplyStep" value="${replydto.boardReplyStep }">
			<input type="hidden" name="boardReplyRef" value="${replydto.boardReplyRef }">
			<div  class="boardreply grid">
				<div>${replydto.boardReplyId }</div>
				<div>${replydto.boardReplyContent }</div>
				<div>${replydto.boardReplyWriteTime }</div>
				<div>${replydto.boardReplyWriter }</div>
				<div><button type="button" class="btn show rreplycontent">ㄷㄷ글</button></div>
				<div class="rreplycontent span" ><input type="text" name="boardReplyContent" ><button type="button" class="btn rreplay" >등록</button> </div>
			</div>
			</form>
		</c:forEach>
	 --%>
	</div>
</div>
<form id="frm-reply">
	<div><label>댓글</label><input type="text" name="content" required><button type="button" class="btn replay" >댓글달기</button></div>
</form>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.replay").on("click", btnReplyClickHandler);
	$(".btn.rreplay").on("click", btnRReplyClickHandler);
	//$(".btn.rreplycontent.show").on("click", btnRReplyContentClickHandler);
	//btnRReplyContentClickHandler대신 displayReplyWrap을 수행, ajax로 한 번 갔다 와야함
	$.ajax({
		//읽으러 갈 곳
		url: "${pageContext.request.contextPath }/board/reply/read.ajax" 
			,method:"post" //get도 상관 없음
			,error : ajaxErrorHandler
			,data: {boardId : "${dto.boardId}"} //El tag 따옴표 필수
			,dataType:"json"
			,success: function(result){
				console.log(result);
				displayReplyWrap(result);
				
			}
	});
}
function btnRReplyClickHandler(){
	//Login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		return;
	}
	
	if($(this).parents(".frm-rreply").find("[name=boardReplyContent]").val().trim().length == 0){
		alert("입력된 글이 없습니다. 입력 후 글 등록해주세요.");
		return;
	}
	console.log($(this).parents(".frm-rreply").serialize());
	
	$.ajax({
		url: "${pageContext.request.contextPath }/board/reply/write.ajax"
		,method:"post"
		,error : ajaxErrorHandler
		,data: $(this).parents(".frm-rreply").serialize()
		,dataType:"json"
		,success: function(result){
			console.log(result);
			if(result == "-1"){
				alert("댓글 작성이 되지 않았습니다. 게시글 목록으로 이동 후 다시 작성해주세요.");
				location.href="${pageContext.request.contextPath }/board/list";
				return;
			}
			if(result == "0"){
				alert("댓글 등록에 실패했습니다. 다시 시도해주세요.");
				return;
			}
			//js의 obj 형태로 온다
			displayReplyWrap(result);
		}
	});
}
function btnReplyClickHandler(){
	//Login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		return;
	}
	
	if($("#frm-reply [name=boardReplyContent]").val().trim().length == 0){
		alert("입력된 글이 없습니다. 입력 후 글 등록해주세요.");
		return;
	}
	console.log($("#frm-reply").serialize());
	
	$.ajax({
		url: "${pageContext.request.contextPath }/board/reply/write.ajax"
		,method:"post"//get : url을 바로 작성하면 해당페이지로 이동 가능 post는 url 접근 불가
		,error : ajaxErrorHandler
		,data: $("#frm-reply").serialize()
		,dataType:"json"
		,success: function(result){ //result에는 list로 담겨옴 boradReplyListDto를 service랑 dao 참고해서 볼 것 (service랑 dao에서 list로 받아오잖아요)
			console.log(result);
			if(result == "-1"){
				alert("댓글 작성이 되지 않았습니다. 게시글 목록으로 이동 후 다시 작성해주세요.");
				location.href="${pageContext.request.contextPath }/board/list";
				return;
			}
			if(result == "0"){
				alert("댓글 등록에 실패했습니다. 다시 시도해주세요.");
				return;
			}
			displayReplyWrap(result);
		}
	});
}



function btnRReplyContentClickHandler(){
/*
	$(".btn.rreplycontent.show").each(function(){
		if($(this).text() == "취소"){
			$(this).text("ㄷㄷ글");
		}
	});
 */	
	if($(this).text() == "대댓글"){//text가 대댓글이라면
		$(this).text("취소");	//버튼에 취소로 보이기
	}else {
		$(this).text("대댓글");//아니라면 대댓글로 보이기
	}
	//$(".boardreply.grid .rreplycontent.span").show();
	//$(this).parent().next().show();//내 부모의 형재를 보여줘
	$(this).parent().next().toggle(); // 한 번 누르면 보이고 한 번 더 누르면 사라짐

	
}

function displayReplyWrap(datalist){ /*result를 여ㅣㄱ에 넣어줌  */
	console.log("${dto.boardId }");
	var htmlVal = '';
	for(var idx in datalist){
		var replydto = datalist[idx];
		htmlVal += `
		<form class="frm-rreply">
		<input type="hidden" name="boardId" value="${dto.boardId }"> /*EL 태그로 가져와라 controller에서 가져오는 겁니다.  */
		<input type="hidden" name="boardReplyId" value="\${replydto.boardReplyId }"> /* $를 EL로 인식하지 말고  변수에 담긴 것을 빼와달라 */
		<input type="hidden" name="boardReplyLevel" value="\${replydto.boardReplyLevel }">
		<input type="hidden" name="boardReplyStep" value="\${replydto.boardReplyStep }">
		<input type="hidden" name="boardReplyRef" value="\${replydto.boardReplyRef }">
		<div  class="boardreply grid">
			<div>\${replydto.boardReplyId }</div>
			<div>\${replydto.boardReplyContent }</div>
			<div>\${replydto.boardReplyWriteTime }</div>
			<div>\${replydto.boardReplyWriter }</div>
			<div><button type="button" class="btn rreplycontent show">ㄷㄷ글</button></div>
			<div class="rreplycontent span" ><input type="text" name="boardReplyContent" ><button type="button" class="btn rreplay" >등록</button> </div>
		</div>
		</form>
		`;
	}
	$(".reply-wrap").html(htmlVal);
	// html(새로운내용으로덮어쓰면기존event등록이사라짐)
	// event 다시 등록
	$(".btn.rreplycontent.show").on("click", btnRReplyContentClickHandler);
	$(".btn.rreplay").on("click", btnRReplyClickHandler);
}
</script>
</body>
</html>