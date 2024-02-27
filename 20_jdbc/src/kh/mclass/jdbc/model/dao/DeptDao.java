package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Dept;

import static kh.mclass.jdbc.common.JdbcTemplate.*; //클래스명을 쓰지 않고 메소드 사용가능 (static method일 경우에만)

public class DeptDao {

	public List<Dept> selectList(Connection conn) {
		String sql = "select * from dept";
		PreparedStatement pstmt =  null;
		ResultSet rs =  null;
		List<Dept> result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<Dept>();
			while(rs.next()) {
				Dept vo = new Dept();
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				result.add(vo);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int insert(Connection conn,Dept vo) {
		int result = -1;
		String sql = "insert into dept values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getDeptno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(2, vo.getLoc());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("dept insert result : "+result);
		return result;
		
	}
	public int delete(Connection conn , int deptno) {
		int result =  -1;
		String sql = "delete from dept where deptno = ?";
		PreparedStatement pstmt =  null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dept delete result :" + result);
		return result;
	}
}
