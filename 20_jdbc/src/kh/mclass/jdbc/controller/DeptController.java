package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptController {
	private DeptService service = new DeptService(); 
	
	public List<Dept> selectList() {
		return service.selectList();
	}
	public int insert(Dept vo) {
		return service.insert(vo);
	}
	public int delete(int deptno) {
		return service.delete(deptno);
	}
	
}
