package kh.mclass.jdbc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dept/insert?no=60&a=AAAA&b=Seoul
		
		//5.데이터 수신
		String noStr= request.getParameter("no");
		String dname= request.getParameter("dname");
		String loc= request.getParameter("loc");
		int deptno = Integer.parseInt(noStr);
		Dept no = new Dept(deptno, dname, loc);
		
		DeptService service = new DeptService();
		int result = service.insert(no);
		if (result > 0) {
			//4.url 페이지 이동
			//DeptController - doGet() 이 호출됨  --> url/deptlist로 이동됨
			response.sendRedirect(request.getContextPath()+"/deptlist");//가고싶은 url
			//contextpath : 절대경로 지정 이 프로젝트는 mclass가 get의 값이 됨
			
			//3. view에 데이터 전달
//			List<Dept> volist = service.selectList();
//			request.setAttribute("volist", volist);
			//1. view0 선택
//			request.getRequestDispatcher("/views/deptlist.jsp").forward(request, response); //화면에 띄울 것
		} else {
			request.setAttribute("msg", "부서를 추가하지 못했습니다. 행정팀에 문의해주세요");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
