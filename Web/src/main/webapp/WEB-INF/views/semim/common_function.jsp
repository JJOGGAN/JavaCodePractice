<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
function checkLogin(msg,prePage){
	var sslogin = "${ssslogin}";  // EL 은 ""안에 작성되어 blank 상황에 문법적 오류 발생을 방지함.

	if(!sslogin){
		var result = confirm(msg);
		if (result) {
			location.href="${pageContext.request.contextPath}/login?prePage=write";
		}else{
			
		}
		//TODO return true;
		return true; //파일을 수정할 때마다 계속 session이 풀리기 때문에 false로 넣어두고 계속 파일 작업
			//로그인 상태를 유지해야하는 부분엔 아이디와 pwd를 하드코드로 박아두고 마지막에 수정한다
	}

	return false;
}
//ajax의 error 부분은 공통적이기 때문에 공통 함수로 만들어 사용한다
function ajaxErrorHandler (request, status, error){
	alert("code: "+request.status + "\n" + "message: " 
			+ request.responseText + "\n"
			+ "error: "+error);

}



</script>