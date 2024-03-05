package kh.mclass.dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.dept.model.service.DeptService;
import kh.mclass.dept.model.vo.Dept;
/*copyroot*/
/**
 * Servlet implementation class DeptListController
 */
@WebServlet("/dept/list")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptService();
		List<Dept> result = service.selectList();
		if(result==null) {
			request.setAttribute("msg", "오류가 발생했습니다. 다시 확인해주세요");
			request.getRequestDispatcher("/views/error/errorPage.jsp").forward(request, response);
		}else {
			request.setAttribute("volist", result);
			request.getRequestDispatcher("/views/dept/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
