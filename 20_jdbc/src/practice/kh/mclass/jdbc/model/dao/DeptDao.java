package practice.kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.kh.mclass.jdbc.model.vo.Dept;
import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class DeptDao {
	public List<Dept> selectList(Connection conn) {
		List<Dept> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Dept>();
			while (rs.next()) {
				Dept vo = new Dept();
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int insert(Connection conn, Dept vo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getDeptno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getLoc());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dept insert result : " + result);
		return result;
	}

	public int delete(Connection conn, int deptno) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("dept delete result : " + result);
		return result;
	}
}
