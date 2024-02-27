package kh.mclass.jdbc.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Emp implements Serializable{

	/**
	 * 생략한다고 크게 문제가 되진 않지만 추가해줍니다. 워닝이 떴기 때문
	 */
	private static final long serialVersionUID = 1L; 
	
//	SQL> desc emp;     // sql plus 에서 다음 항복을 가져옴
//	 이름                                      널?      유형
//	 ----------------------------------------- -------- ----------------------------
//	 EMPNO                                     NOT NULL NUMBER(4)
//	 ENAME                                              VARCHAR2(10)
//	 JOB                                                VARCHAR2(9)
//	 MGR                                                NUMBER(4)
//	 HIREDATE                                           DATE
//	 SAL                                                NUMBER(7,2)
//	 COMM                                               NUMBER(7,2)
//	 DEPTNO                                             NUMBER(2)
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	//toString getter/setter는 만들고
	//생성자는 필요에 따라 맞춰서 생성
	
	
//	기본 생성자
	public Emp() {
		super();
	}
	

//	selectAll 생성자
public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	
//	toString
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
//	Getter / Setter
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
}
