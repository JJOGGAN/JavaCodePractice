package kh.mclass.jdbc.model.dto;

import java.sql.Date;

//EmpDto 사원정보 상세보기
public class EmpDto {
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
	private String mgrEname;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	private String dname;
	private String loc;
}
