package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.dao.EmpDao;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpController { //controller - 구조 만들기 : dao에서 값 받아와서 view에 전달
	private EmpDao dao = new EmpDao();
	
	public List<Emp> selectList() {
		return dao.selectList();
	}
	public void insert(Emp emp) {
		dao.insert(emp);
	}
	public void delete() {
		
	}
	
}
