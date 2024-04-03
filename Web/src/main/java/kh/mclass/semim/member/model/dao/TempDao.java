package kh.mclass.semim.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mclass.jdbc.JdbcTemplate.*;
import kh.mclass.semim.member.model.dto.MemberDto;
//MEM_ID    NOT NULL VARCHAR2(20)  
//MEM_PWD   NOT NULL VARCHAR2(20)  
//MEM_EMAIL NOT NULL VARCHAR2(100) 
public class TempDao {
	//select list - all
	public List<MemberDto> selectAllList(Connection conn) {
		List<MemberDto> result = null;
		String sql ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				result = new ArrayList<MemberDto>();
				do {
					MemberDto dto = new MemberDto(rs.getString("MEM_ID"),rs.getString("MEM_PWD"),rs.getString("MEM_EMAIL"));
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
	//select one
	public MemberDto selectOne(Connection conn,String memId) {
		MemberDto result =null;
		String sql ="SELELCT MEM_ID,MEM_PWD,MEM_EMAIL FROM MEMBER WHERE MEM_ID=?";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			pstmt =conn.prepareStatement(sql);
			//?
			pstmt.setString(1,memId);
			rs=pstmt.executeQuery();
			//reset
			if (rs.next()) {
				result = new MemberDto(rs.getString("MEM_ID"),rs.getString("MEM_PWD"),rs.getString("MEM_EMAIL"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		close(rs);
		close(pstmt);
		return result;
	}
	//insert
	public int insert(Connection conn, MemberDto dto) {
		int result = 0;
		//INSERT INTO MEMBER VALUES('kh1','pwd1','kh1@a.com');
		String sql ="INSERT INTO MEMBER(MEM_ID,MEM_PWD,MEM_EMAIL) VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(sql);
			//?처리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			pstmt.setString(3, dto.getMemEmail());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		close(pstmt);
		return result;
	}
	//update
	public int update (Connection conn, MemberDto dto) {
		int result = 0;
		String sql ="";
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(sql);
			//?처리
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		close(pstmt);
		return result;
	}
	//delete
	public int delete (Connection conn, String memId) {
		int result = 0;
		String sql ="DELETE FROM MEMBER WHERE MEM_ID =?";
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(sql);
			//이 위치에서 물음표 처리
			pstmt.setString(1, memId);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		close(pstmt);
		return result;
	}
}
