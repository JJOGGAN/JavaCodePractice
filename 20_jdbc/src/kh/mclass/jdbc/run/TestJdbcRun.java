package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbcRun {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // driver jar 있는지 확인

			// Connection 객체명 conn (관례) //		연결에 상당시간 소요 ↓
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "oracle");// 계정이름은
																											// 자유,
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
			stat = conn.createStatement(); // statement 를 리턴함 //sql에 있는 Statement import
			rs = stat.executeQuery("select id, last_name from emp"); // 소문자로 적어도 oracle이 알아서 대문자로 변환해줌
			int result = stat.executeUpdate("UPDATE EMPSET LAST_NAME = ‘KIM’" + " WHERE ID = ‘10000’"); // ID가 10000인
			// 있으면 1 없으면 0을 리턴
			// 사람의 성을 KIM으로
			// EMP가 없어서 에러 발생 ORA-00942: 테이블 또는 뷰가 존재하지 않습니다 -> 마이너스00942 : 오류번호

			// 바꿔줄래?
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		1 연결 1 해제 : 언제 재연결을 할 지 모르는데 계속 연결해두면 자바, DB입장에서 부담스럽기 때문

	}
}
