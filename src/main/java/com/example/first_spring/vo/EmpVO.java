package com.example.first_spring.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO extends DeptVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	private String loc;
	

}


