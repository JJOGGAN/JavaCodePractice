<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 선택</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
/* 방법1*/
.checkboxs {
	overflow: hidden;
}

.checkedItems {
	clear: both;
}

.checkboxs {
	display: flex;
	gap: 10px
}

/* 방법2 */
/* 
.checkboxs>div {
	float: lefr;
	margin-right: 20px;
}
 */
</style>
<script>
	//const : 상수
	const itemCount = 10;
	$(loadedHandler);
	function loadedHandler() {
		/* 1.화면구성 */
		var htmlValue = "";

		for (var i = 1; i <= itemCount; i++) {
			//베이직 코드
			/*
			htmlValue += '<div>';
			htmlValue += '<label for="menu-'+i+'">menu-'
					+ i
					+ '</label> <input type="checkbox" data-itemcode='+i+' id="menu-'+i+'"class="item">';
			htmlValue += '</div>';
			*/
			htmlValue+=
				`
				<div>
					<label for="menu-\${i}">menu-\${i}</label>
					<input type="checkbox"  id="menu-\${i}" data-itemcode="\${i}" class="item">
				</div>
				`;
		}
		/* 안의 내용 지우고 넣어줘 : html에 htmlValue를 넣어줘  */
		$(".checkboxs").html(htmlValue);

		/* 2. 전체선택 이벤트 등록 */
		/* $("#allcheck").on("click",function(){}); */
		$("#allCheck").on("click", allCheckHandler);

		/* 4. items(menu)를 이벤트 등록  */
		$(".item").on("click", itemCheckHandler);

		/* 6. 반대선택 이벤트 등록 */
		$("#revCheck").on("click", revCheckHandler);

	}
	/* 7.반대선택 이벤트 처리 CB Handler */
	function revCheckHandler() {
		console.log($(this));
		//$(".item").prop("checked");
		//elemen와 this와 동일
		$(".item").each(function(index, element) {
			console.log("*************************")
			console.log(this); // xxx(each) 메소드 앞 객체 - 하나씩
			//this :반복되는 .item의 객체(그 .item가 걸린 그것을 )가져온다 , 얘 자체임
			console.log(element); //xxx(each) 메소드 앞 객체 - 하나씩
			//element : .item의 checked 상태를 get해서 그 값을 가져옴
			console.log($(element).prop("checked"));

			$(element).prop("checked", !$(element).prop("checked"));
		});

		$(".item").prop("checked", function(index, chechkedValue) {
			//2번째 매개인자는 each는 element 하나, 그 외 메소드들은 checked 된 값이 전달됨

			//each 외 xxx(prop)메소드의 cb function들은 each 기능이 내포되어 있다
			console.log(this); // 하나씩
			console.log(chechkedValue); //  객체의 checked의 getter 값
			$(this).prop("checked", chechkedValue);
		});
		updateCheckAllByCountCheckedItem();
	}

	/* 5. item이벤트 처리 CB  Heandler */
	function itemCheckHandler() {
		//console.log(this);
		//console.log($(this));

		/* 100. item 이벤트, 반대선택 이벤트 처리시 공통 부분 함수 호출 - 전체선택 check */
		updateCheckAllByCountCheckedItem();
		//console.log("this에서 itemcode 가져욤");
		//console.log($(this).data("itemcode"));
		
		var label =$(this).parent().children("label").html();
		/* 8. checkedItems 에 이벤트 발생 -> 바로그 item의 div로 생성 */
		if ($(this).prop("checked") == true) {
			var htmlValue='';
			htmlValue+= '<div data-itemcode="'+$(this).data("itemcode")+'">';
			htmlValue+= '<span>'+label+'</span>';
			htmlValue+= '</div>';
			$(".checkedItems").append(htmlValue); //기존 내용을 유지하면서 내용을 밀어넣음
		}

		/* 9. checkedItems 에 이벤트 발생 -> 바로그 item의 div를 제거 */
		else {

		}
	}
	/* 100. item 이벤트, 반대선택 이벤트 처리시 공통 부분을 함수도 만들기 */
	function updateCheckAllByCountCheckedItem() {
		//확인용 출력
		console.log($(".item"));
		console.log($(".item:checked"));
		console.log($(".item:checked").length); //jquery에서 필스임
		// 체크된 item가 max가 되면 전체선택 박스가 체크됨
		if ((".item:checked").length == itemCount) {
			$("#allCheck").prop("checked", true);
		} else {
			$("#allCheck").prop("checked", false);
		}
	}

	/* 3. 전체선택 이벤트 러치 CB Heandler */
	function allCheckHandler() {
		//console.log(this);
		/* jquery의 object모양 */
		console.log($(this));

		//attr()메소드는 동적페이지 변화를 인지하지 않는다.
		//console.log($(this).attr("checked")); //attr : undefined

		//prop()메소드는 동적페이지 변화를 인지하고 그 결과값을 true/false/로 준다.
		console.log($(this).prop("checked")); //prop : true  

		console.log($(".item")); //10개의 elements

		//property
		$(".item").prop("checked", $(this).prop("checked"));

		/* 		//원시적인 방법
		if ($(this).prop("checked")) {
			$(".item").prop("checked", true);
		} else {
			$(".item").prop("checked", false);
		}
		 */

	}
</script>
</head>
<body>
	<h1>전체선택/해제</h1>
	<div class="wrap-check">
		<label for="allCheck">전체선택</label> <input type="checkbox"
			id="allCheck"> <label for="revCheck">반대선택</label> <input
			type="checkbox" id="revCheck">
	</div>
	<div class="checkboxs">
		<!-- 
		<div>
			<label for="menu-x">menu-x</label> <input type="checkbox"  id="menu-x" data-itemcode="n"
				class="menu">
		</div>
		 -->
	</div>
	<div class="checkedItems">
		<!-- 
		<div data-itemcode="n">
			<span>메뉴 item-x</span>
		</div>
		<div data-itemcode="n">
			<span>메뉴 item-x</span>
		</div>
		 -->
	</div>
</body>
</html>