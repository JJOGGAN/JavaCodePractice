package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Dept;

public class DeptDaoPrac {
//	 DEPTNO                                    NOT NULL NUMBER(2)
//	 DNAME                                              VARCHAR2(14)
//	 LOC                                                VARCHAR2(13)
	
	public List<Dept> selectList(Connection conn ) {
		String sql = "select * from dept order by deptno desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			list =  new ArrayList<Dept>();
			while(rs.next()) {
				Dept vo = new Dept();
				vo.setDeptNo(rs.getInt("deptno"));
				vo.setdName(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close
		}
		
		
		return list;
	}
}
