package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp;

public class TestPracticeRun {
//상황에 대한 오류를 어떻게 해결할까 고민하면서 코드를 작성할 것
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> empList = null; //오류가 있는 상태를 유지하기 위해 선언만
		//System.out.println(empList.size()); //NullPoinrterException 
		
		//만약 초기화까지 하면...
		//empList = new ArrayList<Emp>);
		//System.out.println(empList.size()); //0 으로 선언되고 그 값이 실제로 0인건지 아닌지 알 수 없음 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","scott","TIGER");
			//scott : 사용자 이름 , TIGER : 비밀번호
			
			if(conn != null) System.out.println("GOOD"); else System.out.println("FAIL");
			stmt = conn.createStatement(); // 
			rs = stmt.executeQuery("select * from emp");
			
			////////List 생성
			//conn 연결 성공한 후 while 문으로 돌리기 전에 생성
			//conn이 성공한 후에 Emp의 값을 읽으러 감
			empList = new ArrayList<Emp>(); // size : 0
			
			while(rs.next()) {
				//////// emp 생성 : while문이 반복될 때 마다 새로운 emp라는 객체가 생성되는 것이다
				Emp emp = new Emp(); //while 안에 생성 : while밖에서 생성하면 emp는 한 번만 생성되기 때문에 처음 공간에 계속 정보를 넣게 된다.
				
				//////// Emp 객체 값 채우기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				////////List 객체 값채우기 :ArrayList이기 때문에 순서대로 마지막공간에 emp를 넣는다
				empList.add(emp); 
				////
			}
			System.out.println(empList);
			
			System.out.println("--------- READ DONE -----------");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 오류");
		} finally {
			try {
				if (rs != null)rs.close();
				if (stmt != null)stmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(empList == null) {
			System.out.println("오류로 데이터 읽기 실패");
		}else {
			System.out.println("사원 수 : "+empList.size());
			if(empList.size() >0) { //사원이 1이상이면 사원 data 출력
				for (Emp emp : empList) {
					System.out.println(emp);
				}
			}
		}
	}

}
