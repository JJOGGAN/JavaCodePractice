package kh.mclass.jdbc.model.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcTemplate {
	private JdbcTemplate() {}
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			String currentPath = JdbcTemplate.class.getResource("").getPath();
			prop.load(new FileReader(currentPath + "driver.properties"));
			Class.forName(prop.getProperty("jdbc.driver"));
			conn = DriverManager.getConnection(prop.getProperty("jdbc.url")
					, prop.getProperty("jdbc.username")
					,prop.getProperty("jdbc.password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void AutoCommit(Connection conn, boolean autocommit) {
			try {
				if(conn != null)
				conn.setAutoCommit(autocommit);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null)
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(conn != null)
				conn.commit();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn != null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
