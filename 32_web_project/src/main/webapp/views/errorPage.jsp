<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
JSP 제공 내장객체의 scope 분리하여 말하시오.  page(pageContext) - request - session - application
ex) setAttribute - getAttribute
page(pageContext)
- request(response전까지 유지) - request.getRequestDispatcher("xxx.jsp").forward(req,res); 과 함께 사용함
- session(브라우저창닫기까지, removeAttribute()) - response.sendRedirect(url..);과 함께 사용됨. 고르인정보(로그아웃)
- application


매개변수(인자)없음.
String paVlaue = (String)pageContext.getAttribute("pageScope");
//reponse.getWriter() ==> out  이름의 객체
out.write("aaa");

 
<h1>${msg}</h1>
${volist}
</body>
</html>