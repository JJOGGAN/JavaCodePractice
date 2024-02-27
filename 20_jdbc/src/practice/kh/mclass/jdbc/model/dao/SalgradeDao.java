package practice.kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.kh.mclass.jdbc.model.vo.Dept;
import practice.kh.mclass.jdbc.model.vo.Salgrade;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class SalgradeDao {

//리스트에 담아서 값 출력
	public List<Salgrade> selectList(Connection conn) {
		List<Salgrade> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from salgrade";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Salgrade>();
			while (rs.next()) {
				Salgrade vo = new Salgrade();
				vo.setGrade(rs.getInt("grade"));
				vo.setLosal(rs.getInt("losal"));
				vo.setHisal(rs.getInt("hisal"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int insert(Connection conn , Salgrade vo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into salgrade values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getGrade());
			pstmt.setInt(2,vo.getLosal());
			pstmt.setInt(3, vo.getHisal());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("salgrade insert result : "+result);
		return result;
	}

	public int delete(Connection conn , int grade) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from salgrade where grade = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		}finally {
			close(pstmt);
		}
		System.out.println("salgrade delete result : "+result);
		return result;
	}

}
