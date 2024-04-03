<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/resource/reset.css"
	rel="stylesheet">
<!-- jquery 연습용 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<h1>타이틀입니다.</h1>
	<button type="button" class="btn btn-first">신메뉴 추가</button>
	<button type="button" class="btn btn-second">추가2</button>
	<button type="button" class="btn btn-add" onclick="cbf4();">추가3</button>

	<div id="content1">
		<ul class="menu">
			<li>menu 1</li>
			<li>menu 2</li>
			<li id="select">menu 3</li>
			<li class="c_select">menu 4</li>
			<li>menu 5</li>
		</ul>
	</div>
	<br>


	<table border="1">
		<thead>
			<tr id="tbl_col">
				<td style="color: red;">title1</td>
				<td>title2</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>11</td>
				<td>12</td>
			</tr>
			<tr>
				<td>21</td>
				<td>22</td>
			</tr>
			<tr>
				<td>31</td>
				<td>33</td>
			</tr>

		</tbody>
	</table>

	<script>
		var newMenu = "<li>new menu</li>";
		$(".btn.btn-first").on("click", function() {
			//1.ul에 첫번째에 신메튜'추가
			$("ul").prepend(newMenu);
			//$(newMenu).prependTo("ul");
			console.log($(newMenu));
			console.log($(newMenu).get(0));


			//console.log($(document.getElementById("select")).get(0));
			//원래의 DOM을 존 래식형태로 바꾸기 $()안에 넣어준다.
			//자동형변환을 해주기 때문에 선택자 부분에 그냥 넣어도 된다.
			$("ul").append(newMenu);
			
			//3.menu3위에 넣기
			$("#select").before(newMenu);
			
			//menu4다음 추가
			$(".c_select").after(newMenu);
			
		});
		

		let count = 1;
		var cbf4 = function() {
			console.log("정상동작하네요");
			// 방법1
			var htmlValue = '';
			htmlValue += '<tr>';
			htmlValue += '    <td>' + count + '</td>';
			htmlValue += '    <td>col name' + count + '</td>';
			htmlValue += '</tr>';
			$("tbody").append(htmlValue);

			var temp = document.getElementsByTagName("tbody")[0].innerHTML += htmlValue; //getter 개념 
			document.getElementsByTagName("tbody")[0].innerHTML = temp
					+ htmlValue; //setter개념

			count++;
		};
		$(".btn-add").click(cbf4);
		$(".btn").click(function() {
			console.log("btn요소 전부가 .. 클릭되었을 때 공통으로 하고 싶은 행동");
		});

		/*   document.getElementById("btn-add").addEventListener("click", cbf4); */
	</script>
</body>
</html>