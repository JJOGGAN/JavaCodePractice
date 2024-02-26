package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.EmpController;
import kh.mclass.jdbc.model.controller.DeptController;
import kh.mclass.jdbc.model.vo.Dept;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);
	private EmpController controller = new EmpController();

	public void empMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1: EMP 조회");
			System.out.println("2. EMP 추가");
			System.out.println("3. EMP 삭제");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insert();
				break;
			case "3":
				delete();
				break;
			default:
				exit = true;
				break;
			}
			if(exit) {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	public void selectList() {
		List<Emp> list = controller.selectList();
		if(list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원수:"+ list.size());
			if(list.size() > 0) {
				for(Emp vo : list) {
					System.out.println(vo);
				}
			}
		}
	}
	public void insert() {
		try {
			System.out.print("ename : ");
			String ename = sc.nextLine();
			System.out.print("job : ");
			String job = sc.nextLine();

			System.out.print("deptno(10,20,30,40) : ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);
			System.out.print("mgr(7369,7499, 7521) : ");
			String mgrStr = sc.nextLine();
			int mgr = Integer.parseInt(mgrStr);
			System.out.print("empno(4자리숫자1001~) : ");
			String empnoStr = sc.nextLine();
			int empno = Integer.parseInt(empnoStr);
			System.out.print("sal(5자리숫자) : ");
			String salStr = sc.nextLine();
			double sal = Double.parseDouble(salStr);
			System.out.print("comm(5자리숫자) : ");
			String commStr = sc.nextLine();
			double comm = Double.parseDouble(commStr);
			
			Date hiredate = null;
//			public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
			Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			//System.out.println(emp);
			System.out.println("====== 지금까지 입력한 데이터를 controller에게 전달함.");
			controller.insert(emp);
			
			
		}catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요.");
		}
		
	}

	public void delete() {
		controller.delete();
	}
}
