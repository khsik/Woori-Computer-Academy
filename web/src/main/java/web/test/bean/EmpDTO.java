package web.test.bean;

import java.sql.Timestamp;

public class EmpDTO { // Data Transfer Object
	private int empno;		// 사원 번호
	private String ename;	// 이름
	private String job;		// 업무
	private int mgr;		// 상사
	private Timestamp hiredate;	// 입사 날짜
	private int sal;		// 급여
	private int comm;		// 보너스
	private int deptno;		// 부서 번호

	// set
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(int mgr) {
		this.mgr=mgr;
	}
	public void setHiredate(Timestamp date) {
		this.hiredate = date;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	// get
	public int getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public int getMgr() {
		return mgr;
	}
	public Timestamp getHiredate() {
		return hiredate;
	}
	public int getSal() {
		return sal;
	}
	public int getComm() {
		return comm;
	}
	public int getDeptno() {
		return deptno;
	}
}