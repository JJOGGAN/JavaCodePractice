package practice.kh.mclass.jdbc.controller;

import java.util.List;

import practice.kh.mclass.jdbc.model.service.SalgradeService;
import practice.kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController {
	private SalgradeService service = new SalgradeService();
	public List<Salgrade> selectList() {
		return service.selectList();
	}
	public int insert(Salgrade vo) {
		return service.insert(vo);
	}
	public int delete(int deptno) {
		return service.delete(deptno);
	}
}
