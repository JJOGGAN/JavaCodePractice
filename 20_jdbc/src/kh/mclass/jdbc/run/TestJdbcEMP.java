package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbcEMP {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//지금 파일을 불러올 수 있는 상태인지 확인
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 프로젝트 안에 내가 가지고 있는 위치를 복사해서 넣어야한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","scott","TIGER");
			
			if(conn != null) System.out.println("GODD"); else System.out.println("FAIL");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from emp"); //해당 명령어를 서버에 보내는 역학
			while(rs.next()) { //next -> 다음 행이 있으면 읽어줘
				System.out.println("      한행있음");
				System.out.println("empno : "+rs.getInt("empno")); //Int 형으로 꺼내줘
				System.out.println("ename : "+rs.getString("ename")); //String type
				System.out.println("sal : "+rs.getDouble("sal")); //double type
			}
			System.out.println("*** END ***");
		}catch (ClassNotFoundException e) {
		} catch (SQLException e) { // try문에 아무것도 없어도 오류 발생

		} finally {
			try {
				if (rs != null )rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e2) {
			}
		}
	}
}
