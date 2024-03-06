package kh.mclass.dept.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.dept.model.service.OpenApiService;
import kh.mclass.dept.model.vo.OpenApiVo;

@WebServlet("/OpenApiController")
public class OpenApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OpenApiController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OpenApiService service = new OpenApiService();
//		List<OpenApiVo> result = service.getCtprvnRltmMesureDnsty(); //xml
		Map<String, Object> result = service.getCtprvnRltmMesureDnstyByJson(); // json
		System.out.println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
