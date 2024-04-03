package kh.mclass.semim.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mclass.jdbc.JdbcTemplate.*;
import kh.mclass.semim.board.model.dto.BoardDto;
//BOARD_ID     NOT NULL NUMBER         
//SUBJECT      NOT NULL VARCHAR2(120)  
//CONTENT      NOT NULL VARCHAR2(4000) 
//WRITE_TIME   NOT NULL TIMESTAMP(6)   
//LOG_IP                VARCHAR2(15)   
//BOARD_WRITER NOT NULL VARCHAR2(20)   
//READ_COUNT   NOT NULL NUMBER     

public class BoardDao {

	public List<BoardDto> selectAllList(Connection conn){
		List<BoardDto> result = null;
		String sql = "SELECT BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT FROM BOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); //pstmt로 insert, update, delete 로 한 그 값을 가져오는 것이 ResultSet
			//rs처리
			if (rs.next()) {
				result = new ArrayList<BoardDto>();
				do {
					BoardDto dto = new BoardDto(rs.getInt("BOARD_ID"), rs.getString("SUBJECT"), rs.getString("CONTENT"), rs.getString("WRITE_TIME"),  rs.getString("LOG_IP"),  rs.getString("BOARD_WRITER"), rs.getInt("READ_COUNT"));
					result.add(dto);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	public BoardDto selectOne(Connection conn, Integer boardId){
		BoardDto result = null;
		String sql = "SELECT BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT FROM BOARD WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//?처리
			pstmt.setInt(1, boardId);
			rs=pstmt.executeQuery();
			//rs처리
			if (rs.next()) {
				result = new BoardDto(rs.getInt("BOARD_ID"), rs.getString("SUBJECT"), rs.getString("CONTENT"), rs.getString("WRITE_TIME"),  rs.getString("LOG_IP"),  rs.getString("BOARD_WRITER"), rs.getInt("READ_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	public int insert (Connection conn, BoardDto dto) {
		int result = 0;
		String sql = "INSERT INTO BOARD( BOARD_ID,SUBJECT,CONTENT,WRITE_TIME,LOG_IP,BOARD_WRITER,READ_COUNT) "
						+ "	VALUES(SEQ_BOARD_ID.nextval,?,?,DEFAULT,?,?,DEFAULT)";
		PreparedStatement pstmt = null;
		//BOARD_ID     NOT NULL NUMBER         
		//SUBJECT      NOT NULL VARCHAR2(120)  
		//CONTENT      NOT NULL VARCHAR2(4000) 
		//WRITE_TIME   NOT NULL TIMESTAMP(6)   
		//LOG_IP                VARCHAR2(15)   
		//BOARD_WRITER NOT NULL VARCHAR2(20)   
		//READ_COUNT   NOT NULL NUMBER     
		try {
			pstmt = conn.prepareStatement(sql);
			//? 처리
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getLogIp());
			pstmt.setString(4, dto.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public int update (Connection conn, BoardDto dto) {
		int result = 0;
		String sql = "UPDATE BOARD SET SUBJECT=?,CONTENT=?,LOG_IP=? WHERE BOARD_ID = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//?처리
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getLogIp());
			pstmt.setInt(1, dto.getBoardId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public int delete (Connection conn, Integer boardId) {
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//?처리
			pstmt.setInt(1,boardId );
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
}
