package kh.mclass.dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.dept.model.service.DeptService;
import kh.mclass.dept.model.vo.Dept;

@WebServlet("/dept/delete")
public class DeptDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptDeleteController() {
		super();
	}

//doGet을 애초에 지워서 미연에 실수 방지

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ?deptno=71
		String deptnoStr = request.getParameter("deptno");
//		String[] n5Arr request.getParameterValues("n5");  - checkbox랑 짝꿍
		int deptno = 0;
		try {
			deptno = Integer.parseInt(deptnoStr);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (deptno != 0) {
			int result = new DeptService().delete(deptno);
			if (result > 0) {
				response.sendRedirect(request.getContextPath() + "/dept/list");
			} else {
				request.setAttribute("msg", "DEPT에 없는 항목으로 삭제하지 못했습니다.");
				request.getRequestDispatcher("/views/error/errorPage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "DEPT에 없는 항목으로 삭제하지 못했습니다.");
			request.getRequestDispatcher("/views/error/errorPage.jsp").forward(request, response);
		}
	}
}
