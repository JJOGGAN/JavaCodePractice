package kh.mclass.semim.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mclass.semim.member.model.service.MemberService;

/**
 * Servlet implementation class CheckIdController
 */
@WebServlet("/checkid")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdController() {
        super();
    }

//get사용 안 함
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>/checkid doPost id check time!!!!!!!");
		String memId = request.getParameter("cid");
		System.out.println(">>>>>>memid : "+memId);
		//TODO DB로 여정 떠남
		
		int result = new MemberService().selectCheckId(memId);
		response.getWriter().append(String.valueOf(result));

		
		//ajax확인용
//		String kk = request.getParameter("k1");
//		System.out.println(kk);
//		String kdk = request.getParameter("k2");
//		System.out.println(kdk);
//		
//		List<MemberDto> result = new MemberService().selectAllList();
//		System.out.println(result);
//		Gson gson = new Gson();
//		System.out.println("aaa");
//		String jsonResult = gson.toJson(result); //gson아 json으로 바꿔줘
//		response.getWriter().append(jsonResult); //
		
		//ajax로 왔다면 다른 이동 루트를 작성하지 않는다!!!!!!!!!!
		//ajax로 controller로 왔다면 다시돌아가는 건 원래 페이지 이다
		
		//response.getWriter().append("존재한다"); //'존재한다'이것을 보낸다는 것
	}

}
