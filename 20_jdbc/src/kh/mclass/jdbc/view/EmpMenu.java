package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.EmpController;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);
	private EmpController controller = new EmpController();

	public void mainMenu() {
		while (true) {
			Boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1. select");
			System.out.println("2. insert");
			System.out.println("3. delete");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insertEmp();
				break;
			case "3":
				deleteEmp();
				break;
			default:
				exit = true;
				break;
			}
			if (exit) {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	public void selectList() { // view부분과 controller부분의 메소드명은 보통 같게 설정

		List<Emp> empList = controller.selectList();

		if (empList == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원 수 : " + empList.size());
			if (empList.size() > 0) { // 사원이 1이상이면 사원 data 출력
				for (Emp emp : empList) {
					System.out.println(emp);
				}
			}
		}
	}

	public void insertEmp() { // 추가

		try {
			//String과 다른 타입 구분해서 나열
			System.out.println("ename : ");
			String ename = sc.nextLine();
			System.out.println("job : ");
			String job = sc.nextLine();
			//

			System.out.println("empno(4자리 숫자 1001~) : "); //겹치면 안 됨
			String empnoStr = sc.nextLine();
			int empon = Integer.parseInt(empnoStr);

			System.out.println("mgr(7369,7499,7521) : "); //현재 DB에 들어간 사원 번호만 입력해야함
			String mgrStr = sc.nextLine();
			int mgr = Integer.parseInt(mgrStr);

			System.out.println("sal(7자리 - 소숫점 두자리 포함) : ");
			double sal = sc.nextDouble();

			System.out.println("comm(7자리) : ");
			double comm = sc.nextDouble();
			sc.nextLine();

			System.out.println("deptno(10,20,30,40) : ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);

			Date hiredate = null; //날짜엔 null값
			
			Emp emp = new Emp(empon, ename, job, mgr, hiredate, sal, comm, deptno);
			System.out.println(emp);
			System.out.println("----------check-------");
			
			controller.insertEmp(emp);
		} catch (NumberFormatException e) {
//			e.getStackTrace();
			System.out.println("숫자값을 입력하세요.");
		}


	}

	public void deleteEmp() { // 삭제
		controller.deleteEmp();
	}
}
