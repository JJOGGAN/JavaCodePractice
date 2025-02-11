package kh.mclass.semim.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.mclass.jdbc.JdbcTemplate.*;

import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
//BOARD_ID     NOT NULL NUMBER         
//SUBJECT      NOT NULL VARCHAR2(120)  
//CONTENT      NOT NULL VARCHAR2(4000) 
//WRITE_TIME   NOT NULL TIMESTAMP(6)   
//LOG_IP                VARCHAR2(15)   
//BOARD_WRITER NOT NULL VARCHAR2(20)   
//READ_COUNT   NOT NULL NUMBER    
import kh.mclass.semim.board.model.dto.BoardListDto;
import kh.mclass.semim.board.model.dto.BoardReadDto;
import kh.mclass.semim.board.model.dto.BoardReplyListDto;
import kh.mclass.semim.board.model.dto.BoardReplyWriteDto;
import kh.mclass.semim.board.model.dto.FileReadDto;
import kh.mclass.semim.board.model.dto.FileWriteDto;

//private Integer boardId;
//private String subject;
//private String writeIime;
//private String boardWriter;
//private Integer readCount;

public class BoardDao {

	// select list - all
	public List<FileReadDto> selectFileList(Connection conn, Integer boardId) {
		List<FileReadDto> result = null;
//		(BOARD_ID, BOARD_FILE_ID, SAVED_FILE_PATH_NAME, ORIGINAL_FILENAME)
		String sql = "SELECT BOARD_ID, BOARD_FILE_ID, SAVED_FILE_PATH_NAME, ORIGINAL_FILENAME   FROM BOARD_FILE WHERE BOARD_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			// ResetSet처리
			if (rs.next()) {
				result = new ArrayList<FileReadDto>();
				do {
//					TODO 왜 error 뜨지
					FileReadDto dto = new FileReadDto(	
							rs.getString("BOARD_ID"),rs.getString("BOARD_FILE_ID"),
							rs.getString("SAVED_FILE_PATH_NAME"),rs.getString("ORIGINAL_FILENAME")
							);
					result.add(dto);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		System.out.println("selectFileList : " + result);
		return result;
	}

	// select total Count
	public Integer selectTotalCount(SqlSession session) {
		/* namespace.select에 적었던 id */
		return session.selectOne("boardns.selectTotalCount");
	}

	// selelct list - board reply : board id
	public List<BoardReplyListDto> selectBoardReplyList(SqlSession session, Integer boardId) {
		/* 이름.select에 적었던id */
		return session.selectList("boardns.selectBoardReplyList", boardId);
		/*
		 * return타입은 selectList라는 메소드 자체가 여러개를 만들어서 메소드가 알아서 List로 돌려줌 기본적으로 ArrayList로
		 * 해준다
		 */
		/* selectOne으로 하면 List타입이 아니고 하나로 리턴함 */
	}

	// selelct page list
	public List<BoardListDto> selectPageList(Connection conn, int start, int end) {
		List<BoardListDto> result = null;
		String sql = "SELECT T2.*" + " FROM(SELECT T1.*, ROWNUM RN"
				+ " FROM (SELECT BOARD_ID, SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT FROM BOARD ORDER BY BOARD_ID DESC) T1 "

				+ " ) T2" + " WHERE RN  BETWEEN ? AND ?" // 앞에 띄워쓰기 반드시 해야함
		;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			// 한페이지당 글수 * 현재페이지+1
			pstmt.setInt(1, start);
			// pstmt.setInt(1,(pageSize*(currentPageNum-1)+1));
			// 한페이지당 글수 * 현재페이지
			pstmt.setInt(2, end);
			// pstmt.setInt(2,(pageSize*currentPageNum));
			rs = pstmt.executeQuery(); // pstmt로 insert, update, delete 로 한 그 값을 가져오는 것이 ResultSet

			// rs처리
			if (rs.next()) {
				result = new ArrayList<BoardListDto>();
				do {
					BoardListDto dto = new BoardListDto(rs.getInt("BOARD_ID"), rs.getString("SUBJECT"),
							rs.getString("WRITE_TIME"), rs.getString("BOARD_WRITER"), rs.getInt("READ_COUNT"));
					result.add(dto);
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}

	// select list - all
	public List<BoardListDto> selectAllList(Connection conn) {
		List<BoardListDto> result = null;
		String sql = "SELECT BOARD_ID, SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT    FROM BOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if (rs.next()) {
				result = new ArrayList<BoardListDto>();
				do {
					BoardListDto dto = new BoardListDto(rs.getInt("BOARD_ID"), rs.getString("SUBJECT"),
							rs.getString("WRITE_TIME"), rs.getString("BOARD_WRITER"), rs.getInt("READ_COUNT"));
					result.add(dto);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}

	// select one
	public BoardReadDto selectOne(Connection conn, Integer boardId) {
		BoardReadDto result = null;
		String sql = "SELECT BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT FROM BOARD WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			// rs처리
			if (rs.next()) {
				result = new BoardReadDto(rs.getInt("BOARD_ID"), rs.getString("SUBJECT"), rs.getString("CONTENT"),
						rs.getString("WRITE_TIME"), rs.getString("LOG_IP"), rs.getString("BOARD_WRITER"),
						rs.getInt("READ_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}

	// select SEQ_BOARD_ID.nextval 번호 넣기
	public int getSequenceNum(Connection conn) {
		int result = 0;
		String sql = "SELECT SEQ_BOARD_ID.nextval FROM DUAL";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet처리
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}

	// insert - Reply 댓글 대댓글
	public int insertRReply(Connection conn, BoardReplyWriteDto dto) {
		int result = 0; // 1 정상, 0비정상
		String sql = " INSERT INTO BOARD_REPLY VALUES ( (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY), ?,"
				+ "            ?, ? , default , null, "
				+ "            (SELECT BOARD_REPLY_LEVEL+1 FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  , "
				+ "            (SELECT BOARD_REPLY_REF     FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  , "
				+ "            (SELECT BOARD_REPLY_STEP+1  FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, dto.getBoardId());
			pstmt.setString(2, dto.getBoardReplyWriter());
			pstmt.setString(3, dto.getBoardReplyContent());
			pstmt.setInt(4, dto.getBoardReplyId());
			pstmt.setInt(5, dto.getBoardReplyId());
			pstmt.setInt(6, dto.getBoardReplyId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	// insert - Reply 댓글 원본글
	public int insertReply(Connection conn, BoardReplyWriteDto dto) {
		int result = 0;
		String sql = " INSERT INTO BOARD_REPLY VALUES"
				+ "        ( (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY) , ?, "
				+ "            ?, ? , default , null, "
				+ "            DEFAULT , (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY), DEFAULT )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, dto.getBoardId());
			pstmt.setString(2, dto.getBoardReplyWriter());
			pstmt.setString(3, dto.getBoardReplyContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	// 게시글 등록하기
	public int insert(Connection conn, BoardInsertDto dto) {
		System.out.println("boardDao insert() param : " + dto);
		int result = 0;
//		String sql = "INSERT INTO BOARD (BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT)"
//		+ " VALUES (SEQ_BOARD_ID.nextval, ?, ?, default, ?, ?, default)";
		String sql = "INSERT ALL ";
		sql += "	INTO BOARD (BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT) ";
		sql += "		VALUES (SEQ_BOARD_ID.nextval, ?, ?, default, ?, ?, default) ";
		if (dto.getFileList() != null && dto.getFileList().size() > 0) {
			for (FileWriteDto filedto : dto.getFileList()) {
				sql += "	INTO BOARD_FILE (BOARD_ID, BOARD_FILE_ID, SAVED_FILE_PATH_NAME, ORIGINAL_FILENAME) ";
				sql += "		VALUES (SEQ_BOARD_ID.nextval, ?, ?, ?) ";
			}
		}
		sql += "	SELECT * FROM DUAL ";
		System.out.println("sql: " + sql);
		PreparedStatement pstmt = null;
		// BOARD_ID NOT NULL NUMBER
		// SUBJECT NOT NULL VARCHAR2(120)
		// CONTENT NOT NULL VARCHAR2(4000)
		// WRITE_TIME NOT NULL TIMESTAMP(6)
		// LOG_IP VARCHAR2(15)
		// BOARD_WRITER NOT NULL VARCHAR2(20)
		// READ_COUNT NOT NULL NUMBER
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			int i = 1;
			pstmt.setString(i++, dto.getSubject());
			pstmt.setString(i++, dto.getContent());
			pstmt.setString(i++, null); // TODO pstmt.setString(3, dto.getLogIp());
			pstmt.setString(i++, dto.getBoardWriter());
			if (dto.getFileList() != null && dto.getFileList().size() > 0) {
				int fileId = 1;
				for (FileWriteDto filedto : dto.getFileList()) {
					pstmt.setInt(i++, fileId++);
					pstmt.setString(i++, filedto.getFilePath());
					pstmt.setString(i++, filedto.getOrginFileName());
				}
			}

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		System.out.println("boardDao insert() return : " + result);
		return result;
	}

	// update - reply step 댓글 등록할 때 마다 업데이트해준다
	public int updateReplyStep(Connection conn, Integer boardReplyId) {
		int result = -1; // 0~n 정상이므로 비정상인경우-1 //0이 작동은 했지만 업데이트한 행이 0개 일 때
		// 게시글 작성자와 아이디가 다르면 board 테이블의 read_count가 증가
		String sql = "UPDATE BOARD_REPLY SET BOARD_REPLY_STEP = BOARD_REPLY_STEP+1  WHERE "
				+ "            BOARD_REPLY_REF = ( SELECT BOARD_REPLY_REF FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ?)"
				+ "            AND "
				+ "            BOARD_REPLY_STEP > ( SELECT BOARD_REPLY_STEP FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setInt(1, boardReplyId);
			pstmt.setInt(2, boardReplyId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		System.out.println("boardDao updateReplyStep() return : " + result);
		return result;
	}

	// update 조회수 업데이트 - 아이디가 다를 때만 올라간다
	public int updateReadCount(Connection conn, Integer boardId) {
		int result = 0;
		// 게시글 작성자와 아이디가 다르면 board 테이블의 read_count가 증가
		String sql = " UPDATE BOARD SET READ_COUNT=READ_COUNT+1 WHERE BOARD_ID = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setInt(1, boardId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	// update
	public int update(Connection conn, BoardDto dto) {
		int result = 0;
		String sql = "UPDATE BOARD SET SUBJECT=?,CONTENT=?,LOG_IP=? WHERE BOARD_ID = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getLogIp());
			pstmt.setInt(4, dto.getBoardId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}

	public int delete(Connection conn, Integer boardId) {
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setInt(1, boardId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
}
