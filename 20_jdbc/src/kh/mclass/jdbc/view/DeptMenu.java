package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.DeptController;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptMenu {
	private Scanner sc = new Scanner(System.in);
	private DeptController controller = new DeptController();

	public void deptMenu() {
		while (true) {
			boolean exit = false;
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
		List<Dept> list = controller.selectList();
		if(list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원수:"+ list.size());
			if(list.size() > 0) {
				for(Dept vo : list) {
					System.out.println(vo);
				}
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
			System.out.println("====== 지금까지 입력한 데이터를 controller에게 전달함.");
			int result = controller.insert(vo);
			if(result > 0) {
				System.out.println("추가하였습니다.");
			} else {
				System.out.println("추가기능 중 시스템 오류로 삭제하지 못했습니다. 다시 시도해주세요.");
			}
		}catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요.");
		}
		
	}

	public void delete() {
		try {
			System.out.print("삭제할 deptno(51,52,...) : ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);
		
			int result = controller.delete(deptno);
			if(result > 0) {
				System.out.println("삭제하였습니다.");
			} else {
				System.out.println("삭제하다 시스템 오류로 삭제하지 못했습니다. 다시 시도해주세요.");
			}
		}catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요.");
		}
		
	}
	

	
}
