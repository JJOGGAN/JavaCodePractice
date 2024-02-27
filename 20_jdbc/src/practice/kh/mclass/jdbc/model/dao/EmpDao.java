package practice.kh.mclass.jdbc.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import practice.kh.mclass.jdbc.model.vo.Emp;

import static kh.mclass.jdbc.common.JdbcTemplate.*;



public class EmpDao {
	public List<Emp> selectList(Connection conn) {
		List<Emp> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Emp>();
			while (rs.next()) {
				Emp vo = new Emp();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setMgr(rs.getInt("mgr"));
				vo.setHiredate(rs.getDate("hiredate"));
				vo.setSal(rs.getDouble("sal"));
				vo.setComm(rs.getDouble("comm"));
				vo.setDeptno(rs.getInt("deptno"));

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
	//EMPNO                                     NOT NULL NUMBER(4)
	//ENAME                                              VARCHAR2(10)
	//JOB                                                VARCHAR2(9)
	//MGR                                                NUMBER(4)
	//HIREDATE                                           DATE
	//SAL                                                NUMBER(7,2)
	//COMM                                               NUMBER(7,2)
	//DEPTNO                                             NUMBER(2)
	public int insert(Connection conn, Emp vo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(?,?,?,?,SYSDATE,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDouble(5, vo.getSal()); 
			pstmt.setDouble(6, vo.getComm());
			pstmt.setInt(7, vo.getDeptno());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("emp insert result : " + result);
		return result;
	}

	public int delete(Connection conn, int deptno) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from emp where deptno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("emp delete result : " + result);
		return result;
	}
}
