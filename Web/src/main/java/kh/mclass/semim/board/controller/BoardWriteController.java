package kh.mclass.semim.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage =(String)request.getSession().getAttribute("prePage");
		if(prePage.equals("write")) {
			request.getSession().removeAttribute("prePage");
		}
		request.getRequestDispatcher("/WEB-INF/views/semim/board/write.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		//System.out.println(subject + "    :    "+content);
	}

}
