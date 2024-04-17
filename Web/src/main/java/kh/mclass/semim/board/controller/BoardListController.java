package kh.mclass.semim.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.board.model.service.BoardService;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		--------------------------------- start,end를 controller에서 할지 dao에서 할지는 개발자의 선택에 따라서 정하는 겁니다.
//		--한 페이지당 글수 
		int pageSize = 3;
//		--화면 하단에 나타낼 페이지수
		int pageBlockSize = 5;
//		--현재페이지
		int currentPageNum = 1; //게시판을 눌렀을 때 첫번째 페이지가 나오게 default값 설정
		String pageNum = request.getParameter("page");
		//페이지를 지정하고 들어왔다면 현재페이지를 그 값으로 설정함
		if (pageNum != null && !pageNum.equals("")) {
			try {
				currentPageNum = Integer.parseInt(pageNum); //사용자가 입력한 페이지
			}catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println(">>>>>>>>> boardlistcontroller NumberFormatException");
			}
		}

		//service.selectPageList(start,end);//		--where rn between 한페이지당 글 수 * (현재페이지-1)+1 and  한페이지당 글 수 * (현재페이지)
//		--총 글 갯수  -> DB에서 그때그때 읽어와야 실행할 수 있다 service에서 해주자
		
		
//		---------------------------------
//		--한 페이지에 몇개씩 나타낼 것인가? 3개씩
//		--화면 하단에 나타낼 '페이지 수'는 몇? 5씩
//		--현재페이지는 어디인가
//		-- 3이다!!  --> 하단에 12345 표시
//		-- 10이다!! --> 하단에 678910표시
//		-- 하단에 몇 페이지씩 표시할 것인가
//		--그렇다면 전체 페이지 수가 몇 장이 될 것인가
//		--- 전체 글 갯수(25) / 한페이지에 나타낼 게시글 수(4)
//		select ceil(count(*)/3) from board; 
							//int totalCount = service.selectTotalCount();
//		--전체 페이지수 = ceil(총글개수/한 페이지당 글 수)
							//int totalPageCount =totalCount/pageSize;
//		select t2.*
//		from( select t1.*,rownum rn from(select * from bloard order by board_id desc) t1) t2
//		where rn between 7 and 9 --3page
//		--where rn between 한페이지당 글 수 * (현재페이지-1)+1 and  한페이지당 글 수 * (현재페이지)
//		;
//		--현재 페이지를 기준으로 
//		----(현재페이지 % 페이지수 ==0)?
//		-- 시작 페이지 start page 와 
//		---- startPageNum =(현재페이지 % 페이지수 ==0)? ((현제페이지 / 페이지수)* 페이지 수 +1 : ((현재페이지/페이지수 )*페이지수 +1)
//		-- 마지막 페이지 end page를 정할 것이다
//		----  endPageNum = (현재페이지/페이지수 +1) * 페이지 수
//		---- endPageNum =(endPageNum> 전체페이지수 ) ? 전체 페이지 수 : startPageNum+vpdlwltn -1;
		
		//setAttribute jsp 파일로 값 넘겨줄 때 쓰는 것 
		request.setAttribute("map" , service.selectPageList(pageSize, pageBlockSize, currentPageNum));
		System.out.println(">>>>>>>>> map"+ service.selectPageList(pageSize, pageBlockSize, currentPageNum) );
		
		//request.setAttribute("dtolist", service.selectAllList());
		request.getRequestDispatcher("/WEB-INF/views/semim/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
