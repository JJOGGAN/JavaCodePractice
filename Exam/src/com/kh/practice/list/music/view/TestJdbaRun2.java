package com.kh.practice.list.music.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbaRun2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","scott","TIGER");
			
			if(conn != null) System.out.println("did it");else System.out.println("try again");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from emp");
			while(rs.next()) {
				
			}
			// TODO 코드 연습
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
