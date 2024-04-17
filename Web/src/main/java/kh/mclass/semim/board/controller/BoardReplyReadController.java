package kh.mclass.semim.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mclass.semim.board.model.service.BoardService;

/**
 * Servlet implementation class BoardReplyReadController
 */
@WebServlet("/board/reply/read.ajax") //ajax로 진입 sendRedirect를 해주지 않음
public class BoardReplyReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyReadController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("boardId");
		try {
			int boardId = Integer.parseInt(boardIdStr);//사용자가 입력한 페이지
			//json형태로 바꿔준다.
			response.getWriter().append(new Gson().toJson(service.selectBoardReplyList(boardId)));
			 //boardreplylistdto 형식을 준다 ?
		}catch(NumberFormatException e) {
			System.out.println("!!! NumberFormatException !!!!!!");//error뜨면 list로 보내버림
			response.sendRedirect(request.getContextPath()+"board/list");
		}
	}

}
