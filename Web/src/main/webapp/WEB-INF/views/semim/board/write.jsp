<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semim/common_function.jsp"/>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Board Write</title>
</head>
<body>
<h1>Semim Board Write 게시판!!!!! 글쓰기!!! </h1>
<form id="frm-write"> <!-- form tag의 아이디는 유니크하게 들어간다 -->
	<div><label>제목</label><input type="text" name="subject"></div>
	<div><label>내용</label><textarea name="content">여깁니다</textarea></div>
	<div><button type="button" class="btn write">글쓰기</button></div>
</form>

<script type="text/javascript">
$(loadedHandler)
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click",btnWriteClickHandler);

}
	function btnWriteClickHandler(){
/* 	console.log($("[name=subject]").val());
	console.log($("[name=content]").val().trim());
	console.log($("[name=content]").val().trim().length); 확인용 */
	
	var sslogin = "${ssslogin}";// ssslogin이 값이 없을 경우 var sslogin = "";로 인식함 Eㅣtag 같은 걸 자바에서 쓸 땐 반드시 따옴표 안에 적어준다 
	if(!sslogin){
		var result = confirm("로그인되어야 글쓰기가 가능합니다. 로그인페이지로 이동하시겠습니까?");
		if (result) {
			location.href="${pageContext.request.contextPath}/login?prePage=write";
		}else{
			/* --- */
		}
	}else{
		location.href="${pageContext.request.contextPath}/board/write"; //location 이동하고 싶은 위치
	}
	
	if($("[name=subject]").val().trim().length==0){
		alert("제목을 입력하시지요");
		return;
	}
	if($("[name=content]").val().trim().length==0){
		alert("빈 문자열은 입력할 수 없습니다. 내용을 입력하시지요");
		return; //각각을 if로 묶어줌으로써 elseif 보다 안정적이다
	}
	/* form tag의 속성을 js를 통해 작성 */
	var frm =document.getElementById("frm-write");
	frm.method="post"; /* content내용은 길기 때문에 post형식으로 간다 */
	frm.action = "${pageContext.request.contextPath}/board/write";//가고싶은 위치
	frm.submit();
}
	</script>
</body>
</html>