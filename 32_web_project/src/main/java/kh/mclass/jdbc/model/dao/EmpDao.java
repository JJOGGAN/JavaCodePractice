package kh.mclass.jdbc.model.dao;
//Data Access Object : 데이터에 접근하는 클래스

import java.sql.Connection;
import static kh.mclass.jdbc.common.JdbcTemplate.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp;

public class EmpDao {
	public List<Emp> selectList(Connection conn) {
		// Statement stmt = null;
		List<Emp> empList = null; // 오류가 있는 상태를 유지하기 위해 선언만
		PreparedStatement pstmt = null; // statment 보다 보안성이 높음
		ResultSet rs = null;
		// System.out.println(empList.size()); //NullPoinrterException

		/* 범위 제한 */
		// int searchEmpno =2000;
		int searchDeptno = 20;
//		String sql = "select * from emp where empno < ?" ; // 사원번호를 2000이하로 밤위제한
		String sql = "select * from emp where deptno =" + searchDeptno; // Deptno 범위 제한
//		String sql = "select * from emp where deptno = ?" ;
//		String sql = "select * from emp";
		// 만약 초기화까지 하면...
		// empList = new ArrayList<Emp>);
		// System.out.println(empList.size()); //0 으로 선언되고 그 값이 0인건지 연결을 실패해서 0 인건지 알 수 없음


		try {
			pstmt = conn.prepareStatement(sql);
			/* 27행을 사용할 경울 밑에 행 필요 */ //
			//pstmt.setInt(1, searchDeptno);
			rs = pstmt.executeQuery();

// 데이터 엑세스 과정
			//////// List 생성
			// conn 연결 성공한 후 while 문으로 돌리기 전에 생성
			// conn이 성공한 후에 Emp의 값을 읽으러 감
			empList = new ArrayList<Emp>(); // size : 0

			while (rs.next()) {
				//////// emp 생성 : while문이 반복될 때 마다 새로운 emp객체 생성
				Emp emp = new Emp(); // while 안에 생성 : while밖에서 생성하면 emp는 한 번만 생성되기 때문에 처음 공간에 계속 정보를 넣게 된다.

				//////// Emp 객체 값 채우기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				//////// List 객체 값채우기 :ArrayList이기 때문에 순서대로 마지막공간에 emp를 넣는다
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return empList;
	}

	public int insert(Connection conn, Emp emp) { // 입력받은 값을 oracle에 전송

		PreparedStatement pstmt = null; // ? 쿼리스트링 사용 가능
		int result = -1;
		// String sql = "insert into emp" +
//		"(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) "
//		+ " values "
//		+ "("+emp.getEmpno()+", '"+emp.getEname()+"', '"+emp.getJob()+"' , "+emp.getMgr()+","
//				+ " SYSDATE, "+emp.getSal()+", "+emp.getComm()+", "+emp.getDeptno()+" )");

		try {

			String sql = "insert into emp (EMPNO,ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) values(?,?,?,?,SYSDATE,?,?,?)";

			/* JdbcTemplate에서 작동 */
			// conn.setAutoCommit(false); // 자동 commit을 못하게 한다. / close()를 하면 자동으로 커밋이 되어서
			// 지금 실행해도 자동커밋이 된다.

			pstmt = conn.prepareStatement(sql); // pstmt 가 output 같은 존재

			// 값
			// 모든 값 넣어주기 단 DATE자료형은 제외 - hiredate
			pstmt.setInt(1, emp.getEmpno()); // 1번째 물을표에 emp.getEmpno()를 넣어줘
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
//			pstmt.setDate(5, emp.getHiredate()); 
			pstmt.setDouble(5, emp.getSal()); // 만약 이렇게 중간에 뛰어 넘어도 index는 순차적으로 적어준다
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());

			result = pstmt.executeUpdate();

//			int result = pstmt.executeUpdate("insert into emp "
//					+ "(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) "
//					+ " values "
//					+ "("+emp.getEmpno()+", '"+emp.getEname()+"', '"+emp.getJob()+"' , "+emp.getMgr()+","
//							+ " SYSDATE, "+emp.getSal()+", "+emp.getComm()+", "+emp.getDeptno()+" )");
//			System.out.println("결과확인 : "+result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("emp insert result : " + result);
		return result;
	}

	public int delete(Connection conn, int emptno) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from emp where emptno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emptno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("emp delete result : " + result);
		return result;
	}
}
