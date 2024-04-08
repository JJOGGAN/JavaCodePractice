package kh.mclass.semim.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.member.model.dto.MemberLoginDto;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet은 마지막 문장이 이 문장입니다 대부분
		request.getRequestDispatcher("/WEB-INF/views/semim/login.jsp").forward(request, response); //login.jsp로 보냄
		// 페이지를 여는 것 자체는 get에서 이루어진다
		System.out.println("login doGet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println("/login doPost dto : "+dto);
		//TODO login - 실습 때 구현 - classdiagram참고
		//성공 : 1
		//실패 : 0
		int result = 1;
		response.getWriter().append(String.valueOf(result));
	}

}
