package practice.kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import practice.kh.mclass.jdbc.model.dao.EmpDao;
import practice.kh.mclass.jdbc.model.vo.Emp;

import static practice.kh.mclass.jdbc.common.JdbcTemplate.*;

public class EmpService {
	private EmpDao dao = new EmpDao();
	public List<Emp> selectList() {
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
		autoCommit(conn, false);
		result = dao.delete(conn, deptno);
		if(result >0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result; 
	}
}
