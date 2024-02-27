package practice.kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import practice.kh.mclass.jdbc.model.dao.DeptDao;
import practice.kh.mclass.jdbc.model.vo.Dept;
import static practice.kh.mclass.jdbc.common.JdbcTemplate.*;

public class DeptService {
	private DeptDao dao = new DeptDao();
	public List<Dept> selectList() {
		List<Dept> list = null;
		Connection conn = getConnection();
		list = dao.selectList(conn);
		close(conn);
		return list;
	}
	public int insert(Dept vo) {
		int result = -1;
		Connection conn = getConnection();
		result = dao.insert(conn, vo);
		autoCommit(conn, false);
		if(result >0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result; 
	}
	public int delete(int deptno) {
		int result = -1;
		Connection conn = getConnection();
		result = dao.delete(conn, deptno);
		autoCommit(conn, false);
		if(result >0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result; 
	}
}
