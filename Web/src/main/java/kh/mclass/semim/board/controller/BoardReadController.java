package kh.mclass.semim.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.board.model.service.BoardService;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet("/BoardReadController")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("id");
		int boardId = Integer.parseInt(boardIdStr);
		
		try {
			boardId = Integer.parseInt(boardIdStr); //사용자가 입력한 페이지
			request.setAttribute("dto", service.selectOne(boardId));
			request.getRequestDispatcher("/WEB-INF/views/semim/read.jsp").forward(request, response);
		}catch (NumberFormatException e) { //error뜨면 list로 보내버림
			//e.printStackTrace();
			System.out.println(">>>>>>>>> boardlistcontroller NumberFormatException");
			response.sendRedirect(request.getContextPath()+"board/list");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
