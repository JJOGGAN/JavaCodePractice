package kh.mclass.semim.board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;

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
		String uploadPath  = request.getServletContext().getRealPath("resources/uploadfiles"); //? resource 아래의 upladfiles에 파일 저장
		//file-즉 enctype="multipart/form-data" 형태로 전달된 경우
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 10*1024*1024; //10M 제한
		
//		new MultipartRequest(request //jsp->controller 로 전달된 객체
//				,getServletInfo() //wqs 서버에 저장할 디렉토리
//				,serialVersionUID //업로드 파일 크기제한
//				,// 인코딩 방법
//				, //was 서버에 저장할 디렉토리에 동일이름이 존재할 때 새로운 이름 부여방식
//				null);
		MultipartRequest multiReq=new MultipartRequest(request,uploadPath,uploadFileLimit,new DefaultFileRenamePolicy());
		
		String filePath=multiReq.getFilesystemName("uploadfiles");
		//파일 꺼내기 만약 파일이 없다면 어떻게 출력할 것인가
		if(filePath == null) {
			System.out.println("첨부파일이 없다.");
		}else {
			System.out.println("첨부파일정보는 ==== ");
			System.out.println(filePath);
			System.out.println(multiReq.getOriginalFileName(filePath));//....?????
		}
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
