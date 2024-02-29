package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

@WebServlet("/SalgradeDeleteController")
public class SalgradeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalgradeDeleteController() {
        super();
    }

//	 GRADE                                              NUMBER
//	 LOSAL                                              NUMBER
//	 HISAL                                              NUMBER
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gradeStr = request.getParameter("grade");
//		String losalStr = request.getParameter("lo");
//		String hisalStr = request.getParameter("hi");
		
		int grade = Integer.parseInt(gradeStr);
//		int losal = Integer.parseInt(losalStr);
//		int hisal = Integer.parseInt(hisalStr);
		
		SalgradeService service = new SalgradeService();
		int result  = service.delete(grade);
		
		if (result >0) {
			List<Salgrade> volist = service.selectList();
			request.setAttribute("volist", volist);
			request.getRequestDispatcher("/views/salgradelist.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "result에 값이 들어오지 않았음");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
