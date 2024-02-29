package kh.mclass.jdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

/**
 * Servlet implementation class DeptInsertController
 */
@WebServlet("/dept/insert")
public class DeptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptService();
		String noStr = req.getParameter("no");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		
		int deptno = Integer.parseInt(noStr);
		
		Dept vo = new Dept(deptno, dname, loc);
		int result = service.insert(vo);
		if (result >0) {
			response.sendRedirect(req.getContextPath()+"/dept/insert");
		}else {
			req.setAttribute("msg", "부서추가하기 실패 재확인 필요");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
