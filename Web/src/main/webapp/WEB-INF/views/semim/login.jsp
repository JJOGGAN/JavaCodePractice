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

<!--form tag를 활용한 로그인 방법 1.  -->
<fieldset>
	<legend> 로그인</legend>
	<form action ="${pageContaxt.request.contextPath}/login " method="post"> <!-- ajax를 사용하면 action,method필요없음 -->
	<div><label>id : </label><input type="text" name="id"></div>
	<div> <label>pwd : </label><input type="password" name="pwd"></div>
	<div><button type="submit">로그인</button></div> <!--input말고 버튼 쓰면 안되낭..  -->
</form>
</fieldset>

<!--ajax활용 방법  2.-->
<fieldset>
	<legend> 로그인</legend>
	<form id="frm-login"> <!-- ajax를 사용하면 action,method필요없음 -->  <!--form이 onsubmit방식을 가지고 있다  -->
	<div><label>id : </label><input type="text" name="id"></div>
	<div> <label>pwd : </label><input type="password" name="pwd"></div>
	<div><button type="button" class="btn submit">로그인</button></div>
</form>
</fieldset>

<script >
//존 래식이 형님과 함께하는 코딩생활
	$(loadedHandler)
	function loadedHandler(){
		//event 등록
		$("#frm-login .btn.submit").on("click",frmClickHandler);
		
	}
 	function frmClickHandler(){
 		 //location.href="${pageContext.request.contextPath}/login"; //location 이동하고 싶은 위치
		console.log("클릭");
		//console.log(document.getElementById("frm-login").serialize);
		console.log($("#frm-login").serialize()); //form 태그 안에 name =값 모양을 나타내는 것
		
		$.ajax({
			
			url : "${pageContext.request.contextPath}/login"
			,method: "post"
			,data : {id : $("#frm-login [name=id]").val(),pwd : $("#frm-login [name=pwd]").val()}
			//,data:$("#frm-login").serialize()
			,success : function(result){
				console.log(">>>>>>result값을 보여줘"+result);//result확인용
				if(result == 1){
					alert("반갑습니다.");
					location.href="${pageContext.request.contextPath}/main";
				}
				else {
					console.log("result값을 보여줘"+result);
					alert("아이디와 비밀번호를 확인해주세요.");
					$("[name=pwd]").val("");
					location.href = "${pageContext.request.contextPath}/login"; 
				}
			}
			,error:function(request,status,error){
				alert("code: "+request.status + "\n" + "message: " 
						+ request.responseText + "\n"
						+ "error: "+error);
			}
			
		});
	}




</script>
</body>
</html>