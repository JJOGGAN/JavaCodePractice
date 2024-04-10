<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>List page</title>
</head>
<body>
<h1>Semim board list</h1>
<!--아무것도 안 뜸  -->
[[$(dtolist)]]
[[<%=request.getAttribute("dtolist") %>]]

<!--함수를 안 쓰고 속성에 onclick=""에 location@@을 넣어도 된다  -->
<div><button type="button" class="btn write">글쓰기</button></div>
<script type="text/javascript">
$(loadedHandler)
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click",btnWriteClickHandler);

}
	function btnWriteClickHandler(){
		// error var sslogin = ${ssslogin}; 컴퓨터는  ssslogin이 값이 없을 경우 var sslogin = ;로 인식함 
		var sslogin = "${ssslogin}";// ssslogin이 값이 없을 경우 var sslogin = "";로 인식함 Eㅣtag 같은 걸 자바에서 쓸 땐 반드시 따옴표 안에 적어준다 
		if(!sslogin){
			var result = confirm("로그인되어야 글쓰기가 가능합니다. 로그인페이지로 이동하시겠습니까?");
			if (result) {
				location.href="${pageContext.request.contextPath}/login?prePage=write";
			}else{
				/* --- */
			}
			return;
		}
		
	//	else{
	//		location.href="${pageContext.request.contextPath}/board/write"; //location 이동하고 싶은 위치
	//	}
	
}
	</script>
</body>
</html>