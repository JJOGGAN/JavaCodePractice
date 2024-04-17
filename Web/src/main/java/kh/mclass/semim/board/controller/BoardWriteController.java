package kh.mclass.semim.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
import kh.mclass.semim.board.model.dto.FileWriteDto;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prePage = (String) request.getSession().getAttribute("prePage");

		if (prePage != null && prePage.equals("write")) {
			request.getSession().removeAttribute("prePage");
		}
		request.getRequestDispatcher("/WEB-INF/views/semim/board/write.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>> loard/write doPost()");
		String uploadPath = request.getServletContext().getRealPath("resources/uploadfiles"); // ? resource 아래의
																								// upladfiles에 파일 저장

		// file-즉 enctype="multipart/form-data" 형태로 전달된 경우

		File uploadPathFile = new File(uploadPath);
		if (!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 10 * 1024 * 1024; // 10M 제한

//		new MultipartRequest(request //jsp->controller 로 전달된 객체

		List<FileWriteDto> fileList = new ArrayList<FileWriteDto>();
//				,getServletInfo() //wqs 서버에 저장할 디렉토리
//				,serialVersionUID //업로드 파일 크기제한
//				,// 인코딩 방법
//				, //was 서버에 저장할 디렉토리에 동일이름이 존재할 때 새로운 이름 부여방식
//				null);
		MultipartRequest multiReq = new MultipartRequest(request // jsp-> controller로 전달된 객체
				, uploadPath // 서버에 저장할 디렉토리
				, uploadFileLimit // 업로드 파일크기 제한
				, "UTF-8" // 인코팅 방법
				, new DefaultFileRenamePolicy()// was 서버에 저장할 디렉토리에 동일한 이름이 존재할 때 새로운 이름 부여방식 (뒤에 숫자 붙임)
		);
		// 업로드 가능한 파일 크기가 무제한인 사이트의 경우 파일을 쪼개서 전달할 것이다.
//★★★이 시점에 new MultipartRequest하면 file은 uploadPath위치에 저장 완료!!!!

		// TODO 파일이 하나일 경우
//		String filePath=multiReq.getFilesystemName("uploadfiles");
//		//파일 꺼내기 만약 파일이 없다면 어떻게 출력할 것인가
//		if(filePath == null) {
//			System.out.println("첨부파일이 없다.");
//		}else {
//			System.out.println("첨부파일정보는 ==== ");
//			System.out.println(filePath);
//			System.out.println(multiReq.getOriginalFileName(uploadfiles+"\\"+filePath));//....?????
//		}

		// 0개 이상일 경우
		//multiReq : 파일은 String 형식으로 보낼 수 없기 때문에 multiReq를 사용함 //multiReq는 jar에서 가져온 것이예용
		Enumeration<?> fileNames = multiReq.getFileNames();
		while (fileNames.hasMoreElements()) {
			// Object fileName = fileNames.nextElement(); //필시 obj는 fileName이 될 것이다.
			String name = (String) fileNames.nextElement(); // 굳이 object 형식으로 갖고 있을 필요가 없으니 String으로 자료형을 변환해준다.
			// input type ="file" name="xxxx",xxxx_0,XXXX_1 여러개일 경우 이렇게 나타남
			String fileName = multiReq.getFilesystemName(name); // 서버에 저장된 파일 이름 client가 보낸 이름과 다름 ..?
			String orginFileName = multiReq.getOriginalFileName(name);
			System.out.println(">>>>>>>>>>BWC의파일  name : " + name + " >>fileNmae : " + fileName + "  >>orginFileName : "
					+ orginFileName); // "xxxx"

			// 우리에게 필요한 정보 fileNmae,orginFileName

			File f1 = multiReq.getFile(name);
			if (f1 == null) {
				System.out.println("업로드 실패!!!!!!!!!!");
			} else {
				System.out.println(f1.length()); // 파일의 크기
			}
			FileWriteDto filedto = new FileWriteDto(fileName, orginFileName);
			fileList.add(filedto);
		}
		// toString이 없으면 해쉬코드 형식으로 출력됨

		String subject = multiReq.getParameter("subject");
		String content = multiReq.getParameter("content");
		MemberInfoDto memberInfoDto = (MemberInfoDto) request.getSession().getAttribute("ssslogin");
//		System.out.println(">>>>>> s : "+subject);
//		System.out.println(">>>>>> c : "+content);
//		BoardInsertDto dto = new BoardInsertDto(subject, content, memberInfoDto.getMemId());
//		int result = service.insert(dto)	;	//System.out.println(subject + "    :    "+content);
//		resp.sendRedirect(req.getContextPath()+"/board/list");
		BoardInsertDto dto = new BoardInsertDto(subject, content, "kh1", fileList);
		int sequenceNum = service.insert(dto);
		resp.sendRedirect(request.getContextPath() + "/board/list?num=" + sequenceNum);
	}

}
