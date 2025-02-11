package kh.mclass.semim.board.model.service;

import static kh.mclass.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.mclass.mybatis.common.MybatisTemplate;
import kh.mclass.semim.board.model.dao.BoardDao;
import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.BoardListDto;
import kh.mclass.semim.board.model.dto.BoardReadDto;
import kh.mclass.semim.board.model.dto.BoardReplyListDto;
import kh.mclass.semim.board.model.dto.BoardReplyWriteDto;
import kh.mclass.semim.board.model.dto.FileReadDto;

public class BoardService {
	private BoardDao dao = new BoardDao();

	// select문 두개를 돌릴건데 하나의 메서드에서 돌리기 위한 작업 - conn을 재연결하지 않기 위한 작업
	// 서비스 하나에 두 명령어가 들어간다 .. 따로 떨어뜨려두면 속도가 떨어질 수 있다

	// select totalCount - conn을 재연결 하지 않도록 함.
//	public int selectTotalCount() {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.selectTotalCount(conn);
//		close(conn);
//		return result;
//	}

	// select list - all
	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;

		Connection conn = getSemiConnection(true);
		System.out.println("currentPageNum: " + currentPageNum);
		int start = pageSize * (currentPageNum - 1) + 1;
		int end = pageSize * currentPageNum;
//		select t2.*
//		from (select t1.*, rownum rn from (SELECT BOARD_ID, SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT    FROM BOARD order by board_id desc) t1 ) t2
//		--where rn between 한페이지당글수*(현재페이지-1)+1   and 한페이지당글수*(현재페이지)
//		;

//		--- 총글개수 103
//		select count(*) cnt from board;
		SqlSession session = MybatisTemplate.getSqlSession();
		int totalCount = dao.selectTotalCount(session);
		System.out.println(" >>>>>>>totalCount:" + totalCount);
//		-- 전체페이지수  = ceil(총글개수/한페이지당글수) = (총글개수%한페이지당글수== 0)?(총글개수/한페이지당글수):(총글개수/한페이지당글수+1) 
//		int totalPageCount = (int)Math.ceil(totalCount/(double)pageSize);
		int totalPageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;

//		-- 시작페이지 startPageNum = (현재페이지%페이지수 == 0) ? ((현재페이지/페이지수)-1)*페이지수 + 1  :((현재페이지/페이지수))*페이지수 + 1
//		-- 끝페이지 endPageNum =  (endPageNum > 전체페이지수) ? 전체페이지수 : startPageNum+페이지수 - 1;
		int startPageNum = (currentPageNum % pageBlockSize == 0)
				? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1
				: ((currentPageNum / pageBlockSize)) * pageBlockSize + 1;
		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount
				: startPageNum + pageBlockSize - 1;

		List<BoardListDto> dtolist = dao.selectPageList(conn, start, end);
		close(conn);

		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		System.out.println("selectPageList() : " + result);
		return result;
	}

	// 댓글 리스트 보여주는 것
	// select list - board reply
	public List<BoardReplyListDto> selectBoardReplyList(Integer boardId) {
		List<BoardReplyListDto> result = null;
//		Connection conn = getSemiConnection(true);
		/**/
		SqlSession session = MybatisTemplate.getSqlSession();
		result = dao.selectBoardReplyList(session, boardId);
		session.close();
		return result;
	}

	// 게시판들어갔을 때 보드 리스트 보여주는 것
	// select list - all
	public List<BoardListDto> selectAllList() {
		List<BoardListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;
	}

	// select one
	// 클라이언트에게 게시글 중에서 보여줄 값만 따로 dto 만든 후 BoardDto -> BoardReadDto로 변경
	public BoardReadDto selectOne(Integer boardId) {
		BoardReadDto result = null;
		Connection conn = getSemiConnection(true);
		// 기존보다 가져오는 양이 줄었기 때문에 속도가 빨라 보일 수 있다 코드가 2줄 줄어듬
		result = dao.selectOne(conn, boardId);
		if (result != null) {
			dao.updateReadCount(conn, boardId);
		}
		List<FileReadDto> filelist = dao.selectFileList(conn, boardId);
		result.setFiledtolist(filelist); //TODO

		// ajax 대체
//			List<BoardReplyListDto> replylist = dao.selectBoardReplyList(conn, boardId);	
//			result.setReplydtolist(replylist);
		close(conn);
		return result;
	}

	//

	// insert - boardreply 게시글에 댓글 달기
	public int insertReply(BoardReplyWriteDto dto) {
		int result = 0;
		int resultupdate = 0;
		Connection conn = getSemiConnection(true);
		autocommit(conn, false);
		if (dto.getBoardReplyId() != 0) {
			resultupdate = dao.updateReplyStep(conn, dto.getBoardReplyId());
			if (resultupdate > -1) {
				result = dao.insertRReply(conn, dto);
			}
		} else {
			result = dao.insertReply(conn, dto);
		}
		if (resultupdate > -1 && result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// insert
	public int insert(BoardInsertDto dto) {
		int result = 0;
		// INSERT INTO MEMBER VALUES('kh1','pwd1','kh1@a.com');
		Connection conn = getSemiConnection(true);
//		int sequencNum = dao.getSequenceNum(conn);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}

	// update
	public int update(BoardDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.update(conn, dto);

		close(conn);
		return result;
	}

	// delete
	public int delete(Integer boardId) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.delete(conn, boardId);

		close(conn);
		return result;
	}
}
