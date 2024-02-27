package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController { // controller - 구조 만들기 : dao에서 값 받아와서 view에 전달
	private SalgradeService service = new SalgradeService();

	public List<Salgrade> selectList() {
		return service.selectList();
	}

	public int insert(Salgrade vo) {
		return service.insert(vo);
	}

	public int delete(int greade) {
		return service.delete(greade);
	}

}
