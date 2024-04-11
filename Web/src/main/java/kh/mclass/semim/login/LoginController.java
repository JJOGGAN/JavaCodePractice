package kh.mclass.semim.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.member.model.dto.MemberInfoDto;
import kh.mclass.semim.member.model.dto.MemberLoginDto;
import kh.mclass.semim.member.model.service.MemberService;

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
		String prePage = request.getParameter("prePage");
		request.getSession().setAttribute("prePage", prePage);
		//doGet은 마지막 문장이 이 문장입니다 대부분
		request.getRequestDispatcher("/WEB-INF/views/semim/login.jsp").forward(request, response); //login.jsp로 보냄
		// 페이지를 여는 것 자체는 get에서 이루어진다
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println("/login doPost dto: "+ dto);
		//TODO login - 실습 때 구현 - classdiagram참고
		//성공 : 1
		//실패 : 0
		int result = 0;
		//int result = new MemberService().login(dto); 
		MemberInfoDto resultInfo = new MemberService().loginGetInfo(dto);;//로그인 했을 때 각종 정보를 가져오는 것
		if (resultInfo != null) {//succcess
		//	request.getSession().setAttribute("ssslogin", id); // setAttribute (이름, 저장할 데이터) , 값이 많다면..pwd를 가지고 다니면 위험하니까 memberInfoDto를 가지고 다녀도 될 듯
			request.getSession().setAttribute("ssslogin", resultInfo);//이름이 겹칠 가능성이 있다면 특이하게 적어서 겹칠 수 있는 경우를 차단
			result=1;
		}
		response.getWriter().append(String.valueOf(result));
	}

}
