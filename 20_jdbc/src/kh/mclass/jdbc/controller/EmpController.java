package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.EmpService;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpController { //controller - 구조 만들기 : dao에서 값 받아와서 view에 전달
	private EmpService service = new EmpService();
	
	public List<Emp> selectList() {
		return service.selectList();
	}
	public int insert(Emp emp) {
		return service.insert(emp);
	}
	public int delete(int emptno) {
		return service.delete(emptno);
	}
	
}
