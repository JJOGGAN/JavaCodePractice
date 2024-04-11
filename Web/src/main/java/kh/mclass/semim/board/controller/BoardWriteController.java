package kh.mclass.semim.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.service.BoardService;
import kh.mclass.semim.member.model.dto.MemberInfoDto;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
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
		if(prePage !=null && prePage.equals("write")) {
			request.getSession().removeAttribute("prePage");
		}
		request.getRequestDispatcher("/WEB-INF/views/semim/board/write.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>> loard/write doPost()");
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		MemberInfoDto memberInfoDto = (MemberInfoDto)req.getSession().getAttribute("ssslogin");
		System.out.println(">>>>>> s : "+subject);
		System.out.println(">>>>>> c : "+content);
		BoardInsertDto dto = new BoardInsertDto(subject, content, memberInfoDto.getMemId());
//		int result = service.insert(dto)	;	//System.out.println(subject + "    :    "+content);
//		resp.sendRedirect(req.getContextPath()+"/board/list");
		int sequenceNum = service.insert(dto);
		resp.sendRedirect(req.getContextPath()+"/board/list?num="+sequenceNum);
	}

}
