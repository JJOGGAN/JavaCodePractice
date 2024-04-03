<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/resources/css/notice.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/signup.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

	<div class="content-wrap">
		<section>
			<form action="insert.no" method="post">
				<fieldset>
					<legend>공지사항 작성하기</legend>

					<table class="write-table">
						<tbody>
							<tr>
								<td class="title"><label for="title">제목</label></td>
								<td><input type="text" id="title" name="title"
									placeholder="제목을 입력하세요" required></td>
							</tr>
							<tr>
								<td><label for="content">내용</label></td>
								<td><textarea type="text" id="content" name="content"
										placeholder="내용을 입력하세요" cols="40" rows="4" required></textarea></td>
							</tr>
							<tr>
								<td><label for="input-file">첨부파일</label></td>
								<td><input type="file" name="uploadFile" id="input-file"></td>
							</tr>

						</tbody>
					</table>
					<input class="position" type="submit" value="작성하기" onclick="">
				</fieldset>

			</form>
		</section>
		<section class="notice-section">
			<table border="1" class="notice">
				<!-- 타이틀 부분 -->
				<thead>
					<tr>
						<td class="num">번호</td>
						<td colspan="2">제목</td>
						<td class="writer">작성자</td>
						<td class="date">작성일</td>
						<td class="count">조회수</td>
					</tr>
				</thead>
				<!-- 첫번째 -->
				<tbody>
					<tr>
						<td>9</td>
						<td>공지사항 제목9</td>
						<td class="button-size"><button type="button"
								onclick="location.href='http://www.google.com' ">바로가기</button></td>
						<td>user01</td>
						<td>2021-03-29</td>
						<td>34</td>
					</tr>
					<tr>
						<td>6</td>
						<td>공지사항 제목6</td>
						<td><button type="button"
								onclick="location.href='http://www.google.com' ">바로가기</button></td>
						<td>answ445</td>
						<td>2021-03-12</td>
						<td>67</td>
					</tr>
					<tr>
						<td>3</td>
						<td>공지사항 제목3</td>
						<td><button type="button"
								onclick="location.href='http://www.google.com' ">바로가기</button></td>
						<td>testg12</td>
						<td>2021-03-01</td>
						<td>98</td>
					</tr>
					<tr>
						<td>2</td>
						<td>공지사항 제목2</td>
						<td><button type="button"
								onclick="location.href='http://www.google.com' ">바로가기</button></td>
						<td>palwe3</td>
						<td>2021-01-02</td>
						<td>85</td>
					</tr>
					<tr>
						<td>1</td>
						<td>공지사항 제목1</td>
						<td><button type="button"
								onclick="location.href='http://www.google.com' ">바로가기</button></td>
						<td>xml23</td>
						<td>2020-12-24</td>
						<td>124</td>
					</tr>
				</tbody>
				<tfoot>
					<td colspan="4">전체공지사항 갯수</td>
					<td colspan="2">5개</td>
				</tfoot>

			</table>
		</section>

		<!-- 2번 문항 -->
		<section class="wrap">
			<form action="#" method="get" class="location">
				<div>
					<div class="signup">
						<div class="label">
							<label for="userId">아이디</label>
						</div>
						<div class="info">
							<input type="text" id="userId" name="userId">
							<div class="idmsg"></div>
						</div>

					</div>
					<!-- 아이디 필수 항목 체크 -->
					<script>
						$("#userId").on("blur", function() {
							var idLength = $(this).val().trim().length;
							var msg = "";
							if (idLength < 1) {
								mag = "필수 입력 항목입니다";
								$(".idmsg").html(mag);
							}
						});
					</script>
					<div class="signup">
						<div class="label">
							<label for="userpw" type="password">패스워드</label>
						</div>
						<div class="info">
							<input type="password" id="userpw" name="userpw">

							<div class="caution"></div>
							<div class="pwmsg"></div>
						</div>
					</div>
					<!-- 비밀번호  -->
					<script>
						$("#userpw").on("blur",function() {
											var pwLength = $(this).val().trim().length;
											var pw = $(this).val().trim();
											var msg = "";
											if (pwLength < 1) {
												msg = "필수 입력 항목입니다";
												$(".pwmsg").html(msg);
											} else {
												const regex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,32}$/;
												if (!regex.test(pw))
													msg = "다시 확인해주세요";
												$(".pwmsg").html(msg).css(
														'color', 'red');
											}
										});

						$("#userpw").on("click", function() {
							var msg = "영문자 대/소문자 특수문자 숫자 포함 8~32자";

							$(".caution").html(msg);
							$(".caution").css('font-size', '8px');
						});
					</script>
					<div class="signup">
						<div class="label">
							<label for="userpwCheck">패스워드확인</label>
						</div>
						<div class="info">
							<input type="password" id="userpwCheck" name="userpwCheck">
							<div class="pwcheck"></div>
						</div>
					</div>
					<!-- 비밀번호확인 -->
					<script>
						$("#userpwCheck").on("blur", function() {
							var idLength = $(this).val().trim().length;
							var msg = "";
							if (idLength < 1) {
								mag = "필수 입력 항목입니다";
								$(".pwcheck").html(mag);
							}
						});
					</script>

					<div class="signup">
						<div class="label">
							<label for="email">이메일</label>
						</div>
						<div>
							<input type="text" id="email" name="email">
						</div>
					</div>
					<script>
						const regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
					</script>

					<div class="signup">
						<div class="label">
							<label for="adress">주소</label>
						</div>
						<div>
							<textarea name="adress" id="adress" cols="22" rows="2"></textarea>
						</div>
					</div>
					<div class="btn">
						<button class="btn_sulbmit" type="submit">가입</button>
					</div>

				</div>
			</form>

		</section>
	</div>



</body>
</html>