<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax js</title>
</head>
<body>
<h1>Ajax Javascript</h1>
<form action="${pageContext.request.contextPath}/join" method="post">

<div>id : <input type="text" name="id" ></div><button type="button" class="btn checkid">중복확인</button>
<div>password : <input type="password" name="pwd" ></div>
<div>email : <input type="text" name="email" ></div>
<div><button type ="submit" >회원가입 </button></div>
 </form>
 
 
 <div class="member-list">
 	
 </div>
 
 <script >
 /*
 1. 객체생성: script문에요청을위한XMLHttpRequest객체생성
 2. 서버응답처리함수생성및지정(onreadystatechange에함수지정)
 지정되는함수에포함될내용
 1) 응답상태확인
 readyState(서버응답상태확인)
  status(Http응답상태코드확인)
  2) 응답완료(서버응답데이터접근) 
 responseText/ responseXML
  3. open()메소드호출하여  요청방식, 대상(서버), 동기/비동기지정
 4. send()메소드호출하여대상(서버)에전송
 */
 	//1.객체생성
 	var req = new XMLHttpRequest();
  
  	req.onreadystatechange = function(){
  		console.log("이곳은 서버에서 응답이 들어오면 호출되는 곳이구요 - 여러번 들어올 예정입니다.(readyState의 변화만큼 들어옵니다.)");
  		console.log(req.readyState); //4까지 들어와요 0,1,2,3,4
  		if(req.eadyState == 4 && req.status == 200){
  			//success
  			//req.responseText
  			console.log(req.responseText);
  		}else{
  			//error
  		}
  	};
  
  
  	//3.req객체에 전송할 준비 -요청방식, 대상(서버), 동기/비동기 총 3개의 파라미터 입력
  	req.open("post","${pageContext.request.contextPath}/ajax/test",true);
  	
  	//2.req객체에 데이터를 실어서 보냄 - 보내기전 설정이 필요함 
  	req.send();
  	
 	
 </script>
</body>
</html>