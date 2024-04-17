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
<form id="frm-write" > <!-- form tag의 아이디는 유니크하게 들어간다 -->
	<div><label>제목</label><input type="text" name="subject"></div>
	<div><label>내용</label><textarea name="content">여깁니다</textarea></div>
	<div><button type="button" class="btn file">파일추가</button></div>
	<!--event click 시 동적으로 추가됨 -->
	<div><button type="button" class="btn write">글쓰기</button></div>
</form>

<script type="text/javascript">
$(loadedHandler)
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click",btnWriteClickHandler);
	$(".btn.file").on("click",btnFileClickHandler);

}
function btnFileClickHandler(){
		var htmlVal=`<div><input type="file" name="uploadfiles" required><button type="button" class="btn file-cancle">취소</button></div>`;
		$(this).parent().after(htmlVal); // 부모 중심으로 뒤에 this = <div><button type="button" class="btn file">파일추가</button></div>
//js중요!!     Event 등록 시 중복되는 것을 방지하기 위함
		$(".btn.file-cancle").off("click"); //기존에 걸려있던 click 이벤트 제거 해당 코드가 없다면 n번째 취소 버튼을 누르면 취소가 n번 실행됨
		$(".btn.file-cancle").on("click",btnFileClickHandler);
	}
function btnFileCancleClickHandler(){
		console.log("btnFileCancleClickHandler"); //확인용
//		중요!!		
		$(this).parent().remove();
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
//	중요!	
	/* form tag의 속성을 js를 통해 작성 */
	var frm =document.getElementById("frm-write");
	frm.method="post"; /* content내용은 길기 때문에 post형식으로 간다 */
	frm.action = "${pageContext.request.contextPath}/board/write";//가고싶은 위치
	//값을 전달할 땐 항상 String으로 전달 되는데 파일은 String으로 전달할 수 없으니까
	//파일형식으로 저장 전달 등등을 할 땐 이 코드가 필수입니다.
	frm.enctype="multipart/form-data"; //form tag대신 해당 위치에 넣어줘도 된다. 반드시 필요한 코드
					 				//form 태그 내부에 input type="file"이 있다면!!
	//파일은 파일 형식대로 String은 String 형식대로 짤라서 보내줘!! 이기 때문에 jar를 다운받아서 사용합니다.
	frm.submit();
}
	</script>
</body>
</html>