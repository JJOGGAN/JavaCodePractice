package kh.mclass.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	private JdbcTemplate() {}
	
	//SEMIM을 위한 connection
	public static Connection getSemiConnection(boolean islocalhost) {
		Connection conn = null;
		Properties prop = new Properties(); // 애플리케이션의 환경설정과 관련된 속성을 저장 key:value
		try {
			String currentPath = JdbcTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(currentPath + "driver.properties")); /* properties 파일 연결 */
			Class.forName(prop.getProperty("jdbc.driver"));
			if(islocalhost) {
				conn = DriverManager.getConnection(prop.getProperty("jdbc.semi.localhost.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			}else {
				conn = DriverManager.getConnection(prop.getProperty("jdbc.semim.dbserver.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			}

			if(conn != null) System.out.println("연결성공"); else System.out.println("연결실패!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//기존 connection function
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties(); // 애플리케이션의 환경설정과 관련된 속성을 저장 key:value
		try {
			String currentPath = JdbcTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(currentPath + "driver.properties")); /* properties 파일 연결 */
			Class.forName(prop.getProperty("jdbc.driver"));

			conn = DriverManager.getConnection(prop.getProperty("jdbc.url")
											, prop.getProperty("jdbc.username")
											, prop.getProperty("jdbc.password"));
			if(conn != null) System.out.println("연결성공"); else System.out.println("연결실패!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Autocommit(Connection conn, boolean autocommit) {
		try {
			if(conn != null) conn.setAutoCommit(autocommit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(conn != null) conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null) conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
