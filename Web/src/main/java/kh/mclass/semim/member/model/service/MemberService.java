package kh.mclass.semim.member.model.service;

import static kh.mclass.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.mclass.semim.member.model.dao.MemberDao;
import kh.mclass.semim.member.model.dto.MemberDto;
import kh.mclass.semim.member.model.dto.MemberLoginDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int selectCheckId(String memId) {
		int result =0;
		Connection conn = getSemiConnection(true);	
		result = dao.selectCheckId(conn,memId);
		
		close(conn);
		return result;
	}
	/////////수정 해야함
	public int loginGetInfo(MemberLoginDto dto) {
		int result =0;
		Connection conn = getSemiConnection(true);	
		result = dao.loginGetInfo(conn,dto);
		
		close(conn);
		return result;
	}
	
	//select list - all
	public List<MemberDto> selectAllList() {
		List<MemberDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		
		close(conn);
		return result;
	}
	//select one
	public MemberDto selectOne(String memId) {
		MemberDto result =null;
		Connection conn = getSemiConnection(true);	
		result = dao.selectOne(conn,memId);
		
		close(conn);
		return result;
	}
	//insert
	public int insert(MemberDto dto) {
		int result = 0;
		//INSERT INTO MEMBER VALUES('kh1','pwd1','kh1@a.com');
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn,dto);
		close(conn);
		return result;
	}
	//update
	public int update ( MemberDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);	
		result = dao.update(conn,dto);
		
		close(conn);
		return result;
	}
	//delete
	public int delete (String memId) {
		int result = 0;
		Connection conn = getSemiConnection(true);	
		result = dao.delete(conn,memId);
		
		close(conn);
		return result;
	}
}
