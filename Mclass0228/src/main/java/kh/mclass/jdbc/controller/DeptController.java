package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

/**
 * Servlet implementation class DeptController
 */
@WebServlet("/deptlist")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller 역할
		// 2. Service - Dao 호출
		DeptService service = new DeptService();
		List<Dept> result = service.selectList();
		System.out.println("===나오나....===");
		System.out.println(result);
		if (result == null) {
			req.setAttribute("msg", "조회할 수 없음");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, response);
		} else {

			// 3. view 에 데이터 전달
			req.setAttribute("volist", result);
			req.setAttribute("data2", "컨트롤러에서 jsp-view로 값 전달.. ");
			req.setAttribute("data3", 2005);
			// 1. view 선택
			// request.getRequestDispatcher("/a.jsp").forward(request, response);
			req.getRequestDispatcher("/views/deptlist.jsp").forward(req, response);
		}
		// view 역할을 JSP 파일에서 함.
//		response.getWriter().append("Served at: hello Servlet~!~~~").append(request.getContextPath());
//		response.getWriter().append("Hello Web Project!")
//		.append("<br>")
//		.append("		<h1>제목1</h1>")
//		.append("<table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
