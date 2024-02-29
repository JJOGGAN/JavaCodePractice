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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// controller의 역할
		// Service - Dao 호출
		DeptService service = new DeptService();
		List<Dept> result = service.selectList();
		System.out.println(result); //없어도 출력됨..
		
		if (result ==null) {
			req.setAttribute("msg", "조회할 수 없음 console확인");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, response);
		}
		// 3.view 에 데이터 전달 (값 채우기)
		req.setAttribute("volist", result);
		req.setAttribute("data2","controller에 값 전달...");
		// 1. view 선택
		req.getRequestDispatcher("/views/deptlist.jsp").forward(req, response);
		// 절대 위치나 상대위치나 상관없음

		// view 역할은 JSP파일에서 한다

		// response.getWriter().append("Served at: hello
		// Servlet!!").append(request.getContextPath());
		// response.getWriter().append("welcome to 32 web project");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
