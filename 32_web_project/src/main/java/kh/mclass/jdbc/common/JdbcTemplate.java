package kh.mclass.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	// connection, 트랜잭션 , 객체반환을 관리하는 클래스
	/* 기본 생성자를 private으로 만들기도 함 */
	private JdbcTemplate() {
	}

	// static 메소드로 만들기
	public static Connection getConnection() { // 싱글턴 패턴과 유사 / Connection 형태를 꺼내다오
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			if (conn != null)
				System.out.println("연결성공");
			else
				System.out.println("연결실패!!!!!!!!!");
			// conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void autoCommit(Connection con, boolean autocommit) {
		try {
			if (con != null)
				con.setAutoCommit(autocommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null)
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null)
				con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
		}
	}
	/* 생략가능 : 다형성 -> statement를 상속받으니 굳이 필요없음 */
//	public static void close(PreparedStatement pstmt) {
//		try {
//			if(pstmt != null) pstmt.close();
//		} catch (Exception e) {
//		}
//	}

}
