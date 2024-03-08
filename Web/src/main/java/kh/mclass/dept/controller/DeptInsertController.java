package kh.mclass.dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.dept.model.service.DeptService;
import kh.mclass.dept.model.vo.Dept;

/**
 * Servlet implementation class DeptInsertController
 */
@WebServlet("/dept/insert")
public class DeptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptInsertController() {
		super();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// ?deptno=71&dname=ABC&loc=seoul
//
//	} 애초에 doGet자체를 막아버린다

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//insert의 경우는 post방식으로만 넣는다. (보안성)
		//get (url)로 입력이 가능하면 누구나 다 할 수 있으니까
		String deptnoStr = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		int deptno = 0;
		try {
			deptno = Integer.parseInt(deptnoStr);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (deptno != 0) {
			Dept vo = new Dept(deptno, dname, loc);
			int result = new DeptService().insert(vo);
			if (result > 0) {
				response.sendRedirect(request.getContextPath() + "/dept/list");
			} else {
				request.setAttribute("msg", "DEPT에 추가하지 못했습니다.");
				request.getRequestDispatcher("/views/error/errorPage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "DEPT에 추가하지 못했습니다.");
			request.getRequestDispatcher("/views/error/errorPage.jsp").forward(request, response);
		}
	}

}
