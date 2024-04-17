<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semim/common_function.jsp"/>
<title>List page</title>
<style>
.board.grid {
	display: grid;
	grid-template-columns: 1fr 5fr 3fr 2fr 1fr;
}

.board.grid>div {
	display: flex;
	border: 1px solid black;
	text-align: center;
}

ul {
	list-style-type: none;
}

ul>li {
	display: inline-block;
	padding: 0 10px;
}
</style>
</head>
<body>
	<h1>Semim board list</h1>
	<!--아무것도 안 뜸  -->
	<!--디버깅  -->
	${dtolist}
	<br> [[ 로그인 정보 : ${sssLogin} ]]
	<br> [[ map : ${map.dtolist }]]
	<br> [[ totalPageCount : ${map.totalPageCount }]]
	<br> [[ startPageNum : ${map.startPageNum }]]
	<br> [[ endPageNum : ${map.endPageNum }]]
	<br>

	<div>체크용</div>


	<!-- 	private Integer boardId;
	private String subject;
	private String writeTime;  // TIMESTAMP
	private String boardWriter;
	private Integer readCount; -->

	<!--함수를 안 쓰고 속성에 onclick=""에 location@@을 넣어도 된다  -->
	<div>
		<button type="button" class="btn write">글쓰기</button>
	</div>
	<div class="board grid">
		<c:choose>
			<c:when test="${empty map.dtolist }">
	글 없어요.
	</c:when>
			<c:otherwise>
				<c:forEach items="${map.dtolist }" var="vo" varStatus="vs">
					<div>${vo.boardId }</div>
					<div>
						<a
							href="${pageContext.request.contextPath }/board/read?id=${vo.boardId }">${vo.subject }</a>
					</div>
					<div>${vo.writeTime }</div>
					<div>${vo.boardWriter }</div>
					<div>${vo.readCount }</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<div>
		<ul>
			<c:if test="${map.startPageNum > 1}">
				<li><a
					href="${pageContext.request.contextPath }/board/list?page=${map.startPageNum-1 }">
						&lt;&lt; </a></li>
			</c:if>
			<c:forEach begin="${map.startPageNum }" end="${map.endPageNum }"
				var="page">
				<c:if test="${map.currentPageNum == page }">
					<li><strong>${page }</strong></li>
				</c:if>
				<c:if test="${map.currentPageNum != page }">
					<li><a
						href="${pageContext.request.contextPath }/board/list?page=${page }">${page }</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${map.endPageNum < map.totalPageCount }">
				<li><a
					href="${pageContext.request.contextPath }/board/list?page=${map.endPageNum+1 }">
						&gt;&gt; </a></li>
			</c:if>
		</ul>
	</div>

	<script type="text/javascript">
		$(loadedHandler)
		function loadedHandler() {
			//event 등록
			$(".btn.write").on("click", btnWriteClickHandler);

		}
		function btnWriteClickHandler() {
			// error var sslogin = ${ssslogin}; 컴퓨터는  ssslogin이 값이 없을 경우 var sslogin = ;로 인식함 
			//var sslogin = "${ssslogin}";// ssslogin이 값이 없을 경우 var sslogin = "";로 인식함 Eㅣtag 같은 걸 자바에서 쓸 땐 반드시 따옴표 안에 적어준다 
			if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
				return;
			}
			
			location.href="${pageContext.request.contextPath }/board/write";
			console.log("지나갑니다~~~~~~");
			//	else{
			//		location.href="${pageContext.request.contextPath}/board/write"; //location 이동하고 싶은 위치
			//	}

		}
	</script>
</body>
</html>