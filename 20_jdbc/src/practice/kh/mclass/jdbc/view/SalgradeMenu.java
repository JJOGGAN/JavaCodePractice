package practice.kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import practice.kh.mclass.jdbc.controller.DeptController;
import practice.kh.mclass.jdbc.controller.SalgradeController;
import practice.kh.mclass.jdbc.model.vo.Dept;
import practice.kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeMenu {
	private Scanner sc = new Scanner(System.in);
	private SalgradeController controller = new SalgradeController();

	public void salgradeMenu() {
		loopOut: while (true) {
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
				break loopOut;
			}
		}
	}

	public void selectList() {
		List<Salgrade> list = controller.selectList();
		if (list == null) {
			System.out.println("파일을 불러오지 못했습니다.");
		} else {
			System.out.println("사원 수 : " + list.size());
			for (Salgrade s : list) {
				System.out.println(s);
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
			if (result > 0) {
				System.out.println("추가하였습니다.");
			} else {
				System.out.println("시스텝 오류로 추가하지 못했습니다. 다시시도해주세요");
			}
		} catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요");
		}
	}

	public void delete() {
		try {
			System.out.print("garde : ");
			String gardeStr = sc.nextLine();
			int garde = Integer.parseInt(gardeStr);
			int result = controller.delete(garde);
			if (result > 0) {
				System.out.println("추가하였습니다.");
			} else {
				System.out.println("시스텝 오류로 추가하지 못했습니다. 다시시도해주세요");
			}
		} catch (NumberFormatException e) {
			System.out.println("자료형태에 맞게 입력해주세요");
		}
	}

}
