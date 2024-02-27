package kh.mclass.jdbc.model.dto;

import java.sql.Date;

//신입사원 등록시 사용자 입력자료형
public class EmpAddDto {
	//Emp를 기준으로 함
	
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
	private int mgr;
	private int deptno;
// 필수 입력 정보만 사용자에게 입력받는것
}
