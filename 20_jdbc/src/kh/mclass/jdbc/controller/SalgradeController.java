package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController { // controller - 구조 만들기 : dao에서 값 받아와서 view에 전달
	private SalgradeService service = new SalgradeService();

	public Salgrade selectOne(int grade) {
		Salgrade result = null;
		result = service.selectOne(grade);
		return result;
	}

	public List<Salgrade> selectList() {
		List<Salgrade> result = null;
		result = service.selectList();
		return result;
	}

	public int insert(Salgrade vo) {
		int result = 0;
		result = service.insert(vo);
		return result;
	}

	public int delete(int greade) {
		int result = 0;
		result = service.delete(greade);
		return result;
	}

	public int update(Salgrade vo) {
		int result = 0;
		result =  service.update(vo);
		return result;
	}
}
