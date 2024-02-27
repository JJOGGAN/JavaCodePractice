package practice.kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import practice.kh.mclass.jdbc.controller.DeptController;
import practice.kh.mclass.jdbc.model.vo.Dept;

public class DeptMenu {
	private Scanner sc = new Scanner(System.in);
	private DeptController controller = new DeptController();
	
	public void deptMenu() {
		loopOut:
		while (true) {
			System.out.println("메뉴를 고르세요");
			System.out.println("1: DEPT 조회");
			System.out.println("2. DEPT 추가");
			System.out.println("3. DEPT 삭제");
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
		List<Dept> list = controller.selectList();
		if(list == null) {
			System.out.println("파일을 불러오지 못했습니다.");
		}else {
			System.out.println("사원 수 : "+list.size());
			for (Dept vo : list) {
				System.out.println(vo);
			}
		}
	}
	public void insert() {
		try {
			System.out.print("dname : ");
			String dname = sc.nextLine();
			System.out.print("loc : ");
			String loc = sc.nextLine();

			System.out.print("deptno(10,20,30,40 외) : ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);
			
			Dept vo = new Dept(deptno, dname, loc);
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
