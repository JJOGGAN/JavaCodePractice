package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {
	Employee e = new Employee();

	public void add(int empNo, String name, char gender, String phone) {
		// TODO 매개변수 있는 생성자를 이용하여 데이터 저장하는 메소드
		Employee e = new Employee(empNo, name, gender, phone);
	}

	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double donus) {
		Employee e = new Employee(empNo, name, gender, phone, dept, salary, donus);
	}

	public void modify(String phone) {
		// setter로 수정
		e.setPhone(phone);
	}

	public void modify(int salary) {
		// setter로 수정
		e.setSalary(salary);
	}

	public void modify(double bonus) {
		// setter로 수정
		e.setBonus(bonus);
	}

	public Employee remove() {
		Employee result = null;
		return result;
	}

	public String inform() {
		// TODO result??
		String result = e.printEmployee();
		return result;
	}
}
