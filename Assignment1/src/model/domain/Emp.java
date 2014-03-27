package model.domain;

public class Emp {
	/*
	SQL> desc emp01;
	 이름                                      널?      유형
	 ----------------------------------------- -------- ------------------

	 EMPNO                                     NOT NULL NUMBER(4)
	 ENAME                                              VARCHAR2(10)
	 JOB                                                VARCHAR2(9)
	 MGR                                                NUMBER(4)
	 HIREDATE                                           DATE
	 SAL                                                NUMBER(7,2)
	 COMM                                               NUMBER(7,2)
	 DEPTNO                                    NOT NULL NUMBER(2)
	*/
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String date;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empno, String ename, String job, int mgr, String date,
			int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.date = date;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Emp(int empno, String ename, String job, int mgr, 
			int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empno=");
		builder.append(empno);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", date=");
		builder.append(date);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", comm=");
		builder.append(comm);
		builder.append(", deptno=");
		builder.append(deptno);
		builder.append("]");
		return builder.toString();
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
}
