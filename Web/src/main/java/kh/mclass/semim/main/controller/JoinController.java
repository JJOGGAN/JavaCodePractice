package kh.mclass.semim.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.member.model.dto.MemberDto;
import kh.mclass.semim.member.model.service.MemberService;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semim/join.jsp").forward(request, response);//이 파일을 불러와서 화면에 띄워줘 가 request 남러ㅣ나ㅓㅣ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("성공!!!!!!!");
		String memId= request.getParameter("id");
		String memPwd = request.getParameter("pwd");
		String memEmail = request.getParameter("email");
		MemberDto dto = new MemberDto(memId, memPwd, memEmail);
		int result = new MemberService().selectCheckId(memId);
		if(result < 0 ) {
			// 회원가입실패시
			response.sendRedirect(request.getContextPath()+"/main");//getcontestpath를 우리는 몰라 그러니 그걸 요청했어 그리고 거기에 main을 붙여서 그걸 reponse온거에 같이 보내!!!! redirect해!!!!
			System.out.println("실패");
			return;
		}
		// 회원가입정상
		response.sendRedirect(request.getContextPath()+"/login");
		System.out.println("성공");
	}

}
