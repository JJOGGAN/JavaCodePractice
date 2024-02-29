package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==================request.getParameterNames+switch와 함께 - ex) 카테고리별 검색, 잡코리아 경력/연봉/지역 등등=================");
		Enumeration<String> enumNames = request.getParameterNames();
		System.out.println(enumNames);
		while(enumNames.hasMoreElements()) {
			String name = enumNames.nextElement();
			System.out.println(request.getParameter(name));
		}
		System.out.println("=========  request.getParameterValues+Arrays.asList()와 함께 - 레시피 재료들, 장르선택 ==========");
		//&genre=a1&genre=b1&genre=c1

		String[] genreArr=request.getParameterValues("genre");
		List<String> genreList = Arrays.asList(genreArr); //배열을 List형태로 변환
		System.out.println(genreList);
		System.out.println("===================");
		
		
		
		System.out.println("========= request.getParameterMap() ==========");
		Map<String, String[]>paraMap = request.getParameterMap();
		Set<String> keyset = paraMap.keySet();
		for (String key : keyset) {
			String[] valueArr = paraMap.get(key);
			List<String> valueList = Arrays.asList(valueArr);
			System.out.println(key+" : "+valueList);
		}
		
		//쿼리스트링
		// dept/insert?no=60&a=AAAA&b=Seoul

		// 5.데이터 수신
		String noStr = request.getParameter("no");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		int deptno = Integer.parseInt(noStr);
		Dept no = new Dept(deptno, dname, loc);

		DeptService service = new DeptService();
		int result = service.insert(no);
		if (result > 0) {
			// 4.url 페이지 이동
			// DeptController - doGet() 이 호출됨 --> url/deptlist로 이동됨
			response.sendRedirect(request.getContextPath() + "/deptlist");// 가고싶은 url
			// contextpath : 절대경로 지정 이 프로젝트는 mclass가 get의 값이 됨

			// 3. view에 데이터 전달
//			List<Dept> volist = service.selectList();
//			request.setAttribute("volist", volist);
			// 1. view0 선택
//			request.getRequestDispatcher("/views/deptlist.jsp").forward(request, response); //화면에 띄울 것
		} else {
			request.setAttribute("msg", "부서를 추가하지 못했습니다. 행정팀에 문의해주세요");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}
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
