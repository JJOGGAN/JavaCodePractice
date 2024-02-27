package practice.kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import practice.kh.mclass.jdbc.model.dao.SalgradeDao;
import practice.kh.mclass.jdbc.model.vo.Salgrade;

import static practice.kh.mclass.jdbc.common.JdbcTemplate.*;

public class SalgradeService {

	private SalgradeDao dao = new SalgradeDao();

	public List<Salgrade> selectList() {
		List<Salgrade> list = null;
		Connection conn = getConnection();
		list = dao.selectList(conn);
		close(conn);
		return list;
	}

	public int insert(Salgrade vo) {
		int result = -1;
		Connection conn = getConnection();
		result = dao.insert(conn, vo);
		autoCommit(conn, false);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int delete(int grade) {
		int result = -1;
		Connection conn = getConnection();
		result = dao.delete(conn, grade);
		autoCommit(conn, false);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
