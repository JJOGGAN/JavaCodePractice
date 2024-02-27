package practice.kh.mclass.jdbc.controller;

import java.util.List;

import practice.kh.mclass.jdbc.model.service.EmpService;
import practice.kh.mclass.jdbc.model.vo.Emp;

public class EmpController {
	private EmpService service = new EmpService();
	public List<Emp> selectList() {
		return service.selectList();
	}

	public int insert(Emp vo) {
		return service.insert(vo);
	}

	public int delete(int deptno) {
		return service.delete(deptno);
	}
}
