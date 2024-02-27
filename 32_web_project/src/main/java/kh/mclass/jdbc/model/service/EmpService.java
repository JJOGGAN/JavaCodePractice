package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.EmpDao;
import kh.mclass.jdbc.model.vo.Emp;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class EmpService {
	private EmpDao dao = new EmpDao();
	public List<Emp> selectList(){
		List<Emp> list = null;
		Connection conn = getConnection();
		list = dao.selectList(conn);
		close(conn);
		return list;
	}
	
	public int insert(Emp vo) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.insert(conn, vo);
		if (result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int delete(int emptno) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.delete(conn, emptno);
		if (result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
