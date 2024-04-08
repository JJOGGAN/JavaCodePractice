package kh.mclass.semim.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("/logout doPost()"); : 연결 잘 되어있음
		
		//remove로 해당 값이 사라질 때 까지 로그인이 유지된다
		request.getSession().removeAttribute("ssslogin"); //잘 사용되진 않음
		//request.getSession().invalidate();//내가 가지고 있는 세션에 있는 모든 정보를 지워줌 contextPath 내부에 걸어둔 모든 session-attribute 정보를 지워준다
		//여러지정이 됩니다. 그 여러개 전부를 지워줍니다.
		response.sendRedirect(request.getContextPath()+"/main");//main으로 이동하게 해주세요
	}

}
