package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.SalgradeDao;
import kh.mclass.jdbc.model.vo.Salgrade;
import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class SalgradeService {
	private SalgradeDao dao = new SalgradeDao();
	public Salgrade selectOne(int grade) {
		Salgrade result = null;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.selectOne(conn, grade);
		return result;
	}

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
		autoCommit(conn, false);
		result = dao.insert(conn, vo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	public int delete(int grade) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.delete(conn, grade);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	public int update(Salgrade vo) {
		int result = -1;
		Connection conn = getConnection();
		autoCommit(conn, false);
		result = dao.update(conn, vo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
