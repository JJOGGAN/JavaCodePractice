package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.SalgradeController;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeMenu {
	private Scanner sc = new Scanner(System.in);
	private SalgradeController controller = new SalgradeController();

	public void menu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1: SALGRADE 조회");
			System.out.println("2. SALGRADE 추가");
			System.out.println("3. SALGRADE 삭제");
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
	
	public void selectOne() {
		System.out.print("garde : ");
		String gardeStr = sc.nextLine();
		int garde = Integer.parseInt(gardeStr);
		//TODO 내용 채우기
	}

	public void selectList() {
		List<Salgrade> list = controller.selectList();
		if(list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원수:"+ list.size());
			if(list.size() > 0) {
				for(Salgrade vo : list) {
					System.out.println(vo);
				}
			}
		}
	}
	public void insert() {
		try {
			System.out.print("garde : ");
			String gardeStr = sc.nextLine();
			int garde = Integer.parseInt(gardeStr);
			System.out.print("losal : ");
			String losalStr = sc.nextLine();
			int losal = Integer.parseInt(losalStr);
			System.out.print("hisal : ");
			String hisalStr = sc.nextLine();
			int hisal = Integer.parseInt(hisalStr);
		
			Salgrade vo = new Salgrade(garde, losal, hisal);
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
			System.out.print("garde : ");
			String gardeStr = sc.nextLine();
			int garde = Integer.parseInt(gardeStr);
			int result = controller.delete(garde);
			if(result > 0) {
				System.out.println("삭제하였습니다.");
			} else {
				System.out.println("삭제하다 시스템 오류로 삭제하지 못했습니다. 다시 시도해주세요.");
			}
		}catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요.");
		}
		
	}
	
	public void update() {
		//TODO 내용 채우기
	}
	
}
