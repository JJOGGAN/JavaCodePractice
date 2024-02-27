package practice.kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import practice.kh.mclass.jdbc.controller.DeptController;
import practice.kh.mclass.jdbc.controller.EmpController;
import practice.kh.mclass.jdbc.model.vo.Dept;
import practice.kh.mclass.jdbc.model.vo.Emp;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);
	private EmpController controller = new EmpController();
	
	public void empMenu() {
		loopOut:
		while (true) {
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
				break loopOut;
			}
		}
	}
	
	public void selectList() {
		List<Emp> list = controller.selectList();
		if(list == null) {
			System.out.println("파일을 불러오지 못했습니다.");
		}else {
			System.out.println("사원 수 : "+list.size());
			for (Emp vo : list) {
				System.out.println(vo);
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
			
			Emp vo = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			int result = controller.insert(vo);
			if(result >0) {
				System.out.println("추가하였습니다.");
			}else {
				System.out.println("시스텝 오류로 추가하지 못했습니다. 다시시도해주세요");
			}
		} catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요");
		}
		
	}
	public void delete() {
		try {
			System.out.print("deptno : ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);
			
			int result = controller.delete(deptno);
			if(result >0) {
				System.out.println("추가하였습니다.");
			}else {
				System.out.println("시스텝 오류로 추가하지 못했습니다. 다시시도해주세요");
			}
		} catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요");
		}
		
	}
	
}
