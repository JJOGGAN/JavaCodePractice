<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Semim join</title>
<link rel="shortcut icon" href="#">

</head>
<body>
<h1>Semim Join</h1>
<form action="${pageContext.request.contextPath}/join" method="post">

<div>id : <input type="text" name="id" ><button type="button" class="btn checkid">중복확인</button></div>
<div>password : <input type="current-password" name="pwd"></div>
<div>email : <input type="text" name="email" ></div>
<div><input type ="submit" >회원가입 </div>
 </form>
 
 
 <div class="member-list">
 	
 </div>

<!--scaript loaction  -->
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.checkid").on("click",btnCheckidClickHandler);
	

	
}
	function btnCheckidClickHandler(){
		 //ajax는 form 태그를 대신할 아이 {}안에 저 오브젝트를 다 적어야한다 key: value 형식
		 //중복확인 화면은 유지하되 가서 정보만 확인하고 와야함
		 
		 			//이 형식 ajax의 기본형식
		 $.ajax({ //$는 글자를 의미한다 $()가 사실은 객체명이었다!!!!!!
			// var idVal = $"[name=id]".val(); 값을 바로바로 넣기 어려울 경우 변수에 담아서 ajax의 value 값에 넣어준다
				
			
			 async : true,  //true : 기본값 비동기식 false 동기식
			 				//false : 가 되면 client:checkid 가 was로 갔다가 다시 돌아오는 이 그 사이의 시간동안
			 				//화면이 띄워진 그 상태에서 화면동작은 전혀하지 않는다. 
			 url : "${pageContext.request.contextPath}/checkid" // ~로 가서 확인해줘
			 ,method : "post"
			 ,data : {cid : $("[name=id]").val()}   //id --> controller 의 request.getParameter();에 들어가는 이름과 같아야한다. 
		 	 //////////contentType은 data의 자료형
			 
			 
			 
			 /////////착각하면 안돼!!! : dataType은 success의 result의 자료형을 의미한다
			 //,dataType : "json"
			 ,success: function(result){//success는 value에 function형태를 넣는다 function 파라미터는 하나만!!!!!!!
		 		 console.log(result);	//js가 인식할 수 있는 형태의 자료형만 받을 수 있다 다른 형태를 받아오려면 브릿지역할을 해주는 JSON을 통해서 받아와야한다
		 		 						//만약 java의 map형태를 받아오고싶으면 JSON을 통해 받아와야한다
		 		 if(result > 0){
		 			 alert("다른 아이디를 쓰거라");
		 		 }else{
		 			 alert("사용을 허하노라");
		 		 }
		 		 						////확인용
		 		 						/*
		 		 console.log(typeof result); /// syntaxerror
		 		 var htmlVal = '';
		 		 $.each(result,fungtion(){
		 			 console.log(this.memEmail);
		 			htmlVal += '<div>'+this.memEmail + '</div>';
		 		 });
		 		 $(".member-list").html(htmlVal);
		 		 */
		 	 }
		 	 ,error:function(request,status,error){
					alert("code: "+request.status + "\n" + "message: " 
							+ request.responseText + "\n"
							+ "error: "+error);
				} //error도 function을 value로 넣는다
		 }); 
		 
		//ajax로 왔다면 다른 이동 루트를 작성하지 않는다!!!!!!!!!!
		//servlet의 dispacher, sendredirect 메소드(함수)를 통해 다른 페이지로 이동할 수 없다
		//왔던 곳으로 돌아와 success 아니면 error의 callback으로 돌아가야한다 --> success,error의 function을 수행해야한다
		//ajax는 갔다가 다시 완던 곳으로 돌아와서 다시 다른데로 가는건 됩니당
}

</script>
</body>
</html>