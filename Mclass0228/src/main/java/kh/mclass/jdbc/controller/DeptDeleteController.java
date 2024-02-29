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
 * Servlet implementation class DeptDeleteController
 */
@WebServlet("/dept/delete")
public class DeptDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptDeleteController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dept/delete?no=50&a=10&b=안녕
		String noStr = request.getParameter("no"); // getParameter은 항상 string 으로 리턴
		// String a = request.getParameter("a");
		// String b = request.getParameter("b");
		 String loc = request.getParameter("loc");
		System.out.println("noStr: " + noStr);
		// System.out.println("a: "+a);
		// System.out.println("b: "+b);
		int deptno = Integer.parseInt(noStr);
		DeptService service = new DeptService();
		int result = service.delete(deptno);
		//TODO 0229 5교시 강의 확인
//		if(noStr != null & !noStr.equals("")) {
//			int deptnom = Integer.parseInt(noStr);
//			result = service.delete(deptno);
//		}else if (loc != null&&!loc.equals("")) {
//			result = service.
//		}
		
		if (result > 0) {
			List<Dept> volist = service.selectList();
			request.setAttribute("volist", volist);
			request.getRequestDispatcher("/views/deptlist.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "해당하는 dept 부서가 없어 삭제하지 못했습니다.");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); //
	}

}
